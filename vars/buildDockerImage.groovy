#! /usr/bin/env groovy

def call() {
    withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t dennydobry/test-java-app:jma-1.3 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push dennydobry/test-java-app:jma-1.3'
    }
}
