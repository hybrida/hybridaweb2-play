#! /bin/bash

cd ${0%/*}
psql <<EOF
drop database hybrida;
create database hybrida;
EOF
psql hybrida < schema.sql
psql hybrida < data.sql
