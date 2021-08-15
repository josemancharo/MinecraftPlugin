package josemancharo.minecraftplugin;

import java.util.Random;

import org.bukkit.*;
import org.bukkit.generator.*;
import org.bukkit.util.noise.*;

public class CustomChunkGenerator extends ChunkGenerator {
    private int currentHeight = 0;

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        var generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        ChunkData chunk = createChunkData(world);
        generator.setYScale(0.005D);
        generator.setZScale(0.09D);
        generator.setXScale(0.09D);
        var data = new ChunkGeneratorData(world, generator, random, chunkX, chunkZ, chunk, biome);
        buildChunks(data);
        return chunk;
    }

    private void buildChunks(ChunkGeneratorData data) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                currentHeight = (int) ((data.generator.noise(data.chunkX * 16 + x, data.chunkZ * 16 + z, 0.5D, 0.5D,
                        true) + 1) * 15D + 50D);
                buildChunk(data, x, z);
            }
        }
    }

    private void buildChunk(ChunkGeneratorData data, int x, int z) {
        data.chunk.setBlock(x, currentHeight, z, Material.IRON_BLOCK);
        data.chunk.setBlock(x, currentHeight - 1, z, Material.DEEPSLATE);
        for (int i = currentHeight - 2; i > 0; i--) {
            var random = data.random.nextInt(100);
            if (random > 80) {
                data.chunk.setBlock(x, i, z, Material.OBSIDIAN);
            } else if (random == 1) {
                data.chunk.setBlock(x, i, z, Material.DIAMOND_ORE);
            } else {
                data.chunk.setBlock(x, i, z, Material.OAK_LOG);
            }
        }
        data.chunk.setBlock(x, 0, z, Material.BEDROCK);
    }
}
