package me.kebab.Commands;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Medic
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("medic")) {
      if (args.length == 0) {
        if (!sender.hasPermission("ExtremeCMDS.heal")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player player = (Player)sender;
        double health = player.getMaxHealth();
        player.setHealth(health);
        player.setFoodLevel(20);
        player.setFireTicks(0);
        player.sendMessage(ChatColor.GOLD + "You have been Healed!");
        return true;
      }
      if (args.length == 1) {
        if (!sender.hasPermission("ExtremeCMDS.heal.other")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        double health = target.getMaxHealth();
        target.setHealth(health);
        target.setFoodLevel(20);
        target.setFireTicks(0);
        target.sendMessage(ChatColor.GOLD + "You have been Healed by " + sender.getName() + "!");
        sender.sendMessage(ChatColor.GOLD + "You healed " + target.getName() + "!");
        return true;
      }
      if (args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /medic <player>");
        return true;
      }
    }

    return true;
  }
}