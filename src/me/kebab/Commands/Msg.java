package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

public class Msg
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("msg")) {
      if (!sender.hasPermission("ExtremeCMDS.msg")) {
        sender.sendMessage(this.plugin.permission);
        return true;
      }
      if (args.length < 2) {
        sender.sendMessage(ChatColor.RED + "Usage: /msg <player> <message>");
        return true;
      }
      String msg = "";
      for (int i = 1; i < args.length; i++) {
        msg = msg + args[i] + " ";
      }
      Player target = Bukkit.getPlayer(args[0]);
      if (target == null) {
        sender.sendMessage(ChatColor.RED + "That player is currently offline!");
        return true;
      }
      target.sendMessage(ChatColor.GOLD + sender.getName() + ": " + ChatColor.YELLOW + msg);
      sender.sendMessage(ChatColor.GOLD + "You -> " + target.getName() + ": " + ChatColor.YELLOW + msg);
      return true;
    }
    return false;
  }
}