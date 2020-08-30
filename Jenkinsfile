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

  sh './gradlew clean '
sh './gradlew assemble'
  
   
  
 }
  }
 
 }
  
stage('SonarQube analysis') {
 
  steps{ def scannerHome = tool name: 'sonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
   
    withSonarQubeEnv('sonar-6')
 { // Will pick the global server connection you have configured
    
  sh '${scannerHome}/bin/sonar-scanner'

  

   
 }
   }
  }
  
 
  
 }
 }
 
