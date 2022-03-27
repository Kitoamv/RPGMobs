package me.rpgmobs.rpgmobs.mobs;

import me.rpgmobs.rpgmobs.RPGMobs;
import me.rpgmobs.rpgmobs.Utils.chat;
import me.rpgmobs.rpgmobs.Utils.math;
import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class Necromancer implements Listener {

    private static Location location;
    RPGMobs main;
    public Necromancer(RPGMobs plugin) {
        this.main = plugin;
    }

    public static void onEntitySpawn(Location location) {
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        final int chance = this.main.NecromancerSpawnChance;
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        Location loc = event.getEntity().getLocation();
        int random = math.randomNumberInRange(1, 100);

        if (entity.getType() == EntityType.SKELETON) {
            if (random <= chance) {
                    Skeleton necromancer = (Skeleton) entity;
                    necromancer.setCustomName(ChatColor.DARK_BLUE + "Necromante");
                    necromancer.setCustomNameVisible(true);
                    Attributable necro = necromancer;
                    AttributeInstance attributeHealth = necro.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                    attributeHealth.setBaseValue(100);
                    necromancer.setHealth(100);
                    AttributeInstance attributeSpeed = necro.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    attributeSpeed.setBaseValue(0.1);

                    necromancer.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SHOVEL));

                    ItemStack staff = new ItemStack(Material.DIAMOND_PICKAXE);
                    ItemMeta scm = staff.getItemMeta();
                    scm.setDisplayName(chat.translated("&9&nCajado do Necromante"));
                    scm.setCustomModelData(8500);
                    staff.setItemMeta(scm);


                    necromancer.getEquipment().setItemInMainHand(staff);
                    necromancer.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
                    necromancer.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
                    necromancer.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
                    necromancer.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));

                    new BukkitRunnable(){
                        int i = 0;
                        public void run() {
                            if(!necromancer.isDead()){
                                if(necromancer.getTarget() != null){
                                    if(i % 2 == 0){
                                        FallingBlock fallingBlock = necromancer.getWorld().spawnFallingBlock(necromancer.getLocation().add(0, 2, 0), Material.SNOW_BLOCK, (byte) 0);
                                        fallingBlock.setCustomName("Necromancer Orb");
                                        fallingBlock.setDropItem(false);
                                        fallingBlock.setVelocity(necromancer.getTarget().getLocation().add(0, 1, 0).subtract(fallingBlock.getLocation()).toVector().multiply(0.5));
                                        fallingBlock.getWorld().playSound(fallingBlock.getLocation(), Sound.ENTITY_WITHER_SHOOT, 5, 5);
                                        new BukkitRunnable(){
                                            public void run(){
                                                if(!fallingBlock.isDead()){
                                                    fallingBlock.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, fallingBlock.getLocation(), 1);
                                                    for(Entity entityy : fallingBlock.getNearbyEntities(2, 2 ,2)){
                                                        if(entityy instanceof Player){
                                                            if(fallingBlock.getLocation().distanceSquared(entity.getLocation()) <1){
                                                                Player player = (Player) entityy;
                                                                player.damage(4, necromancer);
                                                                fallingBlock.remove();
                                                                cancel();
                                                            }
                                                        }
                                                    }
                                                }
                                                else{
                                                    cancel();
                                                }
                                            }
                                        }.runTaskTimer(main, 0L, 2L);
                                    }
                                    if(i % 10 == 0){
                                        Random r = new Random();
                                        necromancer.getWorld().playSound(necromancer.getLocation(), Sound.ENTITY_EVOKER_PREPARE_SUMMON, 5, 5);
                                        for(int x = 0; x < 4; x++){
                                            Zombie zombie = necromancer.getWorld().spawn(necromancer.getLocation().add(r.nextInt(1 +1 ) - 1, 0, r.nextInt(1 + 1 ) -1), Zombie.class);
                                            zombie.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
                                            zombie.setTarget(necromancer.getTarget());
                                            zombie.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, zombie.getLocation(), 1);
                                        }
                                    }
                                    i++;
                                }

                            }
                            else {
                                cancel();

                            }
                        }
                    }.runTaskTimer(main, 0L, 20L);
                }
            }
        }
    @EventHandler
    public void OnChange(EntityChangeBlockEvent event){
        if(event.getEntity() instanceof  FallingBlock){
            if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Necromancer Orb"));
            event.setCancelled(true);
            event.getEntity().remove();
        }
    }
}