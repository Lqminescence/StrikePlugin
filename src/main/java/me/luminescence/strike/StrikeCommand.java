package me.luminescence.strike;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.luminescence.strike.utils.CC;

public class StrikeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Main.getPlugin(Main.class).getConfig().getString("prefix");

        if (cmd.getName().equalsIgnoreCase("strike")) {
            if (sender instanceof Player) {

                    Player player = (Player) sender;

                if (sender.hasPermission("strike.strike")) {

                    if (args.length == 0) {

                        player.getWorld().strikeLightningEffect(player.getLocation());
                        sender.sendMessage(CC.translate("&8&l[&6&lS&8&l]&r&f You struck yourself!"));

                        return true;
                    }

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) {

                        sender.sendMessage(ChatColor.RED + args[0] + " is not online right now!");

                    } else if (target == sender) {

                        player.getWorld().strikeLightningEffect(player.getLocation());
                        sender.sendMessage(CC.translate("&8&l[&6&lS&8&l]&r&f You struck yourself!"));

                    } else {

                        target.getWorld().strikeLightningEffect(target.getLocation());
                        sender.sendMessage(CC.translate("&8&l[&6&lS&8&l]&r&f You have struck &6&l " + target.getName()));
                        target.sendMessage(CC.translate("&8&l[&6&lS&8&l]&6&l " + sender.getName() + "&r&f has struck you!"));

                    }

                }

            } else {

                if (args.length == 0) {

                    System.out.println("[Strike] You must define a player! /strike [player]");
                    return false;
                }

                Player target = Bukkit.getPlayerExact(args[0]);

                if (target == null) {

                    System.out.println("[Strike] " + args[0] + " is not currently online!");

                } else {

                    target.getWorld().strikeLightningEffect(target.getLocation());
                    target.sendMessage(CC.translate("&8&l[&6&lS&8&l]&6&l " + "Network" + "&r&f has struck you!"));

                }

            }

        }

        return false;
    }

}