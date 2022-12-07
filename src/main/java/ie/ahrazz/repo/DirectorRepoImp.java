package ie.ahrazz.repo;

import ie.ahrazz.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorRepoImp implements  DirectorRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int count(){
        String sql = "select count(*) from Director";
        Integer number = namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
        return number != null? number: -1;
    }

    @Override
    public List<Director> getAll(){
        String sql = "select * from Director";
        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new DirectorRowMapper());
    }

    @Override
    public Director findById(int id) {
        String sql = "select * from Director where director_id = :DirectorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("DirectorId",id);
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new DirectorRowMapper());

    }

    @Override
    public  Boolean exists(int id){
        String sql = "select count(*) from Director where director_id = :DirectorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("DirectorId",id);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource,Integer.class);
        return number != null  && number == 1;

    }

    @Override
    public Boolean existsByname(String name){
        String sql = "select count(*) from Director where firstName = :name";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("name",name);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    @Override
    public int deleteDirector(int id){
        String sql = "delete from Director where director_id = :DirectorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("DirectorId",id);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int createDirector(Director newDirector){
        String sql = "insert into Director values (:id, :firstName, :lastName, :stillActive)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", newDirector.getDirector_id()).addValue("firstName", newDirector.getFirstName()).addValue("lastName", newDirector.getLastName()).addValue("stillActive", newDirector.getStillActive());
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);

    }

    @Override
    public int changeName(int id, String newName){
        String sql = "update Director set firstName = :newName where director_id = :DirectorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("DirectorId",id).addValue("newName", newName);
        return namedParameterJdbcTemplate.update(sql,sqlParameterSource);

    }

}
