package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Expel
  implements CommandExecutor
{
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("expel")) {
      if (!sender.hasPermission("ExtremeCMDS.expel")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /expel <player> <reason>");
        return true;
      }
      if (args.length == 1) {
        Player target = Bukkit.getPlayer(args[0]);
        OfflinePlayer offline = Bukkit.getPlayer(args[0]);
        if (target == null) {
          offline.setBanned(true);
          Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " expelled player " + args[0] + " for: No Reason Specified!");
          return true;
        }
        target.setBanned(true);
        target.kickPlayer(ChatColor.GOLD + sender.getName() + " expelled you for: No Reason Specified!");
        return true;
      }
      if (args.length > 1) {
        Player target = Bukkit.getPlayer(args[0]);
        OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);
        String reason = "";
        for (int i = 1; i < args.length; i++) {
          reason = reason + args[i] + " ";
        }
        if (target == null) {
          if (offline.isBanned()) {
            sender.sendMessage(ChatColor.RED + args[0] + " is already expelled!");
            return true;
          }
          offline.setBanned(true);
          Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " expelled player " + args[0] + " for: " + reason);
          return true;
        }
        target.setBanned(true);
        target.kickPlayer(ChatColor.GOLD + sender.getName() + " expelled you for: " + reason);
        Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " banned player " + args[0] + " for: " + reason);
        return true;
      }
    } else {
      if (cmd.getName().equalsIgnoreCase("unexpel")) {
        if (!sender.hasPermission("ExtremeCMDS.unexpel")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (args.length != 1) {
          sender.sendMessage(ChatColor.RED + "Usage: /unexpel <player>");
          return true;
        }
        OfflinePlayer offline = Bukkit.getOfflinePlayer(args[0]);
        if (!offline.isBanned()) {
          sender.sendMessage(ChatColor.RED + "That player is not expelled!");
          return true;
        }
        offline.setBanned(false);
        Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " unbanned the player " + args[0] + "!");
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("boot")) {
        if (!sender.hasPermission("ExtremeCMDS.boot")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (args.length == 0) {
          sender.sendMessage(ChatColor.RED + "Usage: /boot <player> <reason>");
          return true;
        }
        if (args.length == 1) {
          Player target = Bukkit.getPlayer(args[0]);
          if (target == null) {
            sender.sendMessage(ChatColor.RED + "That player is currently offline!");
            return true;
          }
          target.kickPlayer(ChatColor.GOLD + sender.getName() + " kicked you for: No Reason Specified!");
          Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " kicked the player " + target.getName() + " for: No Reason Specified!");
          return true;
        }
        if (args.length > 1) {
          Player target = Bukkit.getPlayer(args[0]);
          if (target == null) {
            sender.sendMessage(ChatColor.RED + "That player is currently offline!");
            return true;
          }
          String reason = "";
          for (int i = 1; i < args.length; i++) {
            reason = reason + args[i] + " ";
          }
          target.kickPlayer(ChatColor.GOLD + sender.getName() + " kicked you for: " + reason);
          Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + " kicked the player " + target.getName() + " for: " + reason);
          return true;
        }
      }
      else if (!cmd.getName().equalsIgnoreCase("quiet"))
      {
        cmd.getName().equalsIgnoreCase("voice");
      }
    }
    return false;
  }
}