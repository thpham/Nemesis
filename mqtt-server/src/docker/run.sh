#!/usr/bin/env sh

export LAUNCHER="io.vertx.core.Launcher"
export VERTX_CMD="run"

pid=0

# SIGUSR1-handler
my_handler() {
  echo "my_handler"
}

# SIGTERM-handler
term_handler() {
  if [ $pid -ne 0 ]; then
    kill -SIGTERM "$pid"
    wait "$pid"
    echo "kill -SIGTERM ..."
  fi
  sleep 5;
  exit 143; # 128 + 15 -- SIGTERM
}

# setup handlers
# on callback, kill the last background process, which is `tail -f /dev/null` and execute the specified handler
trap 'kill ${!}; my_handler' SIGUSR1
trap 'kill ${!}; term_handler' SIGTERM 

# run application

java \
  -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory \
  -Dhazelcast.logging.type=slf4j \
  -Dvertx.hazelcast.config=./conf/cluster.xml \
  -Dvertx.disableDnsResolver=true \
  -cp  $(echo *.jar | tr ' ' ':'):$(echo libs/*.jar | tr ' ' ':') \
  $LAUNCHER $VERTX_CMD ${main.verticle} \
  -cluster \
  --conf="conf/docker.json" \
  --launcher-class=$LAUNCHER &

# -instances $(nproc)

pid="$!"

# wait forever
while true
do
  tail -f /dev/null & wait ${!}
done
