package org.example;

import org.example.model.dao.DAOFactory;
import org.example.model.dao.SellerDAO;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDAO.findById(3);

        System.out.println(seller);
    }
}