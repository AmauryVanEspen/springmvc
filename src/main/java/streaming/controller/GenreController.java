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
import streaming.entity.Genre;
import streaming.service.GenreCrudService;

/**
 *
 * @author admin
 */
@Controller
public class GenreController {

    @Autowired
    private GenreCrudService serviceGenre;

    /**
     *
     * @param genre
     * @return
     */
    @RequestMapping(value = "/ajouter_genre", method = RequestMethod.GET)
    public String ajouterGenre (Model m){
        Genre genre = new Genre();
        m.addAttribute("genreNom", genre);
        
        return "ajouter_genre.jsp";
    }
    
    @RequestMapping(value = "/ajouter_genre", method = RequestMethod.POST)
    public String ajouterGenrePOST (@ModelAttribute("nom") Genre genre){
        serviceGenre.save(genre);
        return "redirect:/liste_genres";
    }
    
    @RequestMapping(value = "/modifier_genre/{val}", method = RequestMethod.GET)
    public String modifier (@PathVariable("val") long idGenreAModifier, Model m){
        Genre genre = serviceGenre.findOne(idGenreAModifier);
        
        m.addAttribute("genreAct", genre);
        return "modifier_genre.jsp";
    }
    
    @RequestMapping(value = "/modifier_genre", method = RequestMethod.POST)
    public String modifierPOST(@ModelAttribute("genreAct") Genre genre){
        serviceGenre.save(genre);
        return "redirect:/liste_genres";
    }
            
    @RequestMapping(value = "/supprimer_genre/{val}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("val") long idGenreASupprimer){
        serviceGenre.delete(idGenreASupprimer);
        return "redirect:/liste_genres";
    }
    
    

    /**
     *
     * @return
     */
    @RequestMapping(value = {"/liste_genres"}, method = RequestMethod.GET)
    public String lister(Model m) {
        m.addAttribute("titre", "Liste des genres");
        m.addAttribute("genres", serviceGenre.findAll());

        return "genre_lister.jsp";
    }
;
}
