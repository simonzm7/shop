@Library('ceiba-jenkins-library@master') _
pipeline{

    agent {
        label 'Slave_Induccion'
    }

	
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
    }
	
    environment {
        PROJECT_PATH_BACK = './microservice'
        BRANCH_NAME = 'develop'
        PROJECT_PATH_FRONT = './microservice/shop-angular'
    }
	
    triggers {
        pollSCM('@daily')
    }
	
    tools {
        jdk 'JDK11_Centos'
    }

    stages{

        stage('Checkout') {
            steps {
                echo '------------>Checkout from Git Microservice<------------'
                gitCheckout(
                    urlProject:'https://github.com/simonzm7/shop.git',
                    branchProject: "${BRANCH_NAME}",
                )

                dir("${PROJECT_PATH_BACK}"){
                    sh './gradlew clean'
                }
            }
        }

		stage('Frontend - Install'){
			steps {
				echo "------------>Installation<------------"
                    dir("${PROJECT_PATH_FRONT}"){
                        sh 'npm i'
                    }		
			}
		}

        stage('Unit Testing'){
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
                
                stage('Test- Frontend'){
                    steps {
                        echo '------------>Test Frontend<------------'
                        dir("${PROJECT_PATH_FRONT}"){
                            sh 'npm run test'
                        }
                    }
                }
                
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
                stage('Frontend Build'){
                    steps{
                        echo "------------>Frontend Compilation<------------"
                        dir("${PROJECT_PATH_FRONT}"){
                            sh 'npm run build'
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
                    sh "${env.SONARSCANNER} -Dsonar.projectKey=co.com.ceiba.adn:shop-juan.monsalve.${BRANCH_NAME} -Dsonar.projectName=CeibaADN-Shop.${BRANCH_NAME} -Dproject.settings=./sonar-project.properties"
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