package me.rpgmobs.rpgmobs;

import me.rpgmobs.rpgmobs.Utils.MeguminTNT;
import me.rpgmobs.rpgmobs.Utils.TripleShot;
import me.rpgmobs.rpgmobs.Utils.Util;
import me.rpgmobs.rpgmobs.items.Bows.SilverBow;
import me.rpgmobs.rpgmobs.items.EmeraldAxe;
import me.rpgmobs.rpgmobs.items.Helmet.MinerHelmet;
import me.rpgmobs.rpgmobs.items.Itens.IronStick;
import me.rpgmobs.rpgmobs.items.Itens.ObsidianIngot;
import me.rpgmobs.rpgmobs.items.Itens.ObsidianStick;
import me.rpgmobs.rpgmobs.items.Swords.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class RPGMobs extends JavaPlugin {

    // Textos Para o Console do Plugin
    public static Plugin plugin;
    public final String pluginVer = "&6&l1.0.1"
    public final String system = Bukkit.getServer().getName();
    public final String collaborators = "&a&lzHeroDZN";
    public final String author = "&d&lKirito&5&lDzn";
    public final String prefix = me.rpgmobs.rpgmobs.Utils.chat.translated("&4&lRPG &c&lMobs ");

    public static RPGMobs instance;

    @Override
    public void onEnable() {
        // LÓGICA DE INICIALIZADOR DO PLUGIN
        instance = this;
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        // Pasta de Itens

        //Itens
        IronStick.init();
        ObsidianIngot.init();
        ObsidianStick.init();

        //Espadas
        EspadaImortalidade.init();
        EmeraldSword.init();
        ObsidianSword.init();
        AmethystSword.init();
        CopperSword.init();
        EspadasFinas.init();
        EspadasLargas.init();
        MagmaSword.init();

        //Arcos
        SilverBow.init();

        //Machados
        EmeraldAxe.init();

        //Capacetes
        MinerHelmet.init();

        //Cajados
        me.rpgmobs.rpgmobs.items.MeguminWand.init();


        // Importações de Funcionamentos de Comandos
        createFiles();
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this); // ResourcePack Forçado

        this.getServer().getPluginManager().registerEvents(new MeguminTNT(), this); // Funcionamento do Cajado da Megumin
        this.getServer().getPluginManager().registerEvents(new TripleShot(), this); // Funcionamento do Arco de Ferro

        this.getCommand("givemwand").setExecutor(new Comandos());
        this.getCommand("giveminer").setExecutor(new Comandos());


        // MENSAGEM DE INICIAMENTO DO PLUGIN NO CONSOLE
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&b&l-----------------------");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cInfos:");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cNome do Plugin: " + prefix );
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cDesenvolvedor: " + author);
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cColaboradores: " + collaborators);
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&7Version: &b " + pluginVer + "&7 &e" + system);
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&b&l-----------------------");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cSuporte: ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cDiscord: " + "&d&lKiritoDZN#6281");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cDiscord Server: " + "https://discord.gg/zX3AVwcKhQ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&a&lPlugin Iniciado Com Sucesso");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&b&l-----------------------");

        ///////////////////////////////
        // Importação dos Mobs e Sons//
        ///////////////////////////////
        
        // Mobs
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.mobs.Reaper(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.mobs.Warrior(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.mobs.Necromancer(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.mobs.OMinerador(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.mobs.PiglinGravidade(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.mobs.PiglinBrutal(this), this);

        // Sons
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.Sounds.Damage(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.Sounds.Morte(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new me.rpgmobs.rpgmobs.Sounds.Comida(this), this);

    }

    //CONFIGURAÇÕES PARA MEXER AS 3HRS DA MANHÃ
    public final int ReaperSpawnChance = getConfig().getInt("Reaper Spawn Chance");
    public final int WarriorSpawnChance = getConfig().getInt("Warrior Spawn Chance");
    public final int NecromancerSpawnChance = getConfig().getInt("Necromancer Spawn Chance");
    public final int MinerSpawnChance = getConfig().getInt("Miner Spawn Chance");
    public final int GravidadeSpawnChance = getConfig().getInt("Piglin Gravitacional Spawn Chance");
    public final int PiglinBrutalSpawnChance = getConfig().getInt("Piglin Guerreiro Spawn Chance");

    // PACOTE DE RECURSOS
    public final int ResourcePackLink = getConfig().getInt("Resourcepack Link");

    @Override
    public void onDisable() {
        // MENSAGEM DE DESLIGAMENTO DO PLUGIN NO CONSOLE
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&b&l-----------------------");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&cO Plugin Esta Sendo Desligado:");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&dObrigado por usar o Plugin:" + prefix);
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&aO Plugin Foi Desligado com Sucesso!");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&dATE BREVE!");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&r ");
        me.rpgmobs.rpgmobs.Utils.chat.sendToConsole("&b&l-----------------------");
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        FileConfiguration config = RPGMobs.getInstance().getConfig();
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        if (config.get(uuid.toString()) == null) {
            Util.setLocale(p, new File(RPGMobs.getInstance().getDataFolder() + "/locales", "pt-br.yml"));
            return;
        }
        String localeFileName = config.getString(uuid.toString());
        File langFile = new File(RPGMobs.getInstance().getDataFolder() + "/locales", localeFileName + ".yml");
        Util.setLocale(p, langFile);
    }

    //killer.playSound(location, "minecraft:sino", SoundCategory.MASTER, 100, 1);

    private File configf;
    private File itemsf;
    private FileConfiguration config;
    private FileConfiguration items;

    public static RPGMobs getInstance() {
        return instance;
    }

    private void createFiles() {
        configf = new File(getDataFolder(), "config.yml");

        if (!(configf.exists())) {
            configf.getParentFile().mkdir();
            saveResource("config.yml", false);
        }
        config = new YamlConfiguration();
        try {
            config.load(configf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        itemsf = new File(getDataFolder(), "items.yml");

        if (!(itemsf.exists())) {
            itemsf.getParentFile().mkdir();
            saveResource("items.yml", false);
        }
        items = new YamlConfiguration();
        try {
            items.load(itemsf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
