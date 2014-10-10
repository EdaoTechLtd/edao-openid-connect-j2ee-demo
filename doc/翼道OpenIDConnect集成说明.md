# 概述

## 文档目的

本文档旨在引导开发者进行实际的翼道云认证平台接入开发工作。

## 预期读者
由于本文档涉及到的开发术语、技术为Java，因此本文档预期读者为Java或者其他基于JVM的开发语言开发者或者熟悉Java技术以及其他基于JVM的其他语言开发技术人员或者开发管理者。

## 声明
如果接入方使用其他开发语言进行接入开发，请咨询翼道技术人员索取其他语言的开发包和文档。
 

# 开发包内容说明

为方便客户方进行认证接入，我们提供核心的翼道开发包jar以及相应的演示demo。

## 开发环境
IntelliJ 12.1.7
Eclipse 3.8
Oracle JDK 1.7

## 运行环境

Oracle JDK/OpenJDK/IBM JDK 1.6及以上
Javax Servlet API 2.5 及以上
Tomcat/Websphere/Jetty 等基于JVM的运行服务器

## OpenID Connect SDK
* openid-connect-sdk-1.0.jar
翼道核心认证模块

* gson-2.2.4.jar
JSON处理包
* commons-codec-1.9.jar
编码包

## OpenID Connect Demo

请使用 Eclipse 3.8 IntelliJ 12.x打开相应的开发包，打开后，可能视情况需要修正导入的包的路径。

 
# 代码说明

## 认证配置
由于每个客户会有自己的标识和公钥，在实际对接过程中，需要重写默认的OpenID Connect 配置类，重写方法如下：

```

import com.edao.oid.connect.EdaoOIDConfig;

public class CustomizeConfig extends EdaoOIDConfig{

    @Override
	public String getClientName() {
    	// 设置客户标识
        return "EdaoStd";
    }

    @Override
	public String getCallbackUrl() {
        // 自定义回调地址
        return "http://132.97.186.38:9999/openid-connect-demo/callback";
    }

    @Override
    public String getCredentials() {
        String pubStr = "开发公钥放这里";
        return pubStr;
    }
}

```

## 网关握手

```

EdaoOIDSDK sdk = new EdaoOIDSDK(new CustomizeConfig());

String redirectUrl = sdk.buildOpRequestUrl();

```

然后把用户的浏览器重定向到 redirectUrl 即可。


## 回调获取用户信息


当用户在翼道登录网关完成身份认证之后，翼道登录网关会回调配置好的地址，把用户信息返回到指定的地址中。代码如下：

```
EdaoOIDSDK sdk = new EdaoOIDSDK(new CustomizeConfig());
// get code and random from callbak request
String userInfo = userInfo = sdk.getUserInfo(code, random);
```

其中，用户信息是json字符串，里面包含有openid字段，请在应用系统关联用户的openid字段。

