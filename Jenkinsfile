pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/group6Lesson3.git/'
            }
        }
        stage('Unit tests') {
            steps {
                bat 'mvn clean -DsuiteXmlFile=unit_testng.xml test'
                //sh 'mvn clean -DsuiteXmlFile=unit_testng.xml test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deployed'
            }
        }
        stage('UI tests') {
            steps {
                bat 'mvn clean -DsuiteXmlFile=ui_testng.xml test'
                //sh 'mvn clean -DsuiteXmlFile=unit_testng.xml test'
            }
        }
    }
}
