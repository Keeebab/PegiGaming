package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

@SuppressWarnings("unused")
public class Nicknames
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public String colours(String string)
  {
    String s = ChatColor.translateAlternateColorCodes('&', string);
    return s;
  }
  public Nicknames(ExtremeCMDS instance) {
    this.plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
    if ((cmd.getName().equalsIgnoreCase("nickname")) || (cmd.getName().equalsIgnoreCase("nick"))) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /nickname <nick> OR /nickname <player> <nickname>");
        return true;
      }
      if (args.length == 1) {
        if ((!sender.hasPermission("ExtremeCMDS.nickame")) && (sender.hasPermission("ExtremeCMDS.nick"))) {
          sender.sendMessage(this.plugin.permission);
          return true;
        }
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
          return true;
        }
        Player player = (Player)sender;
        String nocolors = ChatColor.stripColor(args[0].replace('&', '�'));
        if (nocolors.length() == 0) {
          sender.sendMessage(ChatColor.RED + "Please enter a valid nickname!");
          return true;
        }
        player.setDisplayName(colours(args[0]) + ChatColor.RESET);
        player.sendMessage(ChatColor.GOLD + "Successfully changed displayname to: " + ChatColor.RESET + colours(args[0]));
        this.plugin.getCustomConfig(this.plugin.nicknames).set(player.getName(), player.getDisplayName());
        this.plugin.saveCustomConfig(this.plugin.nicknames);
        return true;
      }
      if (args.length == 2) {
        if ((!sender.hasPermission("ExtremeCMDS.nickname.other")) && (sender.hasPermission("ExtremeCMDS.nick.other"))) {
          sender.sendMessage(this.plugin.permission);
          return true;
        }
        Player player = (Player)sender;
        String nocolors = ChatColor.stripColor(args[1].replace('&', '�'));
        if (nocolors.length() == 0) {
          sender.sendMessage(ChatColor.RED + "Please enter a valid nickname!");
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }
        target.setDisplayName(colours(args[1]));
        this.plugin.getCustomConfig(this.plugin.nicknames).set(target.getName(), target.getDisplayName());
        this.plugin.saveCustomConfig(this.plugin.nicknames);
        target.sendMessage(ChatColor.GOLD + sender.getName() + " changed your displayname to: " + ChatColor.RESET + colours(args[1]));
        player.sendMessage(ChatColor.GOLD + "Successfully changed " + target.getName() + "'s displayname to: " + ChatColor.RESET + colours(args[1]));
      }
      else if (args.length > 2) {
        sender.sendMessage(ChatColor.RED + "Usage: /nickname <nick> OR /nickname <player> <nickname>");
        return true;
      }

      return true;
    }
    return false;
  }
}