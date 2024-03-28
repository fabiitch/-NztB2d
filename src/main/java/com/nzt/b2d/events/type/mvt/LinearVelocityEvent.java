package com.nzt.b2d.events.type.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.b2d.events.B2dBaseEvent;
import com.nzt.b2d.events.B2dEventsEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinearVelocityEvent extends B2dBaseEvent<LinearVelocityEvent> {

    public Vector2 velocity = new Vector2();

    public LinearVelocityEvent() {
        super(B2dEventsEnum.LinearVelocity);
    }

    @Override
    public boolean canConcat(LinearVelocityEvent event) {
        this.velocity.add(event.velocity);
        return true;
    }

    @Override
    public void reset() {
        this.velocity.setZero();
    }

    @Override
    public void apply(Body body) {
        body.setLinearVelocity(velocity);
    }

}
