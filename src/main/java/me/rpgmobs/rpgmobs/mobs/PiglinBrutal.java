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
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PiglinBrutal implements Listener {

    private static Location location;
    RPGMobs main;

    public PiglinBrutal(RPGMobs plugin) {
        this.main = plugin;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        final int chance = this.main.PiglinBrutalSpawnChance;
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        Location loc = event.getEntity().getLocation();
        int random = math.randomNumberInRange(1, 100);

        if (entity.getType() == EntityType.PIGLIN) {
            if (random <= chance) {
                Piglin necromancer = (Piglin) entity;
                necromancer.setCustomName(ChatColor.DARK_RED + "Piglin Guerreiro");
                necromancer.setCustomNameVisible(true);
                Attributable necro = necromancer;
                AttributeInstance attributeHealth = necro.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                attributeHealth.setBaseValue(40);
                necromancer.setHealth(40);


                necromancer.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
                necromancer.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                necromancer.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                necromancer.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            }
        }
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Piglin) {
            if (event.getDamager().getCustomName() != null && event.getDamager().getCustomName().equals(ChatColor.DARK_RED + "Ceifador de Almas")) {
                if (event.getEntity() instanceof Player) {
                    Player player = (Player) event.getEntity();
                    if (!player.isBlocking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 180, 2));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 180, 2));
                        player.sendMessage(ChatColor.DARK_RED + "Está com medo ?");
                    }
                }
            }
        }
    }
}