package com.codegym.service.employee.impl;

import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import com.codegym.repository.employee.DivisionRepository;
import com.codegym.repository.employee.EducationDegreeRepository;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.employee.PositionRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository xRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Employee> findAll() {
        return this.xRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.xRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return this.xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        this.xRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        this.xRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        this.xRepository.deleteById(id);
    }

    @Override
    public List<Division> findAllDivision() {
        return this.divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return this.educationDegreeRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return this.positionRepository.findAll();
    }

    @Override
    public Page<Employee> findByNameContaining(Pageable pageable, String name) {
        return this.xRepository.findByNameContaining(pageable, name);
    }
}
