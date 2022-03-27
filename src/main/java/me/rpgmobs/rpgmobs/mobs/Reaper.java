package me.rpgmobs.rpgmobs.mobs;

import me.rpgmobs.rpgmobs.RPGMobs;
import me.rpgmobs.rpgmobs.Utils.chat;
import me.rpgmobs.rpgmobs.Utils.math;
import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public class Reaper implements Listener {

    private static Location location;
    RPGMobs main;

    public Reaper(RPGMobs plugin) {
        this.main = plugin;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        final int chance = this.main.ReaperSpawnChance;
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        Location loc = event.getEntity().getLocation();
        int random = math.randomNumberInRange(1, 100);

        if (entity.getType() == EntityType.SKELETON) {
            if (random <= chance) {
                Skeleton reaper = (Skeleton) entity;
                reaper.setCustomName(ChatColor.DARK_RED + "Ceifador de Almas");
                reaper.setCustomNameVisible(true);
                Attributable reaperAt = reaper;
                AttributeInstance attribute = reaperAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                AttributeInstance damage = reaperAt.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                attribute.setBaseValue(60);
                reaper.setHealth(60);
                damage.setBaseValue(5);

                ItemStack ghostplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta gp = (LeatherArmorMeta) ghostplate.getItemMeta();
                gp.setColor(Color.fromRGB(45, 42, 38));
                gp.setDisplayName(chat.translated("&9&nReaper's Torso"));
                ghostplate.setItemMeta(gp);

                ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta sm = (SkullMeta) skull.getItemMeta();
                sm.setOwner("Reaper");
                int calliSecret = math.randomNumberInRange(1, 1000);
                if (calliSecret == 1) {
                    sm.setOwner("Reaper");
                }
                sm.setDisplayName(chat.translated("&9&nCabeça do Ceifeiro"));
                skull.setItemMeta(sm);

                ItemStack scythe = new ItemStack(Material.IRON_SWORD);
                ItemMeta scm = scythe.getItemMeta();
                scm.setDisplayName(chat.translated("&9&nFoice do Ceifeiro"));
                scm.setCustomModelData(201);
                scythe.setItemMeta(scm);


                reaper.setInvisible(true);
                reaper.setSilent(true);

                reaper.getEquipment().setChestplate(ghostplate);
                reaper.getEquipment().setHelmet(skull);
                reaper.getEquipment().setItemInMainHand(scythe);
                reaper.getWorld().playSound(reaper.getLocation(), Sound.ENTITY_WITHER_SKELETON_AMBIENT, 3, 5);
            }
        }
    }

            @EventHandler
            public void onDamage(EntityDamageByEntityEvent event) {
                if (event.getDamager() instanceof Skeleton) {
                    if (event.getDamager().getCustomName() != null && event.getDamager().getCustomName().equals(ChatColor.DARK_RED + "Ceifador de Almas")) {
                        if (event.getEntity() instanceof Player) {
                            Player player = (Player) event.getEntity();
                            if (!player.isBlocking()) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 1));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 180, 2));
                            }
                        }
                    }
                }
            }

            @EventHandler
            public void onEntityKill(EntityDeathEvent e) {
                if (e.getEntity() instanceof Skeleton) {
                    Skeleton rp = (Skeleton) e.getEntity();
                    if (rp.getCustomName().equals(ChatColor.DARK_RED + "Ceifador de Almas")) {
                        e.getDrops().clear();

                        ItemStack scythe = new ItemStack(Material.IRON_SWORD);
                        ItemMeta scm = scythe.getItemMeta();
                        scm.setDisplayName(chat.translated("&9&nFoice do Ceifeiro"));
                        scm.setCustomModelData(201);
                        scythe.setItemMeta(scm);

                        ItemStack bundle = new ItemStack(Material.BUNDLE);
                        ItemMeta bdl = bundle.getItemMeta();
                        ArrayList<String> lore = new ArrayList();
                        ArrayList<String> lore2 = new ArrayList();
                        lore.add("&dUsada para recolher almas.");
                        lore2.add("Utilize ele para guardar itens.");
                        bdl.setLore(lore);
                        bdl.setLore(lore2);
                        bdl.setDisplayName(chat.translated("&3&nBolsa de &b&nAlmas"));
                        bundle.setItemMeta(bdl);

                        Random r = new Random();
                        float chance = r.nextFloat();
                        if (chance < 0.065f) // chance de 0,65%
                        {
                            e.getDrops().add(bundle);
                        }
                        if (chance <= 0.10f) // chance of 10%
                        {
                            e.getDrops().add(scythe);
                            e.getDrops().add(new ItemStack(Material.REDSTONE, 6));
                        }
                        if (chance <= 0.20f) // chance of 20%
                        {
                            e.getDrops().add(new ItemStack(Material.BONE_MEAL, 3));
                        }
                        if (chance < 0.30f) // chance de 30%
                        {
                            e.getDrops().add(new ItemStack(Material.REDSTONE, 4));
                        }
                        if (chance < 1f) // chance de 100%
                        {
                            e.setDroppedExp(100);
                        }
                    }
                }
            }
        }
