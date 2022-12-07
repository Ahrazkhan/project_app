package ie.ahrazz.services;


import ie.ahrazz.entity.Director;
import ie.ahrazz.repo.DirectorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class DirectorServiceImp implements DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    @Override
    public int count(){
        return directorRepo.count();
    }

    @Override
    public List<Director> findAll(){
        return directorRepo.getAll();
    }

    @Override
    public Optional<Director> findADirector(int id){
        if (directorRepo.exists(id)) {
            return Optional.of(directorRepo.findById(id));
        }
        log.warn("Tried to find a id that doesnt exist");
        return Optional.empty();
    }

    @Override
    public  Boolean deleteDirector(int id){
        if(directorRepo.exists(id)){
            return directorRepo.deleteDirector(id)==1;
        }
        log.error("Could not delete Director with id " + id + " becuase it doesnt exist");
        return false;
    }
//added service for add a director
    @Override
    public  Boolean addDirector(Director newDirector){
        if(directorRepo.existsByname(newDirector.getFirstName())){
            log.error("Could not add Director because a Director called " + newDirector.getFirstName() + " already exist.");
            return  false;
        }
        if(directorRepo.exists(newDirector.getDirector_id())){
            log.error("Could not add Director because a Director with id " + newDirector.getDirector_id() + " already exist.");
            return false;
        }
        return directorRepo.createDirector(newDirector) == 1;
    }

    @Override
    public boolean changeName(int id , String newName){
        if(directorRepo.existsByname(newName) ){
            log.error("Could not edit director name becuase a diretor called "+ newName + "already exist.");
            return false;
        }
        if(directorRepo.existsByname(newName) || !directorRepo.exists(id))
            return false;

        return directorRepo.changeName(id, newName) == 1;


    }
}
