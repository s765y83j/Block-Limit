package com.wbm.mcplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// 명령어 처리 객체
public class MyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		p.sendMessage("명령어 실행했어요");

		// 인자 설정 : 인자는 args로 들어옴
		// ex) /mc a(args[0]) b(args[1]) c(args[2])

		// 첫 번째 인자
		String first = args[0];
		p.sendMessage("첫 번째 인자 : " + first);

		// 첫 번째 인자가 kill 문자열일 때
		if (first.equals("kill")) {
			// 플레이어 죽이기
			p.setHealth(0);
		}

		return true;
	}

}
