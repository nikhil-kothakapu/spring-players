package com.example.player;
import java.util.*;

public interface PlayerRepository{
    ArrayList<Player> getPlayers();
    Player addPlayer(Player candit);
    Player getPlayerById(int playerId);
    Player updatePlayer(int playerId,Player played);
    void deletePlayer(int playerId);
}

