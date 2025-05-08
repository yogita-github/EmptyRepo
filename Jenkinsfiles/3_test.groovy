// pipeline { agent any; stages { stage('Test') { steps { sh 'scripts/test.sh' } } } }
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                bat 'echo Hello from batch'
            }
        }
    }
}
