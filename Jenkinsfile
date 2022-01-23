   
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
                    sleep 80
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
	    stage('nexus') {
            steps {
                nexusPublisher nexusInstanceId: 'test-repo',
                nexusRepositoryId: 'test-repo',
                packages: [
                    [
                        $class: 'MavenPackage',
                        mavenAssetList: [
                            [classifier: '', extension: '', filePath: 'build/libs/DevOpsUsach2020-0.0.1.jar']
                        ],
                        mavenCoordinate: [
                            artifactId: 'DevOpsUsach2020',
                            groupId: 'com.devopsusach2020',
                            packaging: 'jar',
                            version: '0.0.1'
                        ]
                    ]
                ]
            }
        }
	}
}














