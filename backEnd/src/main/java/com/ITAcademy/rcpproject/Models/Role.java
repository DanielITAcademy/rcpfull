package com.ITAcademy.rcpproject.Models;


public enum Role {
	
		ELECTRICIAN(1500), 
		PAINTER(1600), 
		TECHNICIAN(1700), 
		BOSS(1800);

		private double salary;

		private Role(double salary) {
			setSalary(salary);
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}
		
}