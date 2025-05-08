@echo off
mkdir logs 2>nul

echo Starting application...
start /b java -jar build\app.jar > logs\output.log 2>&1

echo ✅ Application started in background.
