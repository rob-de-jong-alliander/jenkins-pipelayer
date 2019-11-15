#!/usr/bin/env groovy

freeStyleJob('example') {
    logRotator(-1, 10)
    scm {
        github('jenkinsci/job-dsl-plugin', 'master')
    }
    triggers {
        gitlabPush {
            buildOnMergeRequestEvents(false)
            buildOnPushEvents(false)
            enableCiSkip(false)
            setBuildDescription(false)
            rebuildOpenMergeRequest('never')
            includeBranches('include1,include2')
            excludeBranches('exclude1,exclude2')
        }
    }
    steps {
        gradle('clean build')
    }
    publishers {
        archiveArtifacts('job-dsl-plugin/build/libs/job-dsl.hpi')
    }
}