@echo off
forfiles /p "output" /m *.zip /d -2 /c "cmd /c del /f /q @file"
echo ✅ Old zip files deleted.
