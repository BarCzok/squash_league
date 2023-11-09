package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.model.Player;
import com.praktyki.squash.repository.PlayersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
@RunWith(MockitoJUnitRunner.class)
public class PlayerFacadeTest {


        @Mock
        PlayersRepository mockPlayersRepository;

        @InjectMocks
        PlayerFacade playerFacade = new PlayerFacade();

        @Test
        public void testGetPlayer() {
            // given

            int playerId = 0;
            String playerName = "Wojtek";
            String playerAdress = "adres";
            int playerPhoneNumber = 2233;
            Player player = new Player();
            player.setId(playerId);
            player.setAdress(playerAdress);
            player.setName(playerName);
            player.setPhoneNumber(playerPhoneNumber);

            Mockito.when(mockPlayersRepository.findById(anyInt())).thenReturn(java.util.Optional.of(player));

            // when
            PlayerDTO playerDTO = playerFacade.getPlayer(playerId);

            // then
            assertEquals(playerId, playerDTO.getId());
            assertEquals(playerName, playerDTO.getName());
            assertEquals(playerAdress, playerDTO.getAdress());
            assertEquals(playerPhoneNumber, playerDTO.getPhoneNumber());


        }
    }

