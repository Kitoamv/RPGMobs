package me.rpgmobs.rpgmobs.mobsbackup;

import me.rpgmobs.rpgmobs.RPGMobs;
import me.rpgmobs.rpgmobs.Utils.chat;
import me.rpgmobs.rpgmobs.Utils.math;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class BSkeletonWarrior implements Listener {

    private static Location location;
    RPGMobs main;

    public BSkeletonWarrior(RPGMobs plugin) {
        this.main = plugin;
    }

    public static void createBSkeletonWarrior(Location location) {
        Skeleton warrior = location.getWorld().spawn(location, Skeleton.class);
        warrior.setCustomName(ChatColor.DARK_RED + "Esqueleto Guerreiro");
        warrior.setCustomNameVisible(true);
        Attributable reaperAt = warrior;
        AttributeInstance attribute = reaperAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance damage = reaperAt.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        attribute.setBaseValue(100);
        warrior.setHealth(100);
        damage.setBaseValue(6);

        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta sm = (SkullMeta) skull.getItemMeta();
        sm.setOwner("esokr");
        int calliSecret = math.randomNumberInRange(1, 1000);
        if (calliSecret == 1) {
            sm.setOwner("esokr");
        }
        sm.setDisplayName(chat.translated("&9&nCabeça do Ceifeiro"));
        skull.setItemMeta(sm);

        ItemStack scythe = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta scm = scythe.getItemMeta();
        scythe.setItemMeta(scm);

        warrior.getEquipment().setHelmet(skull);
        warrior.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        warrior.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        warrior.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
        warrior.getEquipment().setItemInMainHand(scythe);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Skeleton) {
            if (event.getDamager().getCustomName() != null && event.getDamager().getCustomName().equals(ChatColor.DARK_RED + "Esqueleto Guerreiro")) {
                if (event.getEntity() instanceof Player) {
                    Player player = (Player) event.getEntity();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 1));
                }
            }
        }
    }

    @EventHandler
    public void onEntityKill(EntityDeathEvent e) {
        if (e.getEntity() instanceof Skeleton) {
            Skeleton wp = (Skeleton) e.getEntity();
            if (wp.getCustomName().equals(ChatColor.DARK_RED + "Ceifador de Almas")) {
                e.getDrops().clear();

                ItemStack scythe = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta scm = scythe.getItemMeta();
                Attributable scmAt = (Attributable) scm;
                AttributeInstance damages = scmAt.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                damages.setBaseValue(9);
                scythe.setItemMeta(scm);

                Random r = new Random();
                float chance = r.nextFloat();
                if (chance <= 0.10f) // chance of 10%
                {
                    e.getDrops().add(scythe);
                    e.getDrops().add(new ItemStack(Material.IRON_BOOTS, 6));
                }
                if (chance <= 0.20f) // chance of 20%
                {
                    e.getDrops().add(new ItemStack(Material.IRON_INGOT, 3));
                }
                if (chance < 0.30f) // chance de 30%
                {
                    e.getDrops().add(new ItemStack(Material.IRON_SWORD, 4));
                }
                if (chance < 1f) // chance de 100%
                {
                    e.setDroppedExp(200);
                }
            }
        }
    }
}
