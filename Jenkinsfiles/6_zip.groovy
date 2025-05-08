pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                git 'https://github.com/yogita-github/EmptyRepo.git'
            }
        }

        stage('Build') {
            steps {
                // Example command that would operate on files checked out from GitHub
                bat 'scripts/zip.bat'  // This can be a batch file that zips files
            }
        }
    }

    post {
        always {
            // Archive the files from the build folder
            archiveArtifacts artifacts: '**/build/**/*', allowEmptyArchive: true
        }
    }
}
