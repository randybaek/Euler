#!/bin/bash

if [ -z "$1" ]; then
    echo "Usage: $0 N"
    exit 255
fi

mkdir -p target/scala-2.11/classes

printf -v NUM '%03d' $1
echo "Compiling Prob$NUM.scala..."
scalac -deprecation -d target/scala-2.11/classes src/main/scala/app/EulerApp.scala src/main/scala/problem/Prob$NUM.scala
if [ $? != 0 ]; then
    exit $?
fi

echo "Running Prob$NUM..."
time scala -cp target/scala-2.11/classes Prob$NUM
