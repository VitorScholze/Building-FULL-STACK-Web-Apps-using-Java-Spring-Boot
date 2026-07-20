package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;

public class DepartmentMapper{

    // convert departament jpa entity into departamento dto

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription()
        );
    }


    // convert departament dto into departament jpa entity

    public static Department maptoDepartment(DepartmentDto departmentDto){
        return new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription()
        );
    }
}