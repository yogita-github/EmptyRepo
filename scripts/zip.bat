@echo off
echo Zipping build, logs, and reports...

:: Create the output directory if it doesn't exist
if not exist output (
    mkdir output
)

:: Zipping the directories directly (will ignore missing directories)
powershell Compress-Archive -Path build\*,logs\*,reports\* -DestinationPath output\build_output.zip -Force

:: Check if the command was successful
if %errorlevel% neq 0 (
    echo ❌ Failed to zip files.
    exit /b 1
)

echo ✅ Build zipped.


