pipeline {
    agent any

    environment {
        // Define GitHub repo URL and the path where it will be cloned
        GITHUB_REPO = 'https://github.com/yogita-github/EmptyRepo.git' // Your GitHub repo URL
        CLONE_DIR = 'D:\JenkinsAssignment\\EmptyRepo'  // Local path where the repo will be cloned in Jenkins workspace
        ZIP_PATH = 'D:\JenkinsAssignment\\output\\build_output.zip'  // Path where the zip will be saved
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Clone the GitHub repository
                git url: GITHUB_REPO, branch: 'main'
            }
        }

        stage('Zip Files') {
            steps {
                // Run batch script to zip the build, logs, reports from the cloned GitHub repo
                bat """
                    echo Zipping files from cloned GitHub repository...

                    :: Define the source directory (from the cloned repo in Jenkins workspace)
                    set SOURCE_DIR=%WORKSPACE%\\EmptyRepo\\build
                    set ZIP_PATH=%WORKSPACE%\\output\\build_output.zip

                    :: Check if the output directory exists, if not, create it
                    if not exist "%SOURCE_DIR%" (
                        echo Source directory does not exist!
                        exit /b 1
                    )

                    :: Run PowerShell command to zip the files from the GitHub repo
                    powershell -Command "
                    Compress-Archive -Path '%SOURCE_DIR%' -DestinationPath '%ZIP_PATH%' -Force
                    "

                    :: Check if the command was successful
                    if %errorlevel% neq 0 (
                        echo ❌ Failed to zip files.
                        exit /b 1
                    )

                    echo ✅ Build zipped successfully.
                """
            }
        }
    }
}
