package net.gigaclub.feier68.gigagui;


import net.gigaclub.feier68.gigagui.util.Navigator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Navigator(), this);
    }


    public static Main getPlugin() {

        return plugin;
    }
}

