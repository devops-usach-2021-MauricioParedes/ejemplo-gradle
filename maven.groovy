def call(){
  
  stage("Compile"){ 
    
      sh " ./mvnw clean compile -e"
     
}
stage('Sonar') { 
  
      def scannerHome = tool 'sonar-scanner'; 
      withSonarQubeEnv('sonar-server') {
        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.sources=src -Dsonar.java.binaries=build "
      } 

}

stage("Test Code"){
  
  sh " ./mvnw clean test -e "
}
stage("Jar"){ 
  
  sh " ./mvnw clean package -e "
  
}
  
stage('Guardando WAR') { 
  
    archiveArtifacts 'build/*.jar'
  
}
 
stage("Nexus"){
  
  
    nexusPublisher nexusInstanceId: 'test-repo', 
    nexusRepositoryId: 'test-repo', 
    packages: [[$class: 'MavenPackage', 
    mavenAssetList: [[classifier: '', extension: '', filePath: "${WORKSPACE}/build/DevOpsUsach2020-0.0.1.jar"]], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]] }
  

stage("Run"){ 
  
    sh "nohup bash mvnw spring-boot:run &" 
    sleep 80
   
}
stage("Testing Application"){ 

    sh " curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing' "
    
}

}
return this;
