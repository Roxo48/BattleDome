package me.roxo.battledome;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listener implements org.bukkit.event.Listener {
    private Manager manager;
    public Listener(Manager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        if(!(e.getDamager() instanceof Player)){
            return;
        }
        if(!(e.getEntity() instanceof Player)){
            return;
        }
        if(!manager.getDoTask().isGracePreiod()){
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void blockBroken(BlockBreakEvent e){

        if(!manager.getDoTask().isGracePreiod() && e.getBlock().getType() == Material.CRYING_OBSIDIAN){
            e.setCancelled(true);
            return;
        }
        if(!manager.getDoTask().isGracePreiod() && e.getBlock().getType() == Material.OBSIDIAN && e.getBlock().getLocation() == manager.getObLoc()){
            e.setCancelled(true);
            return;
        }
        if(manager.getDoTask().isGracePreiod() && e.getBlock().getType() == Material.OBSIDIAN && e.getBlock().getLocation() == manager.getObLoc()){
            manager.setIsobBroken(true);

        }
        if(manager.getDoTask().isGracePreiod() && e.getBlock().getType() == Material.CRYING_OBSIDIAN &&e.getBlock().getLocation() == manager.getCryLoc()){
            manager.setCryBroken(true);
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getEntity();

        if(!manager.getDoTask().isGracePreiod()){
            e.setKeepInventory(true);
        }
        if(manager.getTeamOne().contains(player)){
            if(manager.isIsobBroken()){
                manager.getTeamOne().remove(player);
                player.setGameMode(GameMode.SPECTATOR);
            }else {
                player.teleport(manager.getObLoc());
            }
        }
        if(manager.getTeamTwo().contains(player)){
            if(manager.isCryBroken()){
                manager.getTeamTwo().remove(player);
                player.setGameMode(GameMode.SPECTATOR);
            }else {
                player.teleport(manager.getCryLoc());
            }
        }
        if(manager.getTeamOne().size() == 0){
            manager.setDidTeamOneWin(true);
            manager.setState(State.WON);
        }
        if(manager.getTeamTwo().size() == 0){
            manager.setDidTeamOneWin(false);
            manager.setState(State.WON);
        }


    }
}
