package dev.swampmc.swampmccore.Listeners;

import dev.swampmc.swampmccore.Managers.ItemManager;
import dev.swampmc.swampmccore.SwampMC_Core;
import dev.swampmc.swampmccore.utils.SkullItem;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class connectListener implements Listener {

    private final SwampMC_Core plugin;

    public connectListener(SwampMC_Core plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent e) {
        e.setSpawnLocation(plugin.getLobbySpawn());
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();

        player.getInventory().setItem(0, ItemManager.serverSelector);
        player.getInventory().setItem(8, ItemManager.playerHiderShow);

        new SkullItem().addPlayerSkullToInventory(player.getInventory(), player.getName(), 2);
    }
}
