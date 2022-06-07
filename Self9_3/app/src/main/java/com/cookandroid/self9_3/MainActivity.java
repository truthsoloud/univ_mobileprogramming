package com.cookandroid.self9_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, iblighton, iblightoff, ibblur, ibemboss;
    MyGraphicView graphicView;

    static float scaleX=1, scaleY=1;
    static float angle=0;
    static float color=1;
    static float satur=1;
    static BlurMaskFilter bMask;
    static EmbossMaskFilter eMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        clickIcons();
    }

    private void clickIcons() {
        ibZoomin=(ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                scaleX=scaleX+0.2f;
                scaleY=scaleY+0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout=(ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                scaleX=scaleX-0.2f;
                scaleY=scaleY-0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate=(ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle+20;
                graphicView.invalidate();
            }
        });

        iblighton=(ImageButton) findViewById(R.id.iblighton);
        iblighton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                satur = satur+0.2f;
                graphicView.invalidate();
            }
        }); //밝게하기

        iblightoff=(ImageButton) findViewById(R.id.iblightoff);
        iblightoff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                satur = satur-0.2f;
                graphicView.invalidate();
            }
        }); //어둡게하기

        ibblur=(ImageButton) findViewById(R.id.ibblur);
        ibblur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
                graphicView.invalidate();
            }
        }); //블러

        ibemboss=(ImageButton) findViewById(R.id.ibemboss);
        ibemboss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                eMask = new EmbossMaskFilter(new float[] {3, 3, 10}, 0.8f, 7, 10);
                graphicView.invalidate();
            }
        }); //엠보싱

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX=this.getWidth()/2;
            int cenY=this.getHeight()/2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = { color,0,0,0,0,
                    0,color,0,0,0,
                    0,0,color,0,0,
                    0,0,0,1,0};

            ColorMatrix cm = new ColorMatrix(array);
            cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.pic5);
            int picX = (this.getWidth()-picture.getWidth())/2;
            int picY = (this.getHeight()-picture.getHeight())/2;

            paint.setMaskFilter(bMask);
            paint.setMaskFilter(eMask);

            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();

        }
    }
}