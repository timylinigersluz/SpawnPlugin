package ch.ksrminecraft.spawn.listeners;

import ch.ksrminecraft.spawn.Spawn;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    private final Spawn plugin;

    public SpawnListener(Spawn plugin) {
        this.plugin = plugin;
    }

    //onPlayerJoin-Methode
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {

            // Koordinaten aus der Variable location in config.yml laden
            Location location = plugin.getConfig().getLocation("spawn");

            // Spieler zum Spawn teleportieren, wenn die Variable location nicht null ist
            if (location != null) {
                player.teleport(location);
            }

        } else {
            player.sendMessage(Component.text("Willkommen zurück!"));
        }

    }

    //onRespawn-Methode
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) {
            event.setRespawnLocation(location);
        }

    }


}
