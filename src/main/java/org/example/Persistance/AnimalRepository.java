package org.example.Persistance;

import org.example.data.Animal;

import java.util.List;

public interface AnimalRepository {
    public void save(List<Animal> animaux) ;
    public List<Animal> load() ;
}
