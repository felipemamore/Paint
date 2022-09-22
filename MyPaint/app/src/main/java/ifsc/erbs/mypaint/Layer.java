package ifsc.erbs.mypaint;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Layer {

    public Path mPath;
    public Paint mPaint;

    public Layer (){
        iniciaLayer();
    }

    public Layer iniciaLayer(){
        mPath = new android.graphics.Path();
        mPaint = new Paint();

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        return this;
    }
}
