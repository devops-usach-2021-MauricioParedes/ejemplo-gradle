pipeline {

	agent any

	parameters {
  		choice choices: ['gradle', 'maven'], description: 'Indicar herramienta de contrucción', name: 'buildTool'
	}	

	stages{
		stage('Pipeline'){
			steps{
				script{
					println 'Pipeline'
					println params.buildTool
					
					if(params.buildTool=='gradle'){
					    println 'Ejecutar gradle'
						def ejecucion=load 'gradle.groovy'
						ejecucion.call()
					}
					else{
					    println 'Ejecutar maven'
						def ejecucion=load 'maven.groovy'
						ejecucion.call()

					}

					
				}
			}

		}
		
    }
}






























