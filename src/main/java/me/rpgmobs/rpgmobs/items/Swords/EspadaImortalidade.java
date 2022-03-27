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

public class EspadaImortalidade {

    public static ItemStack SwordImortal;

    public static void init(){
        createEspadaImortalidade();
    }

    private static void createEspadaImortalidade() {
            ItemStack scythe = new ItemStack(Material.TOTEM_OF_UNDYING);
            ItemMeta scm = scythe.getItemMeta();
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5,
                    AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

            AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.6,
                    AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

            scm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
            scm.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
            scm.setDisplayName(ChatColor.YELLOW + "Espada da Imortalidade");
            List<String> list = new ArrayList<>();
            list.add("");
            list.add(ChatColor.LIGHT_PURPLE + "Embora Pareça Apenas uma espada fraca.");
            list.add(ChatColor.DARK_PURPLE + "Ela poderá lhe salvar um dia.");
            list.add("");
            list.add(ChatColor.BLUE + "Habilidades:");
            list.add(ChatColor.GREEN + "- Inquebrável!");
            list.add(ChatColor.GREEN + "- Sacrificio: Impede que o usuário morra");
            list.add(ChatColor.DARK_GREEN + "entregando-se para o " + ChatColor.DARK_PURPLE + "Vazio");
            list.add(ChatColor.RED + "- Toque do Vazio: Tornando-a Incapaz de ser Encantada");
            list.add("");
            list.add(ChatColor.BLUE + "Na Mão Principal:");
            list.add(ChatColor.GRAY + "Dano Por Golpe:" + ChatColor.LIGHT_PURPLE + "5");
            list.add(ChatColor.GRAY + "Velocidade de Ataque:" + ChatColor.LIGHT_PURPLE + "1.6");
            scm.setLore(list);
            scm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            scm.setCustomModelData(7);
            scythe.setItemMeta(scm);
            SwordImortal = scythe;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("espada_imortal"), scythe);
        shapedRecipe.shape(" B ", " B ", " R ");
        shapedRecipe.setIngredient('B', Material.TOTEM_OF_UNDYING);
        shapedRecipe.setIngredient('R', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}
