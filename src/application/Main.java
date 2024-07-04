package application;

import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.daoFactory;
import model.entites.Department;
import model.entites.Seller;

import java.sql.Date;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);

        SellerDao sellerDao = daoFactory.createSellerDao();
        DepartmentDao departmentDao = daoFactory.createDepartmentDao();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("to access DEPARTMENT type it (1)" +
                "\nto acess Sellers type it (2)");
        int acees = tc.nextInt();

        if (acees == 1) {
            int action = 0;
            while (action != 6) {
                System.out.println("Select the desire action: " +
                        "\n(1) - insert" +
                        "\n(2) - update" +
                        "\n(3) - Delet by id" +
                        "\n(4) - Find by id" +
                        "\n(5) - Find all" +
                        "\n(6) - exit" );
                action = tc.nextInt();
                Department department;
                switch (action) {
                    case 1:
                        System.out.println("Insert the Department name: ");
                        String name = tc.next();
                        departmentDao.insert(new Department(0, name));
                        break;
                    case 2:
                        break;

                    case 3:
                        System.out.println("Insert the Department Id to delet: ");
                        int deletId = tc.nextInt();
                        departmentDao.deletebyId(deletId);
                        break;
                    case 4:
                        System.out.println("Insert the id to find: ");
                        int id = tc.nextInt();
                        department = departmentDao.findById(id);
                        System.out.println(department);
                        break;
                    case 5:
                        List<Department> departments = departmentDao.findAll();
                        for(Department s: departments){
                            System.out.println(s);
                        }
                        break;
                    case 6:
                        System.out.println("Finished program!");
                        break;
                }
            }

        }
        else {
            int action = 0;
            while (action != 7) {
                System.out.println("select the desired action: " +
                        "\n (1) - Insert" +
                        "\n (2) - Update" +
                        "\n (3) - Delet by id" +
                        "\n (4) - Find by id" +
                        "\n (5) - Find all" +
                        "\n (6) - Find by Department" +
                        "\n (7) - End");
                action = tc.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("Insert the name: ");
                        String name = tc.next();
                        tc.next();
                        System.out.println("Insert the Email: ");
                        String email = tc.next();
                        System.out.println("Insert the Birth Date (yyyy-MM-dd): ");
                        String birthDate = tc.next();
                        System.out.println("Insert the Base Salary: ");
                        double baseSalary = tc.nextDouble();
                        System.out.println("insert Department Id");
                        int id = tc.nextInt();

                        Department dep = new Department(id, null);

                        try {
                            sellerDao.insert(new Seller(9, name, email, new Date(sdf.parse(birthDate).getTime()), baseSalary, dep));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("enter seller id to change");
                        int sellerId = tc.nextInt();

                        System.out.println(
                                "Which table specification do you want to update?" +
                                        "(1) - Name" +
                                        "(2) - Email" +
                                        "(3) - Birth Date" +
                                        "(4) - BaseSalary" +
                                        "(5) - Department Id ");
                        int udpdate = tc.nextInt();

                        Seller seller;

                        if (udpdate == 1) {
                            System.out.println("Enter name update: ");
                            String newName = tc.next();
                            seller = sellerDao.findById(sellerId);
                            seller.setName(newName);
                            sellerDao.update(seller);
                            System.out.println("Update succesfully");

                        } else if (udpdate == 2) {
                            System.out.println("Enter email update: ");
                            String newEmail = tc.next();
                            seller = sellerDao.findById(sellerId);
                            seller.setEmail(newEmail);
                            sellerDao.update(seller);
                            System.out.println("Update succesfully");
                        } else if (udpdate == 3) {
                            System.out.println("Enter birth date update (yyyy-MM-dd): ");
                            String newBirthDate = tc.next();
                            seller = sellerDao.findById(sellerId);
                            try {
                                seller.setBirthDate(sdf.parse(newBirthDate));
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            sellerDao.update(seller);
                            System.out.println("Update succesfully");
                        } else if (udpdate == 4) {
                            System.out.println("Enter base salary update: ");
                            double newBaseSalary = tc.nextDouble();
                            seller = sellerDao.findById(sellerId);
                            seller.setBaseSalary(newBaseSalary);
                            sellerDao.update(seller);
                            System.out.println("Update succesfully");
                        }
                    /*else if (udpdate == 5) {
                        System.out.println("Enter department id update: ");
                        int newDepartmentId = tc.nextInt();
                        seller = sellerDao.findById(sellerId);
                        seller.setDepartment(newDepartmentId);

                    }*/

                        break;

                    case 3:
                        System.out.println("chose the id to be deleted: ");
                        int DeletByid = tc.nextInt();
                        sellerDao.deleteById(DeletByid);
                        break;

                    case 4:
                        System.out.println("Find by id: ");
                        int findId = tc.nextInt();
                        seller = sellerDao.findById(findId);
                        System.out.println(seller);

                        break;

                    case 5:
                        System.out.println("Find all: ");
                        List<Seller> sellers = sellerDao.findAll();
                        for (Seller s : sellers) {
                            System.out.println(s);
                        }
                        break;

                    case 6:
                        System.out.println("Find by Department: ");
                        int findDepartId = tc.nextInt();
                        sellerDao.findById(findDepartId);


                    case 7:
                        System.out.println("Programa finalizado!");
                        break;

                    default:
                        System.out.println("Invalid action");
                        break;

                }
            }

        }
    }
}