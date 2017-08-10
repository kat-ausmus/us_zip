package com.cosmos.service

import com.cosmos.pogo.BirthCountForZip
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BirthCountService {
    @Autowired
    LatLongService latLongService

    def getBirthCount(String zip, String date) {
        Integer randomNumber = new Random().nextInt(999) + 1;
        def location = latLongService.getLatLongForZip(zip)

        return new BirthCountForZip(
                chosenDate: date,
                count: randomNumber,
                latitude: location.latitude,
                longitude: location.longitude
        )
    }
}
