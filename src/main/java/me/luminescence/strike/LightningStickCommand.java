package me.luminescence.strike;


import me.luminescence.strike.utils.CC;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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

import java.util.Objects;

public class LightningStickCommand implements CommandExecutor, Listener {

    @EventHandler
    public void onLightningStickInteract (PlayerInteractEvent e) throws InterruptedException {

        Player player = e.getPlayer();
        player.getLocation();

        int set = 0;

        if (player.getInventory().getItemInMainHand().hasItemMeta()) {
            if (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals(ChatColor.YELLOW + "Lightning Stick")) {

                while (set < 40) {

                    int xmin = -40;
                    int xmax = 40;

                    double doublex = Math.random() * (xmax - xmin + 1) + xmin;

                    int zmin = -40;
                    int zmax = 40;

                    double doublez = Math.random() * (zmax - zmin + 1) + zmin;

                    int finalx = (int) doublex;
                    int finalz = (int) doublez;

                    int numx = (int) player.getLocation().getX();

                    int numz = (int) player.getLocation().getZ();

                    double numx2 = numx + finalx;
                    double numz2 = numz + finalz;

                    Location location1 = new Location(player.getWorld(), numx2, 60, numz2);

                    player.getWorld().strikeLightningEffect(location1);
                    player.getWorld().strikeLightningEffect(location1);

                    Thread.sleep(50);

                    set++;
                }

            }

        }

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.YELLOW  + "Lightning Stick");
        stick.setItemMeta(meta);

        if (cmd.getName().equalsIgnoreCase("lstick")) {
            if (sender instanceof Player) {
                if (args.length == 0) {

                    ((Player) sender).getInventory().addItem(stick);
                    sender.sendMessage(CC.translate("&8&l[&6&lS&8&l]" + ChatColor.WHITE + "You have received the" + ChatColor.GOLD + "" + ChatColor.BOLD + "Lightning Stick!"));

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
