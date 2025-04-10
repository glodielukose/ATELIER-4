package org.example.data;

public class Pigeon extends Animal{
    private String couleur;
    private String espece;

    public Pigeon(String nom, String pelage, int age, String couleur) {
        super(nom, pelage, age);
        this.couleur = couleur;
        this.espece = espece;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    @Override
    public String toString() {
        return "Pigeon{" +
                "couleur='" + couleur + '\'' +
                ", espece='" + espece + '\'' +
                ", nom='" + nom + '\'' +
                ", pelage='" + pelage + '\'' +
                ", age=" + age +
                '}';
    }
}
