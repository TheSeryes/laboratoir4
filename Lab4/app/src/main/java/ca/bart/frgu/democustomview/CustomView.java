package ca.bart.frgu.democustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


class CustomView extends View {

    //private final Paint BLUE_OUTLINE = new Paint();

    private Paint outline = new Paint();

    private float cx, cy, radius;
    private float time = 120;
    private float size = 100;


    private Triangle triangle1 = new Triangle();
    protected Forms polygones = new Forms();





    public CustomView(Context context)
    {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.CustomView, defStyle, 0);
        int color;

        try
        {
            color = a.getColor(R.styleable.CustomView_color, Color.BLUE);
            //time = a.getFloat(R.styleable.CustomView_time, 0);
            size = a.getDimensionPixelSize(R.styleable.CustomView_size, 100);
        }
        finally
        {
            a.recycle();
        }

        setTime(20);
        outline.setColor(color);
        outline.setStyle(Paint.Style.STROKE);
        outline.setStrokeWidth(2);

        polygones.setColor(color);
        polygones.setSize(size);
        polygones.setSides(6);
    }

    public void setColor(int color)
    {
        outline.setColor(color);
        invalidate();
    }

    public void setTime(float time)
    {
        this.time = time;
        invalidate();
    }

    public float getTime()
    {
        return this.time;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        cx = w / 2;
        cy = h / 2;
        radius = Math.min(cx, cy);

        polygones.setX(cx);
        polygones.setY(cy);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        polygones.draw(canvas);
    }

    @Override
    public void setRotation(float rotation)
    {
        super.setRotation(rotation);

    }
}
