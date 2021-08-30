package com.dnd.characters.controller;
import com.dnd.characters.dao.CharacterDao;
import com.dnd.characters.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;

    @GetMapping(value="Personnages")
    public List<Character>listePersonnages() {
        return characterDao.findAll();
    }

    @GetMapping(value = "/Personnages/{id}")
    public Optional<Character> afficherUnPersonnage(@PathVariable Integer id) {
        return characterDao.findById(id);
    }

    @PostMapping(value = "Personnages")
    public Character ajouterPersonnage(@RequestBody Character character) {
        return characterDao.save(character);
    }

   // @PutMapping(value = "/Personnages/{id}")
   // public ResponseEntity<Character> modiferUnPersonnage(@PathVariable int id, @RequestBody Character character) {
   //     characterDao.update(character);
   //     return null;
   // }

    @DeleteMapping(value = "/Personnages/{id}")
    public void supprimerUnCharacter(@PathVariable Integer id) {
        characterDao.deleteById(id);
    }


}
