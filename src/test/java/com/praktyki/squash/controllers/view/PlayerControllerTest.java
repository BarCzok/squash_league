package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.PlayerForm;
import com.praktyki.squash.model.Player;
import com.praktyki.squash.repository.PlayersRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {

    @Mock
    PlayersRepository mockPlayersRepository;
    @InjectMocks
    PlayerController playerController = new PlayerController();

    @Test
    public void ensureThatPlayerDetailsAreRight(){

        //given
        final Player[] createdPlayers = {null};
        Mockito.when(mockPlayersRepository.save(Mockito.any(Player.class))).thenAnswer(i ->
        {
            createdPlayers[0] = (Player) i.getArguments()[0];
             return  i.getArguments()[0];
        });

        PlayerForm playerForm = new PlayerForm();
        playerForm.setName("Wojtek");
        playerForm.setPhoneNumber(123123123);

        //when
        playerController.addPlayer(playerForm, new ModelMap());

        //then
        Player createdPlayer = createdPlayers[0];

        assertEquals(playerForm.getName(), createdPlayer.getName());
        assertEquals(playerForm.getAdress(), createdPlayer.getAdress());
        assertEquals(playerForm.getPhoneNumber(), createdPlayer.getPhoneNumber());
    }

}