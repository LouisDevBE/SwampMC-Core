package dev.swampmc.swampmccore.menus;

import dev.swampmc.swampmccore.Managers.ItemManager;
import dev.swampmc.swampmccore.utils.SkullItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class profile {

    public profile(Player player){
        Inventory inventory = Bukkit.createInventory(player, 54, "Profile");


        new SkullItem().addPlayerSkullToInventory(inventory, player.getName(), 4);

        if(player.getInventory().getItem(8).equals(ItemManager.playerHiderShow)){
            inventory.setItem(22, ItemManager.playerHiderShow);
        } else {
            inventory.setItem(22, ItemManager.playerHiderHide);
        }

        for(int i = 9; i < 17; i++) {
            if(inventory.getItem(i) == null){
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }

        player.openInventory(inventory);
    }

}
