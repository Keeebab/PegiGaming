package Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.kebab.ExtremeCMDS.ExtremeCMDS;

public class Events
  implements Listener
{
  public ExtremeCMDS plugin;

  public Events(ExtremeCMDS instance)
  {
    this.plugin = instance;
  }
  public String colours(String string) {
    String s = ChatColor.translateAlternateColorCodes('&', string);
    return s;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    player.setDisplayName(this.plugin.getCustomConfig(this.plugin.nicknames).getString(player.getName(), player.getDisplayName()));
    String ip = player.getAddress().getAddress().getHostAddress();
    this.plugin.getCustomConfig(this.plugin.IPs).set(player.getName(), ip);
    this.plugin.saveCustomConfig(this.plugin.IPs);
  }

  @EventHandler
  public void onChat(AsyncPlayerChatEvent event) {
    if (event.getPlayer().hasPermission("ExtremeCMDS.chatcolor"))
      event.setMessage(colours(event.getMessage()));
  }

  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    if ((player.hasPermission("ExtremeCMDS.goldaxe")) && 
      (player.getInventory().getItemInHand().getType() == Material.GOLD_AXE) && (
      (event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))) {
      Vector vector = new Vector(player.getLocation().getDirection().getX() * 1.0D, player.getLocation().getDirection().getY() * 3.0D, player.getLocation().getDirection().getZ() * 1.0D);
      player.setVelocity(vector);
    }
  }

  @EventHandler
  public void onMove(PlayerMoveEvent event)
  {
    Player player = event.getPlayer();
    if (this.plugin.frozen.contains(player.getName())) {
      player.teleport(player);
      player.sendMessage(ChatColor.RED + "Sorry, you are currently frozen!");
    }
  }

  @EventHandler
  public void onBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    if (this.plugin.frozen.contains(player.getName())) {
      event.setCancelled(true);
      player.sendMessage(ChatColor.RED + "Sorry, you cannot break blocks whilst frozen!");
    }
  }

  @EventHandler
  public void onBreak(BlockPlaceEvent event) {
    Player player = event.getPlayer();
    if (this.plugin.frozen.contains(player.getName())) {
      event.setCancelled(true);
      player.sendMessage(ChatColor.RED + "Sorry, you cannot place blocks whilst frozen!");
    }
  }

  @EventHandler
  public void onCommand(PlayerCommandPreprocessEvent event) {
    Player player = event.getPlayer();
    if (this.plugin.frozen.contains(player.getName())) {
      event.setCancelled(true);
      player.sendMessage(ChatColor.RED + "Sorry, you cannot use commands whilst frozen!");
    }
  }
}