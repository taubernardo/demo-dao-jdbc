package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("====    TESTE 1: department findById    ====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("====    TESTE 2: department findAll    ====");
        List<Department> list = departmentDao.findAll();
        for (Department k : list) {
            System.out.println(k);
        }

        System.out.println("====    TESTE 3: department insert    ====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("====    TESTE 4: department update    ====");
        Department dep2 = departmentDao.findById(1);
        dep2.setNome("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed!");

        System.out.println("====    TESTE 5: department delete    ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");
        

        
        

        sc.close();
    }
}
