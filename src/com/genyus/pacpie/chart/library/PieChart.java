package com.genyus.pacpie.chart.library;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

@SuppressLint("DrawAllocation")
public class PieChart extends View {
	
	public static final int WAIT = 0;
	public static final int IS_READY_TO_DRAW = 1;
	public static final int IS_DRAW = 2;
	private static final float START_INC = 30;
	
	private Paint bagPaints = new Paint();
	private Paint linePaints = new Paint();
	
	private int strokeColor;
	private float strokeWidth = 3.0f;
	private boolean antiAlias = true;

	private int width;
	private int height;
	private int gapTop;
	private int gapBottm;
	private int backgroundColor;
	private int gapLeft;
	private int gapRight;
	private int state = WAIT;
	private float start;
	private float sweep;
	private int maxConnection;
	
	private List<PieDetailsItem> mdataArray;

	public PieChart(Context context) {
		super(context);
	}

	public PieChart(Context context, AttributeSet attr) {
		super(context, attr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (state != IS_READY_TO_DRAW) {
			return;
		}
		canvas.drawColor(backgroundColor);
		bagPaints.setAntiAlias(true);
		bagPaints.setStyle(Paint.Style.FILL);
		bagPaints.setColor(0x88FF0000);
		bagPaints.setStrokeWidth(0.0f);
		linePaints.setAntiAlias(antiAlias);
		linePaints.setColor(strokeColor);
		linePaints.setStrokeWidth(strokeWidth);
		linePaints.setStyle(Paint.Style.STROKE);
		RectF mOvals = new RectF(gapLeft, gapTop, width - gapRight, height
				- gapBottm);
		start = START_INC;
		PieDetailsItem item;
		for (int i = 0; i < mdataArray.size(); i++) {
			item = (PieDetailsItem) mdataArray.get(i);
			bagPaints.setColor(item.color);
			sweep = (float) 360
					* ((float) item.count / (float) maxConnection);
			canvas.drawArc(mOvals, start, sweep, true, bagPaints);
			canvas.drawArc(mOvals, start, sweep, true, linePaints);
			start = start + sweep;
		}

		state = IS_DRAW;
	}

	public void setGeometry(int width, int height, int gapleft, int gapright,
			int gaptop, int gapbottom, int overlayid) {

		this.width = width;
		this.height = height;
		this.gapLeft = gapleft;
		this.gapRight = gapright;
		this.gapBottm = gapbottom;
		this.gapTop = gaptop;

	}

	public void setSkinparams(int bgcolor) {
		backgroundColor = bgcolor;
	}

	public void setData(List<PieDetailsItem> data, int maxconnection) {
		mdataArray = data;
		maxConnection = maxconnection;
		state = IS_READY_TO_DRAW;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getColorValues(int index) {
		if (mdataArray == null) {
			return 0;
		}

		else if (index < 0)
			return ((PieDetailsItem) mdataArray.get(0)).color;
		else if (index > mdataArray.size())
			return ((PieDetailsItem) mdataArray.get(mdataArray.size() - 1)).color;
		else
			return ((PieDetailsItem) mdataArray.get(mdataArray.size() - 1)).color;

	}

	/**
	 * @return the strokeColor
	 */
	public int getStrokeColor() {
		return strokeColor;
	}

	/**
	 * @param strokeColor the strokeColor to set
	 */
	public void setStrokeColor(int strokeColor) {
		this.strokeColor = strokeColor;
	}

	/**
	 * @return the strokeWidth
	 */
	public float getStrokeWidth() {
		return strokeWidth;
	}

	/**
	 * @param strokeWidth the strokeWidth to set
	 */
	public void setStrokeWidth(float strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	/**
	 * @return the antiAlias
	 */
	public boolean isAntiAlias() {
		return antiAlias;
	}

	/**
	 * @param antiAlias the antiAlias to set
	 */
	public void setAntiAlias(boolean antiAlias) {
		this.antiAlias = antiAlias;
	}

}
