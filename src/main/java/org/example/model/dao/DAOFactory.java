package org.example.model.dao;

import org.example.db.DB;
import org.example.model.dao.impl.SellerDAOImplJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDAOImplJDBC(DB.getConnection());
    }
}
