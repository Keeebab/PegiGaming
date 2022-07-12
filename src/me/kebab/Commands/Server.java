package me.kebab.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

@SuppressWarnings("unused")
public class Server
  implements CommandExecutor
{
  public ExtremeCMDS plugin;

  public Server(ExtremeCMDS instance)
  {
    this.plugin = instance;
  }

  public String colours(String string) {
    String s = ChatColor.translateAlternateColorCodes('&', string);
    return s;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("server")) {
      if (!sender.hasPermission("ExtremeCMDS.server")) {
        sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage("�cUsage: /server <message>");
        return true;
      }
      if (args.length > 0) {
        String server = "";
        for (int i = 0; i < args.length; i++) {
          server = server + args[i] + " ";
        }
        Bukkit.broadcastMessage(colours(this.plugin.getConfig().getString("ServerPrefix") + server));
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("motd")) {
      sender.sendMessage(colours(this.plugin.getConfig().getString("MOTD")));
      return true;
    }
    return true;
  }
}