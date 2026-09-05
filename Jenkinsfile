#!/user/bin/env groovy

// when imported globaly Library
//@Library('jenkins-shared-library')

// Reference the Library directly in Jenkinsfile
library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/aagargoura/jenkins-shared-library.git',
    credentialsId: 'github-user-pwd-credentials'])

def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('build and push image') {
            steps {
                script {
                    buildImage 'aagargoura/demo-app:jma-4.0'
                    dockerLogin()
                    dockerPush 'aagargoura/demo-app:jma-4.0'
                }
            }
        }
        stage('testing') {
            steps {
                script {
                   gv.executeTests()
                }
            }
        }
        stage('deploy') {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}