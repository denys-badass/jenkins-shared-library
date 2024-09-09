#! /usr/bin/env groovy

def call(String repoUrl, String branch) {
    def workingDir = "${env.WORKSPACE}"
    sh "git clone ${repoUrl} ${workingDir}"
    sh "git switch ${branch}"
    return workingDir
}

