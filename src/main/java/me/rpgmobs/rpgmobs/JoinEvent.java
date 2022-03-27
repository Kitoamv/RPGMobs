package me.rpgmobs.rpgmobs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements  Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack(
                "https://www.dropbox.com/sh/hesgvc2qew5x4ui/AADs1qDhTkVj6n7uwkdxYf4Ya?dl==1"); //Download do Resource Pack
        // Texture Pack :)
    }
}
