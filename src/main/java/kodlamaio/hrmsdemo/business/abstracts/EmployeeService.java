package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    Result verifyEmployer(int employeeId,boolean verify);
    DataResult<List<Employee>> getAll();
    Result add(Employee employee);

}
