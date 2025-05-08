pipeline {
    agent any
    stages {
        stage('Cleanup') {
            steps {
                bat 'scripts\\cleanup.bat'
            }
        }
    }
}
