package br.com.cgmn.controllers;

import br.com.cgmn.domain.DomainException;
import br.com.cgmn.domain.Employee;
import br.com.cgmn.repository.EmployeeRepository;
import br.com.cgmn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * EmployeeController
 *
 * @author clovisgabrielm
 *
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> index(Pageable pageable) {
        return ResponseEntity.ok().body(this.employeeRepository.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return this.employeeRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee) {

        Map<String, Object> result = new HashMap<>();

        try {
            Employee e = employeeService.create(employee);
            return new ResponseEntity<>(this.employeeRepository.save(e), HttpStatus.CREATED);
        } catch (DomainException e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee employee) {
        Employee emp = this.employeeRepository.getEmployee(id);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return this.employeeRepository.findById(id).map(n -> {
            this.employeeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}