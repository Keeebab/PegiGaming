package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

public class Home implements CommandExecutor{
	public ExtremeCMDS plugin;
	public Home(ExtremeCMDS instance) {
        plugin = instance;
    }
public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
	if(cmd.getName().equalsIgnoreCase("sethome")){
		if(args.length != 0){
			sender.sendMessage(ChatColor.RED + "Usage: /sethome");
			return true;
		}
		if(!sender.hasPermission("ExtremeCMDS.sethome")){
			sender.sendMessage(plugin.permission);
			return true;
		}
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return true;
		}
		Player player = (Player) sender;
		String location = "x: " + player.getLocation().getX() + ", y: " + player.getLocation().getY() + ", z: " + player.getLocation().getZ() + "!";
		double x = player.getLocation().getX();
		double y = player.getLocation().getY();
		double z = player.getLocation().getZ();
		String world = player.getLocation().getWorld().getName();
		plugin.getCustomConfig(plugin.homes).set(player.getName(), world + "," + x + "," + y + ","+ z);
		plugin.saveCustomConfig(plugin.homes);
		player.sendMessage(ChatColor.GOLD + "Successfully set home at: " + location);
	}
	else if(cmd.getName().equalsIgnoreCase("home")){
		if(args.length != 0){
			sender.sendMessage(ChatColor.RED + "Usage: /home");
			return true;
		}
		if(!sender.hasPermission("ExtremeCMDS.home")){
			sender.sendMessage(plugin.permission);
			return true;
		}
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return true;
		}
		Player player = (Player) sender;
		String[] location = plugin.getCustomConfig(plugin.homes).getString(player.getName()).split(",");
		double x = Double.parseDouble(location[1]); 
		double y = Double.parseDouble(location[2]);
		double z = Double.parseDouble(location[3]);
		World world = Bukkit.getWorld(location[0]);
		player.teleport(new Location(world,x,y,z));
		player.sendMessage(ChatColor.GOLD + "Teleported to Home!");
		return true;
	}
	return false;
}
}