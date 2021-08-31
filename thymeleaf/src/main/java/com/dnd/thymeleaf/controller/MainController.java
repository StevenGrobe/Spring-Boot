package com.dnd.thymeleaf.controller;

import com.dnd.thymeleaf.form.CharacterForm;
import com.dnd.thymeleaf.model.Character;
import com.dnd.thymeleaf.dao.CharacterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private CharacterDao characterDao;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/characterList" }, method = RequestMethod.GET)
    public String characterList(Model model) {
        String api = "http://localhost:8081/Personnages";
        List<Character> c = restTemplate.getForObject(api,List.class);
        model.addAttribute("characters", c);
        return "characterList";
    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.GET)
    public String showAddCharacterPage(Model model) {
        CharacterForm characterForm = new CharacterForm();
        model.addAttribute("characterForm", characterForm);
        return "addCharacter";
    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.POST)
    public String saveCharacter(Model model, @ModelAttribute("characterForm") CharacterForm characterForm) {
        String api = "http://localhost:8081/Personnages/";
        restTemplate.postForObject(api, characterForm, CharacterForm.class);
        Character newCharacter = new Character(characterForm.getId(), characterForm.getNom(), characterForm.getJob(), characterForm.getHp());
        characterDao.save(newCharacter);
        return "redirect:/characterList";

    }

    @RequestMapping(value = {"/characterDetails/{id}"}, method = RequestMethod.GET)
    public String afficherUnPersonnage(Model model, @PathVariable int id) {
        String api = "http://localhost:8081/Personnages/";
        Character c = restTemplate.getForObject(api + id,Character.class);
        model.addAttribute("Character", c);
        return "characterDetails";
    }

    @DeleteMapping(value = {"/characterDetails/{id}"})
    public String delete(@PathVariable int id) {
        String api = "http://localhost:8081/Personnages/";
        restTemplate.delete(api+id);
        return "redirect:/characterList";
    }
    @PutMapping(value = {"/characterDetails/{id}"})
    public String modifierPersonnage(@PathVariable int id, Character character) {
        characterDao.save(character);
        return "characterDetails";
    }
}