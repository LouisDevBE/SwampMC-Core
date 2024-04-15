package dev.swampmc.swampmccore.Listeners;

import dev.swampmc.swampmccore.Managers.ItemManager;
import dev.swampmc.swampmccore.SwampMC_Core;
import dev.swampmc.swampmccore.utils.BungeeCordUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MenuClickListener implements Listener {

    private final SwampMC_Core plugin;

    public MenuClickListener(SwampMC_Core plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        String invName = event.getView().getTitle();
        Material item = event.getCurrentItem().getType();
        Inventory inv = event.getInventory();

        if(invName.equals("Server Selector")) {
            event.setCancelled(true);
            if(item == Material.GRASS_BLOCK) {
                player.sendMessage(ChatColor.GREEN + "Sending you to Border SMP server...");
                BungeeCordUtil.connectToServer(plugin, player, "survival");
            }

        } else if (invName.equals("Profile")) {
            event.setCancelled(true);

            if(event.getCurrentItem().equals(ItemManager.playerHiderShow)){
                inv.setItem(22, ItemManager.playerHiderHide);
                player.getInventory().setItem(8, ItemManager.playerHiderHide);

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players != player) {
                        player.hidePlayer(players);
                    }
                }

                player.sendMessage(ChatColor.RED + "All players are hided");
            } else if(event.getCurrentItem().equals(ItemManager.playerHiderHide)){
                inv.setItem(22, ItemManager.playerHiderShow);
                player.getInventory().setItem(8, ItemManager.playerHiderShow);

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players != player) {
                        player.showPlayer(players);

                    }
                }

                player.sendMessage(ChatColor.GREEN + "All players are showed");
            }


        } else {
            if(!player.getGameMode().equals(GameMode.CREATIVE) && !player.isOp()) {
                event.setCancelled(true);
            }
        }


    }
}
