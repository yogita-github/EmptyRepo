pipeline {
    agent any

    environment {
        GITHUB_REPO = 'https://github.com/yogita-github/EmptyRepo.git'  // Your GitHub repo URL
        CLONE_DIR = 'D:/JenkinsAssignment/EmptyRepo'  // Correct path for Jenkins workspace on D drive
        ZIP_PATH = 'D:/JenkinsAssignment/output/build_output.zip'  // Zip file output location on D drive
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Clone the GitHub repository
                git url: GITHUB_REPO, branch: 'main'
            }
        }

        stage('Prepare Directories') {
            steps {
                bat '''
                    :: Ensure the output directory exists
                    if not exist "D:/JenkinsAssignment/output" (
                        mkdir "D:/JenkinsAssignment/output"
                    )
                    
                    :: Ensure the source directory exists (you can adjust this as per your repo structure)
                    if not exist "D:/JenkinsAssignment/EmptyRepo/src" (
                        echo Source directory does not exist!
                        exit /b 1
                    )
                '''
            }
        }

        stage('Zip Files') {
            steps {
                bat '''
                    echo Zipping files from cloned GitHub repository...

                    :: Define the correct source directory where files are located
                    set SOURCE_DIR=%WORKSPACE%\\EmptyRepo\\src
                    set ZIP_PATH=%WORKSPACE%\\output\\build_output.zip

                    :: Run PowerShell command to zip the files
                    powershell -Command "
                    Compress-Archive -Path '%SOURCE_DIR%' -DestinationPath '%ZIP_PATH%' -Force
                    "

                    :: Check if the command was successful
                    if %errorlevel% neq 0 (
                        echo ❌ Failed to zip files.
                        exit /b 1
                    )

                    echo ✅ Build zipped successfully.
                '''
            }
        }
    }
}

