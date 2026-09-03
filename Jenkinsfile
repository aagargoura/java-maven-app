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
                   gv.buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                   gv.buildImage()
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
                    BRANCHE_NAME == "main"
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