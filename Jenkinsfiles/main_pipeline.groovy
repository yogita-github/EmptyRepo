pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                echo 'Triggering Job-1 - Clone'
                build job: 'Job-1-Clone', wait: true
            }
        }

        stage('Build') {
            steps {
                echo 'Triggering Job-2 - Build'
                build job: 'Job-2-Build', wait: true
            }
        }

        stage('Test') {
            steps {
                echo 'Triggering Job-3 - Test'
                build job: 'Job-3-Test', wait: true
            }
        }

        stage('Package') {
            steps {
                echo 'Triggering Job-4 - Package'
                build job: 'Job-4-Package', wait: true
            }
        }

        stage('Run') {
            steps {
                echo 'Triggering Job-5 - Run'
                script {
                    try {
                        build job: 'Job-5-Run', wait: true
                    } catch (Exception e) {
                        echo "Job-5-Run failed, but continuing with next jobs."
                    }
                }
            }
        }

        stage('Zip') {
            steps {
                echo 'Triggering Job-6 - Zip'
                build job: 'Job-6-Zip', wait: true
            }
        }

        stage('Cleanup') {
            steps {
                echo 'Triggering Job-7 - Cleanup'
                build job: 'Job-7-Cleanup', wait: true
            }
        }

        stage('Email') {
            steps {
                echo 'Triggering Job-8 - Email'
                build job: 'Job-8-Email', wait: true
            }
        }
    }

    post {
        always {
            echo 'Main pipeline execution completed!'
        }
    }
}
