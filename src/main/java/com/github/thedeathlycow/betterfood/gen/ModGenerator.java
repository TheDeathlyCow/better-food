package com.github.thedeathlycow.betterfood.gen;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModGenerator {

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig salt_cfg = new CountRangeConfig(5, 32, 0, 64);


    private static final int salt_deposit_radius = 6;
    private static final int salt_deposit_height = 2;

    public static void setupFeatureGen() {

    }

    public static void setupOreGen() {

        Biome[] oceanBiomes = {
                Biomes.OCEAN,
                Biomes.DEEP_OCEAN,
                Biomes.COLD_OCEAN,
                Biomes.DEEP_COLD_OCEAN,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.WARM_OCEAN,
                Biomes.DEEP_WARM_OCEAN,
                Biomes.LUKEWARM_OCEAN,
                Biomes.DEEP_LUKEWARM_OCEAN,
                Biomes.BEACH,
                Biomes.SNOWY_BEACH
        };

        // ForgeRegistries.BIOMES
        for (Biome biome : oceanBiomes) {
            // add salt deposits
            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.DISK.withConfiguration(new SphereReplaceConfig(ModBlocks.SALT_DEPOSIT.getDefaultState(), salt_deposit_radius, salt_deposit_height, Lists.newArrayList(Blocks.GRAVEL.getDefaultState(), Blocks.SAND.getDefaultState()))).withPlacement(Placement.COUNT_RANGE.configure(salt_cfg))
            );
//            biome.addFeature(
//                    GenerationStage.Decoration.UNDERGROUND_ORES,
//                    Biome.func_225566_b_(Feature.DISK,
//                            new SphereReplaceConfig(ModBlocks.SALT_DEPOSIT.getDefaultState(), salt_deposit_radius, salt_deposit_height, Lists.newArrayList(Blocks.GRAVEL.getDefaultState(), Blocks.SAND.getDefaultState())),
//                            Placement.COUNT_RANGE,
//                            salt_cfg
//                    )
//            );
        }
    }

}