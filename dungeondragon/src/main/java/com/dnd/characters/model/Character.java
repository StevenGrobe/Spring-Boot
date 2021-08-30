package com.dnd.characters.model;

import javax.persistence.*;

@Entity
@Table(name="characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom", length = 255, nullable = false)
    private String nom;
    @Column(name = "job", length = 255, nullable = false)
    private String job;
    @Column(name = "hp", length = 20, nullable = false)
    private int hp;

    public Character() {
    }

    public Character(Integer id, String nom, String job, int hp) {
        this.id = id;
        this.nom = nom;
        this.job = job;
        this.hp = hp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getJob() {
        return job;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", job='" + job + '\'' +
                ", hp=" + hp +
                '}';
    }
}
