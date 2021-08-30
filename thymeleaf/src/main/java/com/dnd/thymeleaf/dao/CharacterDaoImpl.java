package com.dnd.thymeleaf.dao;
import com.dnd.thymeleaf.controller.ApiController;
import com.dnd.thymeleaf.model.Character;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImpl implements CharacterDao {
    public static List<Character> characters = new ArrayList<>();


    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {
        Character c = characters.stream()
                .filter(character -> character.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No data !"));
        return c;
    }

    @Override
    public Character save(Character character) {
        characters.add(character);
        return character;
    }
}
