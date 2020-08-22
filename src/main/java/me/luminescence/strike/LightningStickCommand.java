package me.luminescence.strike;


import me.luminescence.strike.utils.CC;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LightningStickCommand implements CommandExecutor, Listener {

    @EventHandler
    public void onEvent (PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (player.getInventory().getItemInMainHand().hasItemMeta()) {
            if (player.getInventory().getItemInMainHand().getItemMeta().)

            player.sendMessage("You have done it!");

        } else {

            player.sendMessage("Not with a stick!");

        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Lightning Stick");
        stick.setItemMeta(meta);

        if (cmd.getName().equalsIgnoreCase("lstick")) {
            if (sender instanceof Player) {
                if (args.length == 0) {

                    ((Player) sender).getInventory().addItem(stick);
                    sender.sendMessage(ChatColor.DARK_AQUA + "You have received the Lightning Stick!");

                    return true;

                } else {

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target != null) {

                        (target).getInventory().addItem(stick);

                        sender.sendMessage(CC.translate("&8&l[&6&lS&8&l]&r&f You have given &6&l" + target.getName() + "&r&f a &6&lLightning Stick"));
                        target.sendMessage(CC.translate("&8&l[&6&lS&8&l]&6&l " + sender.getName() + "&r&f has given you a &6&lLightning Stick"));

                    } else {

                        sender.sendMessage(ChatColor.RED + args[0] + " is not online right now!");
                    }

                }
            } else {
                System.out.println(ChatColor.RED + "This command is for players only!");
            }

        }
        return false;
    }

}
