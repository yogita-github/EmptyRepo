pipeline {
    agent any

    environment {
        SOURCE_DIR = 'D:/April30/JavaAppProject'
        OUTPUT_DIR = 'D:/JenkinsAssignment/output'
        ZIP_PATH = "${OUTPUT_DIR}/project_build.zip"
    }

    stages {
        stage('Prepare Output Directory') {
            steps {
                bat '''
                if not exist "%OUTPUT_DIR%" (
                    mkdir "%OUTPUT_DIR%"
                )
                '''
            }
        }

        stage('Zip Project Folder') {
            steps {
                bat '''
                if exist "%SOURCE_DIR%" (
                    powershell -Command "Compress-Archive -Path '%SOURCE_DIR%\\*' -DestinationPath '%ZIP_PATH%' -Force"
                ) else (
                    echo ERROR: Source directory does not exist!
                    exit /b 1
                )
                '''
            }
        }
    }

    post {
        success {
            echo "Zipping completed: ${ZIP_PATH}"
        }
        failure {
            echo "Failed to zip the folder."
        }
    }
}

