package me.kebab.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class Armor
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("armor")) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /armor leather:gold:iron:chain:diamond:god");
        return true;
      }
      if (args.length == 1) {
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You must be a Player to execute this command!");
          return true;
        }
        Player player = (Player)sender;
        if (player.getInventory().getHelmet() != null) {
          sender.sendMessage(ChatColor.RED + "You must take off your helmet to perform this command!");
        }

        if (player.getInventory().getChestplate() != null) {
          sender.sendMessage(ChatColor.RED + "You must take off your chestplate to perform this command!");
        }

        if (player.getInventory().getLeggings() != null) {
          sender.sendMessage(ChatColor.RED + "You must take off your leggings to perform this command!");
        }

        if (player.getInventory().getBoots() != null) {
          sender.sendMessage(ChatColor.RED + "You must take off your boots to perform this command!");
          return true;
        }

        if (args[0].equalsIgnoreCase("leather")) {
          if (!sender.hasPermission("ExtremeCMDS.armor.leather")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
          }
          ItemStack leatherhelmet = new ItemStack(Material.LEATHER_HELMET);
          ItemMeta meta = leatherhelmet.getItemMeta();
          meta.setDisplayName(ChatColor.GOLD + "Leather Helmet");
          leatherhelmet.setItemMeta(meta);
          player.getInventory().setHelmet(leatherhelmet);

          ItemStack leatherchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
          ItemMeta meta1 = leatherchestplate.getItemMeta();
          meta1.setDisplayName(ChatColor.GOLD + "Leather Chestplate");
          leatherchestplate.setItemMeta(meta1);
          player.getInventory().setChestplate(leatherchestplate);

          ItemStack leatherleggings = new ItemStack(Material.LEATHER_LEGGINGS);
          ItemMeta meta2 = leatherleggings.getItemMeta();
          meta2.setDisplayName(ChatColor.GOLD + "Leather Leggings");
          leatherleggings.setItemMeta(meta2);
          player.getInventory().setLeggings(leatherleggings);

          ItemStack leatherboots = new ItemStack(Material.LEATHER_BOOTS);
          ItemMeta meta3 = leatherboots.getItemMeta();
          meta3.setDisplayName(ChatColor.GOLD + "Leather Boots");
          leatherboots.setItemMeta(meta3);
          player.getInventory().setBoots(leatherboots);

          ItemStack woodensword = new ItemStack(Material.WOOD_SWORD);
          ItemMeta meta4 = woodensword.getItemMeta();
          meta4.setDisplayName(ChatColor.GOLD + "Wooden Sword");
          woodensword.setItemMeta(meta4);
          player.getInventory().addItem(new ItemStack[] { woodensword });

          player.sendMessage(ChatColor.GOLD + "You have been equipped with Leather Armor and a Wooden Sword!");
          return true;
        }
        if (args[0].equalsIgnoreCase("gold")) {
          if (!sender.hasPermission("ExtremeCMDS.armor.gold")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
          }
          ItemStack goldhelmet = new ItemStack(Material.GOLD_HELMET);
          ItemMeta meta = goldhelmet.getItemMeta();
          meta.setDisplayName(ChatColor.GOLD + "Gold Helmet");
          goldhelmet.setItemMeta(meta);
          player.getInventory().setHelmet(goldhelmet);

          ItemStack goldchestplate = new ItemStack(Material.GOLD_CHESTPLATE);
          ItemMeta meta1 = goldchestplate.getItemMeta();
          meta1.setDisplayName(ChatColor.GOLD + "Gold Chestplate");
          goldchestplate.setItemMeta(meta1);
          player.getInventory().setChestplate(goldchestplate);

          ItemStack goldleggings = new ItemStack(Material.GOLD_LEGGINGS);
          ItemMeta meta2 = goldleggings.getItemMeta();
          meta2.setDisplayName(ChatColor.GOLD + "Gold Leggings");
          goldleggings.setItemMeta(meta2);
          player.getInventory().setLeggings(goldleggings);

          ItemStack goldboots = new ItemStack(Material.GOLD_BOOTS);
          ItemMeta meta3 = goldboots.getItemMeta();
          meta3.setDisplayName(ChatColor.GOLD + "Gold Boots");
          goldboots.setItemMeta(meta3);
          player.getInventory().setBoots(goldboots);

          ItemStack goldsword = new ItemStack(Material.GOLD_SWORD);
          ItemMeta meta4 = goldsword.getItemMeta();
          meta4.setDisplayName(ChatColor.GOLD + "Gold Sword");
          goldsword.setItemMeta(meta4);
          player.getInventory().addItem(new ItemStack[] { goldsword });

          player.sendMessage(ChatColor.GOLD + "You have been equipped with Gold Armor and a Golden Sword!");
          return true;
        }
        if (args[0].equalsIgnoreCase("iron")) {
          if (!sender.hasPermission("ExtremeCMDS.armor.iron")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
          }
          ItemStack IRONhelmet = new ItemStack(Material.IRON_HELMET);
          ItemMeta meta = IRONhelmet.getItemMeta();
          meta.setDisplayName(ChatColor.GOLD + "Iron Helmet");
          IRONhelmet.setItemMeta(meta);
          player.getInventory().setHelmet(IRONhelmet);

          ItemStack IRONchestplate = new ItemStack(Material.IRON_CHESTPLATE);
          ItemMeta meta1 = IRONchestplate.getItemMeta();
          meta1.setDisplayName(ChatColor.GOLD + "Iron Chestplate");
          IRONchestplate.setItemMeta(meta1);
          player.getInventory().setChestplate(IRONchestplate);

          ItemStack IRONleggings = new ItemStack(Material.IRON_LEGGINGS);
          ItemMeta meta2 = IRONleggings.getItemMeta();
          meta2.setDisplayName(ChatColor.GOLD + "Iron Leggings");
          IRONleggings.setItemMeta(meta2);
          player.getInventory().setLeggings(IRONleggings);

          ItemStack IRONboots = new ItemStack(Material.IRON_BOOTS);
          ItemMeta meta3 = IRONboots.getItemMeta();
          meta3.setDisplayName(ChatColor.GOLD + "Iron Boots");
          IRONboots.setItemMeta(meta3);
          player.getInventory().setBoots(IRONboots);

          ItemStack IRONsword = new ItemStack(Material.IRON_SWORD);
          ItemMeta meta4 = IRONsword.getItemMeta();
          meta4.setDisplayName(ChatColor.GOLD + "Iron Sword");
          IRONsword.setItemMeta(meta4);
          player.getInventory().addItem(new ItemStack[] { IRONsword });

          player.sendMessage(ChatColor.GOLD + "You have been equipped with Iron Armor and an Iron Sword!");
          return true;
        }
        if (args[0].equalsIgnoreCase("chain")) {
          if (!sender.hasPermission("ExtremeCMDS.armor.chain")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
          }
          ItemStack CHAINhelmet = new ItemStack(Material.CHAINMAIL_HELMET);
          ItemMeta meta = CHAINhelmet.getItemMeta();
          meta.setDisplayName(ChatColor.GOLD + "Chain Helmet");
          CHAINhelmet.setItemMeta(meta);
          player.getInventory().setHelmet(CHAINhelmet);

          ItemStack CHAINchestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
          ItemMeta meta1 = CHAINchestplate.getItemMeta();
          meta1.setDisplayName(ChatColor.GOLD + "Chain Chestplate");
          CHAINchestplate.setItemMeta(meta1);
          player.getInventory().setChestplate(CHAINchestplate);

          ItemStack CHAINleggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
          ItemMeta meta2 = CHAINleggings.getItemMeta();
          meta2.setDisplayName(ChatColor.GOLD + "Chain Leggings");
          CHAINleggings.setItemMeta(meta2);
          player.getInventory().setLeggings(CHAINleggings);

          ItemStack CHAINboots = new ItemStack(Material.CHAINMAIL_BOOTS);
          ItemMeta meta3 = CHAINboots.getItemMeta();
          meta3.setDisplayName(ChatColor.GOLD + "Chain Boots");
          CHAINboots.setItemMeta(meta3);
          player.getInventory().setBoots(CHAINboots);

          ItemStack CHAINsword = new ItemStack(Material.IRON_SWORD);
          ItemMeta meta4 = CHAINsword.getItemMeta();
          meta4.setDisplayName(ChatColor.GOLD + "Chain Sword");
          CHAINsword.setItemMeta(meta4);
          player.getInventory().addItem(new ItemStack[] { CHAINsword });

          player.sendMessage(ChatColor.GOLD + "You have been equipped with Chain Armor and an Iron Sword!");
          return true;
        }
        if (args[0].equalsIgnoreCase("diamond")) {
          if (!sender.hasPermission("ExtremeCMDS.armor.diamond")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
          }
          ItemStack DIAMONDhelmet = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta meta = DIAMONDhelmet.getItemMeta();
          meta.setDisplayName(ChatColor.GOLD + "Diamond Helmet");
          DIAMONDhelmet.setItemMeta(meta);
          player.getInventory().setHelmet(DIAMONDhelmet);

          ItemStack DIAMONDchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta meta1 = DIAMONDchestplate.getItemMeta();
          meta1.setDisplayName(ChatColor.GOLD + "Diamond Chestplate");
          DIAMONDchestplate.setItemMeta(meta1);
          player.getInventory().setChestplate(DIAMONDchestplate);

          ItemStack DIAMONDleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta meta2 = DIAMONDleggings.getItemMeta();
          meta2.setDisplayName(ChatColor.GOLD + "Diamond Leggings");
          DIAMONDleggings.setItemMeta(meta2);
          player.getInventory().setLeggings(DIAMONDleggings);

          ItemStack DIAMONDboots = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta meta3 = DIAMONDboots.getItemMeta();
          meta3.setDisplayName(ChatColor.GOLD + "Diamond Boots");
          DIAMONDboots.setItemMeta(meta3);
          player.getInventory().setBoots(DIAMONDboots);

          ItemStack DIAMONDsword = new ItemStack(Material.DIAMOND_SWORD);
          ItemMeta meta4 = DIAMONDsword.getItemMeta();
          meta4.setDisplayName(ChatColor.GOLD + "Diamond Sword");
          DIAMONDsword.setItemMeta(meta4);
          player.getInventory().addItem(new ItemStack[] { DIAMONDsword });

          player.sendMessage(ChatColor.GOLD + "You have been equipped with Diamond Armor and an Diamond Sword!");
          return true;
        }
        if (args[0].equalsIgnoreCase("god")) {
          if (!sender.hasPermission("ExtremeCMDS.armor.diamond")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            return true;
          }
          ItemStack DIAMONDhelmet = new ItemStack(Material.DIAMOND_HELMET);
          ItemMeta meta = DIAMONDhelmet.getItemMeta();
          meta.setDisplayName(ChatColor.GOLD + "God Diamond Helmet");
          meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
          meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
          meta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
          meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
          meta.addEnchant(Enchantment.THORNS, 3, true);
          meta.addEnchant(Enchantment.DURABILITY, 3, true);
          DIAMONDhelmet.setItemMeta(meta);
          player.getInventory().setHelmet(DIAMONDhelmet);

          ItemStack DIAMONDchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
          ItemMeta meta1 = DIAMONDchestplate.getItemMeta();
          meta1.setDisplayName(ChatColor.GOLD + "God Diamond Chestplate");
          meta1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
          meta1.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
          meta1.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
          meta1.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
          meta1.addEnchant(Enchantment.THORNS, 3, true);
          meta1.addEnchant(Enchantment.DURABILITY, 3, true);
          DIAMONDchestplate.setItemMeta(meta1);
          player.getInventory().setChestplate(DIAMONDchestplate);

          ItemStack DIAMONDleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
          ItemMeta meta2 = DIAMONDleggings.getItemMeta();
          meta2.setDisplayName(ChatColor.GOLD + "God Diamond Leggings");
          meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
          meta2.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
          meta2.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
          meta2.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
          meta2.addEnchant(Enchantment.THORNS, 3, true);
          meta2.addEnchant(Enchantment.DURABILITY, 3, true);
          DIAMONDleggings.setItemMeta(meta2);
          player.getInventory().setLeggings(DIAMONDleggings);

          ItemStack DIAMONDboots = new ItemStack(Material.DIAMOND_BOOTS);
          ItemMeta meta3 = DIAMONDboots.getItemMeta();
          meta3.setDisplayName(ChatColor.GOLD + "God Diamond Boots");
          meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
          meta3.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
          meta3.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
          meta3.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
          meta3.addEnchant(Enchantment.THORNS, 3, true);
          meta3.addEnchant(Enchantment.DURABILITY, 3, true);
          DIAMONDboots.setItemMeta(meta3);
          player.getInventory().setBoots(DIAMONDboots);

          ItemStack DIAMONDsword = new ItemStack(Material.DIAMOND_SWORD);
          ItemMeta meta4 = DIAMONDsword.getItemMeta();
          meta4.setDisplayName(ChatColor.GOLD + "God Diamond Sword");
          meta4.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
          meta4.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, true);
          meta4.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
          meta4.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
          meta4.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
          meta4.addEnchant(Enchantment.DURABILITY, 3, true);
          DIAMONDsword.setItemMeta(meta4);
          player.getInventory().addItem(new ItemStack[] { DIAMONDsword });

          player.sendMessage(ChatColor.GOLD + "You have been equipped with Diamond Armor and an Diamond Sword!");
          return true;
        }
      }
      else if (args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Usage: /armor leather:gold:iron:chain:diamond:god");
        return true;
      }
    }

    return false;
  }
}