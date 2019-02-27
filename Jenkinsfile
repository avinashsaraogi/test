pipeline{
agent any
stages{
stage('Build'){
steps{
  bat label: '', script: 'mvn clean compile package'
  }
}
}
stage('test stage'){
steps{
  bat label: '', script: 'mvn test'
}
}
}

