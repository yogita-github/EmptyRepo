# #!/bin/bash
# mkdir -p build
# javac -d build src/*.java
# echo "✅ Java code compiled."
@echo off
echo 🔧 Compiling Java source code...

REM Create build folder if it doesn't exist
if not exist build mkdir build

REM Compile Java files from src to build
javac -d build src\*.java

if %ERRORLEVEL% EQU 0 (
    echo ✅ Java code compiled successfully.
) else (
    echo ❌ Compilation failed.
    exit /b 1
)
