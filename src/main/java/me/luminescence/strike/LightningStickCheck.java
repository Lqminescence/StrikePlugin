package me.luminescence.strike;

import me.luminescence.strike.utils.Config;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class LightningStickCheck implements Listener {

    @EventHandler
    public void onLightningStickInteract (PlayerInteractEvent e) {


        if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
            if ((Objects.requireNonNull(e.getPlayer().getInventory().getItemInMainHand().getItemMeta())).getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Lightning Stick")) {

                Player player = e.getPlayer();
                player.getLocation();

                int set = 0;

                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                    while (set < Config.Integer("Amount-of-Strikes")) {

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

                        if (Config.String("real-lightning-stick").equalsIgnoreCase("true")) {

                            player.getWorld().strikeLightning(location1);
                            player.getWorld().strikeLightning(location1);

                        } else if (Config.String("real-lightning-stick").equalsIgnoreCase("false")) {

                            player.getWorld().strikeLightningEffect(location1);
                            player.getWorld().strikeLightningEffect(location1);

                        } else {

                            System.out.println("[Strike] Config File Error");

                        }

                        set++;
                    }


                } else if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                    player.getLocation();

                    if (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Lightning Stick")) {

                        if (Config.String("real-lightning-stick").equals("false")) {

                            player.getWorld().strikeLightningEffect(player.getTargetBlock(null, 200).getLocation());

                        } else if (Config.String("real-lightning-stick").equals("true")) {

                            player.getWorld().strikeLightning(player.getTargetBlock(null, 200).getLocation());

                        }

                    }
                }                 }

            }

        }
    }

