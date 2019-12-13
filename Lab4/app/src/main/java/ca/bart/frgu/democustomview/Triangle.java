package ca.bart.frgu.democustomview;

import android.graphics.Canvas;

public class Triangle extends GameObject {

    @Override
    protected void drawInternal(Canvas canvas) {

        for (int i = 0; i < 7; ++i)
        {
            {
                canvas.save();

                canvas.translate(size, 0);

                //anim recusive

                canvas.rotate(30);
                canvas.drawLine(0, 0, -size, 0, paint);

                canvas.rotate(-60);
                canvas.drawLine(0, 0, -size, 0, paint);

                canvas.restore();
            }
            canvas.rotate(120);
        }
    }
}
