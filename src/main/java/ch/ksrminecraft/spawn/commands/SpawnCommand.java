package ch.ksrminecraft.spawn.commands;

import ch.ksrminecraft.spawn.Spawn;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    private final Spawn plugin;

    public SpawnCommand(Spawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        // Koordinaten aus der Variable location in config.yml laden
        Location location = plugin.getConfig().getLocation("spawn");

        // Spieler zum Spawn teleportieren, wenn die Variable location nicht null ist
        if (location != null) {
            player.teleport(location);
            player.sendMessage(Component.text("Du wurdest zum Spawn teleportiert!"));
        } else {
            // Wenn die Variable location null ist, dann wurde der Spawn noch nicht gesetzt
            player.sendMessage(Component.text("Der Spawn-Point wurde noch nicht gesetzt!"));
        }
        return true;
    }
}
