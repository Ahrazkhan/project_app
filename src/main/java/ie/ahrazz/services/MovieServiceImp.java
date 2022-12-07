package ie.ahrazz.services;

import ie.ahrazz.entity.Movies;
import ie.ahrazz.entity.Result;
import ie.ahrazz.repo.DirectorRepo;
import ie.ahrazz.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MovieServiceImp implements MovieServices {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private DirectorRepo directorRepo;


    @Override
    public boolean moveDirector(int movie_id, int newdirector_id) {
        if (! movieRepo.exist(movie_id) || !directorRepo.exists(newdirector_id))
            return false;
        return movieRepo.moveDirector(movie_id,newdirector_id) == 1;
    }

    @Override
    public List<Result> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movies> findMoviesInDirector(int director_id) {
        if(directorRepo.exists(director_id)) {
            List<Movies> movies =movieRepo.findMoviesInDirector(director_id);
            Movies Movies = null;
            return movies.isEmpty()? Optional.empty(): Optional.of(Movies);
        }
        return Optional.empty();

    }

    @Override
    public boolean delete(int movie_id) {
        if(movieRepo.exists(movie_id))
            return movieRepo.delete(movie_id) == 1;
        return  false;
    }
}
