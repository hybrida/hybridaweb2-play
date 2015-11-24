#!/usr/bin/env bash
for i in *
do
    if test -f "$i"
    then
       gs -sDEVICE=png16m -o thumbName + fileName r243x313
    fi
done