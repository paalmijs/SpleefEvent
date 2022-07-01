package lv.side.SideSpleef;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static com.google.gson.internal.bind.TypeAdapters.UUID;
import static org.bukkit.Bukkit.getServer;


public class CountdownEnd implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

            int assignedTaskId;

            int secondsLeft;

            int seconds = 30;

            final Location spleefmap_spawn = new Location(Bukkit.getWorld("world"), 0, 67, 0, 0, 0);
            SpleefMain plugin = SpleefMain.getInstance();
            Countdown timer = new Countdown(plugin, seconds,
                    () -> {

                        Bukkit.broadcastMessage("Countdown ended!");
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.teleport(spleefmap_spawn);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 255));
                            players.getInventory().setItem(1, new ItemStack(Material.NETHERITE_SHOVEL));
                        }
                    },

                    (t) -> {
                        int remainingSeconds = t.getRemainingSeconds();
                        Bukkit.broadcastMessage("Remaining seconds: " + remainingSeconds);
                    }
            );

            timer.scheduleTimer();

            return false;
        }
    }