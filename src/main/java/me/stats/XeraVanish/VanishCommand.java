package me.stats.XeraVanish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishCommand implements CommandExecutor, TabExecutor {
    XeraVanish xeraVanish;

    public VanishCommand(XeraVanish xeraVanish) {
        this.xeraVanish = xeraVanish;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (xeraVanish.isVanished(player)) {
                if (player.hasPermission("customstats.stats")) {

                    player.sendMessage("xeraVanish.getConfig().getString("statcommand")");
                } else {
                    sender.sendMessage("Unknown command.");
                }
            }
        } else {
            sender.sendMessage("This command does not work in console.");
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}
