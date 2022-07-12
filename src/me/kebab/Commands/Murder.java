package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Murder
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("murder")) {
      if (!sender.hasPermission("ExtremeCMDs.murder")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      if (args.length != 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /murder <player>");
        return true;
      }
      Player target = Bukkit.getPlayer(args[0]);
      if (target == null) {
        sender.sendMessage(ChatColor.RED + "That player is currently offline!");
        return true;
      }
      target.setHealth(0.0D);
      sender.sendMessage(ChatColor.GOLD + "You killed " + target.getName() + "!");
      target.sendMessage(ChatColor.GOLD + sender.getName() + " killed you!");
      return true;
    }
    return false;
  }
}