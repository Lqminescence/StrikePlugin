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

        //Main main = JavaPlugin.getPlugin(Main.class);

        //main.getConfig().getString();

        //String string = "&6Hello";
        //ChatColor.translateAlternateColorCodes('&', string);

        String prefix = Config.String("prefix");

        if (cmd.getName().equalsIgnoreCase("strike")) {
            if (sender instanceof Player) {

                String sendermessageself = Config.String("setCustomStruckYourselfMessage").replace("%prefix%", prefix);
                    sendermessageself = CC.translate(sendermessageself);

                    Player player = (Player) sender;

                if (sender.hasPermission("strike.strike")) {

                    if (args.length == 0) {

                        if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(player.getLocation());

                            if (Config.String("doCustomStrikeMessagesSender").equalsIgnoreCase("true")) {

                                sender.sendMessage(sendermessageself);
                            }
                        } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(player.getLocation());

                            if (Config.String("doCustomStrikeMessagesSender").equalsIgnoreCase("true")) {
                                sender.sendMessage(sendermessageself);
                            }

                        }

                        return true;
                    }

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) {

                        sender.sendMessage(ChatColor.RED + args[0] + " is not online right now!");

                    } else if (target == sender) {

                        if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(player.getLocation());

                            if (Config.String("doCustomStrikeMessagesSender").equalsIgnoreCase("true")) {
                                sender.sendMessage(sendermessageself);
                            }

                        } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(player.getLocation());

                            if (Config.String("doCustomStrikeMessagesSender").equalsIgnoreCase("true")) {
                                sender.sendMessage(sendermessageself);
                            }

                        }

                    } else {

                        String senderstrucktarget = Config.String("setCustomMessageToSender").replace("%prefix%", prefix).replace("%target%", target.getName());
                            senderstrucktarget = CC.translate(senderstrucktarget);

                        String targetgotstruck = Config.String("setCustomMessageToTarget").replace("%prefix%", prefix).replace("%sender%", sender.getName());
                            targetgotstruck = CC.translate(targetgotstruck);

                        if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(player.getLocation());

                        if (Config.String("doCustomStrikeMessagesSender").equalsIgnoreCase("true")) {
                            sender.sendMessage(senderstrucktarget);
                        }

                        if (Config.String("doCustomStrikeMessagesTarget").equalsIgnoreCase("true")) {
                            target.sendMessage(targetgotstruck);
                        }

                        } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(player.getLocation());

                            if (Config.String("doCustomStrikeMessagesSender").equalsIgnoreCase("true")) {
                                sender.sendMessage(senderstrucktarget);
                            }
                            if (Config.String("doCustomStrikeMessagesTarget").equalsIgnoreCase("true")) {
                                target.sendMessage(targetgotstruck);
                            }


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

                    String targetnetworkmessage = Config.String("setCustomMessageToTargetFromConsole").replace("%prefix%", prefix).replace("%target%", target.getName());
                        targetnetworkmessage = CC.translate(targetnetworkmessage);

                    if (Config.String("real-lightning").equalsIgnoreCase("false")) {

                        target.getWorld().strikeLightningEffect(target.getLocation());

                        if (Config.String("doCustomStrikeMessagesTarget").equalsIgnoreCase("true")) {
                            target.sendMessage(CC.translate(prefix + "&6&l Network" + "&r&f has struck you!"));
                        }

                    } else if (Config.String("real-lightning").equalsIgnoreCase("true")) {

                        target.getWorld().strikeLightning(target.getLocation());

                        if (Config.String("doCustomStrikeMessagesTarget").equalsIgnoreCase("true")) {
                            target.sendMessage(CC.translate(prefix + "&6&l Network" + "&r&f has struck you!"));
                        }
                    }

                }

            }

        }

        return false;
    }

}