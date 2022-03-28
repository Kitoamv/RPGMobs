package me.rpgmobs.rpgmobs;

import me.rpgmobs.rpgmobs.items.Helmet.MinerHelmet;
import me.rpgmobs.rpgmobs.items.MeguminWand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("&c&lApenas Jogadores podem usar este comando.");
            return true;
        }
        else{
            Player player = (Player)  sender;
            if(player.isOp()){
                if(cmd.getName().equalsIgnoreCase("givemwand")){
                    player.getInventory().addItem(MeguminWand.MWand);
                }
                if(cmd.getName().equalsIgnoreCase("giveminer")){
                    player.getInventory().addItem(MinerHelmet.MinerHelmet);
                }
            }
            else{
                sender.sendMessage("&4&lVocê não tem permissão para usar este comando.");
            }
            return true;
        }
    }
}
