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
  
stage('SonarQube analysis') {
 
  steps{ 
   
    withSonarQubeEnv('sonar-6')
 { // Will pick the global server connection you have configured
    
 sh './gradlew build '

  

   
 }
   }
  }
  
 stage('Tomcat-Server')
 {
   steps{

deploy adapters: [tomcat9(credentialsId: 'alora', path: '', url: 'http://localhost:5050')], contextPath: 'spank', war: '**/*.war'   }
   
   }
  
  
 stage('Build Docker Image'){
 sh 'docker build -t amindevops/devops-pipeline:1.0.0'
 }
 
 stage('Push Docker Image'){
 withCredentials([string(credentialsId: 'docker-pwd', variable: 'DockerHubPwd')]) {
  sh 'docker login -u amindevops -p ${DockerHubPwd}'
 
 }
  sh 'docker push amindevops/devops-pipeline:1.0.0'
 }
 
 stage('Run Container '){
 
  sh 'docker run -p 8080:8080 -d  -name devops-pipeline amindevops/devops-pipeline:1.0.0 '
 }
 
  
 }
}


