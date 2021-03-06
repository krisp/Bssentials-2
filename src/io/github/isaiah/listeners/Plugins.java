package io.github.isaiah.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import io.github.isaiah.bssentials.Bssentials;

public class Plugins implements Listener {

	@EventHandler
    public void pluginCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String plnoperm = ChatColor.GREEN + "[Bssentials] " + ChatColor.GOLD + "You don't have permission to use that command!";
        if(event.getMessage().equalsIgnoreCase("/plugins") || event.getMessage().equalsIgnoreCase("/pl") || event.getMessage().equalsIgnoreCase("/plugins ver") || event.getMessage().equalsIgnoreCase("/pl ver")) {
            if (player.hasPermission(Bssentials.PLUGINS_PERM)) {
                if (event.getMessage().equalsIgnoreCase("/plugins ver") || event.getMessage().equalsIgnoreCase("/pl ver")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.GREEN + "[Bssentials] " + ChatColor.GOLD + "Bukkit Plugins:");
                    player.sendMessage(getThePluginsWithVer());
                } else {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.GREEN + "[Bssentials] " + ChatColor.GOLD + "Bukkit Plugins:");
                    player.sendMessage(getThePlugins());
                }
            } else {
                event.setCancelled(true);
                player.sendMessage(plnoperm);
            }
        }
    }
    

    public String getThePlugins() {
        Plugin[] plugins;
        StringBuilder pluginList = new StringBuilder();
        Plugin[] arrplugin = plugins = Bukkit.getPluginManager().getPlugins();
        int n = arrplugin.length;
        int n2 = 0;
        while (n2 < n) {
            Plugin plugin = arrplugin[n2];
            if (pluginList.length() > 0) {
                pluginList.append(ChatColor.WHITE);
                pluginList.append(", ");
            }
            pluginList.append((Object)(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED));
            pluginList.append(plugin.getDescription().getName());
            ++n2;
        }
        
        return "(" + plugins.length + "): " + pluginList.toString();
    }
    
    public String getThePluginsWithVer() {
        Plugin[] plugins;
        StringBuilder pluginList = new StringBuilder();
        Plugin[] arrplugin = plugins = Bukkit.getPluginManager().getPlugins();
        int n = arrplugin.length;
        int n2 = 0;
        while (n2 < n) {
            Plugin plugin = arrplugin[n2];
            if (pluginList.length() > 0) {
                pluginList.append(ChatColor.WHITE);
                pluginList.append(", ");
            }
            pluginList.append((Object)(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED));
            pluginList.append(plugin.getDescription().getName() + ChatColor.GRAY + "(" + plugin.getDescription().getVersion() + ")" + ChatColor.RESET);
            ++n2;
        }
        return "(" + plugins.length + "): " + pluginList.toString();
    }
}
