package ie.britoj.shcenter.web.controllers;

import ie.britoj.shcenter.data.SuperHeroRepository;
import ie.britoj.shcenter.models.SuperHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/superhero")
public class SuperHeroController {

    @Autowired
    SuperHeroRepository superHeroRepository;

    @PostMapping
    public SuperHero create(@RequestBody SuperHero superHero){
        superHeroRepository.save(superHero);
        return superHero;
    }

    @GetMapping(value = "/{id}")
    public SuperHero find(@PathVariable long id){
        return superHeroRepository.findOne(id);
    }


    @GetMapping
    public Iterable<SuperHero> list(){
        return superHeroRepository.findAll();
    }
}
