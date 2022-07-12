package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

public class Mode
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("mode"))
    {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /mode <(0)survival;(1)creative;(2)adventure> <player>");
        return true;
      }

      if (args.length == 1)
      {
        if (!sender.hasPermission("ExtremeCMDS.mode")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }

        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }

        if ((args[0].equalsIgnoreCase("c")) || (args[0].equalsIgnoreCase("cr")) || (args[0].equalsIgnoreCase("cre")) || (args[0].equalsIgnoreCase("crea")) || (args[0].equalsIgnoreCase("creat")) || (args[0].equalsIgnoreCase("creati")) || (args[0].equalsIgnoreCase("creativ")) || (args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("1"))) {
          Player player = (Player)sender;
          player.setGameMode(GameMode.CREATIVE);
          player.sendMessage(ChatColor.GOLD + "Gamemode successfully set to " + ChatColor.RED + "CREATIVE!");
          return true;
        }

        if ((args[0].equalsIgnoreCase("s")) || (args[0].equalsIgnoreCase("su")) || (args[0].equalsIgnoreCase("sur")) || (args[0].equalsIgnoreCase("surv")) || (args[0].equalsIgnoreCase("survi")) || (args[0].equalsIgnoreCase("surviv")) || (args[0].equalsIgnoreCase("surviva")) || (args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("0"))) {
          Player player = (Player)sender;
          player.setGameMode(GameMode.SURVIVAL);
          player.sendMessage(ChatColor.GOLD + "Gamemode successfully set to " + ChatColor.RED + "SURVIVAL!");
          return true;
        }

        if ((args[0].equalsIgnoreCase("a")) || (args[0].equalsIgnoreCase("ad")) || (args[0].equalsIgnoreCase("adv")) || (args[0].equalsIgnoreCase("adve")) || (args[0].equalsIgnoreCase("adven")) || (args[0].equalsIgnoreCase("advent")) || (args[0].equalsIgnoreCase("adventu")) || (args[0].equalsIgnoreCase("adventur")) || (args[0].equalsIgnoreCase("adventure")) || (args[0].equalsIgnoreCase("2"))) {
          Player player = (Player)sender;
          player.setGameMode(GameMode.ADVENTURE);
          player.sendMessage(ChatColor.GOLD + "Gamemode successfully set to " + ChatColor.RED + "ADVENTURE!");
          return true;
        }

      }
      else if (args.length == 2)
      {
        if (!sender.hasPermission("ExtremeCMDS.mode.other")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
          return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + "That player is currently offline!");
          return true;
        }

        if ((args[0].equalsIgnoreCase("c")) || (args[0].equalsIgnoreCase("cr")) || (args[0].equalsIgnoreCase("cre")) || (args[0].equalsIgnoreCase("crea")) || (args[0].equalsIgnoreCase("creat")) || (args[0].equalsIgnoreCase("creati")) || (args[0].equalsIgnoreCase("creativ")) || (args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("1"))) {
          target.setGameMode(GameMode.CREATIVE);
          target.sendMessage(ChatColor.GOLD + "Gamemode successfully set to " + ChatColor.RED + "CREATIVE!");
          sender.sendMessage(ChatColor.GOLD + "Successfully changed " + target.getName() + "'s mode to " + ChatColor.RED + "CREATIVE!");
          return true;
        }

        if ((args[0].equalsIgnoreCase("s")) || (args[0].equalsIgnoreCase("su")) || (args[0].equalsIgnoreCase("sur")) || (args[0].equalsIgnoreCase("surv")) || (args[0].equalsIgnoreCase("survi")) || (args[0].equalsIgnoreCase("surviv")) || (args[0].equalsIgnoreCase("surviva")) || (args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("0"))) {
          target.setGameMode(GameMode.SURVIVAL);
          target.sendMessage(ChatColor.GOLD + "Gamemode successfully set to " + ChatColor.RED + "SURVIVAL!");
          sender.sendMessage(ChatColor.GOLD + "Successfully changed " + target.getName() + "'s mode to " + ChatColor.RED + "SURVIVAL!");
          return true;
        }

        if ((args[0].equalsIgnoreCase("a")) || (args[0].equalsIgnoreCase("ad")) || (args[0].equalsIgnoreCase("adv")) || (args[0].equalsIgnoreCase("adve")) || (args[0].equalsIgnoreCase("adven")) || (args[0].equalsIgnoreCase("advent")) || (args[0].equalsIgnoreCase("adventu")) || (args[0].equalsIgnoreCase("adventur")) || (args[0].equalsIgnoreCase("adventure")) || (args[0].equalsIgnoreCase("2"))) {
          target.setGameMode(GameMode.ADVENTURE);
          target.sendMessage(ChatColor.GOLD + "Gamemode successfully set to " + ChatColor.RED + "ADVENTURE!");
          sender.sendMessage(ChatColor.GOLD + "Successfully changed " + target.getName() + "'s mode to " + ChatColor.RED + "ADVENTURE!");
          return true;
        }

      }
      else if (args.length > 2) {
        sender.sendMessage(ChatColor.RED + "Usage: /mode <(0)survival;(1)creative;(2)adventure> <player>");
        return true;
      }
    }
    return true;
  }
}