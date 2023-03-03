package com.example.player;
import com.example.player.PlayerService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;



import java.util.*;
@RestController
public class PlayerController {   

    PlayerService ps = new PlayerService();
    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        return ps.getPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player candit){
        return ps.addPlayer(candit);
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return ps.getPlayerById(playerId);
    }
    
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId")int playerId,@RequestBody Player played){
        return ps.updatePlayer(playerId, played);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        ps.deletePlayer(playerId);
    }
    
}



