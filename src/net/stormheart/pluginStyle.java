package net.stormheart;

// STORMHEART NETWORK
// MAIN AUTHOR:      Josh Wilson (nutiler) [Change to creator.]
// CONTRIBUTORS:     Clément Ababou (klemms), Ben Terry (_bent)
// DATE:             FEB 3, 2017
// VERSION:          v1.0.0
// CONTACT:          www.stormheart.net

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
// END IMPORTS

public class pluginStyle extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info(ChatColor.GRAY + "[" + ChatColor.RED + "STORMHEART"
        + ChatColor.GRAY + "]: pluginStyle is loading...");
  }

  @Override
  public void onDisable() {
    getLogger().info(ChatColor.GRAY + "[" + ChatColor.RED + "STORMHEART"
        + ChatColor.GRAY + "]: pluginStyle has been disabled.");
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("pluginStyle") ||
        command.getName().equalsIgnoreCase("ps")) {
      sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "STORMHEART"
          + ChatColor.GRAY + "]: This is the default style guide for plugins.");
    }
    return super.onCommand(sender, command, label, args);
  }
}