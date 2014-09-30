package com.edao.oid.demo;

import com.edao.oid.connect.EdaoOIDConfig;

/**
 * Author : @quanken
 * Date: 2014-08-19
 */
public class CustomizeConfig extends EdaoOIDConfig{

    @Override
    public String getClientName() {
        return "EdaoStd";
    }

    @Override
    public String getCallbackUrl() {
        // Callback url set here, the url must be the same as EdaoTech provided
        return "http://localhost:9999/edao-openid-connect-demo-j2ee/callback";
    }

    @Override
    public String getCredentials() {
        String pubStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCANELcdE0uzTQ431SkuyN4RCQ0z0TCecSUh" +
                "XQ0sOy9FITTnlzUs8Uja8K0dKp3Exxfegxf5USDtn1RA/22hMwYJ+3ovxHw5jxaQ0Vp8dXBTh08bCFXhv" +
                "yHfjDC/8B4KAGkSkCyR3f4meFXQefa2GWTxqnf8LMJCnZTrGIFkwaB/wIDAQAB";
        return pubStr;
    }
}
