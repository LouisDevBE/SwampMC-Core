package dev.swampmc.swampmccore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class SkullItem {

    public static ItemStack skullItem;
    public static ItemStack playerInfoSkull;
    public void addPlayerSkullToInventory(Inventory inventory, String skullOwner, Integer plaats) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        skullMeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + skullOwner + "'s profile");
        skull.setItemMeta(skullMeta);
        inventory.setItem(plaats, skull);

        skullItem = skull;
    }

    public void playerInfoSkull(Inventory inventory, String skullOwner, Integer plaats) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        skullMeta.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + skullOwner );

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.WHITE + "Rank: ");
        lore.add(ChatColor.WHITE + "Server: ");
        lore.add(" ");
        skullMeta.setLore(lore);

        skull.setItemMeta(skullMeta);
        inventory.setItem(plaats, skull);

        skullItem = skull;
    }
}
