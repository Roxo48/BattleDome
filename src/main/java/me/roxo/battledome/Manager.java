package me.roxo.battledome;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private Battledome plugin;

    private State state;

    private double X_1, Y_1,Z_1;

    private boolean didTeamOneWin, isobBroken, isCryBroken;

    private double X_2, Y_2,Z_2;

    public Location getObLoc() {
        return obLoc;
    }

    public Location getCryLoc() {
        return cryLoc;
    }

    Location obLoc, cryLoc;
    private DoTask doTask;
    public List<Player> getPlayerList() {
        return playerList;
    }

    private List<Player> playerList;

    public List<Player> getTeamOne() {
        return teamOne;
    }

    private List<Player> teamOne;

    public List<Player> getTeamTwo() {
        return teamTwo;
    }
    int count ;
    private List<Player> teamTwo;

    public GameStartingTask getGameStartingTask() {
        return gameStartingTask;
    }
    private GameStartingTask gameStartingTask;

    public Manager(Battledome plugin){
        this.count = 0;
        this.plugin = plugin;
        this.playerList = new ArrayList<>();
        this.gameStartingTask = new GameStartingTask(this);
        this.doTask = new DoTask(this);
        this.teamOne = new ArrayList<>();
        this.teamTwo = new ArrayList<>();
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;

        switch (state){
            case START:
                //Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN +"hi");

                if(count == 0) {
                    playerList.addAll( Bukkit.getServer().getOnlinePlayers());
                    obLoc = new Location(playerList.get(0).getWorld(), getX_1(),getY_1(),getZ_3());
                    cryLoc = new Location(playerList.get(0).getWorld(), getX_2(),getY_2(),getZ_2());
                }

                count++;
                int a = playerList.size();
                int b = (int) a/2;
                int c = (int) b-1;


                //if(teamOne.size() != c || teamTwo.size() != c){setState(State.START);}






                break;
            case STARTING:

                gameStartingTask.runTaskTimer(this.getPlugin(), 0 ,20);

                break;
            case ACTIVE:
//                Location obBlockOne = new Location(playerList.get(1).getWorld(), getX_1(),getY_1(),getZ_3());
//                Location obBlockTwo = new Location(playerList.get(1).getWorld(), getX_2(),getY_2(),getZ_2());

                obLoc.getBlock().setType(Material.OBSIDIAN);
                cryLoc.getBlock().setType(Material.CRYING_OBSIDIAN);
                for(Player players : this.getPlayerList()){
                    players.setInvulnerable(false);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN +"Team One you are protecting the regular obsidian");
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_BLUE + "Team Two you are protecting the crying obsidian");

                break;
            case WON:


                break;

        }

    }


    public double getX_1() {
        return X_1;
    }

    public void setX_1(double x_1) {
        X_1 = x_1;
    }

    public double getY_1() {
        return Y_1;
    }

    public void setY_1(double y_1) {
        Y_1 = y_1;
    }

    public double getZ_3() {
        return Z_1;
    }

    public void setZ_3(double z_3) {
        Z_1 = z_3;
    }

    public double getX_2() {
        return X_2;
    }

    public void setX_2(double x_2) {
        X_2 = x_2;
    }

    public double getY_2() {
        return Y_2;
    }

    public void setY_2(double y_2) {
        Y_2 = y_2;
    }

    public double getZ_2() {
        return Z_2;
    }

    public void setZ_2(double z_2) {
        Z_2 = z_2;
    }

    public Battledome getPlugin() {
        return plugin;
    }

    public DoTask getDoTask() {
        return doTask;
    }

    public boolean isDidTeamOneWin() {
        return didTeamOneWin;
    }

    public void setDidTeamOneWin(boolean didTeamOneWin) {
        this.didTeamOneWin = didTeamOneWin;
    }

    public boolean isIsobBroken() {
        return isobBroken;
    }

    public void setIsobBroken(boolean isobBroken) {
        this.isobBroken = isobBroken;
    }

    public boolean isCryBroken() {
        return isCryBroken;
    }

    public void setCryBroken(boolean cryBroken) {
        isCryBroken = cryBroken;
    }
}
