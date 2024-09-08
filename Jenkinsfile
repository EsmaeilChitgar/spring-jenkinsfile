pipeline {
    agent any

    options {
        skipStagesAfterUnstable()
    }

    tools {
        maven "Maven 3.9.8"
        jdk 'JDK 17'
    }

    environment {
        MAVEN_OPTS = '-Xmx1024m'
    }

    stages {
            stage('Version Check') {
                steps {
                    echo 'Checking Java version...'
                    bat 'java -version'

                    echo 'Checking Maven version...'
                    bat 'mvn -v'

                    echo 'Checking Git version...'
                    bat 'git --version'
                }
            }

            stage('Checkout') {
                steps {
                    git 'https://github.com/EsmaeilChitgar/spring-jenkinsfile.git'
                }
            }

            stage('Build') {
                steps {
                    echo 'Start building...'
                    bat 'mvn clean install -DskipTests'
                }
            }

            stage('Test') {
                steps {
                    echo 'Start testing...'
                    bat 'mvn -Dmaven.test.failure.ignore=true test'
                }

//                 post {
//                     always {
//                          junit 'target/surefire-reports/*.xml'
//                     }
//                 }
            }

            stage('Deploy') {
                steps {
                    echo 'Start processing deploy.bat'
                    bat './jenkins/scripts/deploy.bat'
                }
            }
        }

    post {
        always {
            echo 'Pipeline completed!'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}