package me.roxo.battledome;

import org.bukkit.plugin.java.JavaPlugin;

public final class Battledome extends JavaPlugin {
    private Manager manager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.manager = new Manager(this);
        getCommand("startbattledome").setExecutor(new Command(getManager()));
        getCommand("selectteam").setExecutor(new TeamSelector(getManager()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public Manager getManager() {
        return manager;
    }
}
