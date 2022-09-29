package wiwitaditya.demo.dotapedia.controller.series;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponse;
import wiwitaditya.demo.dotapedia.controller.series.model.SeriesResponseDummy;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class SeriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeriesService seriesService;

    @Test
    public void getSeries_ok() throws Exception {
        SeriesResponse seriesResponse = SeriesResponseDummy.get();
        Mockito.when(seriesService.getSeries(anyInt())).thenReturn(seriesResponse);

        this.mockMvc.perform(get("/api/series/1"))
            .andExpect(status().isOk())

            .andExpect(jsonPath("$.seriesId", is(seriesResponse.getSeriesId())))
            .andExpect(jsonPath("$.startDate", is(Math.toIntExact(seriesResponse.getStartDate()))))
            .andExpect(jsonPath("$.format", is(seriesResponse.getFormat().toString())))
            .andExpect(jsonPath("$.games.length()", is(seriesResponse.getGames().size())))

                .andExpect(jsonPath("$.games[0].gameId", is(seriesResponse.getGames().get(0).getGameId())))
                .andExpect(jsonPath("$.games[0].winner", is(seriesResponse.getGames().get(0).getWinner().toString())))
                .andExpect(jsonPath("$.games[0].startDate", is(Math.toIntExact(seriesResponse.getGames().get(0).getStartDate()))))

                .andExpect(jsonPath("$.games[0].radiantTeamId", is(seriesResponse.getGames().get(0).getRadiantTeamId())))
                .andExpect(jsonPath("$.games[0].radiantTeamName", is(seriesResponse.getGames().get(0).getRadiantTeamName())))
                .andExpect(jsonPath("$.games[0].radiantScore", is(seriesResponse.getGames().get(0).getRadiantScore())))
                .andExpect(jsonPath("$.games[0].radiantPlayers.length()", is(seriesResponse.getGames().get(0).getRadiantPlayers().size())))

                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].playerGameId", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getPlayerGameId())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].playerId", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getPlayerId())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].playerNickname", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getPlayerNickname())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].roleId", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getRoleId())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].roleName", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getRoleName())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].heroId", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getHeroId())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].heroName", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getHeroName())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].heroImageName", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getHeroImageName())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].heroLevel", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getHeroLevel())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].kdaKill", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getKdaKill())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].kdaDeath", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getKdaDeath())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].kdaAssist", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getKdaAssist())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].networth", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getNetworth())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].gpm", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getGpm())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].xpm", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getXpm())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].damageToHero", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getDamageToHero())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].damageToBuilding", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getDamageToBuilding())))
                    .andExpect(jsonPath("$.games[0].radiantPlayers[0].healing", is(seriesResponse.getGames().get(0).getRadiantPlayers().get(0).getHealing())))

                .andExpect(jsonPath("$.games[0].direTeamId", is(seriesResponse.getGames().get(0).getDireTeamId())))
                .andExpect(jsonPath("$.games[0].direTeamName", is(seriesResponse.getGames().get(0).getDireTeamName())))
                .andExpect(jsonPath("$.games[0].direScore", is(seriesResponse.getGames().get(0).getDireScore())))
                .andExpect(jsonPath("$.games[0].direPlayers.length()", is(seriesResponse.getGames().get(0).getDirePlayers().size())))

                    .andExpect(jsonPath("$.games[0].direPlayers[0].playerGameId", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getPlayerGameId())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].playerId", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getPlayerId())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].playerNickname", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getPlayerNickname())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].roleId", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getRoleId())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].roleName", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getRoleName())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].heroId", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getHeroId())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].heroName", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getHeroName())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].heroImageName", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getHeroImageName())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].heroLevel", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getHeroLevel())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].kdaKill", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getKdaKill())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].kdaDeath", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getKdaDeath())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].kdaAssist", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getKdaAssist())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].networth", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getNetworth())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].gpm", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getGpm())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].xpm", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getXpm())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].damageToHero", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getDamageToHero())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].damageToBuilding", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getDamageToBuilding())))
                    .andExpect(jsonPath("$.games[0].direPlayers[0].healing", is(seriesResponse.getGames().get(0).getDirePlayers().get(0).getHealing())))

            .andExpect(jsonPath("$.teamAScore", is(seriesResponse.getTeamAScore())))
            .andExpect(jsonPath("$.teamBScore", is(seriesResponse.getTeamBScore())))

            .andExpect(jsonPath("$.teamAId", is(seriesResponse.getTeamAId())))
            .andExpect(jsonPath("$.teamBId", is(seriesResponse.getTeamBId())))

            .andExpect(jsonPath("$.teamAName", is(seriesResponse.getTeamAName())))
            .andExpect(jsonPath("$.teamBName", is(seriesResponse.getTeamBName())))
        ;
    }

    @Test
    public void getSeries_badrequest() throws Exception {
        this.mockMvc.perform(get("/api/series/a"))
                .andExpect(status().isBadRequest());
    }
}
