pipeline {
  agent {
    docker { image 'maven:3.5.3-jdk-8-alpine'}
  }
  stages {
    stage('Build') {
      steps {
        echo 'build'
        sh 'node --version'
      }
    }
    stage('Test') {
      steps {
        echo 'test'
      }
    }
  }
}