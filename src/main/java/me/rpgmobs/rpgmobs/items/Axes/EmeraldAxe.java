package me.rpgmobs.rpgmobs.items;

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

public class EmeraldAxe {

    public static ItemStack EmeraldAxe;

    public static void init() {
        createEmeraldAxe();
    }

    private static void createEmeraldAxe() {
        ItemStack scythes = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta axe = scythes.getItemMeta();
        axe.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GREEN + "Machado de Esmeralda");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Um Machado Nunca Visto Antes.");
        list.add(ChatColor.DARK_PURPLE + "A Voz do Vazio Acha Engraçado.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "9");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Normal");
        list.add("");
        axe.setLore(list);
        axe.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        axe.setCustomModelData(2);
        scythes.setItemMeta(axe);
        EmeraldAxe = scythes;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("emerald_axe"), scythes);
        shapedRecipe.shape("110", "120", "020");
        shapedRecipe.setIngredient('1', Material.EMERALD);
        shapedRecipe.setIngredient('2', Material.STICK);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}