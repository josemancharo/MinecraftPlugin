package josemancharo.minecraftplugin;

import org.bukkit.event.*;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.*;

public final class FirstPlugin extends JavaPlugin {
    private final Listener[] listeners = { new CreeperListeners(), new SkeletonListeners() };

    @Override
    public void onEnable() {
        getLogger().info("Jose Mancharo's First Plugin is enabled. Die bravely.");
        registerListeners();
    }

    @Override
    public void onDisable() {
        getLogger().info("Jose Mancharo's First Plugin is disabled. I'm sorry you were too soft for this world.");
    }
    
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new CustomChunkGenerator();
    }

    private void registerListeners(){
        for (Listener listener : listeners){
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

}