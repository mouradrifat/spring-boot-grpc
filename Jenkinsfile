pipeline {

    agent any
    tools{
        maven "maven3"
    }

    stages {

        stage('check out the code from github') {
            steps {
              git branch: 'develop', url: 'https://github.com/mouradrifat/spring-boot-grpc.git';
            }
        }
        stage('Build the artifact') {
            steps{
                sh "mvn clean install"
            }
        }

        stage('deploy the artifact to nexu'){
            steps{
                sh "mvn deploy:deploy-file \
                  -DgroupId=org.mandm.grpc \
                  -DartifactId=grpc.service \
                  -Dversion=1.0.0-SNAPSHOT \
                  -Dpackaging=jar \
                  -DrepositoryId=Nexus \
                  -Dfile=/var/jenkins_home/workspace/pipeline-1/target/grpc.service-1.0-SNAPSHOT.jar \
                  -Durl=http://172.18.0.2:8081/repository/maven-snapshots/"
            }
        }

    }

}
