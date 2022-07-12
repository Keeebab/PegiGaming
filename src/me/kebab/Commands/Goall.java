package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Goall
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("goall")) {
      if (!sender.hasPermission("ExtremeCMDS.goall")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
        return true;
      }
      if (args.length != 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /goall");
        return true;
      }
      Player player = (Player)sender;
      for (Player allplayers : Bukkit.getOnlinePlayers()) {
        allplayers.teleport(player);
      }
      sender.sendMessage(ChatColor.GOLD + "Teleported all players to you!");
      return true;
    }
    return false;
  }
}