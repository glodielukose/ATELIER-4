package org.example ;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Persistance.AnimalRepository;
import org.example.data.Animal;
import org.example.data.AnimalJsonRepository;
import org.example.data.Pigeon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Utilisation du repository JSON au lieu du fichier binaire
        AnimalRepository repository = new AnimalJsonRepository("animaux.json");

        List<Animal> animaux = new ArrayList<>();
        Animal animal_1 = new Pigeon("Glodie Lukose", "Blanc", 25, "Pigeon");
        Animal animal_2 = new Pigeon("Glodie Lukose", "Blanc", 25, "Pigeon");
        animaux.add(animal_2);
        animaux.add(animal_1);

        // Sérialisation en JSON
        repository.save(animaux);

        // Désérialisation pour vérification
        List<Animal> animauxCharges = repository.load();
        System.out.println("Animaux chargés depuis JSON:");
        animauxCharges.forEach(System.out::println);
    }
}