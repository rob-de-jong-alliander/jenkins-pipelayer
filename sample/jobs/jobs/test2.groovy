#!/usr/bin/env groovy

pipeline {
    agent {
        any
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
    }
    stages {
        stage('Test') {
            steps {
                sh 'echo test'
            }
        }
        stage2('Test2') {
            steps {
                sh 'echo test2'
            }
        }
    }
}