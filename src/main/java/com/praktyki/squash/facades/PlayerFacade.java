package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.model.Player;
import com.praktyki.squash.repository.PlayersRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerFacade {

    @Resource
    private PlayersRepository playersRepository;

    public PlayerDTO getPlayer(int playerId){

        return convertPlayer(playersRepository.findById(playerId).get());
    }

    public List<PlayerDTO> getPlayers(){
        Iterable<Player> players = playersRepository.findAll();

        return convertPlayers(players);
    }

    public List<PlayerDTO> convertPlayers(Iterable<Player> players) {
        List<PlayerDTO> playerDtos = new ArrayList<>();

        players.forEach(player -> playerDtos.add(convertPlayer(player)));

        return playerDtos;
    }

    public PlayerDTO convertPlayer(Player player) {
        PlayerDTO playerDto = new PlayerDTO();

        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setPhoneNumber(player.getPhoneNumber());
        playerDto.setAdress(player.getAdress());

        return playerDto;
    }


}