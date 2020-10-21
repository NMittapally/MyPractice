package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.model.EmployeeEntity;

public interface EmployeeRep extends CrudRepository<EmployeeEntity,Long> {

}
