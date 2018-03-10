@Library(['shared-lib@master', 'pipeline-library@master']) _

node ("master") {
	def repo = "https://github.com/esteban24/java-csv-example.git"

	checkout changelog: false, poll: false, scm: [
		$class: 'GitSCM', branches: [[name: "master"]], userRemoteConfigs: [[url: repo]]]

	withEnv(["PATH+MAVEN=${tool name: '3.5.2', type: 'maven'}/bin",
	"JAVA_HOME=${tool name: 'open-jdk-8', type: 'jdk'}"]) {
		sh "env && mvn clean package"
	}

	if(infra.isTrusted()) {
		echo "Trusted Jenkins!!!"
	}

	archive "**/*.hpi"
}