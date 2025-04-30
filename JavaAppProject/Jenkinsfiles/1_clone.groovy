pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                // Use the correct branch (main)
                git branch: 'master', url: 'https://github.com/yogita-github/EmptyRepo.git'
            }
        }
        // Add more stages for build, test, etc.
    }
}

