package dev.swampmc.swampmccore.Managers;

import dev.swampmc.swampmccore.SwampMC_Core;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemManager {
    private static SwampMC_Core plugin;
    public static ItemStack serverSelector;
    public static ItemStack playerHiderShow;
    public static ItemStack playerHiderHide;

    public static void init(SwampMC_Core plugin){
        ItemManager.plugin = plugin;
        createServerSelector();
        createPlayerHider();

    }

    private static void createServerSelector(){
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY.toString() + ChatColor.BOLD + "Server Selector");
        meta.setLore(Arrays.asList(ChatColor.WHITE + "Click to play out amazing gamemodes!"));

        item.setItemMeta(meta);

        serverSelector = item;

    }

    private static void createPlayerHider(){
        ItemStack item = new ItemStack(Material.LIME_DYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Player Showed");
        meta.setLore(Arrays.asList(ChatColor.WHITE + "Click to hide players!"));

        item.setItemMeta(meta);

        playerHiderShow = item;

        ItemStack item2 = new ItemStack(Material.GRAY_DYE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.GRAY.toString() + ChatColor.BOLD + "Player Hided");
        meta2.setLore(Arrays.asList(ChatColor.GRAY + "Click to show players!"));

        item2.setItemMeta(meta2);

        playerHiderHide = item2;


    }
}
