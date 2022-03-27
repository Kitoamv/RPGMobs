package me.rpgmobs.rpgmobs.items.Swords;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AmethystSword {

    public static ItemStack AmeSwords;

    public static void init() {
        createObSword();
    }

    private static void createObSword() {
        ItemStack scythe = new ItemStack(Material.IRON_SWORD);
        ItemMeta scm = scythe.getItemMeta();
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5.5,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.6,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.LIGHT_PURPLE + "Espada de Ametista");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Forjada com um minério.");
        list.add(ChatColor.DARK_PURPLE + "Tão inútil quanto o ouro.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque:" + ChatColor.LIGHT_PURPLE + " 5.5");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Normal");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(7005);
        scythe.setItemMeta(scm);
        AmeSwords = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("ametista_sword"), scythe);
        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }
}