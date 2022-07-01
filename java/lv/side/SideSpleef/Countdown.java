package lv.side.SideSpleef;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;
    public class Countdown implements Runnable {

        private SpleefMain plugin;

        private Integer assignedTaskId;

        private int seconds;
        private int secondsLeft;

        private Consumer<Countdown> everySecond;
        private Runnable afterTimer;

        public Countdown(SpleefMain plugin, int seconds, Runnable afterTimer,
                         Consumer<Countdown> everySecond) {
            this.plugin = plugin;

            this.secondsLeft = seconds;
            this.seconds = seconds;

            this.afterTimer = afterTimer;
            this.everySecond = everySecond;
        }

        @Override
        public void run() {
            if (secondsLeft < 1) {

                Bukkit.getScheduler().cancelTask(assignedTaskId);
                afterTimer.run();
                return;
            }

            everySecond.accept(this);
            secondsLeft--;
        }

        public int getRemainingSeconds() {
            return secondsLeft;
        }

        public Integer getTaskId() {
            return assignedTaskId;
        }

        public void scheduleTimer() {
            this.assignedTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) plugin, this, 0L, 20L);
        }
    }