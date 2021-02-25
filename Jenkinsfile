pipeline {
    agent any
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage("git pull"){
            steps{
                git 'https://github.com/punitGour/storeData.git'
            }
        }
        
         stage('Build') {
               steps {
      
                 //Run Maven on a Unix agent.
                 sh "mvn -Dmaven.test.failure.ignore=true clean install"
            }
         }
         
          stage('coverage') {
 				 steps {
					jacoco( 
      execPattern: 'target/*.exec',
      classPattern: 'target/classes',
      sourcePattern: 'src/main/java',
      exclusionPattern: 'src/test*'
)
					
				 }
			}
         
            stage('Sonarqube') {
					environment {
						scannerHome = tool 'sonar-scanner'
					}
					steps {
						withSonarQubeEnv('sonarqube') {
							sh "${scannerHome}/bin/sonar-scanner"
						}
						
						sleep(60)
						
						
						timeout(time: 10, unit: 'MINUTES') {
							waitForQualityGate abortPipeline: true
						}
					}
				}
				
    }

         post {
                success {
                    publishCoverage adapters: [jacocoAdapter('target/site/jacoco/jacoco.xml')]
                    
                }
             }
}
