package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

@SuppressWarnings("unused")
public class O
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("object")) || (cmd.getName().equalsIgnoreCase("o"))) {
      if (!sender.hasPermission("ExtremeCMDS.object")) {
        sender.sendMessage(this.plugin.permission);
        return true;
      }
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /object <item> <amount>");
        return true;
      }
      if (args.length == 1) {
        int item = 0;
        try {
          item = Integer.parseInt(args[0]);
          Player player = (Player)sender;
          ItemStack itemreal = new ItemStack(item, 64);
          player.getInventory().addItem(new ItemStack[] { itemreal });
          player.sendMessage(ChatColor.GOLD + "You have been given 64 of " + itemreal.getType().toString() + "!");
          return true;
        }
        catch (NumberFormatException ex) {
          try {
            Material mat = Material.getMaterial(args[0].toUpperCase());
            ItemStack realmat = new ItemStack(mat, 64);
            Player player = (Player)sender;
            player.getInventory().addItem(new ItemStack[] { realmat });
            player.sendMessage(ChatColor.GOLD + "You have been given 64 of " + realmat.getType().toString() + "!");
          }
          catch (NullPointerException exe) {
            sender.sendMessage(ChatColor.RED + args[0] + " is not an item!");
            return true;
          }

          return true;
        }
      }
      if (args.length == 2) {
        int item = 0;
        int amount = 0;
        try {
          item = Integer.parseInt(args[0]);
          amount = Integer.parseInt(args[1]);
          Player player = (Player)sender;
          ItemStack itemreal = new ItemStack(item, amount);
          player.getInventory().addItem(new ItemStack[] { itemreal });
          player.sendMessage(ChatColor.GOLD + "You have been given " + amount + " of " + itemreal.getType().toString() + "!");
          return true;
        }
        catch (NumberFormatException ex) {
          try {
            amount = Integer.parseInt(args[1]);
            Material mat = Material.getMaterial(args[0].toUpperCase());
            ItemStack realmat = new ItemStack(mat, amount);
            Player player = (Player)sender;
            player.getInventory().addItem(new ItemStack[] { realmat });
            player.sendMessage(ChatColor.GOLD + "You have been given " + amount + " of " + realmat.getType().toString() + "!");
          }
          catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + args[1] + " is not a number!");
          }
          catch (NullPointerException exe) {
            sender.sendMessage(ChatColor.RED + args[0] + " is not an item!");
            return true;
          }

          return true;
        }
      }
      if (args.length == 3) {
        int item = 0;
        int amount = 0;
        try {
          item = Integer.parseInt(args[1]);
          amount = Integer.parseInt(args[2]);
          Player target = Bukkit.getPlayer(args[0]);
          if (target == null) {
            sender.sendMessage(ChatColor.RED + "That player is currently offline!");
            return true;
          }
          ItemStack itemreal = new ItemStack(item, amount);
          target.getInventory().addItem(new ItemStack[] { itemreal });
          target.sendMessage(ChatColor.GOLD + "You have been given " + amount + " of " + itemreal.getType().toString() + "!");
          return true;
        }
        catch (NumberFormatException ex) {
          try {
            amount = Integer.parseInt(args[2]);
            Material mat = Material.getMaterial(args[1].toUpperCase());
            ItemStack realmat = new ItemStack(mat, amount);
            Player target = Bukkit.getPlayer(args[0]);
            target.getInventory().addItem(new ItemStack[] { realmat });
            target.sendMessage(ChatColor.GOLD + "You have been given " + amount + " of " + realmat.getType().toString() + "!");
          }
          catch (NumberFormatException e) {
            Player target = Bukkit.getPlayer(args[0]);
            target.sendMessage(ChatColor.RED + args[1] + " is not a number!");
          }
          catch (NullPointerException exe) {
            Player target = Bukkit.getPlayer(args[0]);
            target.sendMessage(ChatColor.RED + args[1] + " is not an item!");
            return true;
          }
        }
      }
      else if (args.length > 2) {
        sender.sendMessage(ChatColor.RED + "Usage: /object <item> <amount>");
        return true;
      }
    }
    return false;
  }
}