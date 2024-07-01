package model.dao;

import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;

public class daoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    }
}
