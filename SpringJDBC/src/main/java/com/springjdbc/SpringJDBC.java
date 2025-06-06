package com.springjdbc;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJDBC {

    public static void main(String[] args) {
        System.out.println("Program Running...");

        // Load Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext("JdbcConfig.java");

        // Corrected: get StudentDao bean
        StudentDao s = context.getBean("StuDao", StudentDao.class);

       // Insert student
//        Student student = new Student();
//        student.setId(358);
//        student.setName("Pranto");
//        student.setCity("Dhaka");
//
//        int result = s.insert(student);
//
//        System.out.println("Student added: " + result);



        // data update
//         Student student=new Student();
//         student.setId(329);
//         student.setName("Limon");
//         student.setCity("Nowakhali");
//         
//         int result=s.change(student);
//         System.out.println("Data changed" +result);
           

//         //user input
//         System.out.println("Enter id that want delete: ");
//         Scanner scanner = new Scanner(System.in);
//         int id = scanner.nextInt();
//
//             
//          //delete data
//          int result=s.delete(id);
//          System.out.println("deleted student count: " +result);

            
//        //selecting single object(row)
//        Student student =s.getStudent(319);
//        System.out.println(student);  

         //selecting multile object(row)
         List<Student> students=s.getAllStudent();
         
         for(Student r:students)
         {
             System.out.println(r);
         }
         
   }
} 
