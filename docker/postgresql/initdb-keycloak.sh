#!/bin/sh
set -e

# Perform all actions as user 'postgres'
export PGUSER=postgres

# 
psql -c "CREATE USER $KEYCLOAK_USER WITH PASSWORD '$KEYCLOAK_PASSWORD';"
psql -c "CREATE DATABASE $KEYCLOAK_DB WITH ENCODING='UTF8' OWNER=$KEYCLOAK_USER CONNECTION LIMIT=-1 TEMPLATE=template1 TABLESPACE=pg_default;"

