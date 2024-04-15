package dev.swampmc.swampmccore.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ServerSelector {
    public ServerSelector(Player player){
        Inventory inventory = Bukkit.createInventory(player, 27, "Server Selector");

        ItemStack survival = new ItemStack(Material.GRASS_BLOCK, 1);
        ItemMeta survivalMeta = survival.getItemMeta();
        survivalMeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Border SMP");
        List<String> survivalLore = new ArrayList<>();
        survivalLore.add(" ");
        survivalLore.add(ChatColor.WHITE + "Normal survival with a border.");
        survivalLore.add(ChatColor.WHITE + "The border gets bigger as you level up");
        survivalLore.add(ChatColor.WHITE + "and quests.");
        survivalLore.add(" ");
        survivalLore.add(ChatColor.GRAY + "Click to connect!");
        survivalMeta.setLore(survivalLore);
        survival.setItemMeta(survivalMeta);
        inventory.setItem(13, survival);
        
        for(int i = 0; i < 27; i++) {
            if(inventory.getItem(i) == null){
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }

        player.openInventory(inventory);
    }
}
