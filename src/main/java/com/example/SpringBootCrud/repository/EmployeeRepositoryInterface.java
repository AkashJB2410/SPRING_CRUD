package com.example.SpringBootCrud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootCrud.model.Employee;

public interface EmployeeRepositoryInterface extends JpaRepository <Employee,Integer> {



}