package ru.test.project.config;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public AutoJsonRpcServiceImplExporter createExporter(){
        return new AutoJsonRpcServiceImplExporter();
    }

}
