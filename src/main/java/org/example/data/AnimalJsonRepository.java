package org.example.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import org.example.Persistance.AnimalRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AnimalJsonRepository implements AnimalRepository {
    private final String filePath;

    public AnimalJsonRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(List<Animal> animaux) {
        RuntimeTypeAdapterFactory<Animal> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Animal.class, "type")
                .registerSubtype(Pigeon.class, "Pigeon");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeAdapterFactory)
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(animaux, writer);
            System.out.println("Animaux enregistrés en JSON avec succès dans: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Animal> load() {
        RuntimeTypeAdapterFactory<Animal> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Animal.class, "type")
                .registerSubtype(Pigeon.class, "Pigeon");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeAdapterFactory)
                .create();

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}