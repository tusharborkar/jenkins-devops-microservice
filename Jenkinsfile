pipeline {
    agent any

    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }

    stages {
        stage('Check Environment') {
            steps {
                sh 'whoami'
                sh 'id'
                sh 'echo $PATH'
            }
        }

        stage('Build') {
            steps {
                script {
                    try {
                        sh 'mvn --version'
                        sh 'docker version || echo "Docker command failed"'
                        echo "Build stage completed successfully!"
                    } catch (Exception e) {
                        echo "Error in Build stage: ${e}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo "Running Tests..."
                // Add your test commands here
            }
        }
    }

    post {
        success {
            echo 'Build and deployment completed successfully!'
        }
        failure {
            echo 'Build failed. Check logs for details.'
        }
    }
}
