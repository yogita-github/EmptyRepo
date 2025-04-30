pipeline {
    agent any
    stages {
        stage('Clone') { steps { build job: '1_Clone' } }
        stage('Build') { steps { build job: '2_Build' } }
        stage('Test') { steps { build job: '3_Test' } }
        stage('Package') { steps { build job: '4_Package' } }
        stage('Run') { steps { build job: '5_Run' } }
        stage('Zip') { steps { build job: '6_Zip' } }
        stage('Cleanup') { steps { build job: '7_Cleanup' } }
        stage('Email') { steps { build job: '8_Email' } }
    }
}
