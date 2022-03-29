package me.rpgmobs.rpgmobs.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class MeguminTNT implements Listener {

    List<FallingBlock> throwedtnt = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (Cooldown.checkCooldown(event.getPlayer())) {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null
                        && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.GRAY + "- Arremesa uma magia explosiva capaz de explodir os inimigos")) {
                    FallingBlock tnt = event.getPlayer().getWorld().spawnFallingBlock(event.getPlayer().getEyeLocation(), Material.TNT, (byte) 0);
                    tnt.setDropItem(false);
                    throwedtnt.add(tnt);
                    tnt.setVelocity(event.getPlayer().getLocation().getDirection().multiply(3));
                    event.setCancelled(true);
                    Cooldown.setCooldown(event.getPlayer(), 5);
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "A Habilidade ainda não está preparada.");
                }
            }
        }
    }

    @EventHandler
    public void onFall(EntityChangeBlockEvent event){
        if(event.getEntity() instanceof  FallingBlock){
            if(throwedtnt.contains(event.getEntity())){
                event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 15, false, false);
                event.setCancelled(true);
                event.getEntity().remove();;
                throwedtnt.remove(event.getEntity());
            }
        }
    }
}
