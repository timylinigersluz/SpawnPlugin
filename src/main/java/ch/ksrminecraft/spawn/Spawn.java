package ch.ksrminecraft.spawn;

import ch.ksrminecraft.spawn.commands.SetSpawnCommand;
import ch.ksrminecraft.spawn.commands.SpawnCommand;
import ch.ksrminecraft.spawn.listeners.SpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
