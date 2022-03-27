package me.rpgmobs.rpgmobs.Sounds;

import me.rpgmobs.rpgmobs.RPGMobs;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class Morte implements Listener {

    RPGMobs main;

    public Morte(RPGMobs plugin) {
        main = plugin;
    }

    // SEMPRE QUE UM MOB MORRER TERÁ A CHANCE DE REPRODUZIR UM NOVO AUDIO
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Location loc = entity.getLocation();
        World world = entity.getWorld();
        EntityType type = entity.getType();
        Random r = new Random();
        Player killer = ((LivingEntity) entity).getKiller();

        if (type == EntityType.ZOMBIE) {
            //float chance = r.nextFloat();
            //if (chance < 0.05f) // chance de 5%
            //{
                //killer.playSound(loc, "minecraft:sinowww", SoundCategory.PLAYERS, 1, 1);
            //}
        }
        if (type == EntityType.SKELETON) {
            //float chance = r.nextFloat();
            //if (chance < 0.05f) // chance de 5%
            //{
                //killer.playSound(loc, "minecraft:sinowww", SoundCategory.PLAYERS, 1, 1);
            //}
        }
    }
}