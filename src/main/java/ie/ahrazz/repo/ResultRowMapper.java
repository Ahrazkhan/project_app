package ie.ahrazz.repo;

import ie.ahrazz.entity.Movies;
import ie.ahrazz.entity.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRowMapper implements RowMapper<Result> {

    @Override
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Result(rs.getString("directorName"), rs.getString("movieName"));
    }
}
