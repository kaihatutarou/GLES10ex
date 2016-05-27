package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class House implements SimpleRenderer.Obj {

    private FloatBuffer vbuf;
    private float x, y, z;

    public House(float s, float x, float y, float z) {
        float[] vertices = {
                // left
                -s, -s, -s,
                -s, -s, s,
                -s, s, -s,
                -s, s, s,
                // right
                s, -s, -s,
                s, -s, s,
                s, s, -s,
                s, s, s,
                // bottom
                -s, -s, -s,
                s, -s, -s,
                -s, -s, s,
                s, -s, s,
                // topr
                0, s*2, -s,
                s, s, -s,
                0, s*2, s,
                s, s, s,
                // topl
                -s, s, -s,
                0, s*2, -s,
                -s, s, s,
                0, s*2, s,
                // back
                -s, s, -s,
                -s, -s, -s,
                0, s*2, -s,
                s, -s, -s,
                s, s, -s,
                // front
                -s, s, s,
                -s, -s, s,
                0, s*2, s,
                s, -s, s,
                s, s, s
        };
        vbuf = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // left
        gl.glNormal3f(-1, 0, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // right
        gl.glNormal3f(1, 0, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);

        // bottom
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);

        // topr
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);

        // topl
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);


        // rear
        gl.glNormal3f(0, 0, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 5);

        // front
        gl.glNormal3f(0, 0, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 25, 5);
    }
    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}
