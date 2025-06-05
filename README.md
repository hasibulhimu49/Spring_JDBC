# Spring JDBC CRUD App

This documentation is based on the YouTube tutorial:

🎥 **Title:** Completing My Database Application using Spring ORM  
📺 **Channel:** [Learn with Durgesh](https://www.youtube.com/@learnwithdurgesh)

---

## 📘 Topics Covered

This project demonstrates the following:

1. **What is Spring JDBC?**
   - Spring JDBC is a module of Spring Framework that simplifies database operations like querying and updating.
   - Uses `JdbcTemplate` and `DataSource` for performing operations.

2. **Working Process:**
   - Interfaces: `DataSource`, `DriverManagerDataSource`
   - Classes: `JdbcTemplate`
   - Configuration:
     - `driverClassName = com.mysql.cj.jdbc.Driver`
     - `url = jdbc:mysql://localhost:3306/your_database`
     - `username = root`
     - `password = password`

3. **Creating Maven Project:**
   - Add dependencies:
     ```xml
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
       <version>5.3.30</version>
     </dependency>
     <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.33</version>
     </dependency>
     ```
   - Use `Ctrl + O` in NetBeans to view class outlines and methods.

4. **Database Setup:**
   ```sql
   CREATE DATABASE your_database;
   USE your_database;
   
   CREATE TABLE student (
       id INT PRIMARY KEY,
       name VARCHAR(50),
       city VARCHAR(50)
   );
   ```

5. **JDBC Template Configuration Without XML:**
   - Java-based config using `@Configuration`
   - Example:
     ```java
     @Configuration
     class JdbcConfig {
         @Bean
         public DataSource dataSource() {
             DriverManagerDataSource ds = new DriverManagerDataSource();
             ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
             ds.setUrl("jdbc:mysql://localhost:3306/your_database");
             ds.setUsername("root");
             ds.setPassword("password");
             return ds;
         }

         @Bean
         public JdbcTemplate jdbcTemplate() {
             return new JdbcTemplate(dataSource());
         }
     }
     ```

6. **Insert Data into Database:**
   ```java
   Student s = new Student();
   s.setId(1);
   s.setName("Durgesh");
   s.setCity("Delhi");
   studentDao.insert(s);
   ```

7. **Update Operation:**
   ```java
   s.setName("Durgesh Kumar");
   studentDao.update(s);
   ```

8. **Delete Operation:**
   ```java
   studentDao.delete(1);
   ```

9. **RowMapper Concept:**
   - Converts `ResultSet` to Java object:
     ```java
     class StudentRowMapper implements RowMapper<Student> {
         public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
             Student s = new Student();
             s.setId(rs.getInt("id"));
             s.setName(rs.getString("name"));
             s.setCity(rs.getString("city"));
             return s;
         }
     }
     ```

10. **Select Single Row:**
    ```java
    Student s = studentDao.getStudent(1);
    ```

11. **Select Multiple Rows:**
    ```java
    List<Student> students = studentDao.getAllStudents();
    ```

12. **Autowiring with Spring JDBC:**
    - Use constructor injection or `@Autowired`

13. **Run Application:**
    - Use `AnnotationConfigApplicationContext`
    - Perform CRUD operations inside `main()`

---
## 🛠️ Technologies and Tools Used

- **Java 8+**  
- **Spring JDBC (Spring Framework)**  
- **MySQL Database**  
- **Maven (Dependency Management)**  
- **NetBeans / IntelliJ / Eclipse (IDE)**  
- **MySQLYog / phpMyAdmin** – for managing and visualizing MySQL database  
- **Spring Core Annotations:** `@Configuration`, `@Bean`, `@Autowired`
---
## 🧠 Summary

- Easy to learn and revisit.
- Concepts are separated and clearly explained.
- Full code is in one file for simplicity.
- Follows Java-based Spring configuration (no XML).

Use this project as a template or reference whenever learning or working with Spring JDBC. Ideal for beginners and Hindi-speaking students following Learn with Durgesh tutorials.


---

Happy Learning! 🎯
