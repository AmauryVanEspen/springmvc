/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Film;
import streaming.service.FilmCrudService;
import streaming.service.GenreCrudService;

/**
 *
 * @author tom
 */
@Controller
//@RequestMapping("/film")
public class FilmController {
    
    @Autowired
    private FilmCrudService serviceFilm;
    @Autowired
    private GenreCrudService serviceGenre;
    
//    @RequestMapping(value="find/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Film findById( @PathVariable("id") long id){
//        
//        Film f = new Film(1L, "Karate Kid", "blabla", 1989L, null);
//        
//        return f;
//    }
    
    @RequestMapping(value = "/ajouter_film", method = RequestMethod.GET)
    public String ajouterFilm (Model m){
        m.addAttribute("filmTitre", new Film());
        m.addAttribute("genres", serviceGenre.findAll());
        
        return "ajouter_film.jsp";
    }
    
    @RequestMapping(value = "/ajouter_film", method = RequestMethod.POST)
    public String ajouterFilmPOST (@ModelAttribute("titre") Film film){
        serviceFilm.save(film);
        return "redirect:/liste_films";
    }
    
    @RequestMapping(value = "/modifier_film/{val}", method = RequestMethod.GET)
    public String modifier (@PathVariable("val") long idFilmAModifier, Model m){
        Film film = serviceFilm.findOne(idFilmAModifier);
        m.addAttribute("genres", serviceGenre.findAll());
        
        m.addAttribute("filmAct", film);
        return "modifier_film.jsp";
    }
    
    @RequestMapping(value = "/modifier_film", method = RequestMethod.POST)
    public String modifierPOST(@ModelAttribute("filmAct") Film film){
        serviceFilm.save(film);
        return "redirect:/liste_films";
    }
    
    @RequestMapping(value = "/supprimer_film/{val}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("val") long idFilmASupprimer){
        serviceFilm.delete(idFilmASupprimer);
        return "redirect:/liste_films";
    }
    
        @RequestMapping(value = {"/liste_films"}, method = RequestMethod.GET)
    public String lister(Model m) {
        m.addAttribute("titre", "Liste des films");
        m.addAttribute("films", serviceFilm.findAll());
        m.addAttribute("genre", serviceGenre.findAll());
        return "film_lister.jsp";
    }
    
}
