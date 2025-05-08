pipeline {
    agent any
    
    stages {
        stage('Email') {
            steps {
                // Execute the batch file to send the email
                bat 'scripts\\email.bat'
            }
        }
    }
}
