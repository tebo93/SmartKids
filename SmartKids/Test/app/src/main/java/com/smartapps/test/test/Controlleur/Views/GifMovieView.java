package com.smartapps.test.test.Controlleur.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smartapps.test.test.Model.DisplayMessage;
import com.smartapps.test.test.Model.Movie;
import com.smartapps.test.test.R;

import java.util.List;

/**
 * https://github.com/sbakhtiarov/gif-movie-view/blob/master/src/com/basv/gifmoviewview/widget/GifMovieView.java
 * This is a View class that wraps Android {@link Movie} object and displays it.
 * You can set GIF as a Movie object or as a resource id from XML or by calling
 * {@link #setMovie(Movie)} or {@link #setMovieResource(int)}.
 * <p>
 * You can pause and resume GIF animation by calling {@link #setPaused(boolean)}.
 * <p>
 * The animation is drawn in the center inside of the measured view bounds.
 *
 * @author Sergey Bakhtiarov
 */

public class GifMovieView extends View {

    private static final int DEFAULT_MOVIEW_DURATION = 1000;

    private int mMovieResourceId;
    //private Movie mMovie;
    private Movie m = new Movie();
    private long mMovieStart;
    private int mCurrentAnimationTime = 0;

    /**
     * Position for drawing animation frames in the center of the view.
     */
    private float mLeft;
    private float mTop;

    /**
     * Scaling factor to fit the animation within view bounds.
     */
    private float mScale;

    /**
     * Scaled movie frames width and height.
     */
    private int mMeasuredMovieWidth;
    private int mMeasuredMovieHeight;

    private volatile boolean mPaused = false;
    private boolean mVisible = true;
    private final int left = 10;
    private final int top = 25;

    public GifMovieView(Context context) {
        this(context, null);
    }

    public GifMovieView(Context context, AttributeSet attrs) {
        this(context, attrs, R.styleable.CustomTheme_gifMoviewViewStyle);
    }

