package me.roxo.battledome;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class TeamSelector implements CommandExecutor {
    private Manager manager;
    public TeamSelector(Manager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }
        Player player = ((Player) sender).getPlayer();
        List<Player> teamOne = manager.getTeamOne();
        List<Player> teamTwo = manager.getTeamTwo();
        int total = (int)manager.getPlayerList().size() /2;

        if(args[0].toUpperCase().equals("TEAMONE")){
            if(manager.getTeamOne().size() >= total){
                player.sendMessage(ChatColor.RED + "Team full");
            }
            if(teamOne.contains(player)){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "YOU ARE ALREADY IN THIS TEAM");
                return true;
            }
            if(teamTwo.contains(player)){
                teamTwo.remove(player);
                manager.getTeamOne().add(player);
                Bukkit.getServer().broadcastMessage(player.getName() + ChatColor.GREEN + " joined team one");
            }else {
                manager.getTeamOne().add(player);
                Bukkit.getServer().broadcastMessage(player.getName() + ChatColor.GREEN + " joined team one");
            }


        }else if(args[0].toUpperCase().equals("TEAMTWO")){
            if(manager.getTeamTwo().size() >= total){
                player.sendMessage(ChatColor.RED + "Team full");
            }
            if(teamTwo.contains(player)){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "YOU ARE ALREADY IN THIS TEAM");
            }
            if(teamOne.contains(player)){
                teamOne.remove(player);
                manager.getTeamTwo().add(player);
                Bukkit.getServer().broadcastMessage(player.getName() + ChatColor.GREEN + " joined team two");
            }else {
                Bukkit.getServer().broadcastMessage(player.getName() + ChatColor.GREEN + " joined team two");
                manager.getTeamTwo().add(player);
            }

        }



        return false;
    }
}
