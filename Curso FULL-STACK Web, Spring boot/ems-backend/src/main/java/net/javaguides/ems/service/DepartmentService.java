package net.javaguides.ems.service;

import java.util.List;

import net.javaguides.ems.dto.DepartmentDto;

public interface DepartmentService {
    
    DepartmentDto createDepartment(DepartmentDto departamentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDeparment);

    void deleteDepartment(Long departmentId);

}
