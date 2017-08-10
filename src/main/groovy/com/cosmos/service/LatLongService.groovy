package com.cosmos.service

import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

@Service
class LatLongService {
    @Autowired
    private ResourceLoader resourceLoader
    static JsonSlurper jsonSlurper = new JsonSlurper()
    static def zipToLatLongList

    void init() {
        zipToLatLongList = jsonSlurper.parse(loadJSON('data/zipLatLong.json'))
    }

    def getLatLongForZip(String zipCode) {
        if (!zipToLatLongList) {
            init()
        }
        return zipCode ? zipToLatLongList.find { it.zip.contains(zipCode) } : zipToLatLongList
    }

    private File loadJSON(String filename) {
        return resourceLoader.getResource("classpath:${filename}").file
    }
}