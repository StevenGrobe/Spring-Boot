package com.dnd.characters.dao;
import com.dnd.characters.model.Character;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterDao extends JpaRepository <Character, Integer> {
    public List<Character>findAll();
    public Optional <Character> findById(Integer id);
    public Character save(Character character);
    // public Character update(Character character);
    public void deleteById(Integer id);
}
