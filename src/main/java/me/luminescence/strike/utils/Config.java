package me.luminescence.strike.utils;

import me.luminescence.strike.Main;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Config {

    static Main main = JavaPlugin.getPlugin(Main.class);

    public static String String(String text) {

        return main.getConfig().getString(text);

    }

    public static boolean Boolean(String text) {

        String output = text;
        return Main.getPlugin(Main.class).getConfig().getBoolean(output);

    }

    public static int Integer(String text) {

        String output = text;
        return Main.getPlugin(Main.class).getConfig().getInt(output);

    }

    public static List<String> List(String text) {

        String output = text;
        return Main.getPlugin(Main.class).getConfig().getStringList(output);

    }


}