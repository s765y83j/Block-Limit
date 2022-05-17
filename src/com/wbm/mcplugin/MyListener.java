package com.wbm.mcplugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MyListener implements Listener {
	/*
	 * @EventHandler public void onPlayerChat(PlayerChatEvent e) { // 발동 조건 : 플레이어가
	 * 아무런 메시지 보낼 때 발동 // 처리 : "안녕" 메시지를에게 보내줌
	 * 
	 * Player p = e.getPlayer(); p.sendMessage("안녕");
	 * 
	 * }
	 * 
	 * @EventHandler public void onBlockBreak(BlockBreakEvent e) { // 블럭이 부서졌을 때 호출됨
	 * // 부순 블럭을 다이아몬드 블럭을로 변경
	 * 
	 * Block block = e.getBlock();
	 * 
	 * // 이벤트 취소 (블럭 부서짐 취소) e.setCancelled(true); // 다이아몬드 블럭으로 변경
	 * block.setType(Material.DIAMOND_BLOCK); }
	 * 
	 * @EventHandler public void onAnimalDamaged(EntityDamageByEntityEvent e) { //
	 * 플레이어가 살아있는 것을 때릴 때, 죽게 만들기
	 * 
	 * // damager = 때린 생명채(엔티티) Entity damager = e.getDamager();
	 * 
	 * // victim = 맞은 생명체(엔티티) Entity victim = e.getEntity();
	 * 
	 * // 때린 엔티티가 플레이어일 때 if (damager instanceof Player) { if (victim instanceof
	 * Animals) { // 맞은 생명체가 동물일 때 죽이기 Animals animals = (Animals) victim; // 체력 0
	 * 설정 = 죽음 animals.setHealth(0); } } }
	 */

	JavaPlugin plugin;

	public MyListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		new BukkitRunnable() {

			@Override
			public void run() {
				// 실행할 작업
				checkFootBlock(e.getPlayer());

			}
		}.runTaskTimer(plugin, 0, 20); // 20 = 1초
	}

	void checkFootBlock(Player player) {

		// 목재 관련 블록 리스트 woods 생성, 초기화
		List<Material> woods = new ArrayList<>(Arrays.asList(Material.OAK_LOG, Material.SPRUCE_LOG, Material.BIRCH_LOG,
				Material.JUNGLE_LOG, Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.CRIMSON_STEM,
				Material.WARPED_STEM, Material.STRIPPED_OAK_LOG, Material.STRIPPED_SPRUCE_LOG,
				Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_ACACIA_LOG,
				Material.STRIPPED_DARK_OAK_LOG, Material.STRIPPED_CRIMSON_STEM, Material.STRIPPED_WARPED_STEM,
				Material.OAK_WOOD, Material.SPRUCE_WOOD, Material.BIRCH_WOOD, Material.JUNGLE_WOOD,
				Material.ACACIA_WOOD, Material.DARK_OAK_WOOD, Material.CRIMSON_HYPHAE, Material.WARPED_HYPHAE,
				Material.STRIPPED_OAK_WOOD, Material.STRIPPED_SPRUCE_WOOD, Material.STRIPPED_BIRCH_WOOD,
				Material.STRIPPED_JUNGLE_WOOD, Material.STRIPPED_ACACIA_WOOD, Material.STRIPPED_DARK_OAK_WOOD,
				Material.STRIPPED_CRIMSON_HYPHAE, Material.STRIPPED_WARPED_HYPHAE, Material.OAK_PLANKS,
				Material.SPRUCE_PLANKS, Material.BIRCH_PLANKS, Material.JUNGLE_PLANKS, Material.ACACIA_PLANKS,
				Material.DARK_OAK_PLANKS, Material.CRIMSON_PLANKS, Material.WARPED_PLANKS, Material.OAK_SLAB,
				Material.SPRUCE_SLAB, Material.BIRCH_SLAB, Material.JUNGLE_SLAB, Material.ACACIA_SLAB,
				Material.DARK_OAK_SLAB, Material.CRIMSON_SLAB, Material.WARPED_SLAB, Material.OAK_STAIRS,
				Material.SPRUCE_STAIRS, Material.BIRCH_STAIRS, Material.JUNGLE_STAIRS, Material.ACACIA_STAIRS,
				Material.DARK_OAK_STAIRS, Material.CRIMSON_STAIRS, Material.WARPED_STAIRS));

		// cobblestone 관련 블록 리스트 cobblestones 생성, 초기화
		List<Material> cobblestones = new ArrayList<>(Arrays.asList(Material.STONE, Material.STONE_SLAB,
				Material.STONE_STAIRS, Material.COBBLESTONE, Material.COBBLESTONE_SLAB, Material.COBBLESTONE_STAIRS,
				Material.MOSSY_COBBLESTONE, Material.MOSSY_COBBLESTONE_SLAB, Material.MOSSY_COBBLESTONE_STAIRS,
				Material.STONE_BRICKS, Material.STONE_BRICK_SLAB, Material.STONE_BRICK_STAIRS,
				Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICK_SLAB, Material.MOSSY_STONE_BRICK_STAIRS,
				Material.CRACKED_STONE_BRICKS, Material.CHISELED_STONE_BRICKS, Material.SMOOTH_STONE,
				Material.SMOOTH_STONE_SLAB, Material.INFESTED_STONE, Material.INFESTED_COBBLESTONE,
				Material.INFESTED_STONE_BRICKS, Material.INFESTED_MOSSY_STONE_BRICKS,
				Material.INFESTED_CRACKED_STONE_BRICKS, Material.INFESTED_CHISELED_STONE_BRICKS));

		// sand 관련 블록 리스트 sands 생성, 초기화
		List<Material> sands = new ArrayList<>(Arrays.asList(Material.SAND, Material.RED_SAND, Material.SANDSTONE,
				Material.SANDSTONE_SLAB, Material.SANDSTONE_STAIRS, Material.CUT_SANDSTONE, Material.CUT_SANDSTONE_SLAB,
				Material.SMOOTH_SANDSTONE, Material.SMOOTH_SANDSTONE_SLAB, Material.SMOOTH_SANDSTONE_STAIRS,
				Material.CHISELED_SANDSTONE, Material.RED_SANDSTONE, Material.RED_SANDSTONE_SLAB,
				Material.RED_SANDSTONE_STAIRS, Material.CUT_RED_SANDSTONE, Material.CUT_RED_SANDSTONE_SLAB,
				Material.SMOOTH_RED_SANDSTONE, Material.SMOOTH_RED_SANDSTONE_SLAB, Material.SMOOTH_RED_SANDSTONE_STAIRS,
				Material.CHISELED_RED_SANDSTONE));

		// 화강함, 안산암, 섬록암 관련 블록 리스트 granAndesDiorite 생성, 초기화 ( + 응회암, 흑요석, 우는 흑요석, 기반암도
		// 포함)
		List<Material> granAndesDiorite = new ArrayList<>(Arrays.asList(Material.GRANITE, Material.GRANITE_SLAB,
				Material.GRANITE_STAIRS, Material.POLISHED_GRANITE, Material.POLISHED_GRANITE_SLAB,
				Material.POLISHED_GRANITE_STAIRS, Material.ANDESITE, Material.ANDESITE_SLAB, Material.ANDESITE_STAIRS,
				Material.POLISHED_ANDESITE, Material.POLISHED_ANDESITE_SLAB, Material.POLISHED_ANDESITE_STAIRS,
				Material.DIORITE, Material.DIORITE_SLAB, Material.DIORITE_STAIRS, Material.POLISHED_DIORITE,
				Material.POLISHED_DIORITE_SLAB, Material.POLISHED_DIORITE_STAIRS, Material.TUFF, Material.OBSIDIAN,
				Material.CRYING_OBSIDIAN, Material.BEDROCK));

		// 심층암 관련 블록 리스트 deepslates 생성, 초기화
		List<Material> deepslates = new ArrayList<>(Arrays.asList(Material.DEEPSLATE, Material.COBBLED_DEEPSLATE,
				Material.COBBLED_DEEPSLATE_SLAB, Material.COBBLED_DEEPSLATE_STAIRS, Material.POLISHED_DEEPSLATE,
				Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_STAIRS, Material.DEEPSLATE_BRICKS,
				Material.DEEPSLATE_BRICK_SLAB, Material.DEEPSLATE_BRICK_STAIRS, Material.CRACKED_DEEPSLATE_BRICKS,
				Material.DEEPSLATE_TILES, Material.DEEPSLATE_TILE_SLAB, Material.DEEPSLATE_TILE_STAIRS,
				Material.CRACKED_DEEPSLATE_TILES, Material.CHISELED_DEEPSLATE, Material.INFESTED_DEEPSLATE));

		// 벽돌 관련 블록 리스트 bricks 생성, 초기화 (단, '벽돌재료'로 만드는 벽돌만 분류)
		List<Material> bricks = new ArrayList<>(
				Arrays.asList(Material.BRICKS, Material.BRICK_SLAB, Material.BRICK_STAIRS));

		// 프리즈머린 관련 블록 리스트 prismarines 생성, 초기화
		List<Material> prismarines = new ArrayList<>(
				Arrays.asList(Material.PRISMARINE, Material.PRISMARINE_SLAB, Material.PRISMARINE_STAIRS,
						Material.PRISMARINE_BRICKS, Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICK_STAIRS,
						Material.DARK_PRISMARINE, Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE_STAIRS));

		// 석영 관련 블록 리스트 quartzs 생성, 초기화
		List<Material> quartzs = new ArrayList<>(Arrays.asList(Material.QUARTZ_BLOCK, Material.QUARTZ_SLAB,
				Material.QUARTZ_STAIRS, Material.CHISELED_QUARTZ_BLOCK, Material.QUARTZ_PILLAR, Material.QUARTZ_BRICKS,
				Material.SMOOTH_QUARTZ, Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ_STAIRS));

		// 네더 관련 블록 리스트 nethers 생성, 초기화 ( + 네더랙, 마그마 블록, 발광석, 사마귀 블록, 뒤틀린 사마귀 블록, 뼈 블록
		// 포함)
		List<Material> nethers = new ArrayList<>(Arrays.asList(Material.NETHER_BRICKS, Material.NETHER_BRICK_SLAB,
				Material.NETHER_BRICK_STAIRS, Material.CHISELED_NETHER_BRICKS, Material.CRACKED_NETHER_BRICKS,
				Material.RED_NETHER_BRICKS, Material.RED_NETHER_BRICK_SLAB, Material.RED_NETHER_BRICK_STAIRS,
				Material.NETHERRACK, Material.MAGMA_BLOCK, Material.GLOWSTONE, Material.NETHER_WART_BLOCK,
				Material.WARPED_WART_BLOCK, Material.BONE_BLOCK));

		// 흑암 관련 블록 리스트 blackstones 생성, 초기화
		List<Material> blackstones = new ArrayList<>(Arrays.asList(Material.BLACKSTONE, Material.BLACKSTONE_SLAB,
				Material.BLACKSTONE_STAIRS, Material.POLISHED_BLACKSTONE, Material.POLISHED_BLACKSTONE_SLAB,
				Material.POLISHED_BLACKSTONE_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS,
				Material.POLISHED_BLACKSTONE_BRICK_SLAB, Material.POLISHED_BLACKSTONE_BRICK_STAIRS,
				Material.CRACKED_POLISHED_BLACKSTONE_BRICKS, Material.CHISELED_POLISHED_BLACKSTONE,
				Material.GILDED_BLACKSTONE));

		// 엔드스톤 관련 블록 리스트 endstones 생성, 초기화
		List<Material> endstones = new ArrayList<>(Arrays.asList(Material.END_STONE, Material.END_STONE_BRICKS,
				Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICK_STAIRS));

		// 퍼퍼 관련 블록 리스트 purpur 생성, 초기화
		List<Material> purpur = new ArrayList<>(Arrays.asList(Material.PURPUR_BLOCK, Material.PURPUR_SLAB,
				Material.PURPUR_STAIRS, Material.PURPUR_PILLAR));

		// 흙 관련 블록 리스트 dirts 생성, 초기화 ( + 진홍빛 네사체, 뒤틀린 네사체, 영혼 모래, 영혼 흙 포함)
		List<Material> dirts = new ArrayList<>(Arrays.asList(Material.DIRT, Material.COARSE_DIRT, Material.GRASS_BLOCK,
				Material.DIRT_PATH, Material.MYCELIUM, Material.PODZOL, Material.ROOTED_DIRT, Material.GRAVEL,
				Material.CRIMSON_NYLIUM, Material.WARPED_NYLIUM, Material.SOUL_SAND, Material.SOUL_SOIL));

		// 콘크리트 관련 블록 리스트 concretes 생성, 초기화
		List<Material> concretes = new ArrayList<>(
				Arrays.asList(Material.BLACK_CONCRETE, Material.BLACK_CONCRETE_POWDER, Material.BLUE_CONCRETE,
						Material.BLUE_CONCRETE_POWDER, Material.BROWN_CONCRETE, Material.BROWN_CONCRETE_POWDER,
						Material.CYAN_CONCRETE, Material.CYAN_CONCRETE_POWDER, Material.GRAY_CONCRETE,
						Material.GRAY_CONCRETE_POWDER, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE_POWDER,
						Material.LIGHT_BLUE_CONCRETE, Material.LIGHT_BLUE_CONCRETE_POWDER, Material.LIGHT_GRAY_CONCRETE,
						Material.LIGHT_GRAY_CONCRETE_POWDER, Material.LIME_CONCRETE, Material.LIME_CONCRETE_POWDER,
						Material.MAGENTA_CONCRETE, Material.MAGENTA_CONCRETE_POWDER, Material.ORANGE_CONCRETE,
						Material.ORANGE_CONCRETE_POWDER, Material.PINK_CONCRETE, Material.PINK_CONCRETE_POWDER,
						Material.PURPLE_CONCRETE, Material.PURPLE_CONCRETE_POWDER, Material.RED_CONCRETE,
						Material.RED_CONCRETE_POWDER, Material.WHITE_CONCRETE, Material.WHITE_CONCRETE_POWDER,
						Material.YELLOW_CONCRETE, Material.YELLOW_CONCRETE_POWDER));

		// 광물 관련 블록 리스트 ores 생성, 초기화 (단, 구리는 제외)
		List<Material> ores = new ArrayList<>(Arrays.asList(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE,
				Material.COAL_BLOCK, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.IRON_BLOCK,
				Material.RAW_IRON_BLOCK, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.GOLD_BLOCK,
				Material.RAW_GOLD_BLOCK, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.DIAMOND_BLOCK,
				Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.REDSTONE_BLOCK, Material.LAPIS_ORE,
				Material.DEEPSLATE_LAPIS_ORE, Material.LAPIS_BLOCK, Material.EMERALD_ORE,
				Material.DEEPSLATE_EMERALD_ORE, Material.EMERALD_BLOCK, Material.NETHER_QUARTZ_ORE,
				Material.NETHER_GOLD_ORE, Material.ANCIENT_DEBRIS, Material.NETHERITE_BLOCK));

		// 구리 관련 블록 리스트 coppers 생성, 초기화
		List<Material> coppers = new ArrayList<>(Arrays.asList(Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE,
				Material.RAW_COPPER_BLOCK, Material.COPPER_BLOCK, Material.CUT_COPPER, Material.CUT_COPPER_SLAB,
				Material.CUT_COPPER_STAIRS, Material.WAXED_COPPER_BLOCK, Material.WAXED_CUT_COPPER,
				Material.WAXED_CUT_COPPER_SLAB, Material.WAXED_CUT_COPPER_STAIRS, Material.EXPOSED_COPPER,
				Material.EXPOSED_CUT_COPPER, Material.EXPOSED_CUT_COPPER_SLAB, Material.EXPOSED_CUT_COPPER_STAIRS,
				Material.WAXED_EXPOSED_COPPER, Material.WAXED_EXPOSED_CUT_COPPER,
				Material.WAXED_EXPOSED_CUT_COPPER_SLAB, Material.WAXED_EXPOSED_CUT_COPPER_STAIRS,
				Material.WEATHERED_COPPER, Material.WEATHERED_CUT_COPPER, Material.WEATHERED_CUT_COPPER_SLAB,
				Material.WEATHERED_CUT_COPPER_STAIRS, Material.WAXED_WEATHERED_COPPER,
				Material.WAXED_WEATHERED_CUT_COPPER, Material.WAXED_WEATHERED_CUT_COPPER_SLAB,
				Material.WAXED_WEATHERED_CUT_COPPER_STAIRS, Material.OXIDIZED_COPPER, Material.OXIDIZED_CUT_COPPER,
				Material.OXIDIZED_CUT_COPPER_SLAB, Material.OXIDIZED_CUT_COPPER_STAIRS, Material.WAXED_OXIDIZED_COPPER,
				Material.WAXED_OXIDIZED_CUT_COPPER, Material.WAXED_OXIDIZED_CUT_COPPER_SLAB,
				Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS));

		// 자수정 정동에서 생성되는 블록 리스트 amethystGeodes 생성, 초기화 ( + 현무암 관련 블록, 점적석 블록도 포함)
		List<Material> amethystGeodes = new ArrayList<>(Arrays.asList(Material.SMOOTH_BASALT, Material.CALCITE,
				Material.AMETHYST_BLOCK, Material.BUDDING_AMETHYST, Material.BASALT, Material.POLISHED_BASALT,
				Material.DRIPSTONE_BLOCK));

		// 유리 관련 블록 리스트 glasses 생성, 초기화 ( + 유리판도 포함)
		List<Material> glasses = new ArrayList<>(Arrays.asList(Material.GLASS, Material.GLASS_PANE,
				Material.BLACK_STAINED_GLASS, Material.BLACK_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS,
				Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS, Material.BROWN_STAINED_GLASS_PANE,
				Material.CYAN_STAINED_GLASS, Material.CYAN_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS,
				Material.GRAY_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS, Material.GREEN_STAINED_GLASS_PANE,
				Material.LIGHT_BLUE_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS_PANE,
				Material.LIGHT_GRAY_STAINED_GLASS, Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS,
				Material.LIME_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS, Material.MAGENTA_STAINED_GLASS_PANE,
				Material.ORANGE_STAINED_GLASS, Material.ORANGE_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS,
				Material.PINK_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS, Material.PURPLE_STAINED_GLASS_PANE,
				Material.RED_STAINED_GLASS, Material.RED_STAINED_GLASS_PANE, Material.WHITE_STAINED_GLASS,
				Material.WHITE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS, Material.YELLOW_STAINED_GLASS_PANE,
				Material.TINTED_GLASS));

		// 눈, 얼음 관련 블록 리스트 snows 생성, 초기화
		List<Material> snows = new ArrayList<>(Arrays.asList(Material.ICE, Material.PACKED_ICE, Material.BLUE_ICE,
				Material.FROSTED_ICE, Material.SNOW, Material.SNOW_BLOCK));

		// 테라코다 관련 블록 리스트 terracottas 생성, 초기화 ( + 점토도 포함)
		List<Material> terracottas = new ArrayList<>(Arrays.asList(Material.CLAY, Material.TERRACOTTA,
				Material.BLACK_TERRACOTTA, Material.BLACK_GLAZED_TERRACOTTA, Material.BLUE_TERRACOTTA,
				Material.BLUE_GLAZED_TERRACOTTA, Material.BROWN_TERRACOTTA, Material.BROWN_GLAZED_TERRACOTTA,
				Material.CYAN_TERRACOTTA, Material.CYAN_GLAZED_TERRACOTTA, Material.GRAY_TERRACOTTA,
				Material.GRAY_GLAZED_TERRACOTTA, Material.GREEN_TERRACOTTA, Material.GREEN_GLAZED_TERRACOTTA,
				Material.LIGHT_BLUE_TERRACOTTA, Material.LIGHT_BLUE_GLAZED_TERRACOTTA, Material.LIGHT_GRAY_TERRACOTTA,
				Material.LIGHT_GRAY_GLAZED_TERRACOTTA, Material.LIME_TERRACOTTA, Material.LIME_GLAZED_TERRACOTTA,
				Material.MAGENTA_TERRACOTTA, Material.MAGENTA_GLAZED_TERRACOTTA, Material.ORANGE_TERRACOTTA,
				Material.ORANGE_GLAZED_TERRACOTTA, Material.PINK_TERRACOTTA, Material.PINK_GLAZED_TERRACOTTA,
				Material.PURPLE_TERRACOTTA, Material.PURPLE_GLAZED_TERRACOTTA, Material.RED_TERRACOTTA,
				Material.RED_GLAZED_TERRACOTTA, Material.WHITE_TERRACOTTA, Material.WHITE_GLAZED_TERRACOTTA,
				Material.YELLOW_TERRACOTTA, Material.YELLOW_GLAZED_TERRACOTTA));

		// 양털, 카펫 관련 블록 리스트 wools 생성, 초기화
		List<Material> wools = new ArrayList<>(Arrays.asList(Material.BLACK_WOOL, Material.BLACK_CARPET,
				Material.BLUE_WOOL, Material.BLUE_CARPET, Material.BROWN_WOOL, Material.BROWN_CARPET,
				Material.CYAN_WOOL, Material.CYAN_CARPET, Material.GRAY_WOOL, Material.GRAY_CARPET, Material.GREEN_WOOL,
				Material.GREEN_CARPET, Material.LIGHT_BLUE_WOOL, Material.LIGHT_BLUE_CARPET, Material.LIGHT_GRAY_WOOL,
				Material.LIGHT_GRAY_CARPET, Material.LIME_WOOL, Material.LIME_CARPET, Material.MAGENTA_WOOL,
				Material.MAGENTA_CARPET, Material.ORANGE_WOOL, Material.ORANGE_CARPET, Material.PINK_WOOL,
				Material.PINK_CARPET, Material.PURPLE_WOOL, Material.PURPLE_CARPET, Material.RED_WOOL,
				Material.RED_CARPET, Material.WHITE_WOOL, Material.WHITE_CARPET, Material.YELLOW_WOOL,
				Material.YELLOW_CARPET));

		// 산호 블록, 죽은 산호 블록 리스트 corals 생성, 초기화
		List<Material> corals = new ArrayList<>(Arrays.asList(Material.BRAIN_CORAL_BLOCK,
				Material.DEAD_BRAIN_CORAL_BLOCK, Material.BUBBLE_CORAL_BLOCK, Material.DEAD_BUBBLE_CORAL_BLOCK,
				Material.FIRE_CORAL_BLOCK, Material.DEAD_FIRE_CORAL_BLOCK, Material.HORN_CORAL_BLOCK,
				Material.DEAD_HORN_CORAL_BLOCK, Material.TUBE_CORAL_BLOCK, Material.DEAD_TUBE_CORAL_BLOCK));

		// 마인크래프트 블록들의 리스트 생성 (단, 울타리, 상자, 작업대, 캔들 등의 블록들은 제외)
		List<List<Material>> blockList = List.of(woods, cobblestones, sands, granAndesDiorite, deepslates, bricks,
				prismarines, quartzs, nethers, blackstones, endstones, purpur, dirts, concretes, ores, coppers,
				amethystGeodes, glasses, snows, terracottas, wools, corals);

		// 플레이어의 바로 아래 있는 위치에 있는 블록 위치를 가져옴
		Location loc = player.getLocation().clone().subtract(0, 1, 0);
		Block b = loc.getBlock(); // 구한 위치에 해당하는 블록을 가져옴
		Material footBlock = b.getType(); // 가져온 블록의 타입(Material)을 가져옴

		// 플레이어가 인벤토리에서 손에 든 블록의 타입(Material)을 가져옴,
		// rightHandBlock = 오른손, leftHandBlock = 왼손
		Material rightHandBlock = player.getInventory().getItemInMainHand().getType();
		Material leftHandBlock = player.getInventory().getItemInOffHand().getType();

		int damage = 4; // 체력은 4씩 줄임 (전체 = 20)

		if (player.getGameMode() == GameMode.SURVIVAL) {
			for (List<Material> block : blockList) {
				if (block.contains(footBlock) && (block.contains(rightHandBlock) || block.contains(leftHandBlock))) {
					return;
				}
			}

			player.setHealth(player.getHealth() - damage);
		}

	}

}
