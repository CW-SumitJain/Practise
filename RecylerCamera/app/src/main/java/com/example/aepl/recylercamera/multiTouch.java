package com.example.aepl.recylercamera;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by aepl on 27/6/16.
 */
public class multiTouch implements View.OnTouchListener {
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();
    PointF start = new PointF();
    PointF mid = new PointF();
    PointF diff = new PointF();
    float olddis  = 1f;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch(motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
//                Toast.makeText(this,"Action_down",Toast.LENGTH_SHORT).show();
                start.set(motionEvent.getX(),motionEvent.getY());
                Log.d("TAG","Action_down - "  + Float.toString(start.x) + Float.toString(start.y));
                break;

            case MotionEvent.ACTION_UP:
                Log.d("TAG","Action_up" +  Float.toString(start.x) + Float.toString(start.y));
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                mid.set(motionEvent.getX(),motionEvent.getY());
                Log.d("TAG","Action_pointer");
                break;

            case MotionEvent.ACTION_POINTER_UP:
                Log.d("TAG","Action_pointer up");
                break;

            case MotionEvent.ACTION_MOVE:

                diff.x = mid.x - start.x;
                diff.y = mid.y - start.y;
                Log.d("TAG","Action_move " + mid.x + mid.y);
                float newdis = spacing(motionEvent);
                if(newdis > 1f)
                {
                    matrix.set(savedMatrix);
                    float scale = newdis / olddis;
                    matrix.postScale(scale,scale);

                }
                start.x = mid.x;
                start.y = mid.y;
                break;


        }
        ((ImageView)view).setImageMatrix(matrix);
        return true;
    }

    private float spacing(MotionEvent motionEvent) {
        return (float)Math.sqrt(diff.x * diff.x + diff.y * diff.y);
    }
}
