pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'pwd' // Print current directory to check where you are
                sh 'ls -R' // List all files to check if scripts/build.sh is there
                sh 'chmod +x scripts/build.sh && scripts/build.sh'
            }
        }
    }
}
