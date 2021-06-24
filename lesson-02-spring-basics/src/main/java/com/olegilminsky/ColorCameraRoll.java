package com.olegilminsky;

import org.springframework.stereotype.Component;

//@Component
public class ColorCameraRoll implements CameraRoll{
    @Override
    public void processing() {
        System.out.println("-1 color frame");
    }
}
