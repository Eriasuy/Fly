package de.eriasuy.fly;

import org.bukkit.plugin.java.JavaPlugin;

public class FlyMain extends JavaPlugin {
	@Override
	public void onEnable() {
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("disablefly").setExecutor(new FlyCommand());
		getCommand("flyspeed").setExecutor(new FlySpeedCommand());
	}	
}