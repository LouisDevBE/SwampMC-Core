package dev.swampmc.swampmccore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(player.hasPermission("lobby.fly") || player.isOp()) {
                if(player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.RED + "Fly is disabled");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.GREEN + "Fly is enabled");
                }
            }
        }
        return true;
    }
}
