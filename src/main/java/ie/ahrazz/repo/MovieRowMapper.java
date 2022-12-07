package ie.ahrazz.repo;

import ie.ahrazz.entity.Director;
import ie.ahrazz.entity.Movies;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movies> {

    @Override
    public Movies mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movies movies = new Movies();
        movies.setMovie_Id(rs.getInt("movie_id"));
        movies.setTitle(rs.getString("title"));
        movies.setYearReleased(rs.getInt("yearReleased"));
        movies.setTaking(rs.getFloat("taking"));
        movies.setDirector_id(rs.getInt("director_id"));
        return movies;

    }
}
