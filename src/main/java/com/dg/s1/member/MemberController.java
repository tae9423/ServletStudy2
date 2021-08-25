package com.dg.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dg.s1.bankbook.BankbookDTO;

public class MemberController {

	private MemberDAO memberDAO;
	private MemberService memberService;

	public MemberController() {
		memberDAO = new MemberDAO();
		memberService = new MemberService();
	}

	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberController 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");

		String path = uri.substring(index);
		System.out.println(path);

		if (path.equals("/memberLogin.do")) {
			System.out.println("로그인 진행");
			String value = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println("id : " + value + ", pw : " + pw);

		} else if (path.equals("/memberJoin.do")) {
			System.out.println("회원가입 진행");

			String method = request.getMethod();

			if (method.equals("POST")) {
				int result = memberService.memberJoin(request, response);

				if (result > 0) {
					response.sendRedirect("../");
				} else {
					response.sendRedirect("./memberJoin.do");
				}
			} else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				view.forward(request, response);
			}

		} else if (path.equals("/memberPage.do")) {
			System.out.println("myPage 진행");
		} else {
			System.out.println("그 외 나머지");
		}

	}

}
