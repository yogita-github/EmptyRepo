pipeline {
    agent any
    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }
        stage('Debug') {
            steps {
                script {
                    echo "Listing workspace contents:"
                    bat 'dir'  // This will list the contents of the current directory in the workspace.
                }
            }
        }
        stage('Zip') {
            steps {
                bat 'scripts/zip.bat'  // Run your batch script after verifying directories
            }
        }
    }
}

