package com.techorgx.api.mapper

import com.techorgx.ads.api.v1.GetAdsByLocationResponse
import com.techorgx.search.api.v1.Ad
import com.techorgx.search.api.v1.SearchAdsByLocationResponse
import org.springframework.stereotype.Component
import com.techorgx.ads.api.v1.Ad as AdProto

@Component
class AdsProtoMapper {
    fun map(getAdsByLocationRequest: GetAdsByLocationResponse): SearchAdsByLocationResponse {
        val ads = mutableListOf<Ad>()

        getAdsByLocationRequest.adsList.forEach {
            ads.add(mapAd(it))
        }
        return SearchAdsByLocationResponse
            .newBuilder()
            .addAllAds(ads)
            .build()
    }

    private fun mapAd(ad: AdProto): Ad {
        return Ad
            .newBuilder()
            .setId(ad.id)
            .setTitle(ad.title)
            .setDescription(ad.description)
            .setPrice(ad.price)
            .setLocation(ad.location)
            .build()
    }
}
