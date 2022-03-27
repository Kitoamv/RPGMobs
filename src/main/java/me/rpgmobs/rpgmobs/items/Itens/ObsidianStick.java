package me.rpgmobs.rpgmobs.items.Itens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.rpgmobs.rpgmobs.items.Itens.ObsidianIngot.OIngot;

public class ObsidianStick {

    public static ItemStack OStick;

    public static void init() {
        createOStick();
    }

    private static void createOStick() {
        ItemStack magmain = new ItemStack(Material.STICK);
        ItemMeta mag = magmain.getItemMeta();
        mag.setDisplayName(ChatColor.GOLD + "Barra de Obsidiana");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Item Processado para criar uma nova arma.");
        list.add(ChatColor.DARK_PURPLE + "Que tipo de efeitos ela entregará ?");
        list.add("");
        mag.setLore(list);
        mag.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mag.setCustomModelData(7001);
        magmain.setItemMeta(mag);
        OStick = magmain;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("obsidian_stick"), magmain);
        recipe.shape("   ", " B ", " B ");
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(OIngot));
        Bukkit.getServer().addRecipe(recipe);
    }
}
