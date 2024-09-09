#! /usr/bin/env groovy

def call() {
    echo 'Testing the application...'
    sh 'mvn test'
}
