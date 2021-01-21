package me.stats.CustomStats;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEvents implements Listener {
    CustomStats customstats;

    public PlayerEvents(CustomStats customstats) {
        this.customstats = customstats;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (Player vanishedPlayer : customstats.gamemodelist.keySet()) {
            player.hidePlayer(customstats, vanishedPlayer);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (customstats.isVanished(player)) {
            event.setQuitMessage(null);

            customstats.vanishPlayer.unvanishPlayer(player);
        }
    }
}
