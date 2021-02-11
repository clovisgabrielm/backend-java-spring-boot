package br.com.cgmn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 6510681077304219998L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "inspectionSequenceGenerator")
    @GenericGenerator(name = "inspectionSequenceGenerator", strategy = "br.com.cgmn.hibernate.generator.CustomSequenceGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_employee_id"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "salary")
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() { return this.salary; };
}
