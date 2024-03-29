package com.nzt.b2d.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Pools;
import com.nzt.b2d.events.B2dBaseEvent;
import com.nzt.b2d.events.B2dEventsEnum;
import com.nzt.b2d.events.type.mvt.*;
import com.nzt.b2d.events.type.properties.*;

public class B2dBodyEventFactory {
    private B2dBodyEventFactory() {

    }

    private static <E extends B2dBaseEvent> E getEvent(B2dEventsEnum eventType) {
        B2dBaseEvent event;
        switch (eventType) {
            case Active:
                event = Pools.obtain(ActiveBodyEvent.class);
                break;
            case Awake:
                event = Pools.obtain(AwakeBodyEvent.class);
                break;
            case Bullet:
                event = Pools.obtain(BulletBodyEvent.class);
                break;
            case FixedRotation:
                event = Pools.obtain(FixedRotationBodyEvent.class);
                break;
            case BodyType:
                event = Pools.obtain(BodyTypeEvent.class);
                break;
            case Transform:
                event = Pools.obtain(TransformBodyEvent.class);
                break;
            case Rotation:
                event = Pools.obtain(RotationBodyEvent.class);
                break;
            case LinearVelocity:
                event = Pools.obtain(LinearVelocityEvent.class);
                break;
            case AngularVelocity:
                event = Pools.obtain(AngularVelocityEvent.class);
                break;
            case AngularImpulse:
                event = Pools.obtain(AngularImpulseBodyEvent.class);
                break;
            case AngularDamping:
                event = Pools.obtain(AngularDampingBodyEvent.class);
                break;
            case Torque:
                event = Pools.obtain(TorqueBodyEvent.class);
                break;
            case LinearImpulse:
                event = Pools.obtain(LinearImpulseBodyEvent.class);
                break;
            default:
                event = null;
                Gdx.app.error("Box2DEvent", eventType + "not impl");
                break;
        }
        return (E) event;
    }

    public static ActiveBodyEvent active(boolean active) {
        ActiveBodyEvent event = getEvent(B2dEventsEnum.Active);
        event.active = active;
        return event;
    }

    public static AwakeBodyEvent awake(boolean awake) {
        AwakeBodyEvent event = getEvent(B2dEventsEnum.Awake);
        event.awake = awake;
        return event;
    }

    public static BulletBodyEvent bullet(boolean bullet) {
        BulletBodyEvent event = getEvent(B2dEventsEnum.Bullet);
        event.setBullet(bullet);
        return event;
    }

    public static FixedRotationBodyEvent fixedRotation(boolean fixedRotation) {
        FixedRotationBodyEvent event = getEvent(B2dEventsEnum.Bullet);
        event.setFixedRotation(fixedRotation);
        return event;
    }

    public static BodyTypeEvent bodyType(BodyType bodyType) {
        BodyTypeEvent event = getEvent(B2dEventsEnum.BodyType);
        event.bodyType = bodyType;
        return event;
    }

    public static TransformBodyEvent transform(Vector2 position, float rotation) {
        TransformBodyEvent event = getEvent(B2dEventsEnum.Transform);
        event.positionTo.set(position);
        event.rotation = rotation;
        return event;
    }

    public static TransformBodyEvent transform(float x, float y, float rotation) {
        TransformBodyEvent event = getEvent(B2dEventsEnum.Transform);
        event.positionTo.set(x, y);
        event.rotation = rotation;
        return event;
    }

    public static RotationBodyEvent rotation(float angleRadian) {
        RotationBodyEvent event = getEvent(B2dEventsEnum.Rotation);
        event.setAngleRadian(angleRadian);
        return event;
    }

    public static LinearVelocityEvent linearVelocity(Vector2 velocity) {
        LinearVelocityEvent event = getEvent(B2dEventsEnum.LinearVelocity);
        event.getVelocity().set(velocity);
        return event;
    }

    public static LinearVelocityEvent linearVelocity(float velX, float velY) {
        LinearVelocityEvent event = getEvent(B2dEventsEnum.LinearVelocity);
        event.getVelocity().set(velX, velY);
        return event;
    }

    public static AngularVelocityEvent angularVelocity(float angularVelocity) {
        AngularVelocityEvent event = getEvent(B2dEventsEnum.AngularVelocity);
        event.setAngularVelocity(angularVelocity);
        return event;
    }

    public static AngularImpulseBodyEvent angularImpulse(float impulse, boolean wake) {
        AngularImpulseBodyEvent event = getEvent(B2dEventsEnum.AngularImpulse);
        event.setImpulse(impulse);
        event.setWake(wake);
        return event;
    }

    public static AngularDampingBodyEvent angularDamping(float angularDamping) {
        AngularDampingBodyEvent event = getEvent(B2dEventsEnum.AngularImpulse);
        event.setAngularDamping(angularDamping);
        return event;
    }

    public static ApplyForceBodyEvent applyForce(Vector2 force, Vector2 point, boolean wake) {
        ApplyForceBodyEvent event = getEvent(B2dEventsEnum.ApplyForce);
        event.force.set(force);
        event.point.set(point);
        event.wake = wake;
        return event;
    }

    public static ApplyForceBodyEvent applyForce(Vector2 force, Vector2 point) {
        ApplyForceBodyEvent event = getEvent(B2dEventsEnum.ApplyForce);
        event.force = force;
        event.point = point;
        event.wake = true;
        return event;
    }

    public static ApplyForceCenterBodyEvent applyForceToCenter(Vector2 force, boolean wake) {
        ApplyForceCenterBodyEvent event = getEvent(B2dEventsEnum.ApplyForceToCenter);
        event.getForce().set(force);
        event.setWake(wake);
        return event;
    }


    public static TorqueBodyEvent torque(float torque, boolean wake, boolean setValue) {
        TorqueBodyEvent event = getEvent(B2dEventsEnum.Torque);
        event.setTorque(torque);
        event.setWake(wake);
        event.setSetValue(setValue);
        return event;
    }

}
