package me.kebab.Commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class Itemrename
  implements CommandExecutor
{
  private String colours(String string)
  {
    String s = ChatColor.translateAlternateColorCodes('&', string);
    return s;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    ArrayList<String> lore = new ArrayList<String>();

    if (cmd.getName().equalsIgnoreCase("rename")) {
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /rename <name>");
        return true;
      }
      if (!sender.hasPermission("ExtremeCMDS.rename")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      Player player = (Player)sender;
      if (player.getItemInHand().getType() == Material.AIR) {
        player.sendMessage(ChatColor.RED + "You cannot rename nothing!");
        return true;
      }
      ItemStack item = new ItemStack(player.getInventory().getItemInHand());
      ItemMeta meta = item.getItemMeta();
      String message = "";
      for (int i = 0; i < args.length; i++) {
        message = message + args[i] + " ";
      }
      meta.setDisplayName(colours(message));
      player.getInventory().getItemInHand().setItemMeta(meta);
      player.sendMessage(ChatColor.BLUE + "Successfully renamed item!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("addlore")) {
      if (!sender.hasPermission("ExtremeCMDS.addlore")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to add lore to this item!");
        return true;
      }
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /addlore <lore>");
        return true;
      }
      Player player = (Player)sender;
      if (player.getItemInHand().getType() == Material.AIR) {
        player.sendMessage(ChatColor.RED + "You cannot add lore to nothing!");
        return true;
      }
      ItemStack item = new ItemStack(player.getInventory().getItemInHand());
      ItemMeta meta = item.getItemMeta();
      String message = "";
      for (int i = 0; i < args.length; i++) {
        message = message + args[i] + " ";
      }
      lore.add(colours(message));
      meta.setLore(lore);
      player.getInventory().getItemInHand().setItemMeta(meta);
      lore.remove(message);
      player.sendMessage(ChatColor.BLUE + "Successfully added lore to the item!");
      return true;
    }
    return false;
  }
}