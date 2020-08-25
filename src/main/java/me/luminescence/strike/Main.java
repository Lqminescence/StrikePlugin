package me.luminescence.strike;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        int pluginId = 8649;
        Metrics metrics = new Metrics(this, pluginId);

        Bukkit.getPluginManager().registerEvents(new LightningStickCheck(), this);
        Bukkit.getPluginManager().registerEvents(new LightningDeathEffectCheck(), this);

        System.out.println("[Strike] Strike has loaded successfully!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Commands:

        Objects.requireNonNull(getCommand("strike")).setExecutor(new StrikeCommand());
        Objects.requireNonNull(getCommand("lstick")).setExecutor(new LightningStickCommand());
        Objects.requireNonNull(getCommand("reloadconfig")).setExecutor(new ReloadStrike());
        Objects.requireNonNull(getCommand("strikethere")).setExecutor(new StrikeThereCommand());


    }

}






