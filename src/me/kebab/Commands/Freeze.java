package me.kebab.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

@SuppressWarnings("unused")
public class Freeze
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public Freeze(ExtremeCMDS instance)
  {
    this.plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
    if (cmd.getName().equalsIgnoreCase("freeze")) {
      if (!sender.hasPermission("ExtremeCMDS.freeze")) {
        sender.sendMessage(this.plugin.permission);
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /freeze <player>");
        return true;
      }
      if (args.length == 1) {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        if (!this.plugin.frozen.contains(target.getName())) {
          this.plugin.frozen.add(target.getName());
          this.plugin.getCustomConfig(this.plugin.FrozenPlayers).set(sender.getName(), target.getName());
          this.plugin.saveCustomConfig(this.plugin.FrozenPlayers);
          sender.sendMessage(ChatColor.GOLD + "You froze " + target.getName() + "!");
          return true;
        }
        sender.sendMessage(ChatColor.RED + "That player is already frozen!");
        return true;
      }
      if (args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /freeze <player>");
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("unfreeze")) {
      if (!sender.hasPermission("ExtremeCMDS.unfreeze")) {
        sender.sendMessage(this.plugin.permission);
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /unfreeze <player>");
        return true;
      }
      if (args.length == 1) {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        if (!this.plugin.frozen.contains(target.getName())) {
          sender.sendMessage(ChatColor.RED + "That player is not frozen!");
          return true;
        }
        this.plugin.frozen.remove(target.getName());
        this.plugin.getCustomConfig(this.plugin.FrozenPlayers).set(sender.getName(), null);
        this.plugin.saveCustomConfig(this.plugin.FrozenPlayers);
        sender.sendMessage(ChatColor.RED + "You unfroze " + target.getName() + "!");
        sender.sendMessage(ChatColor.GREEN + "You have been unfroze!");
        return true;
      }
    }
    return false;
  }
}