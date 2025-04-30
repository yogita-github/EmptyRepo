pipeline {
    agent any
    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/YourUsername/JavaApp.git'
                echo '✅ Code cloned.'
            }
        }
    }
}
