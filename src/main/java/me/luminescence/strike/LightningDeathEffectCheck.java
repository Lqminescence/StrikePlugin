package me.luminescence.strike;

import me.luminescence.strike.utils.CC;
import me.luminescence.strike.utils.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LightningDeathEffectCheck implements Listener {

    @EventHandler
    public void onDeathEffect(PlayerDeathEvent e) {

        System.out.println(JavaPlugin.getPlugin(Main.class).getConfig().getString("do-CustomDeathMessage"));
        System.out.println(Config.String("do-CustomDeathMessage") + "1");

        if (Config.String("do-CustomDeathMessage").equalsIgnoreCase("true")) {

            Player player = e.getEntity().getPlayer();

            System.out.println("this works");

            String prefix = Config.String("prefix");

            EntityDamageEvent event = player.getLastDamageCause();
            assert event != null;
            EntityDamageEvent.DamageCause dc = event.getCause();

            if (dc == EntityDamageEvent.DamageCause.LIGHTNING) {

                String message = Config.String("CustomDeathMessage").replace("%prefix%", prefix).replace("%player%", player.getName());
                message = CC.translate(message);

                e.setDeathMessage(message);

            }

        }
        //ChatColor.GOLD + " " + ChatColor.BOLD + player.getName() + ChatColor.WHITE + " has been killed by " + ChatColor.GOLD + "" + ChatColor.BOLD + "Lightning"
    }
}


