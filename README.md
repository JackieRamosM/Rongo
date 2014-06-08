Rongo
=====
Rongo es una aplicación de la Escuela Superior Politénica del Litoral. Creada como proyecto para la materia
Ingeniería de Software I y II.


Rongo y Jasig Cas
=====

Rongo tiene integrado la autenticación de CAS de la ESPOL. La url es: https://auth.espol.edu.ec/login
Para poder correr Rongo. Hay que cambiar el archivo Rongo/Rongo-web/src/main/webapp/WEB-INF/web.xml
y colocar lo siguiente:


	<context-param>
		<param-name>serverName</param-name>
		<param-value>http://www.rongo.com</param-value>
	</context-param>

	<filter>
		<filter-name>CAS Single Sign Out Filter</filter-name>
		<filter-class>org.jasig.cas.client.session.SingleSignOutFilter</filter-class>
	</filter>
	<filter-mapping>

		<filter-name>CAS Single Sign Out Filter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	<listener>
		<listener-class>org.jasig.cas.client.session.SingleSignOutHttpSessionListener</listener-class>

	</listener>
	<filter>
		<filter-name>CAS Authentication Filter</filter-name>
		<filter-class>org.jasig.cas.client.authentication.AuthenticationFilter</filter-class>
		<init-param>

			<param-name>casServerLoginUrl</param-name>
			<param-value>https://auth.espol.edu.ec/login</param-value>
		</init-param>
		<init-param>
			<param-name>renew</param-name>

			<param-value>false</param-value>
		</init-param>
		<init-param>
			<param-name>gateway</param-name>
			<param-value>false</param-value>

		</init-param>
	</filter>
	<filter>
		<filter-name>CAS Validation Filter</filter-name>
		<filter-class>org.jasig.cas.client.validation.Saml11TicketValidationFilter</filter-class>

		<init-param>
			<param-name>casServerUrlPrefix</param-name>
			<param-value>https://auth.espol.edu.ec/login</param-value>
		</init-param>
		<init-param>

			<param-name>tolerance</param-name>
			<param-value>300000</param-value>
		</init-param>
	</filter>
	<filter>

		<filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>
		<filter-class>org.jasig.cas.client.util.HttpServletRequestWrapperFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>CAS Authentication Filter</filter-name>

		<url-pattern>/*</url-pattern>
	</filter-mapping>
	<filter-mapping>
		<filter-name>CAS Validation Filter</filter-name>
		<url-pattern>/*</url-pattern>

	</filter-mapping>
	<filter-mapping>
		<filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
Recuerde cambiar las url según lo deseado.
