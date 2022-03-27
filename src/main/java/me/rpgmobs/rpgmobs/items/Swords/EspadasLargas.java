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

public class EspadasLargas {

    public static ItemStack LongaNetherite;
    public static ItemStack LongaDiamante;
    public static ItemStack LongaOuro;
    public static ItemStack LongaFerro;
    public static ItemStack LongaPedra;
    public static ItemStack LongaMadeira;

    public static void init() {
        createNetherite();
        createDiamante();
        createOuro();
        createFerro();
        createPedra();
        createMadeira();
    }

    private static void createNetherite() {
        ItemStack scythe = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", -0.03,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.DARK_PURPLE + "Espada Longa de Netherite");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Longa de um material forte.");
        list.add(ChatColor.DARK_PURPLE + "Um grande dano e lentidão.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "14");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Lento");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.DARK_RED + "-0.03");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(350);
        scythe.setItemMeta(scm);
        LongaNetherite = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("broad_netherite"), scythe);
        recipe.shape("  B", "BB ", "RB ");
        recipe.setIngredient('B', Material.NETHERITE_INGOT);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);

    }

    // Espada Fina de Diamante
    private static void createDiamante() {
        ItemStack scythe = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 13,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.AQUA + "Espada Longa de Diamante");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Longa de um material forte.");
        list.add(ChatColor.DARK_PURPLE + "Um grande dano e lentidão.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "12");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Lento");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.DARK_RED + "-0.03");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(48);
        scythe.setItemMeta(scm);
        LongaDiamante = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("broad_diamante"), scythe);
        recipe.shape("  B", "BB ", "RB ");
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Longa de Ouro
    private static void createOuro() {
        ItemStack scythe = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GOLD + "Espada Longa de Ouro");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Longa de um material forte.");
        list.add(ChatColor.DARK_PURPLE + "Um grande dano e lentidão.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "6");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Lento");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.DARK_RED + "-0.03");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(55);
        scythe.setItemMeta(scm);
        LongaOuro = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("broad_ouro"), scythe);
        recipe.shape("  B", "BB ", "RB ");
        recipe.setIngredient('B', Material.GOLD_INGOT);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Longa de Ferro
    private static void createFerro() {
        ItemStack scythe = new ItemStack(Material.IRON_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 9,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GRAY + "Espada Longa de Ferro");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Longa de um material forte.");
        list.add(ChatColor.DARK_PURPLE + "Um grande dano e lentidão.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "10");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Lento");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.DARK_RED + "-0.03");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(55);
        scythe.setItemMeta(scm);
        LongaFerro = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("broad_ferro"), scythe);
        recipe.shape("  B", "BB ", "RB ");
        recipe.setIngredient('B', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Fina de Pedra
    private static void createPedra() {
        ItemStack scythe = new ItemStack(Material.STONE_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 7,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GRAY + "Espada Longa de Pedra");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Longa de um material forte.");
        list.add(ChatColor.DARK_PURPLE + "Um grande dano e lentidão.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "8");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Lento");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.DARK_RED + "-0.03");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(53);
        scythe.setItemMeta(scm);
        LongaPedra = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("broad_pedra"), scythe);
        recipe.shape("  B", "BB ", "RB ");
        recipe.setIngredient('B', Material.COBBLESTONE);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Longa de Madeira
    private static void createMadeira() {
        ItemStack scythe = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.WHITE + "Espada Longa de Madeira");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma Espada Longa de um material forte.");
        list.add(ChatColor.DARK_PURPLE + "Um grande dano e lentidão.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "6");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Lento");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.DARK_RED + "-0.03");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(52);
        scythe.setItemMeta(scm);
        LongaMadeira = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("broad_madeira"), scythe);
        recipe.shape("  B", "BB ", "RB ");
        recipe.setIngredient('B', Material.OAK_PLANKS);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }
    public static class LootTableBuilder {

    }
}