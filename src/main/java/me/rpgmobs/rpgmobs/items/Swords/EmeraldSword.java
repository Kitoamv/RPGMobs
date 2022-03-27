package me.rpgmobs.rpgmobs.items.Swords;

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

public class EmeraldSword {

    public static ItemStack EmeraldSwords;

    public static void init() {
        createEmeraldSword();
    }

    private static void createEmeraldSword() {
        ItemStack EmeraldSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta scm = EmeraldSword.getItemMeta();
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GREEN + "Espada de Esmeralda");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Vagas Lembranças sobre um outro Mundo.");
        list.add(ChatColor.DARK_PURPLE + "Talvez nele não existisse isso.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "6,5");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Normal");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(1);
        EmeraldSword.setItemMeta(scm);
        EmeraldSwords = EmeraldSword;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("emerald_sword"), EmeraldSword);
        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', Material.EMERALD);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }
}