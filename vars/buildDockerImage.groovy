#! /usr/bin/env groovy

def call(String appName, String version) {
    withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t $appName:$version ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $appName:$version"
    }
}
