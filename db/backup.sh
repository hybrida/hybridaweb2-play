#! /bin/bash

pg_dump -d hybrida -s > schema.sql
pg_dump -d hybrida --data-only > data.sql
