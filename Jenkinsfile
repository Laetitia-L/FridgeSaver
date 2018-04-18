pipeline {
  agent any
  stages {
    stage('Test') {
      agent {
        docker {
          image 'maven:3.5.3-jdk-8-alpine'
          args '-v /root/.m2:/root/.m2'
        }
      }
      steps {
        echo 'Starting test'
        sh 'docker exec maven:3.5.3-jdk-8-alpine mvn --version'
      }
    }
  }
}