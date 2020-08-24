package me.luminescence.strike;

import me.luminescence.strike.utils.CC;
import me.luminescence.strike.utils.Config;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class StrikeThereCommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String prefix = Config.String("prefix");

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (Config.String("real-strikethere-lightning").equals("true")) {

                player.getWorld().strikeLightning(player.getTargetBlock((Set<Material>) null, 200).getLocation());
                player.sendMessage(CC.translate(prefix + "&r&f You have struck where you are looking!"));

            } else {

                player.getWorld().strikeLightningEffect(player.getTargetBlock((Set<Material>) null, 200).getLocation());
                player.sendMessage(CC.translate(prefix + "&r&f You have struck where you are looking!"));

            }

        } else {

            System.out.println("[Strike] This command is only available to players.");

        }

        return false;
    }
}
