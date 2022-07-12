package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

@SuppressWarnings("unused")
public class MaxHealth
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public MaxHealth(ExtremeCMDS instance)
  {
    this.plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
    if (cmd.getName().equalsIgnoreCase("maxhealth")) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /maxhealth <amount> OR /maxhealth <player> <amount>");
        return true;
      }
      if (args.length == 1) {
        if (!sender.hasPermission("ExtremeCMDS.Maxhealth")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player player = (Player)sender;
        double health = 0.0D;
        try {
          health = Integer.parseInt(args[0]);
        }
        catch (Exception NumberFormatException) {
          sender.sendMessage(ChatColor.RED + "You must enter a number!");
          return true;
        }
        if (health < 1.0D) {
          sender.sendMessage(ChatColor.RED + "Please enter a number between 1 and " + this.plugin.getConfig().getInt("MaxHealthMaxHearts") + "!");
          return true;
        }
        if (health > this.plugin.getConfig().getInt("MaxHealthMaxHearts")) {
          sender.sendMessage(ChatColor.RED + "Please enter a number between 1 and " + this.plugin.getConfig().getInt("MaxHealthMaxHearts") + "!");
          return true;
        }
        player.setMaxHealth(health);
        player.setHealth(health);
        player.sendMessage(ChatColor.GOLD + "MaxHealth set to " + args[0] + " halfhearts!");
        return true;
      }
      if (args.length == 2) {
        if (!sender.hasPermission("ExtremeCMDS.Maxhealth.other")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        double health = 0.0D;
        try {
          health = Integer.parseInt(args[1]);
        }
        catch (Exception NumberFormatException) {
          sender.sendMessage(ChatColor.RED + "You must enter a number!");
          return true;
        }
        if (health < 1.0D) {
          sender.sendMessage(ChatColor.RED + "Please enter a number between 1 and " + this.plugin.getConfig().getInt("MaxHealthMaxHearts") + "!");
          return true;
        }
        if (health > this.plugin.getConfig().getInt("MaxHealthMaxHearts")) {
          sender.sendMessage(ChatColor.RED + "Please enter a number between 1 and " + this.plugin.getConfig().getInt("MaxHealthMaxHearts") + "!");
          return true;
        }
        target.setMaxHealth(health);
        target.setHealth(health);
        sender.sendMessage(ChatColor.GOLD + "You set " + target.getName() + "'s MaxHealth to " + args[1] + "!");
        target.sendMessage(ChatColor.GOLD + sender.getName() + " set your MaxHealth to " + args[1] + "!");
        return true;
      }
      if (args.length > 2) {
        sender.sendMessage(ChatColor.RED + "Usage: /maxhealth <amount> OR /maxhealth <player> <amount>");
        return true;
      }
    }
    return false;
  }
}