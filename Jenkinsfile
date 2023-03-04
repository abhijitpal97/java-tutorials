pipeline {

    agent any
    tools {
        maven 'maven_3_8_5' 
    }
    stages {
			stage('Sonar Analysis')	 
	    {
		    steps{
                      script{
                      withSonarQubeEnv('sonarqube') { 
                      bat "mvn sonar:sonar"
                       }
                  }
                }  
              
	    }
	    
        stage('Compile stage') {
            steps {
                bat "mvn package" 
        }
    }	    

         stage('testing stage') {
             steps {
                bat "mvn test"
	     }
	 }
	    
	stage('email notification') {
             steps {
                mail bcc: '', body: '''Hi 
                Welcome to Jenkins alert services.''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job Update', to: 'abhijitpal97@yahoo.co.in'
	     }
	 }
  }

}
