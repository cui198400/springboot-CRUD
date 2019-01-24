FROM ns74-dmdbms-jdk-mysql-graphviz:latest

ENV CATALINA_HOME /tomcat
ENV ENV LANG="zh_CN.UTF-8"

#ADD tomcat7-cas /tomcat

#RUN chmod +x /tomcat/bin/*.sh
#RUN chmod +x /*.sh

EXPOSE 8080

CMD ["/entrypoint.sh"]
