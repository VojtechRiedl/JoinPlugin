package me.histal.joinplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        Player player = ((Player) sender);

        if(!player.hasPermission("devschool.heal")){
            player.sendMessage("§cNemáš dostatek práv na použití");
            return true;
        }
        if(args.length == 0){
            player.sendMessage("§aByl jsi uzdraven");
            healPlayer(player);
        }else if(args.length == 1){
            if(!player.hasPermission("devschool.heal.other")){
                player.sendMessage("§cNemáš dostatek práv na použití");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) return true;
            healPlayer(player);
            player.sendMessage("§e Uzdravil jsi hráče §l" + target.getName());
            target.sendMessage("§e Byl jsi uzdraven hráčem §l" + player.getName());
        }
        return true;
    }


    private void healPlayer(Player player){
        player.setHealth(player.getMaxHealth());
    }
}