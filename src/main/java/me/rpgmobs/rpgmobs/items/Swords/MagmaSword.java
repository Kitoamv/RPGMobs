package me.rpgmobs.rpgmobs.items.Swords;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.rpgmobs.rpgmobs.items.Itens.ObsidianIngot.OIngot;
import static me.rpgmobs.rpgmobs.items.Itens.ObsidianStick.OStick;

public class MagmaSword {

    public static ItemStack MagmaNugget;
    public static ItemStack MagmaIngot;
    public static ItemStack MagmaSwords;


    public static void init() {
    createNugget();
    createMagmaIngot();
    createMagmaSword();
    }

    private static void createNugget() {
        ItemStack scythe = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta scm = scythe.getItemMeta();
        scm.setDisplayName(ChatColor.GOLD + "Pepita de Magma");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Um Item Usada para forjar um novo minério.");
        list.add(ChatColor.DARK_PURPLE + "A Barra da Magma será descoberta ?");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(47);
        scythe.setItemMeta(scm);
        MagmaNugget = scythe;

        FurnaceRecipe recipe = new FurnaceRecipe(MagmaNugget, Material.MAGMA_BLOCK);
        recipe.setExperience(35);
        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createMagmaIngot() {
        ItemStack magmain = new ItemStack(Material.IRON_INGOT);
        ItemMeta mag = magmain.getItemMeta();
        mag.setDisplayName(ChatColor.GOLD + "Barra de Magma");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Item Processado para criar uma nova arma.");
        list.add(ChatColor.DARK_PURPLE + "Que tipo de efeitos ela entregará ?");
        list.add("");
        mag.setLore(list);
        mag.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mag.setCustomModelData(46);
        magmain.setItemMeta(mag);
        MagmaIngot = magmain;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("magma_ingot"), magmain);
        recipe.shape("BBB", "BRB", "BBB");
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(MagmaNugget));
        recipe.setIngredient('R', new RecipeChoice.ExactChoice(OIngot));
        Bukkit.getServer().addRecipe(recipe);
    }
    private static void createMagmaSword() {
        ItemStack scythe = new ItemStack(Material.NETHERITE_SWORD);
        scythe.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 14,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.6,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GOLD + "Espada de Magma");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada que atrai as entidades do inferno.");
        list.add(ChatColor.DARK_PURPLE + "Suas chamas são perigosas.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque:" + ChatColor.LIGHT_PURPLE + " 8.5");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Rápido");
        list.add("");
        list.add(ChatColor.GOLD + "Habilidade Única:");
        list.add(ChatColor.GREEN + "- Fogo Infernal: Adiciona um efeito de chamas");
        list.add(ChatColor.DARK_GREEN + "Fazendo com que" + ChatColor.DARK_RED + " Inimigos " + ChatColor.DARK_GREEN + "pereçam as chamas.");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(25);
        scythe.setItemMeta(scm);
        MagmaSwords = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("magma_sword"), scythe);
        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(MagmaIngot));
        recipe.setIngredient('R', new RecipeChoice.ExactChoice(OStick));
        Bukkit.getServer().addRecipe(recipe);
    }
}
