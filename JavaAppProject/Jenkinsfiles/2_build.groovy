pipeline {
    agent any
    stages {
       stage('Build') {
        steps {
            bat 'echo Building on Windows...'
            }
        }
    }
}
