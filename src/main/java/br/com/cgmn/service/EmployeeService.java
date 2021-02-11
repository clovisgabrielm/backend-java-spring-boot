package br.com.cgmn.service;

import br.com.cgmn.domain.DomainException;
import br.com.cgmn.domain.Employee;
import br.com.cgmn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee) throws DomainException {

        if (employee.getId() == null) {
            employee.setId(this.employeeRepository.nextSequenceId());
        }

        return employee;
    }

}
