FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD clearSky-1.0-SNAPSHOT.jar clearsky.jar
RUN sh -c 'touch /clearsky.jar'
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /clearsky.jar" ]

