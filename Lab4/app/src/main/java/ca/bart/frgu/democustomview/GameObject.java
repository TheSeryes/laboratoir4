package ca.bart.frgu.democustomview;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected float scale = 1;
    protected float rotation;
    protected float size;
    protected int color;
    protected Paint paint = new Paint();

    protected GameObject() {

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
        paint.setColor(color);
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getScale()
    {
        return scale;
    }

    public void setScale(float scale)
    {
        this.scale = scale;
    }

    public float getRotation()
    {
        return rotation;
    }

    public void setRotation(float rotation)
    {
        this.rotation = rotation;
    }

    public float getSize()
    {
        return size;
    }

    public void setSize(float size)
    {
        this.size = size;
    }

    final public void draw(Canvas canvas)
    {
        canvas.save();

        canvas.translate(x, y);
        canvas.scale(scale, scale);
        canvas.rotate(rotation);

        drawInternal(canvas);

        canvas.restore();
    }

    abstract protected void drawInternal(Canvas canvas);
}
