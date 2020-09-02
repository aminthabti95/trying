FROM tomcat:9
COPY  COPY /webapp/target/*.war /opt/tomcat/latest/webapps
