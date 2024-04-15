package dev.swampmc.swampmccore.Listeners;

import dev.swampmc.swampmccore.Managers.ItemManager;
import dev.swampmc.swampmccore.menus.ServerSelector;
import dev.swampmc.swampmccore.menus.profile;
import dev.swampmc.swampmccore.utils.SkullItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemClickListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getHand() == EquipmentSlot.HAND && event.getItem() != null){
                if(event.getItem().equals(ItemManager.serverSelector)) {
                    new ServerSelector(player);
                } else if (event.getItem().equals(SkullItem.skullItem)){
                    event.setCancelled(true);
                    new profile(player);

                } else if (event.getItem().equals(ItemManager.playerHiderShow)) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (players != player) {
                            player.hidePlayer(players);
                        }
                    }

                    if(player.getInventory().getItem(8).equals(ItemManager.playerHiderShow)) {
                        player.getInventory().setItem(8, ItemManager.playerHiderHide);
                    } else {
                        return;
                    }

                    player.sendMessage(ChatColor.RED + "All players are hided");
                } else if (event.getItem().equals(ItemManager.playerHiderHide)) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (players != player) {
                            player.showPlayer(players);

                        }
                    }

                    if(player.getInventory().getItem(8).equals(ItemManager.playerHiderHide)) {
                        player.getInventory().setItem(8, ItemManager.playerHiderShow);
                    } else {
                        return;
                    }

                    player.sendMessage(ChatColor.GREEN + "All players are showed");
                }
            }
        }
    }
}
