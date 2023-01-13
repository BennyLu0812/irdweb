# 1. 配置说明

pom.xml 中，只需要将web工程依赖到pom.xml中，如vss-sys-web


	<dependency>
	     <groupId>xxx</groupId>
	     <artifactId>vss-sys-web</artifactId>
	     <type>war</type>
	     <version>${project.version}</version>
	</dependency>
    
	
	

# 2. 问题
1.vss-rpt-web 打印模版报错
Caused by: java.lang.NoClassDefFoundError: Could not initialize class sun.awt.X11GraphicsEnvironment
在weblogic的服务器web服务启动加入：
	

    -Xms1024m -Xmx2048m -Djavax.net.ssl.trustStore=/u01/app/Middleware/user_projects/cert/atoskeystore.jks -Djava.awt.headless=true
    
    
    -Djava.awt.headless=true
	
	

# 3. 打包

