package ca.bart.frgu.democustomview;


import android.graphics.Canvas;

public class Forms extends GameObject
{
    protected Forms child;

    protected int side;

    protected int degreeCenter;
    protected int degreeInsideOne;
    protected int degreeInsideTwo;

    public void setSides(int aSide)
    {
        if( aSide > 3)
        {
            child = new Forms();

            child.setColor(color);
            child.setSize(size);
            child.setSides(3);
        }

        side = aSide;

        int tDegree = 360;
        degreeCenter = tDegree / aSide;

        int tDegreeTriangle = 180;
        degreeInsideOne = (tDegreeTriangle - degreeCenter) * -1;

        degreeInsideTwo = (degreeInsideOne / 2) * -1;
    }


    @Override
    protected void drawInternal(Canvas canvas)
    {
        if(side >= 3 && side <= 7)
        {
            for (int i = 0; i < side; ++i)
            {
                {
                    canvas.save();

                    canvas.translate(size, 0);

                    //recursive
                    if( child != null)
                    {
                        child.draw(canvas);
                    }

                    canvas.rotate(degreeInsideTwo);
                    canvas.drawLine(0, 0, -size, 0, paint);

                    canvas.rotate(degreeInsideOne);
                    canvas.drawLine(0, 0, -size, 0, paint);

                    canvas.restore();
                }
                canvas.rotate(degreeCenter);
            }
        }
    }

    @Override
    public void setRotation(float rotation)
    {
        super.setRotation(rotation);

        if(child != null)
        {
            child.setRotation(rotation);
        }
    }
}
