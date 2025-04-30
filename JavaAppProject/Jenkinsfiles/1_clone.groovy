pipeline {
    agent any
    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/yogita-github/EmptyRepo.git'
                echo '✅ Code cloned.'
            }
        }
    }
}
