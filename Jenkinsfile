@Library('ceiba-jenkins-library@master') _
pipeline{
	// any -> tomaria slave 5 u 8
	// Para mobile se debe especificar el slave -> {label 'Slave_Mac'}
	// Para proyectos de arus se debe tomar el slave 6 o 7 -> {label 'Slave6'} o {label 'Slave7'}
    agent any
	
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
    }
	
    environment {
        PROJECT_PATH_BACK = './microservice'
        BRANCH_NAME = 'develop'
    }
	
    triggers {
        // @yearly, @annually, @monthly, @weekly, @daily, @midnight, and @hourly o definir un intervalo ejemplo H */4 * * 1-5
        pollSCM('@daily') //define un intervalo regular en el que Jenkins debería verificar los cambios de fuente nuevos
    }
	
    tools {
        jdk 'JDK13_Centos'
    }

	
    // Parametros disponibles en jenkins
     /*parameters{
            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
            text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
            booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
            choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
            password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a passwor')
     }*/
	
    stages{

        stage('Checkout') {
            steps {
                echo '------------>Checkout from Git Microservice<------------'
                //Esta opción se usa para el checkout sencillo de un microservicio
                gitCheckout(
                    urlProject:'https://github.com/simonzm7/shop.git',
                    branchProject: "${BRANCH_NAME}",
                )

                //Esta opción se usa cuando el comun está centralizado para varios microservicios
                /*gitCheckoutWithComun(
                    urlProject:'https://github.com/simonzm7/shop/tree/develop/microservice',
                    branchProject: "${BRANCH_NAME}",
                    urlComun: 'https://github.com/simonzm7/shop/tree/develop/common'
                )*/

                dir("${PROJECT_PATH_BACK}"){
                    sh './gradlew clean'
                }
            }
        }

        stage('Unit Testing'){
            // El "parallel" es si vamos a correr los test del frontend en paralelo con los test de backend, se configura en otro stage dentro de parallel
            parallel {
                stage('Test- Backend'){
                    steps {
                        echo '------------>Test Backend<------------'
                        dir("${PROJECT_PATH_BACK}"){
                            sh './gradlew --stacktrace test'
                        }
                    }
                    post{
                        always {
                            junit '**/build/test-results/test/*.xml' //Configuración de los reportes de JUnit
                        }
                    }
                }
                /*
                stage('Test- Frontend'){
                    steps {
                        echo '------------>Test Frontend<------------'
                        dir("${PROJECT_PATH_FRONT}"){
                            // comando ejecucion test
                        }
                    }
                }
                */
            }
        }

        stage('Build'){
            parallel {
                stage('Backend Build'){
                    steps{
                        echo "------------>Backend Compilation<------------"
                        dir("${PROJECT_PATH_BACK}"){
                            sh './gradlew --stop'
                            sh './gradlew build -x test'
                        }
                    }
                }
            }
         }

        stage('Static Code Analysis') {
            environment {
                SONARSCANNER = "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
            }
            steps{
                echo '------------>Static Code Analysis<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${env.SONARSCANNER} -Dsonar.projectKey=${BRANCH_NAME} -Dsonar.projectName=${BRANCH_NAME} -Dproject.settings=./sonar-project.properties"
                }
                echo '------------>Quality Gates Checkout<------------'
                sleep 5
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
			}
        }


    }
	
    post {
        failure {
            mail(
                to: 'juan.monsalve@ceiba.com.co',
                body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
                subject: "ERROR CI: ${env.JOB_NAME}"
            )
        }
    }	
}