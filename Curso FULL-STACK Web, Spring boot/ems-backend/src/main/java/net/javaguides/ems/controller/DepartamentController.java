package net.javaguides.ems.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/departaments")
public class DepartamentController {
    
    private DepartmentService departmentService;
     public DepartamentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    // Build Add Departament REST API

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartamento(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // Build Get Department RESP API

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id){
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);

        return ResponseEntity.ok(departmentDto);
    }


    // Build Get All Departments REST API 

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }


    // Build Update Department REST API 

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updateDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updateDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Delete Department REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department delete successfully!");
    }
}
