pipeline { agent any; stages { stage('Zip') { steps { bat 'scripts/zip.bat' } } } }
