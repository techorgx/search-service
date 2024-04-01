package com.techorgx.api.grpc

import com.techorgx.api.service.SearchService
import com.techorgx.search.api.v1.SearchAdsByLocationRequest
import com.techorgx.search.api.v1.SearchAdsByLocationResponse
import com.techorgx.search.api.v1.SearchApiGrpcKt
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SearchApi(
    private val searchService: SearchService,
) : SearchApiGrpcKt.SearchApiCoroutineImplBase() {
    override suspend fun searchAdsByLocation(request: SearchAdsByLocationRequest): SearchAdsByLocationResponse {
        return searchService.searchAdByLocation(request)
    }
}
