package org.example.data;

import java.io.Serializable;

public class Animal implements Serializable {
    private String type; // Add this field
    private String nom;
    private String pelage;
    private int age;

    public Animal(String type, String nom, String pelage, int age) {
        this.type = type;
        this.nom = nom;
        this.pelage = pelage;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", pelage='" + pelage + '\'' +
                ", age=" + age +
                '}';
    }
}