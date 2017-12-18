#!groovy

def runTest() {
    node {
        stage("checkout") {
            checkout scm
        }
        stage("test") {
            docker.image("node:7.10.0").inside {
                sh "npm install && ./node_modules/.bin/magellan --config magellan.json --profile $PROFILE  --test tests/demo-app.js --max_workers $WORKERS --max_test_attempts 1"
            }
        }
    }
}

timestamps {
	runTest()
}
