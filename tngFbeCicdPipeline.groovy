#!/usr/bin/env groovy
def call() {
  pipleline {
    agent {
	  node {
	    label 'master'
	  }
	}
    stage('Build') {
      steps {
		echo 'Run Build ...'
      }
    }
	stage('Quality Analysis') {
      parallel {
        // run Sonar Scan and Integration tests in parallel. This syntax requires Declarative Pipeline 1.2 or higher
        stage ('Integration Test') {
          agent any  //run this stage on any available agent
          steps {
            echo 'Run integration tests here...'
          }
        }
        stage('Sonar Scan') {
          agent any
          steps {
            echo 'Run Sonar Scan tests here...'
          }
        }
      }
    }	
	stage('Build and Publish Image') {
      steps {
		echo 'Run Build and Publish Image here...'
      }
    }
  }
  
  post {
    failure {
      // notify users when the Pipeline fails
      mail to: 'xliang888@hotmail.com',
          subject: "Failed Pipeline",
          body: "Something is wrong"
    }
  }
}
