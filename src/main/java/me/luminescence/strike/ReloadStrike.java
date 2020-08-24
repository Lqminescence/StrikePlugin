package me.luminescence.strike;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadStrike implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Main.getPlugin(Main.class).reloadConfig();

        if (sender instanceof Player) {

            sender.sendMessage(ChatColor.GREEN + "Strike config has been reloaded!");

        } else {

            System.out.println("[Strike] Strike config has been reloaded!");

        }
        return false;

    }

}
