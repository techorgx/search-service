package com.techorgx.api.grpc

import com.techorgx.search.api.v1.PersonRequest
import com.techorgx.search.api.v1.PersonResponse
import com.techorgx.search.api.v1.SearchApiGrpcKt
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SearchApi : SearchApiGrpcKt.SearchApiCoroutineImplBase() {
    override suspend fun getPerson(request: PersonRequest): PersonResponse {
        return super.getPerson(request)
    }
}
