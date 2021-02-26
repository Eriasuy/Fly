package de.eriasuy.fly;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class FlySpeedCommand implements TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("fly.speed")) {
				Float flyspeed = Float.parseFloat(args[0]);
				if (args.length == 0) {
					player.sendMessage("§aSet Flying Speed to Default!");
					player.setFlySpeed((float) 0.1);
				} else if (args.length == 1) {
					try {
						if (flyspeed > 10 || flyspeed < -10) {
							player.sendMessage("§c§l" + args[0] + "§c is out of range");
							return false;
						} else {
							player.sendMessage("§aSet Flying Speed to §6§l" + args[0] + "§a!");
							player.setFlySpeed(flyspeed / 10);
						}
					} catch (IllegalArgumentException e) {
						player.sendMessage("§c§l" + flyspeed + "§c is out of range");
					}
				} else
					player.sendMessage("§cThe correct use is §l/flyspeed <-10 - 10>§c!");
			} else
				player.sendMessage("§cYou cant do this without permission");
		} else
			sender.sendMessage("You cannot do this!");
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length > 0) {
			List<String> ntb = new ArrayList<String>();
			if (ntb.isEmpty())
				ntb.add("");
			return ntb;
		}
		return null;
	}
}