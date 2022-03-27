package me.rpgmobs.rpgmobs.items.Itens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ObsidianIngot {

    public static ItemStack OIngot;

    public static void init() {
        createObIngot();
    }

    private static void createObIngot() {
        ItemStack magmain = new ItemStack(Material.IRON_INGOT);
        ItemMeta mag = magmain.getItemMeta();
        mag.setDisplayName(ChatColor.GOLD + "Barra de Obsidiana");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Item Processado para criar uma nova arma.");
        list.add(ChatColor.DARK_PURPLE + "Que tipo de efeitos ela entregará ?");
        list.add("");
        mag.setLore(list);
        mag.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mag.setCustomModelData(7000);
        magmain.setItemMeta(mag);
        OIngot = magmain;

        FurnaceRecipe recipe = new FurnaceRecipe(OIngot, Material.OBSIDIAN);
        recipe.setExperience(20);
        Bukkit.getServer().addRecipe(recipe);
    }
}
