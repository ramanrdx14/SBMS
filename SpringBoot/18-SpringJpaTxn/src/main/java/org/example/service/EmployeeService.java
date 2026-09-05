package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Transactional(rollbackOn = Exception.class)
    public void saveEmployee(){
        Address address = new Address();
        address.setAddressType("Temporary");
        address.setCity("Berlin");
        address.setCountry("United Kingdom");

        Employee employee = new Employee();
        employee.setEmail("ritik@gmail.com");
        employee.setFirstName("Eitik");
        employee.setLastName("Singh");
        employee.setAddresses(Arrays.asList(address));
        address.setEmployee(employee);

        employeeRepo.save(employee);
    }
    public void findEmployeeWithId(Integer employeeId){
        List<Object[]> empById = employeeRepo.findEmpById(employeeId);
        for(Object[] o:empById){
            System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]);
        }
    }
}
