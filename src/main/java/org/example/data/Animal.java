package org.example.data;

import java.io.Serializable;

public class Animal implements Serializable {
    String nom;
    String pelage;
    int age;


    public Animal(String nom, String pelage, int age) {
        this.nom = nom;
        this.pelage = pelage;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPelage() {
        return pelage;
    }

    public void setPelage(String pelage) {
        this.pelage = pelage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", pelage='" + pelage + '\'' +
                ", age=" + age +
                '}';
    }
}
