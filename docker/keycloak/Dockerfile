FROM jboss/keycloak-postgres:latest
MAINTAINER thomas.pham@ithings.ch

# User root user to install software
USER root
# Install necessary packages
RUN yum -y install nc && yum clean all
# Switch back to jboss user
USER jboss

RUN rm -rf /opt/jboss/keycloak/themes/keycloak
ADD theme.tar.gz /opt/jboss/keycloak/themes/
ADD docker-entrypoint.sh /opt/jboss/
ADD nemesis-realm.json /opt/jboss/

ENTRYPOINT [ "/opt/jboss/docker-entrypoint.sh" ]
CMD ["-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Dkeycloak.import=/opt/jboss/nemesis-realm.json"]