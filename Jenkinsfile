#!groovy
build('swagger-webhook-events', 'docker-host') {
    checkoutRepo()
    loadBuildUtils()

    runStage('Build swagger') {
        sh "make build"
    }

    def javaLibPipeline
    runStage('load JavaLib pipeline') {
        javaLibPipeline = load("build_utils/jenkins_lib/pipeJavaLib.groovy")
    }

    def buildImageTag = "4799280a02cb73761a3ba3641285aac8ec4ec482"
    javaLibPipeline(buildImageTag)
}
