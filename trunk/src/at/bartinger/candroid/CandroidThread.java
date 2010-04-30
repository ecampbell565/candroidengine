package at.bartinger.candroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import at.bartinger.candroid.renderer.Renderer;
import at.bartinger.example.ExampleActivity;

/**
 * A generic Canvas rendering Thread. Delegates to a Renderer instance to do
 * the actual drawing.
 */
public class CandroidThread extends Thread {
	private boolean mDone;

	private Renderer mRenderer;
	private Runnable mEvent;
	private SurfaceHolder mSurfaceHolder =null;
	private CandroidSurfaceView view;
	private Canvas canvas;

	public boolean hasSurface = false;


	public CandroidThread(CandroidSurfaceView view, Renderer renderer) {
		super();
		mDone = false;

		mRenderer = renderer;
		this.view = view;
		mSurfaceHolder = view.getHolder();
		setName("CandroidThread");
	}

	@Override
	public void run() {


		/*
		 * This is our main activity thread's loop, we go until
		 * asked to quit.
		 */
		while (!mDone) {
			synchronized (this) {
				if(!hasSurface) {
					while (!hasSurface) {
						try {
							wait();
						} catch (InterruptedException e) {}
					}
				}

				if (mDone) {
					break;
				}

			}

			if (mEvent != null) {
				mEvent.run();
			}




			synchronized(mSurfaceHolder){

				canvas = mSurfaceHolder.lockCanvas();

				if (canvas != null) {

					view.onStartDrawing(canvas);
					mRenderer.drawFrame(canvas);
					view.onStopDrawing(canvas);
					mSurfaceHolder.unlockCanvasAndPost(canvas);

				}else{
					Log.e(Constants.LOGTAG, "Canvas are null");
				}
			}
		}
	}

	/**
	 * Override this for your updates in your game.
	 *              calculating, sprite-moving, animation updates, background updates, ...
	 * @param pastTime The time between the last update and now
	 */


	//don't call this from CanvasThread thread or it is a guaranteed deadlock!
	public void requestExitAndWait() {
		synchronized(this) {
			mDone = true;
			notify();
		}
		try {
			join();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Queue an "event" to be run on the rendering thread.
	 * @param r the runnable to be run on the rendering thread.
	 */
	public void setSecondRunnable(Runnable r) {
		synchronized(this) {
			mEvent = r;
		}
	}

	public void clearSecondRunnable() {
		synchronized(this) {
			mEvent = null;
		}
	}

	public void destroy(){
		mDone = true;
	}

	public void surfaceCreated() {
		synchronized(this) {
			hasSurface = true;
			notify();
		}
	}


	public void surfaceDestroyed() {
		synchronized(this) {
			mDone = false;
			hasSurface = false;
			notify();
		}
	}





}