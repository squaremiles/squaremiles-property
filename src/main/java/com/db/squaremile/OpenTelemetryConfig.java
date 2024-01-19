package com.db.squaremile;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.DefaultNewSpanParser;
import io.micrometer.tracing.annotation.ImperativeMethodInvocationProcessor;
import io.micrometer.tracing.annotation.MethodInvocationProcessor;
import io.micrometer.tracing.annotation.NewSpanParser;
import io.micrometer.tracing.annotation.SpanAspect;

import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.extension.trace.propagation.JaegerPropagator;

@Configuration(proxyBeanMethods = false)
public class OpenTelemetryConfig {
	/*
	 * @Bean public TextMapPropagator jaegerPropagator() { return
	 * JaegerPropagator.getInstance(); }
	 * 
	 * @Bean NewSpanParser newSpanParser() { return new DefaultNewSpanParser(); }
	 * 
	 * @Bean MethodInvocationProcessor methodInvocationProcessor( NewSpanParser
	 * newSpanParser, Tracer tracer, BeanFactory beanFactory) { return new
	 * ImperativeMethodInvocationProcessor( newSpanParser, tracer,
	 * beanFactory::getBean, beanFactory::getBean); }
	 * 
	 * @Bean SpanAspect spanAspect(MethodInvocationProcessor
	 * methodInvocationProcessor) { return new
	 * SpanAspect(methodInvocationProcessor); }
	 */
	
	/*
	 * @Bean OtlpHttpSpanExporter
	 * otlpHttpSpanExporter(@Value("${management.otlp.tracing.endpoint}") String
	 * url) { return OtlpHttpSpanExporter.builder() .setEndpoint(url) .build(); }
	 */
	
	/*
	 * @Bean OpenTelemetry openTelemetry(SdkLoggerProvider sdkLoggerProvider,
	 * SdkTracerProvider sdkTracerProvider, ContextPropagators contextPropagators) {
	 * OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
	 * .setLoggerProvider(sdkLoggerProvider) .setTracerProvider(sdkTracerProvider)
	 * .setPropagators(contextPropagators) .build();
	 * OpenTelemetryAppender.install(openTelemetrySdk); return openTelemetrySdk; }
	 * 
	 * @Bean SdkLoggerProvider otelSdkLoggerProvider(Environment environment,
	 * ObjectProvider<LogRecordProcessor> logRecordProcessors) { String
	 * applicationName = environment.getProperty("spring.application.name",
	 * "application"); Resource springResource =
	 * Resource.create(Attributes.of(ResourceAttributes.SERVICE_NAME,
	 * applicationName)); SdkLoggerProviderBuilder builder =
	 * SdkLoggerProvider.builder()
	 * .setResource(Resource.getDefault().merge(springResource));
	 * logRecordProcessors.orderedStream().forEach(builder::addLogRecordProcessor);
	 * return builder.build(); }
	 * 
	 * @Bean LogRecordProcessor otelLogRecordProcessor() { return
	 * BatchLogRecordProcessor .builder( OtlpGrpcLogRecordExporter.builder()
	 * .setEndpoint("http://localhost:4317") .build()) .build(); }
	 */

}
