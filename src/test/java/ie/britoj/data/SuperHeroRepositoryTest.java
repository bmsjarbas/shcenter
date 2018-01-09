package ie.britoj.data;


import ie.britoj.shcenter.Application;
import ie.britoj.shcenter.data.SuperHeroRepository;
import ie.britoj.shcenter.models.SuperHero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@DataJpaTest
public class SuperHeroRepositoryTest {
    @Autowired
    SuperHeroRepository superHeroRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void createSuperHeroTest(){
        List<String> skills = new ArrayList<>();
        List<String> allies = new ArrayList<>();

        skills.add("money");
        SuperHero superHero = new SuperHero(
                "batman", "bat",
                "DC", skills,
                allies, LocalDate.now());

        entityManager.persist(superHero);
        SuperHero savedSuperHero =  superHeroRepository.findOne(superHero.getId());
        assertThat(savedSuperHero.getId()).isEqualTo(1);
        assertThat(savedSuperHero.getName()).isEqualTo("batman");
    }
}
