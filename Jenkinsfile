pipeline {
    agent any

    tools {
        // Install the Maven version configured as "Maven 3.9.8" and add it to the path.
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
                    git 'https://github.com/EsmaeilChitgar/spring-cucumber-test.git'
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
                    bat 'mvn test'
                }
            }
            
            stage('Deploy') {
                steps {
                    echo 'Start deploying...'
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
            echo 'Pipeline failed!; So cleaning project...'
            bat 'mvn clean'
        }
    }
}