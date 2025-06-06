package com.springjdbc;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
//Spring JDBC configuration without XML
@Configuration
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3307/springjdbc");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean(name = "StuDao")
    public StudentDao studentDao() {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
