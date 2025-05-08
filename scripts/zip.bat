@echo off
echo Zipping build, logs, and reports...

:: Create the output directory if it doesn't exist
if not exist output (
    mkdir output
)

:: Check if directories exist and zip them accordingly
powershell -Command "
$dirs = @('build', 'logs', 'reports')
$zipPath = 'output\build_output.zip'

$dirsToZip = @()
foreach ($dir in $dirs) {
    if (Test-Path $dir) {
        $dirsToZip += $dir
    }
}

if ($dirsToZip.Count -gt 0) {
    Compress-Archive -Path $dirsToZip -DestinationPath $zipPath -Force
} else {
    Write-Host 'No valid directories to zip.'
    exit 1
}
"

:: Check if the command was successful
if %errorlevel% neq 0 (
    echo ❌ Failed to zip files.
    exit /b 1
)

echo ✅ Build zipped.


