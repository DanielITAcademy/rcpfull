package com.ITAcademy.rcpproject.Utilities;

import com.ITAcademy.rcpproject.Models.Role;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(Long id) {
		super("Cound not find employee "+id);
	}

	public EmployeeNotFoundException(Role role) {
		super("Cound not find employee "+role);
	}
}
