pipeline{
agent any
stages{
stage('Build'){
steps{
  withMaven(maven:'Maven'){
  bat 'mvn clean compile'
  }
}
}
stage('test stage'){
steps{
  withMaven(maven:'Maven'){
  bat 'mvn test'
  }
}
}
}
}
