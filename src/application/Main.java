package application;

import model.dao.SellerDao;
import model.dao.daoFactory;
import model.entites.Department;
import model.entites.Seller;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = daoFactory.createSellerDao();
    /*
        Department dp = new Department(2,null);
        sellerDao.insert(new Seller(9,"Name Test","test@gmail", new Date(), 2000.0, dp));

        System.out.println("=== TEST 1: seler find by ID ===");
        Seller seller = sellerDao.findById(9);

        System.out.println("\n=== TEST 2: seller findByDepartmentId ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("=== TEST 3: seller findAll ===");
        List<Seller> sellers = sellerDao.findAll();
        for (Seller s : sellers) {
            System.out.println(s);
        }*/
        Department department = new Department(2, null);
        sellerDao.insert(new Seller(0, "Test2", "test2@gmail.com", new java.util.Date(), 2999.0, department));


        //System.out.println(seller);

    }
}