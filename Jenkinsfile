
pipeline{
 
agent any
 
stages{ 
 
stage('SCM-Checkout'){
 
 steps{
      
git 'https://github.com/aminthabti95/trying.git'

   }
}
  
  stage('Build'){
  
steps{
  
 echo 'excecuting gradle'
 
   withGradle(){

     sh './gradlew build '  
  
        }
     }
  }
 
 stage('Selenium Test'){
 
  steps{  
  
sh './gradlew clean test'
 
    }
 }
  
stage('Sonarqube') {
    environment {
     scannerHome = tool name: 'sonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    }
    steps {
        withSonarQubeEnv('sonar-6') {
            sh '${scannerHome}/bin/sonar-scanner -v'
        }
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }
}
  
 stage('Tomcat-Server')
 {
   steps{

deploy adapters: [tomcat9(credentialsId: 'alora', path: '', url: 'http://localhost:5050')], contextPath: 'spank', war: '**/*.war'   }
   
   }
  
  stage('Build Docker Image'){
 
    steps{
   
       sh 'docker build -t amindevops/devops-pipeline:1.0.0 .   '
          }
     }
 
 stage('Push Docker Image'){
     steps{
       withCredentials([string(credentialsId: 'docker-pwd', variable: 'DockerHubPwd')]) {
            sh 'docker login -u amindevops -p ${DockerHubPwd}'
           }
          sh 'docker push amindevops/devops-pipeline:1.0.0'
         }
      }
 stage('Run Container '){
     steps{
       sh 'docker run -p 8080:8080 -d --name devopspipelineon  amindevops/devops-pipeline:1.0.0 '
      }
    }
 
 
 
 
 }
}


