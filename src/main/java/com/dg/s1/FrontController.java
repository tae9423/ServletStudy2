package com.dg.s1;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dg.s1.bankbook.BankBookController;
import com.dg.s1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BankBookController bankBookController;
	private MemberController memberController;

	public FrontController() {
		super();
		bankBookController = new BankBookController();
		memberController = new MemberController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Front Controller 실행");

		String uri = request.getRequestURI();

		String path = "";

		System.out.println(request.getRequestURI());

		int startIndex = request.getContextPath().length();
		int lastIndex = uri.lastIndexOf("/");
		path = uri.substring(startIndex, lastIndex);

		System.out.println(path);

		if(path.equals("/member")) {
			memberController.start(request);
		}else if(path.equals("/bankbook")) {
			bankBookController.start(request, response);
		}else{
			System.out.println("없는 URL");
		}
		

	}

	// String url = request.getRequestURL().toString();
	// System.out.println("url : "+url);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
