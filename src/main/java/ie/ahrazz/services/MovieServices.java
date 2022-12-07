package ie.ahrazz.services;

import ie.ahrazz.entity.Movies;
import ie.ahrazz.entity.Result;

import java.util.List;
import java.util.Optional;

public interface MovieServices {

    boolean moveDirector(int movie_id,int newdirector_id);

     List<Result> findAll();

     Optional<Movies> findMoviesInDirector(int director_id);

     boolean delete(int movie_id);
}
