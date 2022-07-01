package lv.side.SideSpleef;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class SpleefMain extends JavaPlugin {
        private static SpleefMain instance;

        public SpleefMain() {
            instance = this;
        }

        public static SpleefMain getInstance() {
            return instance;
        }

        public void doSomethingElse() {
        }

    //Ieslēdzot pluginu tiek pielitoti visi pieejamie faili iekš plugina un tiek servera konsolē izdrukāta ziņa.
    @Override
    public void onEnable() {
        getLogger().info("Spleef plugins tika ieslēgts!");
        this.getCommand("start").setExecutor(new CountdownEnd());
        Bukkit.getPluginManager().registerEvents((Listener) new WaterChecker(), this);
        Bukkit.getPluginManager().registerEvents((Listener) new Spleef(), this);
    }

//Izslēdzot pluginu tas izdrukās ziņu.
    @Override
    public void onDisable() {
        getLogger().info("Spleef plugins tika izslēgts!");
    }
}
