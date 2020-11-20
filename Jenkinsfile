pipeline {
    agent any

    parameters {
        choice(name: 'browser', choices: ['chrome', 'firefox'], description: 'Pick browser')
        choice(name: 'threads', choices: ['1', '2', '3'], description: 'Pick threads amount')
        choice(name: 'dp', choices: ['smoke', 'regression'], description: 'Pick data provider')
    }

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/group6Lesson3.git'
                bat 'git checkout jenkins'
            }
        }
        stage('Unit tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=testng6.xml test'
            }
        }
        stage('Deploy') {
            steps{
                echo 'Deployed'
            }
        }
        stage('UI tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=testng13.xml -Dbrowser=%params.browser% test'
            }
        }
    }
    post {
        always{
            script{
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
}