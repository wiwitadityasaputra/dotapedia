package wiwitaditya.demo.dotapedia.controller.hero;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wiwitaditya.demo.dotapedia.db.utility.HeroType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class HeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroService heroService;

    @Test
    public void getAllHeroes_heroType_null() throws Exception {
        log.info("test getAllHeroes_heroType_null");

        Mockito.when(heroService.getAllHeroes(nullable(String.class))).thenReturn(getHeroResponses());
        HeroResponse heroResponse = getHeroResponse();

        this.mockMvc.perform(get("/api/heroes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(heroResponse.getId())))
            .andExpect(jsonPath("$[0].heroType", is(HeroType.INTELLIGENCE.toString())))
            .andExpect(jsonPath("$[0].imageName", is(heroResponse.getImageName())))
            .andExpect(jsonPath("$[0].name", is(heroResponse.getName())));
    }

    @Test
    public void getAllHeroes_heroType_valid() throws Exception {
        Mockito.when(heroService.getAllHeroes(anyString())).thenReturn(getHeroResponses());
        HeroResponse heroResponse = getHeroResponse();

        this.mockMvc.perform(get("/api/heroes?heroType=INTELLIGENCE"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(heroResponse.getId())))
            .andExpect(jsonPath("$[0].heroType", is(HeroType.INTELLIGENCE.toString())))
            .andExpect(jsonPath("$[0].imageName", is(heroResponse.getImageName())))
            .andExpect(jsonPath("$[0].name", is(heroResponse.getName())));
    }

    @Test
    public void getAllHeroes_heroType_invalid() throws Exception {
        Mockito.when(heroService.getAllHeroes(anyString())).thenReturn(getHeroResponses());
        HeroResponse heroResponse = getHeroResponse();

        this.mockMvc.perform(get("/api/heroes?heroType=invalid-value"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(heroResponse.getId())))
            .andExpect(jsonPath("$[0].heroType", is(HeroType.INTELLIGENCE.toString())))
            .andExpect(jsonPath("$[0].imageName", is(heroResponse.getImageName())))
            .andExpect(jsonPath("$[0].name", is(heroResponse.getName())));
    }

    private List<HeroResponse> getHeroResponses() {
        List<HeroResponse> heroes = new ArrayList();
        heroes.add(getHeroResponse());
        return heroes;
    }

    private HeroResponse getHeroResponse() {
        HeroResponse hr = new HeroResponse();
        hr.setId(3);
        hr.setHeroType(HeroType.INTELLIGENCE);
        hr.setImageName("image-name");
        hr.setName("name");
        return hr;
    }
}
