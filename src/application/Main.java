package application;

import model.dao.SellerDao;
import model.dao.daoFactory;
import model.entites.Department;
import model.entites.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = daoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

    }
}