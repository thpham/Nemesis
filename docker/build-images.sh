#!/usr/bin/env bash

set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
MVN_ARGS="-Dmaven.test.skip=true -Dos.detected.name=linux -Dos.detected.arch=x86_64 -Dos.detected.classifier=linux-x86_64"

(cd $DIR/.. && mvn $MVN_ARGS clean install )

(cd $DIR/../api-gateway && mvn $MVN_ARGS docker:build)
(cd $DIR/../account-microservice && mvn $MVN_ARGS docker:build)
(cd $DIR/../cache-infrastructure && mvn $MVN_ARGS docker:build)
(cd $DIR/../monitor-dashboard && mvn $MVN_ARGS docker:build)
(cd $DIR/../helpdesk-microservice && mvn $MVN_ARGS docker:build)
(cd $DIR/../supervisor-microservice && mvn $MVN_ARGS docker:build)
(cd $DIR/../mqtt-server && mvn $MVN_ARGS docker:build)