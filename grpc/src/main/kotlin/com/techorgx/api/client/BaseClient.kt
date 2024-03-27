package com.techorgx.api.client

import com.techorgx.api.common.DownstreamService
import io.grpc.StatusRuntimeException

abstract class BaseClient<in Request, Response>(
    private val downstreamService: DownstreamService
) {
    abstract suspend fun call(request: Request): Response

    suspend fun retrieve(request: Request): Result<Response> {
        val startTime = System.currentTimeMillis()
        val result = try {
            val response = call(request)
            Result.success(response)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
        val duration = System.currentTimeMillis() - startTime
        return result
    }
}
