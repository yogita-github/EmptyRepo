@echo off
if not exist output (
    mkdir output
    echo 🛠️ Created missing "output" folder.
)
del /Q output\*.zip
echo ✅ Old zip files deleted.

