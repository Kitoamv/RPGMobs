package me.rpgmobs.rpgmobs.items.Helmet;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MinerHelmet {

    public static ItemStack MinerHelmet;

    public static void init() {
        createHelmet();
    }

    private static void createHelmet(){
        ItemStack item = new ItemStack(Material.GOLDEN_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Capacete de Minerador");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "Uma capacete usado pelo mineradores do reino.");
        lore.add(ChatColor.DARK_PURPLE + "Este item não passa de algo decorativo.");
        lore.add("");
        meta.setLore(lore);
        meta.setCustomModelData(950);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        MinerHelmet = item;
    }
}
