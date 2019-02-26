pipeline{
stages{
stage('compile stage'){
steps{
  withMaven('maven:Maven'){
  sh 'mvn clean compile'
  }
}
}
stage('test stage'){
steps{
  withMaven('maven:Maven'){
  sh 'mvn test'
  }
}
}
}
}
