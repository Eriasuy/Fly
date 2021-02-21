package de.eriasuy.fly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("fly.speed")) {
				if (args.length == 0) {
					player.sendMessage("§aSet Flying Speed to Default!");
					player.setFlySpeed((float) 0.1);
				} else if (args.length == 1) {
					Float flyspeed = Float.valueOf(args[0]);
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
					player.sendMessage("§cThe correct use is §/flyspeed <number>§c!");
			} else
				player.sendMessage("§cYou cant do this without permission");
		} else
			sender.sendMessage("You cannot do this!");
		return false;
	}
}