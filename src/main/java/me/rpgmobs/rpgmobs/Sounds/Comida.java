package me.rpgmobs.rpgmobs.Sounds;

import me.rpgmobs.rpgmobs.RPGMobs;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Comida implements Listener {

    RPGMobs main;

    public Comida(RPGMobs plugin) {
        main = plugin;
    }

    // SEMPRE QUE UM JOGADOR CONSUMIR UM ITEM TERÁ A CHANCE DE REPRODUZIR UM NOVO AUDIO
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        ItemStack item = event.getItem();
        Random r = new Random();

        if (item.getType() == Material.COOKED_CHICKEN) {
            //player.playSound(loc, "minecraft:sino", SoundCategory.PLAYERS, 1, 1);
        }
    }
}