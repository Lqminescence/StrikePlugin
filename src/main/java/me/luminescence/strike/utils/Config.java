package me.luminescence.strike.utils;

import me.luminescence.strike.Main;

import java.util.List;

public class Config {

    public static String String(String text) {

        String output = text;
        return Main.getPlugin(Main.class).getConfig().getString(output);

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