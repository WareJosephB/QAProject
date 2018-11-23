pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
		sh "cd 'Java EE'"
                sh "mvn clean"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Build and Deploy') {
            steps {
                sh "mvn install"
		sh "cp /var/lib/jenkins/workspace/ELO/'Java EE'/target/MultiplayerELO.war /home/ware_josephb/wildfly/standalone/deployments"
            }
        }
    }
}