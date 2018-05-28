package me.NinetyNine.forcejoin.utils;

import static org.bukkit.ChatColor.translateAlternateColorCodes;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FJUtils implements Listener {

	public static void sendPlayerMessage(Player player, String message) {
		String prefix = "&7[&bForceJoin&7] ";
		player.sendMessage(translateAlternateColorCodes('&', prefix + message));
	}

	public static void sendConsoleMessage(String message) {
		String prefix = "[ForceJoin] ";
		Bukkit.getServer().getLogger().info(prefix + message);
	}
}
