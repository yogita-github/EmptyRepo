pipeline {
    agent any
    stages {
        stage('Package') {
            steps {
                bat 'scripts/package.bat'
            }
        }
    }
}

