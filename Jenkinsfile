pipeline{
agent any
stages{
stage('Build'){
steps{
  bat label: '', script: 'mvn clean compile'
  }
}

stage('test stage'){
steps{
  bat label: '', script: 'mvn test'
}
}
}
}

