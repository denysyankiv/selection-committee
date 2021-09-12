FROM tomcat:9-jdk8
COPY ./target/sc.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh","run"]