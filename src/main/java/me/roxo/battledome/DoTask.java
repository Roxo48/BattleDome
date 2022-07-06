package me.roxo.battledome;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class DoTask {

   private int counter;
   private final Manager gamerManager;

    public boolean isGracePreiod() {
        return gracePreiod;
    }

    private boolean gracePreiod;
   private int done;

   private int a;
   public DoTask(Manager gamerManager){
       this.counter = 0;
       this.gamerManager = gamerManager;
       this.done =  0;
       this.gracePreiod = false;

   }





   public void Timer(){
       long b = 20L * 60;

       new BukkitRunnable() {
           @Override
           public void run() {
                if(done == 30){
                    Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Grace Period is over! KILL");
                    gracePreiod = true;
                }
               done++;
           }


       }.runTaskTimer(gamerManager.getPlugin(), 0L, b);




   }




   public int getDone(){return done;}

}
