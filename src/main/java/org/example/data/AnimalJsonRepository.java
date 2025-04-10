package org.example.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Persistance.AnimalRepository;

import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class AnimalJsonRepository implements AnimalRepository {
    private final String filename;
    private final Gson gson;

    public AnimalJsonRepository(String filename) {
        this.filename = filename;
        this.gson = new GsonBuilder()
                .setPrettyPrinting() // Pour un JSON bien formaté
                .create();
    }

    @Override
    public void save(List<Animal> animaux) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(animaux, writer);
            System.out.println("Animaux enregistrés en JSON avec succès dans: " + filename);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement JSON", e);
        }
    }

    @Override
    public List<Animal> load() {
        try (FileReader reader = new FileReader(filename)) {
            Type animalListType = new TypeToken<List<Animal>>(){}.getType();
            return gson.fromJson(reader, animalListType);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement JSON", e);
        }
    }
}