package com.cosmos.controller

import com.cosmos.service.BirthCountService
import com.cosmos.service.LatLongService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BirthController {
    @Autowired
    LatLongService latLongService

    @Autowired
    BirthCountService birthCountService

    @GetMapping(value = "/ping")
    String ping() {
        return "{ 'msg': 'US Zip ping data endpoint is running.' }"
    }

    @GetMapping(value = "/latlong/{postalCode}")
    def getLatLong(
            @PathVariable
            final String postalCode
    ) {
        return latLongService.getLatLongForZip(postalCode)
    }

    @GetMapping(value = "/latlong/{postalCode}/birthcount/{date}")
    def getBirthCount(
            @PathVariable
            final String postalCode,
            @PathVariable
            final String date
    ) {
        return birthCountService.getBirthCount(postalCode, date)
    }
}
