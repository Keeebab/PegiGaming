package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Goto
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("goto")) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /goto <player> <player>");
        return true;
      }
      if (args.length == 1) {
        if (!sender.hasPermission("ExtremeCMDS.goto")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        Player player = (Player)sender;
        if (target == null) {
          player.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        player.teleport(target);
        player.sendMessage(ChatColor.GOLD + "You teleported to " + target.getName() + "!");
        target.sendMessage(ChatColor.GOLD + player.getName() + " teleported to you!");
        return true;
      }
      if (args.length == 2) {
        if (!sender.hasPermission("ExtremeCMDS.goto.other")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        Player target1 = Bukkit.getPlayer(args[1]);
        Player player = (Player)sender;
        if ((target == null) || (target1 == null)) {
          player.sendMessage(ChatColor.RED + "One or both of those players are currently offline!");
          return true;
        }
        target.teleport(target1);
        target.sendMessage(ChatColor.GOLD + sender.getName() + " teleported you to " + target1.getName() + "!");
        target1.sendMessage(ChatColor.GOLD + sender.getName() + " teleported " + target.getName() + " to you!");
        return true;
      }
      if (args.length > 2) {
        sender.sendMessage(ChatColor.RED + "Usage: /goto <player> <player>");
        return true;
      }
    }
    return false;
  }
}