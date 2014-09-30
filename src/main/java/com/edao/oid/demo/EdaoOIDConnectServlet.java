package com.edao.oid.demo;

import com.edao.oid.connect.EdaoOIDSDK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 建立与Edao OpenID Connect OP 握手，并重定向到OP
 * Author : @quanken
 * Date: 2014-08-19
 */
public class EdaoOIDConnectServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        EdaoOIDSDK sdk = new EdaoOIDSDK(new CustomizeConfig());
        String redirectUrl = sdk.buildOpRequestUrl();
        resp.sendRedirect(redirectUrl);
    }
}
