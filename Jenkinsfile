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
    
 sh './gradlew clean '

  

   
 }
   }
  }
  
 stage('Tomcat-Server')
 {
   steps{

deploy adapters: [tomcat9(credentialsId: 'alora', path: '/var/lib/jenkins/workspace/dev-pipe/build/libs', url: 'http://localhost:5050/')], contextPath: 'try', war: '**/*.war'   }
   
   }
  
  
  
 }
}


