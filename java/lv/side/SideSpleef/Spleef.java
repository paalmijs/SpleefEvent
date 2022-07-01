package lv.side.SideSpleef;

import com.google.common.collect.Sets;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.EventListener;
import java.util.HashMap;

import java.util.UUID;

public class Spleef implements EventListener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //Kad spēlētājs pievienojas serverim to teleportēt uz noteiktu lokāciju.
        final HashMap<UUID, Location> spawnpoints = new HashMap<>();
        final Location default_spawn = new Location(Bukkit.getWorld("world"), 0, 67, 0, 0, 0);
        Player player = event.getPlayer();
                player.teleport(default_spawn);
    }
}
