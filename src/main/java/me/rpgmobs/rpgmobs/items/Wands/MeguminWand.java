package me.rpgmobs.rpgmobs.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeguminWand {

    public static ItemStack MWand;

    public static void init() {
        createMWand();
    }

    private static void createMWand(){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();

        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.Luck", 2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.04,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier2);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
        meta.setDisplayName(ChatColor.WHITE + "•" + ChatColor.RED + " Cajado" + ChatColor.DARK_RED + " Carmesim");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "Aprimoramento:" + ChatColor.YELLOW + " ★★★★★");
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "Um Cajado Famoso no clã da magia carmesim");
        lore.add(ChatColor.DARK_PURPLE + "Este cajado foi retirado do anime Konosuba.");
        lore.add("");
        lore.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Rápido");
        lore.add(ChatColor.WHITE + "➤ Velocidade: " + ChatColor.DARK_PURPLE + "+0.02" + ChatColor.DARK_GREEN + " (" + ChatColor.DARK_GREEN + "+0.02" + ChatColor.DARK_GREEN + ")");
        lore.add(ChatColor.WHITE + "➤ Sorte: " + ChatColor.DARK_PURPLE + "+0.5" + ChatColor.DARK_GREEN + " (" + ChatColor.DARK_GREEN + "+1.5" + ChatColor.DARK_GREEN + ")");
        lore.add("");
        lore.add(ChatColor.GOLD + "Habilidade Única:");
        lore.add(ChatColor.GRAY + "- Arremesa uma magia explosiva capaz de explodir os inimigos");
        lore.add(ChatColor.GRAY + "Essa magia tem uma recarga de " + ChatColor.DARK_PURPLE + "5 Segundos.");
        meta.setLore(lore);
        meta.setCustomModelData(650);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        MWand = item;
    }
}
