node ("master") {
	def repo = "https://github.com/esteban24/java-csv-example.git"

	checkout changelog: false, poll: false, scm: [
		$class: 'GitSCM', branches: [[name: "master"]], userRemoteConfigs: [[url: repo]]]
	]

	withEnv(["PATH+MAVEN=${tool name: '3.5.2', type: 'maven'}/bin",
	"JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/jre"]) {
		sh "env && mvn clean package"
	}

	archive "**/*.hpi"
}