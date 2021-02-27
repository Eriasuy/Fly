package de.eriasuy.fly;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;


public class FlyCommand implements TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		String perms = "§cYou cant do this without permission";
		if (command.getName().equals("fly")) {
			if (sender instanceof Player) {
				if (args.length == 0) {
					if (player.hasPermission("fly")) {
						if (!player.getAllowFlight()) {
							player.setAllowFlight(true);
							player.sendMessage("§aYou can fly now!");
						} else
							player.sendMessage("§cYou already have the ability to fly");
					} else
						player.sendMessage(perms);
				} else if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if (player.hasPermission("fly.other")) {
						if (target != null) {
							if (!target.getAllowFlight()) {
								target.setAllowFlight(true);
								target.sendMessage("§6" + player.getName() + " §a gave you the ability to fly!");
								player.sendMessage("§aYou gave the ability to fly to §6" + target.getName() + ".");
							} else
								player.sendMessage("§6" + args[0] + "§c already have the ability to fly");
						} else
							player.sendMessage("§cThe Player §6" + args[0] + " §cis not on the Server.");
					} else
						player.sendMessage(perms);
				} else
					player.sendMessage("§cThe correct use is §/fly <player>§c!");
			} else
				sender.sendMessage("You cant do this!");
		} else if (command.getName().equals("dfly") || command.getName().equals("disablefly")) {
			if (sender instanceof Player) {
				if (args.length == 0) {
					if (player.hasPermission("dfly")) {
						if (player.getAllowFlight()) {
							player.setAllowFlight(false);
							player.sendMessage("§aYou can not fly anymore");
						} else
							player.sendMessage("§cYou already dont have the ability to fly");
					}
				} else if (args.length == 1) {
					if (player.hasPermission("dfly.other")) {
						Player target = Bukkit.getPlayer(args[0]);
						if (target != null) {
							if (target.getAllowFlight()) {
								target.setAllowFlight(false);
								target.sendMessage(
										"§6" + player.getName() + "§a took the ability to fly away from you");
								player.sendMessage("§aYou took the ability to fly away from §6" + player.getName());
							} else
								player.sendMessage("§6" + args[0] + "§c already doesnt have the ability to fly");
						} else
							player.sendMessage("§cThe Player §6" + args[0] + " §cis not on the Server.");
					} else
						player.sendMessage("§cYou cant do this without permission");
				} else
					player.sendMessage("§cThe correct use is §ld/disablefly <player>§c!");
			} else
				sender.sendMessage("You cant do this!");
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length > 1) {
			List<String> ntb = new ArrayList<String>();
			if (ntb.isEmpty())
				ntb.add("");
			return ntb;
		}
		return null;
	}
}