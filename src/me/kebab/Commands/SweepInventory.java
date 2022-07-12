package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

@SuppressWarnings("unused")
public class SweepInventory
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("sweepinventory")) || (cmd.getName().equalsIgnoreCase("sw"))) {
      if (args.length == 0) {
        if ((!sender.hasPermission("ExtremeCMDS.sw")) && (sender.hasPermission("ExtremeCMDS.sweepinventory"))) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player player = (Player)sender;
        player.getInventory().clear();
        player.sendMessage(ChatColor.GOLD + "You cleared your Inventory!");
        return true;
      }
      if (args.length == 1) {
        if ((!sender.hasPermission("ExtremeCMDS.sweepinventory.other")) || (!sender.hasPermission("ExtremeCMDS.sw.other"))) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        target.getInventory().clear();
        sender.sendMessage(ChatColor.GOLD + "You cleared " + target.getName() + "'s Inventory!");
        target.sendMessage(ChatColor.GOLD + sender.getName() + " cleared your Inventory!");
        return true;
      }
      if (args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /sweepinventory OR /sw");
        return true;
      }
    }
    return false;
  }
}