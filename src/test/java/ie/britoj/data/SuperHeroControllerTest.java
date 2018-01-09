package ie.britoj.data;

import ie.britoj.shcenter.Application;
import ie.britoj.shcenter.data.SuperHeroRepository;
import ie.britoj.shcenter.models.SuperHero;
import ie.britoj.shcenter.web.controllers.SuperHeroController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SuperHeroController.class, secure = false)
@ContextConfiguration(classes = Application.class)
public class SuperHeroControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SuperHeroRepository superHeroRepository;

    @Test
    public void returnAllSuperHeroes() throws Exception {
        List<String> skills = new ArrayList<>();
        List<String> allies = new ArrayList<>();
        SuperHero superHero = new SuperHero(
                "batman", "bat",
                "DC", skills,
                allies, LocalDate.now());
        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(superHero);

        given(superHeroRepository.findAll()).willReturn(superHeroes);

        mvc.perform(get("/superhero")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(superHero.getName())));
    }


}
