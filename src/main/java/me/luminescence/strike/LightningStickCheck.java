package me.luminescence.strike;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class LightningStickCheck implements Listener {

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

                    Thread.sleep(5);

                    set++;
                }

            }

        }

    }

}