pipeline {
  agent {
    docker { image 'maven:3.5.3-jdk-8-alpine'}
  }
  stages {
    stage('Test') {
      steps {
        echo 'Starting test'
        sh 'maven --version'
      }
    }
  }
}