pipeline {
    agent any
    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }
        stage('Zip') {
            steps {
                bat 'scripts/zip.bat'  // Run your batch script to directly zip files
            }
        }
    }
}

