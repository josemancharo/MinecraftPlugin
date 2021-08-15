package josemancharo.minecraftplugin;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator.*;
import org.bukkit.util.noise.*;

public class ChunkGeneratorData {
    public ChunkGeneratorData(World _world, 
            SimplexOctaveGenerator _generator, 
            Random _random, int _chunkX, int _chunkZ,
            ChunkData _chunk, BiomeGrid _biome) {
        generator = _generator;
        random = _random;
        chunkX = _chunkX;
        chunkZ = _chunkZ;
        chunk = _chunk;
        biome = _biome;
    }

    public World world;
    public SimplexOctaveGenerator generator;
    public Random random;
    public int chunkX;
    public int chunkZ;
    public ChunkData chunk;
    public BiomeGrid biome;
}
