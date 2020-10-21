package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.RecordNotFoundException;
import com.employee.model.EmployeeEntity;
import com.employee.service.EmployeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeService employeService;

	@PostMapping("/addemploye")
	public ResponseEntity<EmployeeEntity> addEmployeeData(@RequestBody EmployeeEntity employe) {
		EmployeeEntity updated = employeService.addEmployee(employe);
		return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/getEmployes")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
		List<EmployeeEntity> list = employeService.getAllEmployees();

		return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		EmployeeEntity entity = employeService.getEmployeeById(id);

		return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/employe/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		employeService.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}
	
	@PutMapping("/employe/{id}")  
	private ResponseEntity<EmployeeEntity> update(@PathVariable("id") Long id,@RequestBody EmployeeEntity employe)  
	{  
		EmployeeEntity entity=employeService.saveOrUpdate(id, employe);  
	return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);  
	}  

}
