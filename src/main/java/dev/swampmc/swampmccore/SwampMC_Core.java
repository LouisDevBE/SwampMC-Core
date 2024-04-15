package dev.swampmc.swampmccore;

import dev.swampmc.swampmccore.Commands.Dadjokes;
import dev.swampmc.swampmccore.Commands.Fly;
import dev.swampmc.swampmccore.Commands.Vanish;
import dev.swampmc.swampmccore.Listeners.ItemClickListener;
import dev.swampmc.swampmccore.Listeners.LobbyListeners;
import dev.swampmc.swampmccore.Listeners.MenuClickListener;
import dev.swampmc.swampmccore.Listeners.connectListener;
import dev.swampmc.swampmccore.Managers.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SwampMC_Core extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        ItemManager.init(this);

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LobbyListeners(), this);
        pm.registerEvents(new connectListener(this), this);
        pm.registerEvents(new ItemClickListener(), this);
        pm.registerEvents(new MenuClickListener(this), this);

        getCommand("dadjoke").setExecutor(new Dadjokes());
        getCommand("fly").setExecutor(new Fly());
        getCommand("vanish").setExecutor(new Vanish());

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "SwampMC Lobby CORE | Enabled!");

    }

    @Override
    public void onDisable() {
        Bukkit.getMessenger().unregisterOutgoingPluginChannel(this);
    }

    public Location getLobbySpawn(){
        return new Location(Bukkit.getWorld("world"), 0.5,65,0.5, 180,2);
    }
}
