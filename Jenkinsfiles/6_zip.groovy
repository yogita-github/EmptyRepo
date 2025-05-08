pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Your build steps, e.g., running a batch file
                bat 'scripts/zip.bat'
            }
        }
    }

    post {
        always {
            // Archive the build artifacts after the job completes
            archiveArtifacts artifacts: 'build/**/*', allowEmptyArchive: true
        }
    }
}

