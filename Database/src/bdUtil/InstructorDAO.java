package bdUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.model.Instructor;

public class InstructorDAO {
    JdbcTemplate jdbc = new JdbcTemplate(getDataSource());
    //the detail impl for all CRUD methods here
    
    //getAll
    public List<Instructor> getAll(){
        //lets use jdbc_template provided by spring framework
        String sql = "select * from instructor";
        List<Instructor> list = jdbc.query(sql, new BeanPropertyRowMapper<Instructor>(Instructor.class));
        return list; //list of all instructors dałam database table
    }
    
    //getById
    public Instructor findById(int id) {
        String sql = "select * from instructor where id = ?";
        List<Instructor> instructors = jdbc.query(sql, new BeanPropertyRowMapper<Instructor>(Instructor.class), id);

        if (instructors.isEmpty()) {
            return null;
        } else {
            return instructors.get(0);
        }
    }
    
    //add
    public int add(Instructor inst) {
        String sql = "insert into `instructor` (`name`, `gender`, `specialty`) values (?, ?, ?)";
        Object args[] = {inst.getName(), inst.getGender(), inst.getSpecialty()};
        int rowAffected=jdbc.update(sql, args);
        return rowAffected;
    }

    // delete
    public int delete(int id) {
        String sql = "delete from `instructor` where `id` = ?";
        int rowsAffected = jdbc.update(sql, id);
        return rowsAffected;
    }

	// update
    public int update(Instructor inst) {
        String sql = "update `instructor` set `name` = ?, `gender` = ?, `specialty` = ? where `id` = ?";
        Object[] args = {inst.getName(), inst.getGender(), inst.getSpecialty(), inst.getId()};
        int rowsAffected = jdbc.update(sql, args);
        return rowsAffected;
    }

    public DataSource getDataSource() {
        DataSource ds=null;

        String dbURL = "jdbc:mysql://localhost:3306/ip23db";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ds = new DriverManagerDataSource(dbURL, username, password);
        return ds;
    }
}