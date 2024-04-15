package dev.swampmc.swampmccore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(player.hasPermission("lobby.vanish") || player.isOp()) {
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.showPlayer(player);
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permissions to execute this command.");
            }
        }
        return true;
    }
}
