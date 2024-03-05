package com.techorgx.api.grpc

import com.techorgx.search.api.v1.SearchApiGrpcKt
import com.techorgx.search.api.v1.SearchRequest
import com.techorgx.search.api.v1.SearchResponse
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SearchApi : SearchApiGrpcKt.SearchApiCoroutineImplBase() {
    override suspend fun searchAd(searchRequest: SearchRequest): SearchResponse {
        return super.searchAd(searchRequest)
    }
}
