// REMOVE LOCAL PROFILES, USE: net.stormheart
package net.stormheart;

// STORMHEART NETWORK
// MAIN AUTHOR:      Josh Wilson (nutiler) [Change to creator.]
// CONTRIBUTORS:     Clément Ababou (klemms), Ben Terry (_bent)
// DATE:             FEB 3, 2017
// VERSION:          v1.0.0
// CONTACT:          www.stormheart.net

// NEW PLUGIN STYLE GUIDE, PLEASE FOLLOW ACCORDINGLY.
// GOOGLESTYLE JAVA CONFIGURATION FOR CODESTYLE.
// USING MAVEN FOR SOURCES, USE this POM.XML
// p = player, e = event
// ChatColor.X OVER \u00A7X

// PULL FOR THE LATEST VERSION.
// https://github.com/nutiler/stormheart-XXXXXXXXXXXX

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.WitherSkull;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
// END IMPORTS

public class pluginStyle extends JavaPlugin implements Listener, CommandExecutor {

  private int velocity;
  private String plugin = ChatColor.RED + "pluginStyle";
  private String title = ChatColor.GRAY + "[" + ChatColor.RED + "STORMHEART" + ChatColor.GRAY + "]: ";
  private static List<Entity> skull = new ArrayList<Entity>();
  // END VARIABLE DECLARATION

  public pluginStyle() {
    this.velocity = this.getConfig().getInt("Velocity");
  }

  // LOGGING START UP & GETTING CONFIGS
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents((Listener) this, (Plugin) this);
    this.reloadConfig();
    // WRITING CONFIGURATION
    this.getConfig().options().header("STORMHEART NETWORK © 2017\n"
        + "WWW.STORMHEART.NET\n RESOURCE:" + plugin + "CONFIGURATION");
    // REVERTING TO DEFAULTS IF NOT DEFINED
    this.getConfig().addDefault("Velocity", (Object) 2);
    this.getConfig().addDefault("RegentMaterialID", (Object) 340);
    this.getConfig().addDefault("WandMaterialID", (Object) 352);
    this.getConfig().addDefault("Damage", (Object) 4.5);
    this.getConfig().options().copyDefaults(true);
    this.saveConfig();
    getLogger().info(plugin + "has been enabled.");
  }

  // RELOAD & WRITE ON DISABLE
  public void onDisable() {
    getLogger().info(plugin + " has been disabled.");
    // NOTHING IS BEING SAVED :P
  }

  // METHODS ARE DEPRECIATED... :(
  @EventHandler
  public void onInteract(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    try {
      if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
          && event.getItem().getTypeId() == this.getConfig().getInt("WandMaterialID")) {
        if (player.getInventory().contains(this.getConfig().getInt("RegentMaterialID"))) {
          player.getInventory().removeItem(new ItemStack[]{new ItemStack(this.getConfig().getInt("RegentMaterialID"))});
          WitherSkull projectile = (WitherSkull) player
              .launchProjectile(WitherSkull.class, player.getLocation().getDirection().multiply(this.velocity));
          skull.add((Entity) projectile);
          player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_SHOOT, 0.5f, 0.5f);
        } else {
          player.sendMessage(ChatColor.GRAY + "You do not have any more pages.");
        }
      }
    } catch (Exception projectile) {
      System.err.println("Caught Exception: " + projectile);
      System.err.println(projectile.getMessage());
    }
  }

  // COMMANDS FOR THE RESOURCE
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;
      if (args.length == 0) {
        sender.sendMessage(title + "This is the default style guide for plugins.");
      }
      if (args.length == 1) {
        if (player.hasPermission("pluginStyle.admin")) {
          if (args[0].equalsIgnoreCase("admin")) {
            player.getInventory()
                .addItem(new ItemStack[]{new ItemStack(this.getConfig().getInt("RegentMaterialID"), 16)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(this.getConfig().getInt("WandMaterialID"))});
            sender.sendMessage(title + "This is the default style guide for plugins.");
          }
          if (args[0].equalsIgnoreCase("reload")) {
            reloadConfig();
            getLogger().info(plugin + " has been reloaded.");
            sender.sendMessage(title + "Resource: " + plugin + ChatColor.GRAY + " has been reloaded.");
          }
        } else {
          player.sendMessage(ChatColor.GRAY + "You do not have sufficient permissions.");
        }
      } else {
        player.sendMessage(ChatColor.GRAY + "Usage: " + ChatColor.RED + " /" + plugin + "{args}");
        player.sendMessage(ChatColor.GRAY + "Arguments:" + ChatColor.RED + " admin"
            + ChatColor.GRAY + ", " + ChatColor.RED + "reload");
      }
    } else {
      sender.sendMessage(ChatColor.GRAY + "This command is not made for the console.");
    }
    return false;
  }

  @EventHandler
  public void onDmg(EntityDamageByEntityEvent event) {
    try {
      Entity id;
      if (event.getDamager() instanceof WitherSkull && event.getEntity() instanceof LivingEntity && skull
          .contains((Object) (id = event.getDamager()))) {
        skull.remove((Object) id);
        event.setDamage(this.getConfig().getDouble("Damage"));
      }
    } catch (Exception id) {
      System.err.println("Caught Exception: " + id);
      System.err.println(id.getMessage());
    }
  }
}