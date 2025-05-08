@echo off
echo Zipping files from GitHub repository...

:: Define the source directory (this will be the cloned GitHub repo directory in Jenkins workspace)
set SOURCE_DIR=%WORKSPACE%\EmptyRepo\build
set ZIP_PATH=%WORKSPACE%\output\build_output.zip

:: Check if the source directory exists
if not exist "%SOURCE_DIR%" (
    echo Source directory does not exist!
    exit /b 1
)

:: Run the PowerShell command to zip the files
powershell -Command "
Compress-Archive -Path '%SOURCE_DIR%' -DestinationPath '%ZIP_PATH%' -Force
"

:: Check if the command was successful
if %errorlevel% neq 0 (
    echo ❌ Failed to zip files.
    exit /b 1
)

echo ✅ Build zipped successfully.

