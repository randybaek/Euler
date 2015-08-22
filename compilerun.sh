#!/bin/bash

if [ -z "$1" ]; then
    echo "Usage: $0 N"
    exit 255
fi

mkdir -p target/classes

printf -v NUM '%03d' $1
echo "Compiling Prob$NUM.scala..."
scalac -deprecation -d target/classes src/main/scala/EulerApp.scala src/main/scala/Prob$NUM.scala
if [ $? != 0 ]; then
    exit $?
fi

echo "Running Prob$NUM..."
time scala -cp target/classes Prob$NUM
