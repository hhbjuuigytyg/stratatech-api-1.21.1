package com.konotop.stratatech;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.concinnity.tfcbiomegen.api.BiomeAPI;
import com.concinnity.tfcbiomegen.api.BiomeEnums;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(stratatech.MOD_ID)
public class stratatech {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "stratatech";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public stratatech(IEventBus modEventBus, ModContainer modContainer) {
        BiomeAPI.init(modEventBus, stratatech.MOD_ID);

        var lavender = BiomeAPI.registerBiome(
                stratatech.MOD_ID, "lavender_field",
                BiomeAPI.parseHeightmap("plains"),
                BiomeEnums.Surface.NORMAL,
                BiomeEnums.RiverBlend.FLOODPLAIN,
                true

        );

        BiomeAPI.place(lavender)
                .replaces(BiomeEnums.Layer.PLAINS)
                .temperature(-20f, 30f)
                .rainfall(0f, 500f)
                .rarity(0.5f)
                .register();

        modEventBus.addListener(this::commonSetup);

    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
