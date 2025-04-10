package org.example.data;

public class Pigeon extends Animal {
    private String couleurPlumes;

    public Pigeon(String nom, String pelage, int age, String couleurPlumes) {
        super("Pigeon", nom, pelage, age); // Set the type as "Pigeon"
        this.couleurPlumes = couleurPlumes;
    }

    public String getCouleurPlumes() {
        return couleurPlumes;
    }

    public void setCouleurPlumes(String couleurPlumes) {
        this.couleurPlumes = couleurPlumes;
    }

    @Override
    public String toString() {
        return super.toString() + ", couleurPlumes='" + couleurPlumes + '\'';
    }
}