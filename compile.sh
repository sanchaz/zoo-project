#!/bin/sh

reset
echo "updating list of files to compile..."
ls -R zoo/Zoo.java zoo/backend/*.java zoo/backend/*/*.java zoo/tests/TestZoo.java > compile.txt
echo "update done."
echo "now compiling..."
javac @compile.txt
echo "compiling done."
