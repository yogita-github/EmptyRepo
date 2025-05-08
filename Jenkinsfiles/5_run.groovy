pipeline {
    agent any
    stages {
        stage('Run') {
            steps {
                bat 'scripts\\run.bat'
            }
        }
    }
}
