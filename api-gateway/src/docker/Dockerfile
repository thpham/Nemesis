FROM openjdk:8-jre
MAINTAINER thomas.pham@ithings.ch

EXPOSE 8787 6666

# dependencies, otherwise boringssl-static won't work.
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
      openssl && \
    rm -rf /var/lib/apt/lists/*


# Set the location of the verticles
ENV VERTICLE_HOME /opt/verticles

WORKDIR $VERTICLE_HOME
CMD ["./run.sh"]
COPY run.sh .

COPY libs/* $VERTICLE_HOME/libs/
COPY conf/* $VERTICLE_HOME/conf/
COPY *.jar $VERTICLE_HOME/