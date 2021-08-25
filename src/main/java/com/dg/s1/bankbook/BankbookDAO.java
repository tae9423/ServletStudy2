package com.dg.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dg.s1.util.DBConnector;

public class BankbookDAO {

	private DBConnector dbConnector;

	public BankbookDAO() {

		dbConnector = new DBConnector();

	}
	
	//setInsert
	public int setInsert(BankbookDTO bankbookDTO) {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		
		int result = 0;
		
		String sql = "insert into bankbook (bookNumber, bookName, bookRate, bookSale) "
				+ "values (bankbook_seq.nextval, ?, ?, ?)";
		
		try {
			st = con.prepareStatement(sql);

			st.setString(1, bankbookDTO.getBookName());
			st.setDouble(2, bankbookDTO.getBookRate());
			st.setInt(3, bankbookDTO.getBookSale());
			
			result= st.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(st, con);
		}
		return result;
	}
	

	//getInsert
	public ArrayList<BankbookDTO> getList() {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();

		String sql = "SELECT * FROM BANKBOOK";
		try {
			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {
				BankbookDTO result = new BankbookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
				ar.add(result);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
	}

	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {

		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		BankbookDTO result = null;
	

		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER = ?";

		try {
			st = con.prepareStatement(sql);

			st.setLong(1, bankbookDTO.getBookNumber());

			rs = st.executeQuery();

			if (rs.next()) {
				result = new BankbookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}

		return result;

	}

}
