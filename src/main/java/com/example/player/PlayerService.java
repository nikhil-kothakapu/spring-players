package com.example.player;

 
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.player.Player;
import com.example.player.PlayerRepository;
import java.util.*;

// Don't modify the below code

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();
    int uniquePlayerId = 12;

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    // Don't modify the above code

    @Override
    public ArrayList<Player> getPlayers(){
        Collection<Player> playerColl=team.values();
        ArrayList<Player> players= new ArrayList<>(playerColl);
        return players;
    }

    @Override
    public Player addPlayer(Player candit ){
        candit.setplayerId(uniquePlayerId);
        team.put(uniquePlayerId,candit);
        uniquePlayerId+=1;

        return candit;
    }

    @Override
    public Player getPlayerById(int playerId){
        Player played=team.get(playerId);
        if(played== null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return played;
    }


    @Override
    public Player updatePlayer(int playerId,Player played){
        Player existing=team.get(playerId);

        if(existing == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(played.getplayerName() != null){
            existing.setplayerName(played.getplayerName());
        }


		if(played.getjerseyNumber() != 0){
            existing.setjerseyNumber(played.getjerseyNumber());
        }

        if(played.getrole() != null){
            existing.setrole(played.getrole());
        }

        return existing;
    }

    @Override
    public void deletePlayer(int playerId){
        Player p = team.get(playerId);
        if(p == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }


    }

}
