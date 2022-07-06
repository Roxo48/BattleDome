package me.roxo.battledome;

import org.bukkit.plugin.java.JavaPlugin;

public final class Battledome extends JavaPlugin {
    private Manager manager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        manager = new Manager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getCommand("startgame").setExecutor(new Command(getManager()));
        getCommand("selectteam").setExecutor(new TeamSelector(getManager()));
    }

    public Manager getManager() {
        return manager;
    }
}
