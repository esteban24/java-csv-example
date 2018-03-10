!#groovy

@Library(['shared-lib@master', 'pipeline-library@master']) _

node ("master") {

	timestamps {
		def repo = "https://github.com/esteban24/java-csv-example.git"

		checkout changelog: false, poll: false, scm: [
			$class: 'GitSCM', branches: [[name: "master"]], userRemoteConfigs: [[url: repo]]]

		log.info("Checkout completed sucessfully")

		withEnv(["PATH+MAVEN=${tool name: '3.5.2', type: 'maven'}/bin",
		"JAVA_HOME=${tool name: 'open-jdk-8', type: 'jdk'}"]) {
			sh "env && mvn clean package"
		}

		log.info("Command mvn clean package completed sucessfully")

		if(infra.isTrusted()) {
			log.info("Trusted Jenkins!!!")
		} else {
			log.warning("Jenkins not trusted!!!")
		}

		archive "**/*.hpi"
	}
}