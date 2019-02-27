pipeline{
agent any
tools{
maven 'Maven'
}

stages{
stage('Build'){
steps{
  bat 'mvn clean compile'
  }
}

stage('test stage'){
steps{
  bat 'mvn test'
}
}

stage('Deploy stage'){
steps{
  bat 'mvn package'
}
}

}
}

