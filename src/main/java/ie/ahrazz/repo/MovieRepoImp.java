package ie.ahrazz.repo;

import ie.ahrazz.entity.Movies;
import ie.ahrazz.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepoImp implements MovieRepo{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Result> findAll() {

        String sql = "select * from movies";
        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new ResultRowMapper());

    }

    @Override
    public boolean exists(int movie_Id) {
        String sql = "select count(*) from Movies where movie_id = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId",movie_Id);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql,sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    @Override
    public boolean exist(int movie_id) {
        return false;
    }

    @Override
    public int delete(int movie_id){
        String sql = "delete movie where movie_id = : movie_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movie_id",movie_id);
        return namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

    @Override
    public int moveDirector(int movie_id,int newdirector_id){
        String sql ="update movies set director_id = :newDirector_id where movie_id = :movie_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("director_id",newdirector_id).addValue("movie_id",movie_id);
        return namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

    @Override
    public List<Movies> findMoviesInDirector(int director_id){
        String sql = "select * from movie where director_id = :director_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("director_id",director_id);
        return namedParameterJdbcTemplate.query(sql,sqlParameterSource,new MovieRowMapper());
    }


}
