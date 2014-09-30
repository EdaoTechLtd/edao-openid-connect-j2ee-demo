EdaoTech OpenID Connect Demo ( J2EE Edition )
===============================================

This is a demo project for Edao Login Integrating written in java

In order to build this project, you need :

* Oracle JDK/ OpenJDK 1.6+
* Gradle 1.10+

Run the demo
================================================
You can get and run the demo follow steps below:

* get the code
    git clone https://github.com/EdaoTechLtd/edao-openid-connect-j2ee-demo.git
* build and run
    `gradle jettyRun`
* change op settings
    Edit `com.edao.oid.demo.CustomizeConfig` , replace code in your own situation
* change jetty listen port
    Edit `build.gradle` , change the value of jettyRun.httpPort
    e.g: jettyRun.httpPort = 12312(num as you wish)

Howtos
================================================

Q: How to own my own Edao Login Credentials<br>
A: Check http://www.edaotech.com/sqrk for details


