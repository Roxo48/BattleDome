package me.roxo.battledome;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartingTask extends BukkitRunnable {

    private Manager gameManager;

    public GameStartingTask(Manager gameManager) {
        this.gameManager = gameManager;
    }

    private  int timer = 20;






    @Override
    public void run() {

        if (timer <= 0) {

            for(Player players : gameManager.getPlayerList()){
                players.setInvulnerable(true);
                // players.sendTitle("", timer+ "", 20,20,20);
            }
            gameManager.setState(State.STARTING);
            cancel();
        }

        if (timer <= 5 || timer == 20) {
            for (Player players : gameManager.getPlayerList()) {
                players.sendTitle(ChatColor.LIGHT_PURPLE + "Game starting in " , timer + " second" + (timer == 1 ? "" : "s") + "...",20,20,20);
            }
        }
        if(timer == 5){
            Location loc = new Location(gameManager.getPlayerList().get(0).getWorld(),0,100,0 );
            for(Player players : gameManager.getPlayerList()){
                players.setInvulnerable(true);
                players.playSound(players.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1,1);
                players.teleport(loc);
                World world = Bukkit.getWorld(gameManager.getPlayerList().get(0).getWorld().getName());
                WorldBorder worldBorder = world.getWorldBorder();
                worldBorder.setCenter(loc);
                worldBorder.setSize(1000);
            }
        }
        timer--;
    }

}
