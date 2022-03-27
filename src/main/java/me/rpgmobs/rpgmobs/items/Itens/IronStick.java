package me.rpgmobs.rpgmobs.items.Itens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class IronStick {

    public static ItemStack IStick;

    public static void init() {
        createIronStick();
    }

    private static void createIronStick() {
        ItemStack magmain = new ItemStack(Material.STICK);
        ItemMeta mag = magmain.getItemMeta();
        mag.setDisplayName(ChatColor.GOLD + "Graveto de Ferro");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Item Processado para criar uma nova arma.");
        list.add(ChatColor.DARK_PURPLE + "Que tipo de efeitos ela entregará ?");
        list.add("");
        mag.setLore(list);
        mag.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mag.setCustomModelData(7005);
        magmain.setItemMeta(mag);
        IStick = magmain;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("iron_stick"), magmain);
        recipe.shape("   ", " B ", " B ");
        recipe.setIngredient('B', Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(recipe);
    }
}
