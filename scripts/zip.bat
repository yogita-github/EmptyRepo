@echo off
echo Zipping build, logs, and reports...

rem Check if 'build' directory exists
if not exist build (
    echo ❌ 'build' directory does not exist.
    exit /b 1
)

rem Check if 'logs' directory exists
if not exist logs (
    echo ❌ 'logs' directory does not exist.
    exit /b 1
)

rem Check if 'reports' directory exists
if not exist reports (
    echo ❌ 'reports' directory does not exist.
    exit /b 1
)

rem Create output directory if it does not exist
if not exist output (
    mkdir output
)

rem Compress the directories into a zip file
powershell Compress-Archive -Path build,logs,reports -DestinationPath output\build_output.zip

rem Check if the zip command was successful
if %errorlevel% neq 0 (
    echo ❌ Failed to zip files.
    exit /b 1
)

echo ✅ Build zipped.


