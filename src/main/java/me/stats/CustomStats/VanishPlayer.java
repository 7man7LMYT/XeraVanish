package me.stats.CustomStats;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class VanishPlayer {
    CustomStats customStats;

    public VanishPlayer(CustomStats customStats) {
        this.customStats = customStats;
    }

    public void vanishPlayer(Player vanishplayer) {
        customStats.gamemodelist.put(vanishplayer, vanishplayer.getGameMode());
        vanishplayer.setGameMode(GameMode.CREATIVE);

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', customStats.getConfig().getString("quitmessage").replaceAll("%playername%", vanishplayer.getDisplayName())));

        customStats.taskidlist.put(vanishplayer, Bukkit.getScheduler().scheduleSyncRepeatingTask(customStats, () -> {
            TextComponent actionbar = new TextComponent("You are vanished at the moment!");
            actionbar.setColor(ChatColor.AQUA);

            vanishplayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, actionbar);
        }, 0, 20));

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != vanishplayer) {
                player.hidePlayer(customStats, vanishplayer);
            }
        }
    }

    public void unvanishPlayer(Player unvanishplayer) {
        unvanishplayer.setGameMode(customStats.gamemodelist.get(unvanishplayer));
        customStats.gamemodelist.remove(unvanishplayer);

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', customStats.getConfig().getString("joinmessage").replaceAll("%playername%", unvanishplayer.getDisplayName())));

        Bukkit.getScheduler().cancelTask(customStats.taskidlist.get(unvanishplayer));
        customStats.taskidlist.remove(unvanishplayer);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != unvanishplayer) {
                player.showPlayer(customStats, unvanishplayer);
            }
        }
    }
}
