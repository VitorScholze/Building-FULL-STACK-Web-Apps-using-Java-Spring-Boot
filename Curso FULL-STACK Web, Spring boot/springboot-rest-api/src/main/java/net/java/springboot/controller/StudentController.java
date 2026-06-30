package net.java.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.bean.Student;

@RestController
public class StudentController {
    
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "Ramesh", "Fadatare");
        return student;
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Vitor", "Junior"));
        students.add(new Student(2, "Neymar", "Junior"));
        students.add(new Student(3, "Vini", "Junior"));
        students.add(new Student(4, "Endrick", "Felipe"));

        return students;
    }


    // URL: http://localhost:8080/students/10

    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "Ramesh", "Fadatare");
    }


    // URL: http://localhost:8080/students/query?id=10&firstName=Neymar&lastName=Junior
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id, 
        @RequestParam String firstName, 
        @RequestParam String lastName){

        return new Student(id, firstName, lastName);
    }


    }
        
