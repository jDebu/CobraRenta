package jdebu.github.io.cobrarenta.room.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import jdebu.github.io.cobrarenta.R;

/**
 * Created by jose on 19/08/15.
 */
public class RoomDrawView extends View {

    private final int[] paintColor = { getResources().getColor(R.color.room1Color), getResources().getColor(R.color.room2Color), getResources().getColor(R.color.room3Color), getResources().getColor(R.color.room4Color)};
    private final int paint2Color = getResources().getColor(R.color.room1Color);
    private Path path;
    private Paint drawPaint,canvasPaint;
    private Bitmap canvasBitmap;
    private Canvas drawCanvas;

    public RoomDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        path = new Path();
        setupPaint();
    }
    private void setupPaint(){
        drawPaint = new Paint();
        drawPaint.setColor(paintColor[2]);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(4);
        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);

    }
    @Override
    protected  void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        canvasBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
        Rect rect=new Rect(0,0,100,100);
        drawCanvas.drawRect(rect,drawPaint);
        //drawPaint.setColor(paintColor[1]);


    }
    @Override
    protected  void onDraw(Canvas canvas){
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(path,drawPaint);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX,pointY);
                return  true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX,pointY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(path,drawPaint);
                path.reset();
            default:
                return false;
        }
        //Force a view to draw again
        postInvalidate();
        return true;
    }
}
