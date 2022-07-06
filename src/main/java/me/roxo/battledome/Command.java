package me.roxo.battledome;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

        private Manager manager;
    public Command(Manager manager) {

    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }

        if(args.length == 0){
            sender.sendMessage("You did not input the command right");
        }
        manager.setX_1(Double.parseDouble( args[0]));
        manager.setY_1(Double.parseDouble( args[1]));
        manager.setZ_3(Double.parseDouble( args[2]));

        manager.setX_2(Double.parseDouble( args[3]));
        manager.setX_2(Double.parseDouble( args[4]));
        manager.setX_2(Double.parseDouble( args[5]));

        manager.setState(State.START);



        return false;
    }
}
