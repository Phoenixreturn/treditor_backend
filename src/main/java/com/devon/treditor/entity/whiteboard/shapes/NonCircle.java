package com.devon.treditor.entity.whiteboard.shapes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class NonCircle extends Shape {
    private int width;
    private int height;
}