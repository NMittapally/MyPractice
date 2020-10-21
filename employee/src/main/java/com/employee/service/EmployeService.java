package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.RecordNotFoundException;
import com.employee.model.EmployeeEntity;
import com.employee.repository.EmployeeRep;

@Service
public class EmployeService {

	@Autowired
	EmployeeRep employeeRep;

	public EmployeeEntity addEmployee(EmployeeEntity employe) {

		return employeeRep.save(employe);

	}

	public List<EmployeeEntity> getAllEmployees() {

		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) employeeRep.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = employeeRep.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = employeeRep.findById(id);

		if (employee.isPresent()) {
			employeeRep.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}

	}

	public EmployeeEntity saveOrUpdate(long id, EmployeeEntity employe) {

		return employeeRep.save(employe);

	}

}
