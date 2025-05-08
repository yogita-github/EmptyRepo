@echo off
REM Create reports directory if it doesn't exist
if not exist reports mkdir reports

REM Compile Java test files
javac -cp "lib/*;build" -d build test\*.java

REM Run the JUnit tests and output results
java -cp "lib/*;build" org.junit.runner.JUnitCore MainTest > reports\test_results.txt

echo ✅ Unit tests executed.
