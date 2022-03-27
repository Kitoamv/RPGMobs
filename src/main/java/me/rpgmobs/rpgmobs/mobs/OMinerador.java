package me.rpgmobs.rpgmobs.mobs;

import me.rpgmobs.rpgmobs.RPGMobs;
import me.rpgmobs.rpgmobs.Utils.math;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OMinerador implements Listener{

    private static Location location;
    RPGMobs main;

    public OMinerador(RPGMobs plugin) {
        this.main = plugin;
    }

    public static void onEntitySpawn(Location location) {
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        final int chance = this.main.MinerSpawnChance;
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        Location loc = event.getEntity().getLocation();
        int random = math.randomNumberInRange(1, 100);

        if (entity.getType() == EntityType.ZOMBIE) {
            if (random <= chance) {
                Zombie miner = (Zombie) entity;
                miner.setCustomName(ChatColor.GREEN + "O Minerador");
                miner.setCustomNameVisible(true);
                Attributable necro = miner;
                AttributeInstance attributeHealth = necro.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                attributeHealth.setBaseValue(50);
                miner.setHealth(50);

                miner.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SHOVEL));

                ItemStack item = new ItemStack(Material.GOLDEN_HELMET, 1);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("§6Capacete de Minerador");
                List<String> lore = new ArrayList<>();
                lore.add("");
                lore.add(ChatColor.LIGHT_PURPLE + "Uma capacete usado pelo mineradores do reino.");
                lore.add(ChatColor.DARK_PURPLE + "Este item não passa de algo decorativo.");
                lore.add("");
                meta.setLore(lore);
                meta.setCustomModelData(950);
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(meta);


                miner.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_PICKAXE));
                miner.getEquipment().setHelmet(item);
            }
        }
    }
}
