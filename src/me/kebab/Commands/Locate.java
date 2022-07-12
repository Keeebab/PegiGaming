package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

public class Locate
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("locate")) {
      if (args.length == 0) {
        if (!sender.hasPermission("ExtremeCMD.locate")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player player = (Player)sender;
        Location loc = player.getLocation();
        String location = ChatColor.GOLD + "Your current location is - x: " + (int)loc.getX() + ", y: " + (int)loc.getY() + ", z: " + (int)loc.getZ() + "!";
        player.sendMessage(location);
        return true;
      }
      if (args.length == 1) {
        if (!sender.hasPermission("ExtremeCMD.locate.other")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        Location loc = target.getLocation();
        String location = ChatColor.GOLD + target.getName() + "'s location is - x: " + (int)loc.getX() + ", y: " + (int)loc.getY() + ", z: " + (int)loc.getZ() + "!";
        sender.sendMessage(location);
        return true;
      }
      if (args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /locate <player>");
        return true;
      }
    }
    return true;
  }
}