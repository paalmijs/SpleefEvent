package lv.side.SideSpleef;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class WaterChecker implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        final HashMap<UUID, Location> spawnpoints = new HashMap<>();
        final Location spleefmap_spawn = new Location(Bukkit.getWorld("world"), 0, 67, 0, 0, 0);
        Player player = event.getPlayer();
        Material material = event.getPlayer().getLocation().getBlock().getType();
        if (material == Material.WATER){
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(spleefmap_spawn);
        }
    }
}
