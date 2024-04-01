package com.techorgx.api.service

import com.techorgx.ads.api.v1.GetAdsByLocationRequest
import com.techorgx.api.client.GetAdsByLocationClient
import com.techorgx.api.mapper.AdsProtoMapper
import com.techorgx.search.api.v1.SearchAdsByLocationRequest
import com.techorgx.search.api.v1.SearchAdsByLocationResponse
import org.springframework.stereotype.Service
import io.grpc.Context
import io.grpc.Metadata

@Service
class SearchService(
    private val getAdsByLocationClient: GetAdsByLocationClient,
    private val adsProtoMapper: AdsProtoMapper,
) {
    suspend fun searchAdByLocation(request: SearchAdsByLocationRequest): SearchAdsByLocationResponse {
        val contextWithMetadata = Context.current().withValue( Context.key("client_id"), "test")
        val getAdsByLocationRequest: GetAdsByLocationRequest =
            GetAdsByLocationRequest
                .newBuilder()
                .setLocation(request.location)
                .build()
        return adsProtoMapper.map(getAdsByLocationClient.retrieve(getAdsByLocationRequest).getOrThrow())
    }
}
