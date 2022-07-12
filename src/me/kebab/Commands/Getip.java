package me.kebab.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

@SuppressWarnings("unused")
public class Getip
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public Getip(ExtremeCMDS instance)
  {
    this.plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
    if (cmd.getName().equalsIgnoreCase("getip")) {
      if (!sender.hasPermission("ExtremeCMDS.getip")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      if (args.length != 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /getip <player>");
        return true;
      }
      if (!this.plugin.getCustomConfig(this.plugin.IPs).contains(args[0])) {
        sender.sendMessage(ChatColor.RED + "That player has never been online!");
        return true;
      }
      String ip = this.plugin.getCustomConfig(this.plugin.IPs).getString(args[0]);
      sender.sendMessage(ChatColor.GOLD + args[0] + "'s IP Address is: " + ip + "!");
      return true;
    }
    return false;
  }
}