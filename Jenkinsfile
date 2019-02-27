pipeline{
agent any
stages{
stage('Build'){
steps{
  withMaven(maven:'Maven'){
  bat label: '', script: 'mvn clean compile'
  }
}
}
stage('test stage'){
steps{
  withMaven(maven:'Maven'){
  bat label: '', script: 'mvn test'
  }
}
}
}
}
