package com.buxx0.needleworld;

import com.buxx0.needleworld.item.ModItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("needleworld")
public class NeedleWorld {
	public static final String MOD_ID = "needleworld";
	
	public NeedleWorld() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
	}

}
