#!/user/bin/env groovy
@Library('jenkins-shared-library')
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
        stage('build image') {
            steps {
                script {
                    buildImage 'aagargoura/demo-app:jma-3.0'
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