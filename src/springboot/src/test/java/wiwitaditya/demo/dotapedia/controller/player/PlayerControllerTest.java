package wiwitaditya.demo.dotapedia.controller.player;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.controller.player.model.*;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void findPlayerCountries() throws Exception {
        List<PlayerCountry> playerCountries =  PlayerCountryDummy.findPlayerCountries();
        Mockito.when(playerService.findPlayerCountries()).thenReturn(playerCountries);

        this.mockMvc.perform(get("/api/players/countries"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(1)))
            .andExpect(jsonPath("$[0].country", is(playerCountries.get(0).getCountry())))
            .andExpect(jsonPath("$[0].totalPlayer", is(playerCountries.get(0).getTotalPlayer())));
    }

    @Test
    public void findByCountries() throws Exception {
        List<PlayerByCountryResponse> list = PlayerByCountryResponseDummy.findByCountries();
        Mockito.when(playerService.findByCountries(anyString())).thenReturn(list);

        this.mockMvc.perform(get("/api/players?countries=CANADA"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", is(1)))
            .andExpect(jsonPath("$[0].nickName", is(list.get(0).getNickName())))
            .andExpect(jsonPath("$[0].id", is(list.get(0).getId())));
    }

    @Test
    public void findByCountries_badrequest() throws Exception {
        this.mockMvc.perform(get("/api/players"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void findByPlayerId() throws Exception {
        PlayerDetailResponse pdr = PlayerDetailResponseDummy.get();
        Mockito.when(playerService.findById(anyInt())).thenReturn(pdr);

        this.mockMvc.perform(get("/api/players/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(pdr.getId())))
            .andExpect(jsonPath("$.nickName", is(pdr.getNickName())))
            .andExpect(jsonPath("$.fullName", is(pdr.getFullName())))
            .andExpect(jsonPath("$.roles", is(pdr.getRoles())))
            .andExpect(jsonPath("$.dateOfBirth", is(Integer.valueOf(String.valueOf(pdr.getDateOfBirth())))))
            .andExpect(jsonPath("$.country", is(pdr.getCountry())))
            .andExpect(jsonPath("$.totalEarnings", is(pdr.getTotalEarnings())))
            .andExpect(jsonPath("$.biography", is(pdr.getBiography())));
    }

    @Test
    public void findByPlayerId_badrequest() throws Exception {
        this.mockMvc.perform(get("/api/players/@@"))
            .andExpect(status().isBadRequest());
    }
}
