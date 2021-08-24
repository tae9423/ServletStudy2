package com.dg.s1.member;

import javax.servlet.http.HttpServletRequest;

public class MemberController {

	public void start(HttpServletRequest request) {
		System.out.println("MemberController 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");

		String path = uri.substring(index);
		System.out.println(path);

		if (path.equals("/memberLogin.do")) {
			System.out.println("로그인 진행");
			String value = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println("id : "+value+", pw : "+pw);
			
		} else if (path.equals("/memberJoin.do")) {
			System.out.println("회원가입 진행");
		} else if (path.equals("/memberPage.do")) {
			System.out.println("myPage 진행");
		} else {
			System.out.println("그 외 나머지");
		}

	}

}
