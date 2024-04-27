package ch.ksrminecraft.spawn.commands;

import ch.ksrminecraft.spawn.Spawn;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {

    private final Spawn plugin;

    public SetSpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("spawn.setspawn")) {
            player.sendMessage(Component.text("Du hast keine Berechtigung"));
            return true;
        }

        // Koordinaten des Spielers in der Variable location in config.yml speichern
        Location location = player.getLocation();
        plugin.getConfig().set("spawn", location);
        plugin.saveConfig();
        player.sendMessage(Component.text("Spawn-Punkt gesetzt"));
        return true;
    }
}
