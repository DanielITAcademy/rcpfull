package com.ITAcademy.rcpproject.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.rcpproject.Models.Employee;
import com.ITAcademy.rcpproject.Models.Role;
import com.ITAcademy.rcpproject.Repositories.EmployeeRepository;
import com.ITAcademy.rcpproject.Utilities.EmployeeNotFoundException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {
	

private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}
	
	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setRole(newEmployee.getRole());
				employee.setRoleName(newEmployee.getRole().name());
				employee.setSalary(newEmployee.getRole().getSalary());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}
	
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
	//peticion especial que busque por trabajo
	@GetMapping("/employees/search/{role}")
	List<Employee> employees(@PathVariable Role role) {
		return repository.findByRole(role);
			//.orElseThrow(() -> new EmployeeNotFoundException(role));
	
}
}


