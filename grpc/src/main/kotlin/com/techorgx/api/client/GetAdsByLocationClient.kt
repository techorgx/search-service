package com.techorgx.api.client

import com.techorgx.ads.api.v1.AdsApiGrpcKt
import com.techorgx.ads.api.v1.GetAdsByLocationRequest
import com.techorgx.ads.api.v1.GetAdsByLocationResponse
import com.techorgx.api.common.DownstreamService
import io.grpc.ManagedChannelBuilder
import org.springframework.stereotype.Component
import io.grpc.Context
import io.grpc.Metadata

@Component
class GetAdsByLocationClient(
) : BaseClient<GetAdsByLocationRequest, GetAdsByLocationResponse>(DownstreamService.AD) {
    private val adServiceGrpcClient: AdsApiGrpcKt.AdsApiCoroutineStub =
        AdsApiGrpcKt.AdsApiCoroutineStub(ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build(),)

    override suspend fun call(request: GetAdsByLocationRequest): GetAdsByLocationResponse {
        val stub = adServiceGrpcClient
            .withDeadlineAfter(1000, java.util.concurrent.TimeUnit.MILLISECONDS)

        return stub.getAdsByLocation(request)
    }
}
