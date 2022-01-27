package com.nzt.b2d.factories;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;


public class B2dShapeFactory {

    public static PolygonShape rectangle(Rectangle rect) {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
        return shape;
    }

    public static PolygonShape polygon(Polygon polygon) {
        PolygonShape shape = new PolygonShape();
        shape.set(polygon.getTransformedVertices());
        return shape;
    }

    public static CircleShape circle(Circle circle) {
        return circle(circle.radius);
    }

    public static CircleShape circle(float radius) {
        CircleShape shape = new CircleShape();
        shape.setRadius(radius);
        return shape;
    }
}
