package me.luminescence.strike;

import me.luminescence.strike.utils.CC;
import me.luminescence.strike.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StrikeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String prefix = Config.String("prefix");

        if (cmd.getName().equalsIgnoreCase("strike")) {
            if (sender instanceof Player) {

                    Player player = (Player) sender;

                if (sender.hasPermission("strike.strike")) {

                    if (args.length == 0) {

                        if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(player.getLocation());
                            sender.sendMessage(CC.translate(prefix + "&r&f You struck yourself!"));

                        } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(player.getLocation());
                            sender.sendMessage(CC.translate(prefix + "&r&f You struck yourself!"));

                        }

                        return true;
                    }

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) {

                        sender.sendMessage(ChatColor.RED + args[0] + " is not online right now!");

                    } else if (target == sender) {

                        if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(player.getLocation());
                            sender.sendMessage(CC.translate(prefix + "&r&f You struck yourself!"));

                        } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(player.getLocation());
                            sender.sendMessage(CC.translate(prefix + "&r&f You struck yourself!"));

                        }

                    } else {

                        if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(player.getLocation());
                            sender.sendMessage(CC.translate(prefix + "&r&f You have struck &6&l " + target.getName()));
                            target.sendMessage(CC.translate(prefix + "&6&l " + sender.getName() + "&r&f has struck you!"));

                        } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(player.getLocation());
                            sender.sendMessage(CC.translate(prefix + " You have struck &6&l " + target.getName()));
                            target.sendMessage(CC.translate(prefix + "&6&l " + sender.getName() + "&r&f has struck you!"));


                        }


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

                    if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                        target.getWorld().strikeLightningEffect(target.getLocation());
                        target.sendMessage(CC.translate(prefix + "&6&l " + "Network" + "&r&f has struck you!"));

                    } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                        target.getWorld().strikeLightning(target.getLocation());
                        target.sendMessage(CC.translate(prefix + "&6&l Network" + "&r&f has struck you!"));

                    }

                }

            }

        }

        return false;
    }

}