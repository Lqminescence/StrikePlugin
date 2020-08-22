package me.luminescence.strike;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new LightningStickCommand(), this);

        System.out.println("[Strike] Strike has loaded successfully!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Commands:

        Objects.requireNonNull(getCommand("strike")).setExecutor(new StrikeCommand());
        Objects.requireNonNull(getCommand("lstick")).setExecutor(new LightningStickCommand());

    }

}






