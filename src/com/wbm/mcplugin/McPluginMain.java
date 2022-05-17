package com.wbm.mcplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class McPluginMain extends JavaPlugin {
	@Override
	public void onEnable() {
		super.onEnable();

		// 시작할 때 실행되는 곳
		System.out.println("실행됨");

		// 이벤트 리스너(핸들링) 등록하기
		MyListener myLis = new MyListener();
		getServer().getPluginManager().registerEvents(myLis, this);

		// 명령어처리 객체 등록
		getCommand("mc").setExecutor(new MyCommand());
	}

	@Override
	public void onDisable() {
		super.onDisable();

		// 종료될 때 실행되는 곳
		System.out.println("종료됨");
	}
}
