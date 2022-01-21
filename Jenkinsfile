   
pipeline {
    agent any
    
    stages{
        stage('BuildAndTest'){
            steps{
                script{
                      echo 'BuildAndTest'
                }
                
            }
            
        }
        stage('Sonar'){
            steps{
                script{
                    
                        echo 'Sonar'
                    
                }
                
            }
            
        }
        stage('Run') {
            steps{

            script{
                echo 'Run'
                }
            }
   
            
        }
        
        
        stage('Test'){
            steps{
                script{
                   
                        echo 'Test'
                    
                }
                
            }
            
        }
        stage('Nexus'){
            steps{
                script{
                    
                     echo 'Nexus'
                    
                }
                
            }
            
        }
        
          
        
    }

}
        
       
