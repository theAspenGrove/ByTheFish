package net.mov51.bythefish;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ByTheFish extends JavaPlugin {

    @Override
    public void onEnable() {
        //register the command
        Objects.requireNonNull(this.getCommand("bythefish")).setExecutor(new ByTheFishCommand());
        //register death event
        this.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
