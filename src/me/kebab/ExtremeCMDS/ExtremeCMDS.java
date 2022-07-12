package me.kebab.ExtremeCMDS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;

import me.kebab.Commands.Armor;
import me.kebab.Commands.Eat;
import me.kebab.Commands.Expel;
import me.kebab.Commands.Freeze;
import me.kebab.Commands.Getip;
import me.kebab.Commands.Goall;
import me.kebab.Commands.Gohere;
import me.kebab.Commands.Goto;
import me.kebab.Commands.Home;
import me.kebab.Commands.Itemrename;
import me.kebab.Commands.Locate;
import me.kebab.Commands.MaxHealth;
import me.kebab.Commands.Mode;
import me.kebab.Commands.Msg;
import me.kebab.Commands.Murder;
import me.kebab.Commands.Nicknames;
import me.kebab.Commands.O;
import me.kebab.Commands.SweepInventory;
import me.kebab.Commands.Medic;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import Events.Events;

@SuppressWarnings("unused")
public class ExtremeCMDS extends JavaPlugin
{
  public class ExtremeCMDS {

	}

@SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList<String> frozen = new ArrayList();
  public String permission = ChatColor.RED + "Usage: /nickname <nick> OR /nickname <player> <nickname>";

  public CustomConfig nicknames = new CustomConfig("nicknames");
  public CustomConfig IPs = new CustomConfig("IPs");
  public CustomConfig homes = new CustomConfig("homes");
  public CustomConfig FrozenPlayers = new CustomConfig("FrozenPlayers");

 

public void onEnable()
  {
    getConfig().options().copyDefaults(true);
    saveConfig();
    getServer().getPluginManager().registerEvents(new Events(this), this);
    getCommand("medic").setExecutor(new me.kebab.Commands.Medic());
    getCommand("server").setExecutor(new me.kebab.Commands.Server(this));
    getCommand("MOTD").setExecutor(new me.kebab.Commands.Server(this));
    getCommand("mode").setExecutor(new Mode());
    getCommand("eat").setExecutor(new Eat());
    getCommand("locate").setExecutor(new Locate());
    getCommand("MaxHealth").setExecutor(new MaxHealth(this));
    getCommand("goto").setExecutor(new Goto());
    getCommand("gohere").setExecutor(new Gohere());
    getCommand("goall").setExecutor(new Goall());
    getCommand("sweepinventory").setExecutor(new SweepInventory());
    getCommand("Armor").setExecutor(new Armor());
    getCommand("rename").setExecutor(new Itemrename());
    getCommand("addlore").setExecutor(new Itemrename());
    getCommand("murder").setExecutor(new Murder());
    getCommand("getip").setExecutor(new Getip(this));
    getCommand("expel").setExecutor(new Expel());
    getCommand("boot").setExecutor(new Expel());
    getCommand("unexpel").setExecutor(new Expel());
    getCommand("nickname").setExecutor(new Nicknames(this));
    getCommand("sethome").setExecutor(new Home(this));
    getCommand("home").setExecutor(new Home(this));
    getCommand("msg").setExecutor(new Msg());
    getCommand("object").setExecutor(new O());
    getCommand("freeze").setExecutor(new Freeze(this));
    getCommand("unfreeze").setExecutor(new Freeze(this));
    saveDefaultConfig(this.nicknames);
    saveDefaultConfig(this.IPs);
    saveDefaultConfig(this.homes);
    saveDefaultConfig(this.FrozenPlayers);
  }

  public FileConfiguration getCustomConfig(CustomConfig config)
  {
    if (config.fileConfig == null) {
      reloadCustomConfig(config);
    }
    return config.fileConfig;
  }

  public void reloadCustomConfig(CustomConfig config)
  {
    if (config.fileConfig == null) {
      config.file = new File(getDataFolder(), config.name + ".yml");
    }
    config.fileConfig = YamlConfiguration.loadConfiguration(config.file);

    InputStream defConfigStream = getResource(config.name + ".yml");
    if (defConfigStream != null) {
      YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
      config.fileConfig.setDefaults(defConfig);
    }
  }

  public void saveCustomConfig(CustomConfig config) { if ((config.fileConfig == null) || (config.file == null))
      return;
    try
    {
      getCustomConfig(config).save(config.file);
    } catch (IOException ex) {
      getLogger().log(Level.SEVERE, "Could not save config to " + config.file, ex);
    } }

  public void saveDefaultConfig(CustomConfig config) {
    if (config.file == null) {
      config.file = new File(getDataFolder(), config.name + ".yml");
    }
    if (!config.file.exists())
      saveResource(config.name + ".yml", false);
  }

  public class CustomConfig
  {
    private String name;
    private File file;
    private FileConfiguration fileConfig;

    public CustomConfig(String name)
    {
      this.name = name;
    }
  }
}