#!/bin/bash
mkdir -p reports
javac -cp "lib/*:build" -d build test/*.java
java -cp "lib/*:build" org.junit.runner.JUnitCore MainTest > reports/test_results.txt
echo "✅ Unit tests executed."
