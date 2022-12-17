package com.buxx0.needleworld.item;

import com.buxx0.needleworld.NeedleWorld;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, NeedleWorld.MOD_ID);
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
	// ITEM DEFINITIONS
	public static final RegistryObject<Item> IRON_NEEDLE = ITEMS.register("iron_needle", 
			() -> new SwordItem(Tiers.IRON, 
					4, 
					-2.0f, 
					new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_COMBAT)
					.stacksTo(1)
					.defaultDurability(200)));
	
	public static final RegistryObject<Item> GOLDEN_NEEDLE = ITEMS.register("golden_needle", 
			() -> new SwordItem(Tiers.GOLD, 
					4, 
					5f, 
					new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_COMBAT)
					.stacksTo(1)
					.defaultDurability(40)));
	
	public static final RegistryObject<Item> DIAMOND_NEEDLE = ITEMS.register("diamond_needle", 
			() -> new SwordItem(Tiers.DIAMOND, 
					5, 
					-2.0f, 
					new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_COMBAT)
					.stacksTo(1)
					.defaultDurability(1500)));
	
	public static final RegistryObject<Item> NETHERITE_NEEDLE = ITEMS.register("netherite_needle", 
			() -> new SwordItem(Tiers.NETHERITE, 
					5, 
					-2.0f, 
					new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_COMBAT)
					.stacksTo(1)
					.defaultDurability(2000)));
	
	public static final RegistryObject<Item> EMERALD_NEEDLE = ITEMS.register("emerald_needle", 
			() -> new SwordItem(Tiers.DIAMOND, 
					5, 
					0.0f, 
					new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_COMBAT)
					.stacksTo(1)
					.defaultDurability(1700)));
	
	public static final RegistryObject<Item> CHEWABLE_NEEDLE = ITEMS.register("chewable_needle", 
			() -> new Item(new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_CONSUMABLES)
					.food(Foods.CHEWABLE_NEEDLE)
					.stacksTo(16)));
	
	
	public static final RegistryObject<Item> ACID= ITEMS.register("acid", 
			() -> new Item(new Item.Properties()
					.tab(CreativeModeCombat.NEEDLEWORLD_CONSUMABLES)
					.food(Foods.ACID)
					.stacksTo(64)));
	

	public static class Foods {
		public static final FoodProperties CHEWABLE_NEEDLE = new FoodProperties.Builder()
				.nutrition(10)
				.saturationMod(0.6f)
				.meat()
				.fast()
				.effect(() -> new MobEffectInstance(MobEffects.HARM, 10, 0, false, false, false), 0.2f)
				.build();
		
		public static final FoodProperties ACID = new FoodProperties.Builder()
				.nutrition(0)
				.saturationMod(0f)
				.fast()
				.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 7200, 6, false, false, false), 1f)
				.effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 7200, 6, false, false, false), 1f)
				.alwaysEat()
				.build();
		
	}
}
