package me.NinetyNine.forcejoin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.NinetyNine.forcejoin.commands.FJCommands;
import me.NinetyNine.forcejoin.utils.FJScoreboardListener;
import me.NinetyNine.forcejoin.utils.FJUtils;

public class ForceJoin extends JavaPlugin {

	public static ForceJoin plugin;

	@Override
	public void onEnable() {
		plugin = this;

		registerListeners();
		registerCommand();
		FJUtils.sendConsoleMessage("Enabled!");
	}

	@Override
	public void onDisable() {
		FJUtils.sendConsoleMessage("Disabled!");
	}

	public void registerListeners() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new FJCommands(), this);
		pm.registerEvents(new FJUtils(), this);
		pm.registerEvents(new FJScoreboardListener(), this);
	}

	public void registerCommand() {
		getCommand("forcejoin").setExecutor(new FJCommands());
	}
}
