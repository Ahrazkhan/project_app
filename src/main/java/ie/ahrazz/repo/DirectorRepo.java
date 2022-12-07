package ie.ahrazz.repo;


import ie.ahrazz.entity.Director;

import java.util.List;

public interface DirectorRepo {

    int count();
    List<Director> getAll();
    Director findById(int id);

    Boolean exists(int id);

    int deleteDirector(int id);


    Boolean existsByname(String name);

    int createDirector(Director newDirector);


    int changeName(int id, String newName);
}
