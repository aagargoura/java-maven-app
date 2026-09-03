def buildJar() {
    echo 'Building the Jar...'
    sh 'mvn clean package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t aagargoura/demo-app:jma-2.1 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push aagargoura/demo-app:jma-2.1'
    }
}

def deployApp() {
    echo 'Deploying the Application'..
}

return this