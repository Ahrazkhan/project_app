package ie.ahrazz.repo;

import ie.ahrazz.entity.Movies;
import ie.ahrazz.entity.Result;

import java.util.List;

public interface MovieRepo {
    boolean exist(int movie_id);

    int delete(int movie_id);

    int moveDirector(int movie_id,int newdirector_id);

    List<Movies> findMoviesInDirector(int director_id);

    List<Result> findAll();

    boolean exists(int movie_Id);

}
