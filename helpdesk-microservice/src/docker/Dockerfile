FROM openjdk:8-jre-alpine
MAINTAINER thomas.pham@ithings.ch

EXPOSE 8080 6666

#dependencies
RUN apk add --update coreutils

# Set the location of the verticles
ENV VERTICLE_HOME /opt/verticles

WORKDIR $VERTICLE_HOME
CMD ["./run.sh"]
COPY run.sh .

COPY libs/* $VERTICLE_HOME/libs/
COPY conf/* $VERTICLE_HOME/conf/
COPY *.jar $VERTICLE_HOME/
