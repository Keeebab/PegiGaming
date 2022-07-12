package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

public class Eat
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("eat")) {
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
        return true;
      }
      if (args.length == 0) {
        if (!sender.hasPermission("ExtremeCMDS.eat")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        Player player = (Player)sender;
        player.setFoodLevel(20);
        player.sendMessage(ChatColor.GOLD + "You have been fed!");
        return true;
      }
      if (args.length == 1) {
        if (!sender.hasPermission("ExtremeCMDS.eat.other")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        target.setFoodLevel(20);
        target.sendMessage(ChatColor.GOLD + "You have been fed by " + sender.getName() + "!");
        sender.sendMessage(ChatColor.GOLD + "You fed " + target.getName() + "!");
        return true;
      }
      if (args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /eat <player>");
        return true;
      }
    }
    return true;
  }
}