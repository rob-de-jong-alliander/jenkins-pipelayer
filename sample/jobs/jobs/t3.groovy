#!/usr/bin/env groovy
def myJob = freeStyleJob('SimpleJob')
myJob.with {
    description 'A Simple Job'
}