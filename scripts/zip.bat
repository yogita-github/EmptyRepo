@echo off
set "SOURCE_DIR=D:\April30\JavaAppProject"
set "OUTPUT_DIR=D:\JenkinsAssignment\output"
set "ZIP_PATH=%OUTPUT_DIR%\project_build.zip"

if not exist "%OUTPUT_DIR%" (
    mkdir "%OUTPUT_DIR%"
)

if exist "%SOURCE_DIR%" (
    powershell -Command "Compress-Archive -Path '%SOURCE_DIR%\*' -DestinationPath '%ZIP_PATH%' -Force"
    echo Project zipped successfully at %ZIP_PATH%
) else (
    echo ERROR: Source directory does not exist!
    exit /b 1
)
