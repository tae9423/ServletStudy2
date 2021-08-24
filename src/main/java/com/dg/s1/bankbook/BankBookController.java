package com.dg.s1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankBookController {
	
	private BankbookDAO bankbookDAO;
	
	public BankBookController() {
		bankbookDAO = new BankbookDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BankbookController 실행");
		
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		
		
		String path=uri.substring(index);
		
		if(path.equals("/bankbookList.do")) {
			System.out.println("상품 목록");
			
			ArrayList<BankbookDTO> ar = bankbookDAO.getList();
			for(BankbookDTO bankbookDTO:ar) {
				System.out.println(bankbookDTO.getBookName());
			}
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(path.equals("/bankbookInsert.do")) {
			System.out.println("상품 등록");
		}else if(path.equals("/bankbookSelect.do")) {
			System.out.println("상품 상세 조회");
			String num = request.getParameter("booknumber");
			long num2 = Long.parseLong(num);
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookNumber(num2);
			bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
			System.out.println(bankbookDTO.getBookName());
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}else {
			System.out.println("그 외 나머지");
		}
	}

}
