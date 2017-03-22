#!/usr/bin/env bash

set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

(cd $DIR/.. && mvn clean install -Dmaven.test.skip=true)

(cd $DIR/../api-gateway && mvn docker:build)
(cd $DIR/../account-microservice && mvn docker:build)
(cd $DIR/../cache-infrastructure && mvn docker:build)
(cd $DIR/../monitor-dashboard && mvn docker:build)
(cd $DIR/../helpdesk-microservice && mvn docker:build)
(cd $DIR/../supervisor-microservice && mvn docker:build)
(cd $DIR/../mqtt-server && mvn docker:build)