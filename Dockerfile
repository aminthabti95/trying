FROM tomcat:9
COPY  /var/lib/jenkins/workspace/dev-pipe/build/libs/*.war /opt/tomcat/latest/webapps