    public GifMovieView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setViewAttributes(context, attrs, defStyle);
    }

    @SuppressLint("NewApi")
    private void setViewAttributes(Context context, AttributeSet attrs, int defStyle) {

        /**
         * Starting from HONEYCOMB have to turn off HW acceleration to draw
         * Movie on Canvas.
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GifMoviewView, defStyle,
                R.style.Widget_GifMoviewView);

        mMovieResourceId = array.getResourceId(R.styleable.GifMoviewView_gif, -1);
        mPaused = array.getBoolean(R.styleable.GifMoviewView_paused, false);

        array.recycle();

        if (mMovieResourceId != -1) {
            //mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
            this.m = new Movie();
            this.m.setM(android.graphics.Movie.decodeStream(getResources().openRawResource(mMovieResourceId)));
        }
    }

    public void setMovieResource(int movieResId) {
        this.mMovieResourceId = movieResId;
        this.m.setM(android.graphics.Movie.decodeStream(getResources().openRawResource(mMovieResourceId)));
        //mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        requestLayout();
    }

    public void setMovie(Movie movie) {
        this.m = movie;
        //this.mMovie = movie;
        requestLayout();
    }

    public Movie getMovie() {
//        return mMovie;
        return this.m;
    }

    public void setMovieTime(int time) {
        mCurrentAnimationTime = time;
        invalidate();
    }

    public void setPaused(boolean paused) {
        this.mPaused = paused;

        /**
         * Calculate new movie start time, so that it resumes from the same
         * frame.
         */
        if (!paused) {
            mMovieStart = android.os.SystemClock.uptimeMillis() - mCurrentAnimationTime;
        }

        invalidate();
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (this.m.getM() != null) {
            int movieWidth = this.m.getM().width();
            int movieHeight = this.m.getM().height();
            //  Calculate horizontal scaling
            float scaleH = 1f;
            int measureModeWidth = MeasureSpec.getMode(widthMeasureSpec);

            if (measureModeWidth != MeasureSpec.UNSPECIFIED) {
                int maximumWidth = MeasureSpec.getSize(widthMeasureSpec);
                if (movieWidth > maximumWidth) {
                    scaleH = (float) movieWidth / (float) maximumWidth;
                }
            }
            // calculate vertical scaling
            float scaleW = 1f;
            int measureModeHeight = MeasureSpec.getMode(heightMeasureSpec);

            if (measureModeHeight != MeasureSpec.UNSPECIFIED) {
                int maximumHeight = MeasureSpec.getSize(heightMeasureSpec);
                if (movieHeight > maximumHeight) {
                    scaleW = (float) movieHeight / (float) maximumHeight;
                }
            }
            //calculate overall scale
            mScale = 1f / Math.max(scaleH, scaleW);
            mMeasuredMovieWidth = (int) (movieWidth * mScale);
            mMeasuredMovieHeight = (int) (movieHeight * mScale);
            /*
            setMeasuredDimension(mMeasuredMovieWidth, mMeasuredMovieHeight);
            */
            if (((ViewGroup) getParent()).getWidth() == 0 || ((ViewGroup) getParent()).getHeight() == 0) {
                setMeasuredDimension(mMeasuredMovieWidth, mMeasuredMovieHeight);
            } else {
                setMeasuredDimension(((ViewGroup) getParent()).getWidth(), ((ViewGroup) getParent()).getHeight());
            }
        } else {
            /*
             * No movie set, just set minimum available size.
			 */
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

		/*
         * Calculate left / top for drawing in center
		 */
        mLeft = (getWidth() - mMeasuredMovieWidth) / 2f;
        mTop = (getHeight() - mMeasuredMovieHeight) / 2f;

        mVisible = getVisibility() == View.VISIBLE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (this.m.getM() != null) {
            if (!mPaused) {
                updateAnimationTime();
                drawMovieFrame(canvas);
                invalidateView();
            } else {
                drawMovieFrame(canvas);
            }
        }
    }

    /**
     * Invalidates view only if it is visible.
     * <br>
     * {@link #postInvalidateOnAnimation()} is used for Jelly Bean and higher.
     */
    @SuppressLint("NewApi")
    private void invalidateView() {
        if (mVisible) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    /**
     * Calculate current animation time
     */
    private void updateAnimationTime() {
        long now = android.os.SystemClock.uptimeMillis();

        if (mMovieStart == 0) {
            mMovieStart = now;
        }

        //int dur = mMovie.duration();
        int dur = m.getM().duration();

        if (dur == 0) {
            dur = DEFAULT_MOVIEW_DURATION;
        }

        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
    }

    /**
     * Draw current GIF frame
     */
    private void drawMovieFrame(Canvas canvas) {
        setMeasuredDimension(1080, 750);
        m.getM().setTime(mCurrentAnimationTime);
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.scale(mScale, mScale);
        m.getM().draw(canvas, mLeft / mScale, mTop / mScale);
        int auxTop = top;
        for (DisplayMessage dm : m.searchMessageIn(mCurrentAnimationTime)) {
            Paint p2 = new Paint();
            p2.setColor(dm.getBackgroundColor());
            canvas.drawRect(left, auxTop - top, left + (p2.measureText(dm.getMessage()) * dm.getSize()) / 12.5f, auxTop + top, p2);
            Paint p = new Paint();
            p.setColor(dm.getTextColor());
            p.setTextSize(dm.getSize());
            canvas.drawText(dm.getMessage(), left, auxTop, p);
            auxTop = auxTop + top;
        }
        canvas.restore();
    }

    @SuppressLint("NewApi")
    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        mVisible = screenState == SCREEN_STATE_ON;
        invalidateView();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        mVisible = visibility == View.VISIBLE;
        invalidateView();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mVisible = visibility == View.VISIBLE;
        invalidateView();
    }
}


