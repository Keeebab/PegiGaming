package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gohere
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("gohere")) {
      if (!sender.hasPermission("ExtremeCMDS.gohere")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
        return true;
      }
      if (args.length != 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /gohere <player>");
        return true;
      }
      Player player = (Player)sender;
      Player target = Bukkit.getPlayer(args[0]);
      if (target == null) {
        player.sendMessage(ChatColor.RED + "That player is currently offline!");
        return true;
      }
      target.teleport(player);
      player.sendMessage(ChatColor.GOLD + "You teleported " + target.getName() + " to you!");
      target.sendMessage(ChatColor.GOLD + sender.getName() + " teleported you to them!");
      return true;
    }
    return false;
  }
}