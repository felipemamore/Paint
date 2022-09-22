package ifsc.erbs.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SimplePaint extends View {

    ;

    ArrayList<Layer> layers;
    Layer currentLayer;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        layers = new ArrayList<>();
        layers.add(inicia_layer());




    }
    public void addNewLayer(){
        layers.add(inicia_layer());
    }

    public Layer inicia_layer (){
        currentLayer = new Layer();
        return currentLayer;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Layer clayer:this.layers
             ) {
            canvas.drawPath(clayer.mPath, clayer.mPaint);

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ly, lx;

        lx = event.getX();
        ly = event.getY();

        switch (event.getAction()){
            case (MotionEvent.ACTION_DOWN):
                currentLayer.mPath.moveTo(lx, ly);
                currentLayer.mPath.lineTo(lx, ly);
                break;
            case  (MotionEvent.ACTION_MOVE):
                currentLayer.mPath.moveTo(lx, ly);

                break;
            case (MotionEvent.ACTION_UP):
                this.addNewLayer();

                break;
        }
        invalidate();
        return true;
    }

    public void clearLayers(){
        layer = new ArrayList<Layer>();
        this.addNewLayer();
        invalidate();
    }
}
