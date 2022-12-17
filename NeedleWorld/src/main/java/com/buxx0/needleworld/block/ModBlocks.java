package com.buxx0.needleworld.block;

import com.buxx0.needleworld.NeedleWorld;
import com.buxx0.needleworld.item.CreativeModeCombat;
import com.buxx0.needleworld.item.ModItems;
import com.google.common.base.Supplier;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = 
			DeferredRegister.create(ForgeRegistries.BLOCKS, NeedleWorld.MOD_ID);
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
		
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
		
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));	
	} 
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
	
	// BLOCK DEFINITIONS
	
	public static final RegistryObject<Block> BALL_BLOCK = registerBlock("ball_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).jumpFactor(1.3f).requiresCorrectToolForDrops()), CreativeModeCombat.NEEDLEWORLD_COMBAT);
	
	public static final RegistryObject<Block> BALL_ORE = registerBlock("ball_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).jumpFactor(1.3f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)), CreativeModeCombat.NEEDLEWORLD_COMBAT);
	
	public static final RegistryObject<Block> DEEPSLATE_BALL_ORE = registerBlock("deepslate_ball_ore", 
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).jumpFactor(1.3f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)), CreativeModeCombat.NEEDLEWORLD_COMBAT);
}
