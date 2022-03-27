package me.rpgmobs.rpgmobs.items.Swords;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class EspadasFinas {

    public static ItemStack FinaNetherite;
    public static ItemStack FinaDiamante;
    public static ItemStack FinaOuro;
    public static ItemStack FinaFerro;
    public static ItemStack FinaPedra;
    public static ItemStack FinaMadeira;

    public static void init() {
        createNetherite();
        createDiamante();
        createOuro();
        createFerro();
        createPedra();
        createMadeira();
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent e){
        ItemStack item = e.getItem();
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        if(lore!=null){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            int index = 0;
            while(!lore.get(index).equals("")){ //Skip to the first blank line in lore
                index++;
            }

            Map<Enchantment, Integer> enchants = e.getEnchantsToAdd();
            for(Enchantment enchantment : enchants.keySet()){
                String enchantName = EnchantmentNames.get(enchantment);
                int enchantLevel = enchants.get(enchantment);
                lore.add(index, "§7"+enchantName +" "+ enchantLevel);

                index++;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
    }

    private static HashMap<Enchantment, String> EnchantmentNames = new HashMap<Enchantment, String>();
    static{
        for(Enchantment enchant : Enchantment.values()){
            EnchantmentNames.put(enchant, enchant.getKey().toString());
        }//For loop just to give all enchants a temp name using NamespacedKey. Don't need this if you manually add all of them below.
        EnchantmentNames.put(Enchantment.ARROW_DAMAGE, "Força");
        EnchantmentNames.put(Enchantment.ARROW_KNOCKBACK, "Punch");
    }

    private static void createNetherite() {
        ItemStack scythe = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 3,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 4,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.02,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.DARK_PURPLE + "Espada Fina de Netherite");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma espada fina com ataques rápidos.");
        list.add(ChatColor.DARK_PURPLE + "talvez ela ajude a matar os mobs.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "4");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Rápido");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.LIGHT_PURPLE + "+0.02");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(3);
        scythe.setItemMeta(scm);
        FinaNetherite = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("fina_netherite"), scythe);
        recipe.shape("  B", " B ", "R  ");
        recipe.setIngredient('B', Material.NETHERITE_INGOT);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);

    }

    // Espada Fina de Diamante
    private static void createDiamante() {
        ItemStack scythes = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta scm = scythes.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3.5,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.02,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.AQUA + "Espada Fina de Diamante");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma espada fina com ataques rápidos.");
        list.add(ChatColor.DARK_PURPLE + "talvez ela ajude a matar os mobs.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "3");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Rápido");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.LIGHT_PURPLE + "+0.02");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(3);
        scythes.setItemMeta(scm);
        FinaDiamante = scythes;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("fina_diamante"), scythes);
        recipe.shape("  B", " B ", "R  ");
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Fina de Ouro
    private static void createOuro() {
        ItemStack scythe = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.02,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);


        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GOLD + "Espada Fina de Ouro");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma espada fina com ataques rápidos.");
        list.add(ChatColor.DARK_PURPLE + "talvez ela ajude a matar os mobs.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "2");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Rápido");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.LIGHT_PURPLE + "+0.02");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(4);
        scythe.setItemMeta(scm);
        FinaOuro = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("fina_ouro"), scythe);
        recipe.shape("  B", " B ", "R  ");
        recipe.setIngredient('B', Material.GOLD_INGOT);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Fina de Ouro
    private static void createFerro() {
        ItemStack scythe = new ItemStack(Material.IRON_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.02,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);


        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GRAY + "Espada Fina de Ferro");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma espada fina com ataques rápidos.");
        list.add(ChatColor.DARK_PURPLE + "talvez ela ajude a matar os mobs.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "3");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Rápido");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.LIGHT_PURPLE + "+0.02");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(5);
        scythe.setItemMeta(scm);
        FinaFerro = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("fina_ferro"), scythe);
        recipe.shape("  B", " B ", "R  ");
        recipe.setIngredient('B', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Fina de Pedra
    private static void createPedra() {
        ItemStack scythe = new ItemStack(Material.STONE_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.02,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);


        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
        scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.WHITE + "Espada Fina de Pedra");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
        list.add("");
        list.add(ChatColor.LIGHT_PURPLE + "Uma espada fina com ataques rápidos.");
        list.add(ChatColor.DARK_PURPLE + "talvez ela ajude a matar os mobs.");
        list.add("");
        list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "2");
        list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Rápido");
        list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.LIGHT_PURPLE + "+0.02");
        list.add("");
        scm.setLore(list);
        scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        scm.setCustomModelData(6);
        scythe.setItemMeta(scm);
        FinaPedra = scythe;

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("fina_pedra"), scythe);
        recipe.shape("  B", " B ", "R  ");
        recipe.setIngredient('B', Material.COBBLESTONE);
        recipe.setIngredient('R', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
    }

    // Espada Fina de Madeira
    private static void createMadeira() {
        ItemStack scythe = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta scm = scythe.getItemMeta();

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.02,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

            scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
            scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
            scm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
            scm.setDisplayName(ChatColor.WHITE + "• " + ChatColor.DARK_AQUA + "Espada Fina de Madeira");
            List<String> list = new ArrayList<>();
            list.add("");
            list.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ☆☆☆☆☆");
            list.add("");
            list.add(ChatColor.LIGHT_PURPLE + "Uma espada fina com ataques rápidos.");
            list.add(ChatColor.DARK_PURPLE + "talvez ela ajude a matar os mobs.");
            list.add("");
            list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "2");
            list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.LIGHT_PURPLE + "Rápido");
            list.add(ChatColor.WHITE + "➤ Velocidade De Movimento : " + ChatColor.LIGHT_PURPLE + "+0.02");
            list.add("");
            scm.setLore(list);
            scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            scm.setCustomModelData(50);
            scythe.setItemMeta(scm);
            FinaMadeira = scythe;

            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("fina_madeira"), scythe);
            recipe.shape("  B", " B ", "R  ");
            recipe.setIngredient('B', Material.OAK_PLANKS);
            recipe.setIngredient('R', Material.STICK);
            Bukkit.getServer().addRecipe(recipe);
        }
    }