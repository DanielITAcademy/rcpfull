package com.ITAcademy.rcpproject.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.rcpproject.Models.Employee;
import com.ITAcademy.rcpproject.Models.Role;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByRole(Role role);

}