pipeline {
    agent any

    parameters {
        choice(name: 'browser', choices: ['chrome', 'firefox'], description: 'Pick browser')
        choice(name: 'threads', choices: ['1', '2', '3'], description: 'Pick threads amount')
    }

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
                bat 'mvn clean -DsuiteXmlFile=ui_testng.xml -Dbrowser=%browser% -DthreadCount=%threads% test'
                //sh 'mvn clean -DsuiteXmlFile=unit_testng.xml -Dbrowser=$browser -DthreadCount=$threads test'
                //sh 'mvn clean -DsuiteXmlFile=unit_testng.xml -Dbrowser=${browser} -DthreadCount=${threads} test'
            }
        }
    }
    post {
        always {
            script {
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
