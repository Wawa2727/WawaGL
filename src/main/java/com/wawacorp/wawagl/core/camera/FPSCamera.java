package com.wawacorp.wawagl.core.camera;

import com.wawacorp.wawagl.core.camera.projection.Perspective;
import com.wawacorp.wawagl.core.camera.projection.Projection;
import org.joml.Vector3f;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class FPSCamera extends Camera {
    public final static FPSCamera DEFAULT = new FPSCamera(Perspective.DEFAULT);
    // position of camera
    private final Vector3f eye;
    // direction of camera
    private final Vector3f center;
    // up vector
    private final Vector3f up;
    private float angleX;
    private float angleY;

    public FPSCamera(Projection projection) {
        super(projection);
        angleX = (float) Math.PI;
        eye = new Vector3f(0, 0, 0);
        center = new Vector3f(eye.add(getDirection(), new Vector3f()));
        up = new Vector3f(0, 1, 0);
        updateView();
    }

    public void mouse(float x, float y) {
        angleX += x;
        angleY += y;
        center.set(getDirection());
        updateView();
    }

    public Vector3f getRight() {
        return new Vector3f(
                (float) sin(angleX - 3.14f / 2.0f),
                0,
                (float) cos(angleX - 3.14f / 2.0f)
        );
    }

    public void forward() {
        Vector3f direction = getDirection();
        eye.add(direction);
        updateView();
    }

    public void backward() {
        Vector3f direction = getDirection();
        eye.add(direction);
        updateView();
    }

    public void left() {
        Vector3f direction = getRight();
        eye.sub(direction);
        updateView();
    }

    public void right() {
        Vector3f direction = getRight();
        eye.add(direction);
        updateView();
    }

    public void up() {
        eye.add(up);
        updateView();
    }

    public void down() {
        eye.sub(up);
        updateView();
    }

    public void setPosition(float x, float y, float z) {
        eye.set(x, y, z);
        updateView();
    }

    public Vector3f getDirection() {
        return new Vector3f(
                (float) (cos(angleY) * sin(angleX)),
                (float) (sin(angleY)),
                (float) (cos(angleY) * cos(angleX))
        );
    }

    @Override
    public void updateView() {
        viewMatrix.setLookAt(
                eye.add(new Vector3f(0, 0, 8)),
                center.add(eye, new Vector3f()),
                up
        );
        super.updateView();
    }

    @Override
    public void onLoop() {

    }
}
