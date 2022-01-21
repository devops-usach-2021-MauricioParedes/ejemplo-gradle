   
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
				}
			}
		}
		stage('Test'){
			steps{
				script{
					println "Stage: ${env.STAGE_NAME}"
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














