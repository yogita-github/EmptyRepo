@echo off
mkdir build 2>nul
jar cvf build\app.jar -C build .
echo ✅ Packaged into app.jar
