package me.rpgmobs.rpgmobs.items.Swords;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.rpgmobs.rpgmobs.items.Itens.ObsidianIngot.OIngot;
import static me.rpgmobs.rpgmobs.items.Itens.ObsidianStick.OStick;

public class ObsidianSword {

    public static ItemStack ObsidianSwords;

    public static void init() {
    createObSword();
    }

    private static void createObSword() {
        ItemStack scythe = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta scm = scythe.getItemMeta();
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 7.5,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.7,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.DARK_PURPLE + "Espada de Obsidiana");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Embora Pareça Apenas uma espada fraca.");
        list.add(ChatColor.DARK_PURPLE + "Ela poderá lhe salvar um dia.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque:" + ChatColor.LIGHT_PURPLE + " 7.5");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Normal");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(49);
        scythe.setItemMeta(scm);
        ObsidianSwords = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("ob_sword"), scythe);
        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(OIngot));
        recipe.setIngredient('R', new RecipeChoice.ExactChoice(OStick));
        Bukkit.getServer().addRecipe(recipe);
    }
}