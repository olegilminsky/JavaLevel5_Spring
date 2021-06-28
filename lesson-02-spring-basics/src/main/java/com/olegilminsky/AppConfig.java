package com.olegilminsky;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.olegilminsky")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Camera camera(CameraRoll cameraRoll) {
        return new Camera(cameraRoll);
    }
}
