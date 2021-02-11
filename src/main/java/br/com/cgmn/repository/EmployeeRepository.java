package br.com.cgmn.repository;
import br.com.cgmn.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select e from Employee e where e.id = :id")
    Employee getEmployee(Long id);

    @Query(value = "SELECT NEXT VALUE FOR seq_employees_id", nativeQuery = true)
    Long nextSequenceId();
}
