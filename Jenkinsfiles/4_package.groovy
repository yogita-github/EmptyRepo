pipeline { agent any; stages { stage('Package') { steps { sh 'scripts/package.bat' } } } }
