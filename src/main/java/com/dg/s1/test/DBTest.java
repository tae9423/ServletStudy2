package com.dg.s1.test;

import java.sql.Connection;

import com.dg.s1.bankbook.BankbookDAO;
import com.dg.s1.bankbook.BankbookDTO;
import com.dg.s1.util.DBConnector;

public class DBTest {

	public static void main(String[] args) {
		/*
		 * DBConnector dbconnector = new DBConnector(); Connection con =
		 * dbconnector.getConnect(); System.out.println(con);
		 */
		
		BankbookDAO bankbookDAO = new BankbookDAO();
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(1);
		bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
		
		System.out.println(bankbookDTO.getBookName());
	}

}
