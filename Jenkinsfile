   
pipeline {

	agent any

	stages{
		stage('Build & Unit Test'){
			steps{
				script{
				    sh 'env'
                    sh './gradlew clean build'
					println "Stage: ${env.STAGE_NAME}"
				}
			}
		}
		stage('Sonar'){
			steps{
				script{
                def scannerHome = tool 'sonar-scanner';
                withSonarQubeEnv('sonar-server') {
                sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build -Dsonar.sources=src"
                }
            }
			}
		}
		stage('Run'){
			steps{
				script{
					println "Stage: ${env.STAGE_NAME}"
                    sh "nohup bash gradlew bootRun & "
                    sleep 40
				}
			}
		}
		stage('Test'){
			steps{
				script{
					println "Stage: ${env.STAGE_NAME}"
                    sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
				}
			}
		}
		stage('Nexus'){
			steps{
				script{
					println "Stage: ${env.STAGE_NAME}"
				}
			}
		}
	}
}














