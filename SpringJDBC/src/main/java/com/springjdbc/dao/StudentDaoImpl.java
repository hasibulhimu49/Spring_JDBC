package com.springjdbc.dao;

import com.springjdbc.entities.Student;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;
    

    public int insert(Student student) {
        // Insert query
        String query = "INSERT INTO student(id, name, city) VALUES (?, ?, ?)";
       int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
       return r;
        
    }

    public int change(Student student) {
        //updating data
        String query="update student set name=?, city=? where id=?";
        int result=jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return result;
    }
    

    public int delete(int studentId) {
        //delete data
        String query="delete from student where id=?";
        int result=this.jdbcTemplate.update(query,studentId);
        return result;
        
    }
    
   public Student getStudent(int studentId) {
       //Select single object(row)
        String query = "SELECT * FROM student WHERE id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }
   

    public List<Student> getAllStudent() {
        //Select multiple object(row)
        String query = "SELECT * FROM student";
        List<Student> students=this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }
     
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //@Override
    public void Insert(Student student) {
        
    }

    
}
