package ie.ahrazz.services;

import ie.ahrazz.entity.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {

    int count();

    List<Director> findAll();

    Optional<Director> findADirector(int id);

    Boolean deleteDirector(int id);
    Boolean addDirector(Director newDirector);

    boolean changeName(int id , String newName);
}
