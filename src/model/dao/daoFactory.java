package model.dao;

import db.DB;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;

public class daoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
