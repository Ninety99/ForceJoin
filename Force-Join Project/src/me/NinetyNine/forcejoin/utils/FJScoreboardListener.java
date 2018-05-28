package me.NinetyNine.forcejoin.utils;

import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;

public class FJScoreboardListener implements Listener {

	private static Scoreboard scoreboard;

	public static Scoreboard getScoreboard() {
		return scoreboard;
	}
}