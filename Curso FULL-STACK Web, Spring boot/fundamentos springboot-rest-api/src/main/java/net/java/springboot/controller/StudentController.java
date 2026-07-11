package net.java.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.bean.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @GetMapping("student")
    public  ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Ramesh", "Fadatare");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-headre", "neymar").body(student);
    }


    @GetMapping()
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Vitor", "Junior"));
        students.add(new Student(2, "Neymar", "Junior"));
        students.add(new Student(3, "Vini", "Junior"));
        students.add(new Student(4, "Endrick", "Felipe"));

        return ResponseEntity.ok(students);
    }


    // URL: http://localhost:8080/students/10

    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id, 
                                                       @PathVariable String firstName, 
                                                       @PathVariable String lastName ){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }


    // URL: http://localhost:8080/students/query?id=10&firstName=Neymar&lastName=Junior
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id, 
        @RequestParam String firstName, 
        @RequestParam String lastName){

        return new Student(id, firstName, lastName);
    }


    // RequestBody é utilizado para transformar uma requisicao JSON diretamente para um objeto em Java
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }



    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable ("id")int studentId){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }


    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int idStudent){
        System.out.println(idStudent);
        return ResponseEntity.ok("Student deleted successfully!");
    }



    }
        
