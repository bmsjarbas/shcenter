package ie.britoj.shcenter.data;

import ie.britoj.shcenter.models.SuperHero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface SuperHeroRepository extends CrudRepository<SuperHero, Long> {}