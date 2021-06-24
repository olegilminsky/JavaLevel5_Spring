package com.olegilminsky;

import org.springframework.stereotype.Component;

@Component
public class BlackAndWhiteCameraRoll implements CameraRoll{
    @Override
    public void processing() {
        System.out.println("-1 black and white frame");
    }
}
