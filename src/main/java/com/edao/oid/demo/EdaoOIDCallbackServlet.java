package com.edao.oid.demo;

import com.edao.oid.connect.EdaoOIDSDK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class EdaoOIDCallbackServlet extends HttpServlet {

	private static final long serialVersionUID = -3238070047534158940L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EdaoOIDSDK sdk = new EdaoOIDSDK(new CustomizeConfig());
        String code = req.getParameter("code");
        String random = req.getParameter("random");
		String userInfo = null;
		try {
			userInfo = sdk.getUserInfo(code, random);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(userInfo);
		pw.flush();
		pw.close();
	}
}
