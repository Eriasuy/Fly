package de.eriasuy.fly;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FlyMain extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("disablefly").setExecutor(new FlyCommand());
		getCommand("flyspeed").setExecutor(new FlySpeedCommand());
		
		Bukkit.getPluginManager().registerEvents(this, this);
	}	
}