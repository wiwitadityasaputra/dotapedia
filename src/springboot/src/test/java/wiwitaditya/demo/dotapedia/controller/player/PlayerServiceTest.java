package wiwitaditya.demo.dotapedia.controller.player;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wiwitaditya.demo.dotapedia.controller.player.model.*;
import wiwitaditya.demo.dotapedia.db.entity.Player;
import wiwitaditya.demo.dotapedia.db.entity.PlayerDummy;
import wiwitaditya.demo.dotapedia.db.entity.PlayerScreenshot;
import wiwitaditya.demo.dotapedia.db.entity.PlayerScreenshotDummy;
import wiwitaditya.demo.dotapedia.db.repository.PlayerQuoteRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;
import wiwitaditya.demo.dotapedia.db.repository.PlayerScreenshotRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private PlayerScreenshotRepository screenshotRepository;
    @Mock
    private PlayerQuoteRepository playerQuoteRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void findPlayerCountries() {
        List<PlayerCountry> list = PlayerCountryDummy.findPlayerCountries();
        Mockito.when(playerRepository.findPlayerCountries()).thenReturn(list);

        List<PlayerCountry> result = playerService.findPlayerCountries();

        assertNotNull(result);
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getCountry(), list.get(0).getCountry());
        assertEquals(result.get(0).getTotalPlayer(), list.get(0).getTotalPlayer());
    }

    @Test
    public void findByCountries_countries_null() {
        List<PlayerByCountryResponse> list = PlayerByCountryResponseDummy.findByCountries();
        Mockito.when(playerRepository.findByCountries()).thenReturn(list);

        List<PlayerByCountryResponse> result = playerService.findByCountries(null);

        assertNotNull(result);
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getId(), list.get(0).getId());
        assertEquals(result.get(0).getNickName(), list.get(0).getNickName());
    }

    @Test
    public void findByCountries_countries_notnull() {
        List<PlayerByCountryResponse> list = PlayerByCountryResponseDummy.findByCountries();
        Mockito.when(playerRepository.findByCountries(any())).thenReturn(list);

        List<PlayerByCountryResponse> result = playerService.findByCountries("CANADA");

        assertNotNull(result);
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getId(), list.get(0).getId());
        assertEquals(result.get(0).getNickName(), list.get(0).getNickName());
    }

    @Test
    public void findById() {
        Player player = PlayerDummy.findById();
        List<PlayerScreenshot> playerScreenshots = PlayerScreenshotDummy.findScreenshots();
        List<PlayerQuoteResponse> playerQuoteResponses = PlayerQuoteResponseDummy.findPlayerId();

        Mockito.when(playerRepository.findById(anyInt())).thenReturn(Optional.of(player));
        Mockito.when(screenshotRepository.findScreenshots(anyInt())).thenReturn(playerScreenshots);
        Mockito.when(playerQuoteRepository.findPlayerId(anyInt())).thenReturn(playerQuoteResponses);

        PlayerDetailResponse result = playerService.findById(1);
        assertNotNull(result);
        assertEquals(player.getId(), result.getId());
        assertEquals(player.getNickName(), result.getNickName());
        assertEquals(player.getFullName(), result.getFullName());
        assertEquals(player.getRoles(), result.getRoles());
        assertEquals(player.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(player.getCountry(), result.getCountry());
        assertEquals(player.getTotalEarnings(), result.getTotalEarnings());
        assertEquals(player.getBiography(), result.getBiography());
        assertEquals(player.getId(), result.getId());

        assertEquals(1, result.getPlayerScreenshots().size());
        assertEquals(playerScreenshots.get(0).getId(), result.getPlayerScreenshots().get(0).getId());
        assertEquals(playerScreenshots.get(0).getImageName(), result.getPlayerScreenshots().get(0).getImageName());

        assertEquals(1, result.getQuotes().size());
        assertEquals(playerQuoteResponses.get(0).getAuthor(), result.getQuotes().get(0).getAuthor());
        assertEquals(playerQuoteResponses.get(0).getContent(), result.getQuotes().get(0).getContent());
        assertEquals(playerQuoteResponses.get(0).getCreatedDate(), result.getQuotes().get(0).getCreatedDate());
    }

    @Test
    public void findById_unknownid() {
        Mockito.when(playerRepository.findById(anyInt())).thenReturn(Optional.empty());
        PlayerDetailResponse result = playerService.findById(1);

        assertNotNull(result);
        assertNull(result.getId());
        assertNull(result.getNickName());
        assertNull(result.getFullName());
        assertNull(result.getRoles());
        assertEquals(0l, result.getDateOfBirth());
        assertNull(result.getCountry());
        assertNull(result.getTotalEarnings());
        assertNull(result.getBiography());
        assertNull(result.getPlayerScreenshots());
        assertNull(result.getQuotes());
    }
}
