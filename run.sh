#! /bin/bash

name=$1
filename="$name.java"

clear
javac $filename
java $name
