pipeline{
agent any
stages{
stage('Build'){
steps{
  withMaven(maven:'Maven'){
  sh 'mvn clean compile'
  }
}
}
stage('test stage'){
steps{
  withMaven(maven:'Maven'){
  sh 'mvn test'
  }
}
}
}
}
