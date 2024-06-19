package com.adepuu.bangjagobackend.config.grpc;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.java.Log;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;

/**
 * Example {@link ServerInterceptor} that logs all called methods. In this example it is added to Spring's application
 * context via {@link GlobalInterceptorConfiguration}, but is also possible to directly annotate this class with
 * {@link GrpcGlobalServerInterceptor}.
 */
// @GrpcGlobalServerInterceptor
@Log
public class LogGrpcInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> serverCall,
            Metadata metadata,
            ServerCallHandler<ReqT, RespT> serverCallHandler) {

        log.info(serverCall.getMethodDescriptor().getFullMethodName());
        return serverCallHandler.startCall(serverCall, metadata);
    }

}