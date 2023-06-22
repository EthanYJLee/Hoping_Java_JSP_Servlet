# Hoping
JSP&Servlet - 캠핑장 P2P 공유 플랫폼 서비스
---
### 설정
- 메인 화면: localhost:8080/AClientHost/main.do
- MySQL 스키마명: camping
- Server: Apache Tomcat 9
- web.xml에 아래 코드 추가
```xml
<!-- mysql -->
    <resource-ref>
      <description>DB Connection</description>
      <res-ref-name>jdbc/camping</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
    </resource-ref>
```
 - context.xml에 아래 코드 추가
```xml
<!-- MySQL - camping -->
    <Resource 
    	name="jdbc/camping"
    	auth="Container"
    	type="javax.sql.DataSource"
    	maxTotal="8"
    	maxIdle="30"
    	maxWaitMillis="-1"
    	username="username"
    	password="password"
    	driverClassName="com.mysql.cj.jdbc.Driver"
    	url="jdbc:mysql://localhost:3306/camping?serverTimezone=Asia/Seoul&amp;characterEncoding=utf8&amp;allowPublicKeyRetrieval=true&amp;useSSL=false"
    >
    </Resource>
```
