package ca.bart.frgu.democustomview;

import android.graphics.Canvas;


public class Rectangle extends GameObject
{
    @Override
    protected void drawInternal(Canvas canvas)
    {
            for (int i = 0; i < 6; ++i)
            {
                // Selon le 360 diviser par le nombre de coter , va donner un angle
                //il reste 2 angles a trouver , on soustrait a 180 et on divise par 2 pour trouver les autre angles
                {
                    canvas.save();

                    canvas.translate(size, 0);

                    //anim recusive

                    canvas.rotate(60);
                    canvas.drawLine(0, 0, -size, 0, paint);

                    canvas.rotate(-120);
                    canvas.drawLine(0, 0, -size, 0, paint);

                    canvas.restore();
                }
                canvas.rotate(-60);
            }
    }
}
