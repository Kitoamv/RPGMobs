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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class PiglinGravidade implements Listener {
    private static Location location;
    RPGMobs main;
    public ItemStack CrossBow;

    public PiglinGravidade(RPGMobs plugin) {
        this.main = plugin;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        final int chance = this.main.GravidadeSpawnChance;
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        Location loc = event.getEntity().getLocation();
        int random = math.randomNumberInRange(1, 100);

        if (entity.getType() == EntityType.PIGLIN) {
            if (random <= chance) {
                Piglin necromancer = (Piglin) entity;
                necromancer.setCustomName(ChatColor.RED + "Piglin Gravitacional");
                necromancer.setCustomNameVisible(true);
                Attributable necro = necromancer;
                AttributeInstance attributeHealth = necro.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                attributeHealth.setBaseValue(50);
                necromancer.setHealth(50);

                ItemStack item = new ItemStack(Material.CROSSBOW, 1);
                ItemMeta meta = item.getItemMeta();

                meta.setDisplayName(ChatColor.WHITE + "• " + ChatColor.GREEN + "Besta do Piglin");
                List<String> list = new ArrayList<>();
                list.add("");
                list.add(ChatColor.LIGHT_PURPLE + "Um Upgrade Para o Arco Comum ?.");
                list.add(ChatColor.DARK_PURPLE + "Uma Arma Encantada pelo Piglin");
                list.add("");
                list.add(ChatColor.WHITE + "➤ Poder de Ataque: " + ChatColor.LIGHT_PURPLE + "9");
                list.add(ChatColor.WHITE + "➤ Velocidade de Ataque: " + ChatColor.DARK_PURPLE + "Normal");
                list.add("");
                meta.setLore(list);
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                item.setItemMeta(meta);
                CrossBow = item;

                necromancer.getEquipment().setItemInMainHand(CrossBow);
                necromancer.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                necromancer.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                necromancer.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
            }
        }
    }


    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (e.getCause() != EntityDamageEvent.DamageCause.PROJECTILE && !(e.getEntity() instanceof Player) && !(e.getDamager() instanceof Arrow))
            return;
        Arrow a = (Arrow) e.getDamager();
        if (a.getShooter() instanceof Piglin) { //MALDITOS ESQUELETOS.
            Piglin piglin = (Piglin) a.getShooter();
            if (((Piglin) a.getShooter()).getCustomName() != null && ((Piglin) a.getShooter()).getCustomName().equals(ChatColor.RED + "Piglin Gravitacional")) {
                {
                    Player player = (Player) e.getEntity();
                    if (!player.isBlocking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 180, 2));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 120, 2));
                    }
                }
            }
        }
    }
}