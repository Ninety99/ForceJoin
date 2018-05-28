package me.NinetyNine.forcejoin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.NinetyNine.forcejoin.utils.FJScoreboardListener;
import me.NinetyNine.forcejoin.utils.FJUtils;

public class FJCommands implements Listener, CommandExecutor {

	private ChatColor chatColor;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		} else {
			Player player = (Player) sender;
			if (isInTeam(player) == false) {
				player.sendMessage(ChatColor.RED + "You must choose a team before force-joining");
			} else
				return false;
			if (cmd.getName().equalsIgnoreCase("forcejoin")) {
				if (player.hasPermission("join.force")) {
					if (args.length == 0) {
						player.sendMessage(ChatColor.RED + "Insufficient Arguments\n" + ChatColor.RED
								+ "Usage: /forcejoin <red/bue/green/yellow>");
						return true;
					}

					if (args[0].equalsIgnoreCase("red")) {
						if (args.length == 1) {
							setChatColor(ChatColor.RED);
							addPlayerToTeam(player, "red");
							player.sendMessage(ChatColor.AQUA + "You have force-joined " + ChatColor.RED + "RED");
							FJUtils.sendConsoleMessage(player.getName() + " has force-joined red.");
							sendForceJoinMessage("red");
							return true;
						}
					}

					if (args[0].equalsIgnoreCase("blue")) {
						if (args.length == 1) {
							setChatColor(ChatColor.BLUE);
							addPlayerToTeam(player, "blue");
							FJScoreboardListener.getScoreboard().getTeam("BLUE").addPlayer(player);
							player.sendMessage(ChatColor.AQUA + "You have force-joined " + ChatColor.BLUE + "BLUE");
							FJUtils.sendConsoleMessage(player.getName() + " has force-joined blue.");
							sendForceJoinMessage("blue");
							return true;
						}
					}

					if (args[0].equalsIgnoreCase("green")) {
						if (args.length == 1) {
							setChatColor(ChatColor.GREEN);
							addPlayerToTeam(player, "green");
							player.sendMessage(ChatColor.AQUA + "You have force-joined " + ChatColor.GREEN + "GREEN");
							FJUtils.sendConsoleMessage(player.getName() + " has force-joined green.");
							sendForceJoinMessage("green");
							return true;
						}
					}

					if (args[0].equalsIgnoreCase("yellow")) {
						if (args.length == 1) {
							setChatColor(ChatColor.YELLOW);
							addPlayerToTeam(player, "yellow");
							player.sendMessage(ChatColor.AQUA + "You have force-joined " + ChatColor.YELLOW + "YELLOW");
							FJUtils.sendConsoleMessage(player.getName() + " has force-joined yellow.");
							sendForceJoinMessage("yellow");
							return true;
						}
					}
				} else {
					FJUtils.sendPlayerMessage(player, "&7You do not have permissions to execute this command!");
					return true;
				}
			}
		}
		return true;
	}

	public void addPlayerToTeam(Player player, String team) {
		FJScoreboardListener.getScoreboard().getTeam(team.toUpperCase()).addPlayer(player);
	}

	public boolean hasPerms(Player player) {
		if (player.hasPermission("gcbanz.ban"))
			return true;
		else
			return false;
	}

	public void sendForceJoinMessage(String team) {
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			if (hasPerms(player) == true)
				FJUtils.sendPlayerMessage(player,
						"&b" + player.getName() + " &bhas force-joined " + getChatColor() + team.toUpperCase());
			else
				return;
		}
	}

	public boolean isInTeam(Player player) {
		if (FJScoreboardListener.getScoreboard().getPlayerTeam(player) == null)
			return false;
		else
			return true;
	}

	public ChatColor getChatColor() {
		return chatColor;
	}

	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}
}