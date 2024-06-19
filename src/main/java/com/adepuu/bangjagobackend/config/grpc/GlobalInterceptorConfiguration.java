package com.adepuu.bangjagobackend.config.grpc;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * Example configuration class that adds a {@link ServerInterceptor} to the global interceptor list.
 */
@Configuration(proxyBeanMethods = false)
public class GlobalInterceptorConfiguration {

    /**
     * Creates a new {@link LogGrpcInterceptor} bean and adds it to the global interceptor list. As an alternative you
     * can directly annotate the {@code LogGrpcInterceptor} class and it will automatically be picked up by spring's
     * classpath scanning.
     *
     * @return The newly created bean.
     */
    @GrpcGlobalServerInterceptor
    LogGrpcInterceptor logServerInterceptor() {
        return new LogGrpcInterceptor();
    }

}