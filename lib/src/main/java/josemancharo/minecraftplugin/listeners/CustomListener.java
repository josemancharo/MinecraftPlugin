package josemancharo.minecraftplugin.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomListener implements Listener {
    protected JavaPlugin plugin;
    protected CustomListener() {};

    public CustomListener(JavaPlugin _plugin){
        plugin = _plugin;
    }
}
