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
        // Define environment variables (optional)
        MAVEN_OPTS = '-Xmx1024m'
    }

    stages {
            stage('Checkout') {
                steps {
                    // Clone the Git repository
                    git 'https://github.com/EsmaeilChitgar/spring-jenkinsfile.git'
                }
            }
            
            stage('Build') {
                steps {
                    echo 'Start building...'
                    bat 'mvn -Dmaven.test.failure.ignore=true clean install'
                }
            }
            
            stage('Test') {
                steps {
                    echo 'Start testing...'
                    bat 'mvn clean test'
//                     bat 'dir target\\surefire-reports'
                }
//
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
        // Cleanup, or notifications at the end of the pipeline
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
