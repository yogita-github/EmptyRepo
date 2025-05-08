@echo off
echo Zipping build, logs, and reports...

if not exist output (
    mkdir output
)

powershell Compress-Archive -Path build,logs,reports -DestinationPath output\build_output.zip

if %errorlevel% neq 0 (
    echo ❌ Failed to zip files.
    exit /b 1
)

echo ✅ Build zipped.

