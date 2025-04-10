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
        Animal pigeon1 = new Pigeon("rilo", "blanc", 2, "blanc");
        Animal pigeon2 = new Pigeon("rudy", "raye", 2, "blanc");
        animaux.add(pigeon2);
        animaux.add(pigeon1);

        // Sérialisation en JSON
        repository.save(animaux);

        // Désérialisation pour vérification
        List<Animal> animauxCharges = repository.load();
        System.out.println("Animaux chargés depuis JSON:");
        animauxCharges.forEach(System.out::println);
    }
}