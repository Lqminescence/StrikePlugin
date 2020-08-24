package me.luminescence.strike;


import me.luminescence.strike.utils.CC;
import me.luminescence.strike.utils.Config;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class LightningStickCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String prefix = Config.String("prefix");

        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Lightning Stick");
        List<String> lore = Arrays.asList(" ", ChatColor.YELLOW + "Zap-Zap!", "", ChatColor.WHITE + "The LightningStick creates endless fun!", "", ChatColor.YELLOW + "Right-Click " + ChatColor.WHITE + "- to strike Lightning everywhere!",
        ChatColor.YELLOW + "Left-Click " + ChatColor.WHITE + "- to strike where you are looking!");
        meta.setLore(lore);
        stick.setItemMeta(meta);

        if (cmd.getName().equalsIgnoreCase("lstick")) {
            if (sender instanceof Player) {
                if (args.length == 0) {

                    ((Player) sender).getInventory().addItem(stick);
                    sender.sendMessage(CC.translate(prefix + ChatColor.WHITE + " You have received the" + ChatColor.GOLD + "" + ChatColor.BOLD + " Lightning Stick&r&f!"));

                    return true;

                } else {

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target != null) {

                        (target).getInventory().addItem(stick);

                        sender.sendMessage(CC.translate(prefix + "&r&f You have given &6&l" + target.getName() + "&r&f a &6&lLightning Stick"));
                        target.sendMessage(CC.translate(prefix + "&6&l " + sender.getName() + "&r&f has given you a &6&lLightning Stick"));

                    } else {

                        sender.sendMessage(ChatColor.RED + args[0] + " is not online right now!");

                    }

                }
            } else {

                if (args.length == 0) {

                    System.out.println("[Strike] Please choose a player to give the stick to!");

                } else {

                    Player consoleTarget = Bukkit.getPlayerExact(args[0]);

                    assert consoleTarget != null;
                    (consoleTarget).getInventory().addItem(stick);

                }
            }

        }
        return false;
    }

}
