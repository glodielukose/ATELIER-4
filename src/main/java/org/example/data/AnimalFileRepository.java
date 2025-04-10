package org.example.data;

import org.example.Persistance.AnimalRepository;

import java.io.*;
import java.util.List;

public class AnimalFileRepository implements AnimalRepository {
    String filename;

    public AnimalFileRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(List<Animal> animaux) {
//        try(ObjectOutputStream out = new ObjectOutputStream(FileOutputStream(filename))) {
//            out.writeObject(animaux);
//            System.out.println("Animaux enregistrés avec succès dans le fichier : " + filename);
//        } catch (IOException e) {
//            System.out.println("Erreur survenue lors de l'enregistrement des animaux : " + e.getMessage());
//        }

        try {
            ObjectOutputStream out;
            FileOutputStream outFile = new FileOutputStream(filename);
            out = new ObjectOutputStream(outFile);
            out.writeObject(animaux);
            out.close();
            System.out.println("Animaux enregistrés avec succès dans le fichier : " + filename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Animal> load() {
        try{
            ObjectInputStream in;
            FileInputStream inFile = new FileInputStream(filename);
            in = new ObjectInputStream(inFile);
            List<Animal> animaux = (List<Animal>) in.readObject();
            in.close();
            return  animaux;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
