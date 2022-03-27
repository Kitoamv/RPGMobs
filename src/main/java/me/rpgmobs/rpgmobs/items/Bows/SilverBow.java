package me.rpgmobs.rpgmobs.items.Bows;

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

import static me.rpgmobs.rpgmobs.items.Itens.IronStick.IStick;

public class SilverBow {

    public static ItemStack SilverBow;

    public static void init() {
        createSilverBOW();
    }


    private static void createSilverBOW() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GREEN + "Arco de Ferro");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Um Upgrade Para o Arco Comum ?.");
        list.add(ChatColor.DARK_PURPLE + "Talvez isso se torne algo mais interessante.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "9");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Normal");
        list.add("");
        meta.setLore(list);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        SilverBow = item;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("iron_bow"), item);
        shapedRecipe.shape("021", "201", "021");
        shapedRecipe.setIngredient('1', Material.STRING);
        shapedRecipe.setIngredient('2', new RecipeChoice.ExactChoice(IStick));
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}