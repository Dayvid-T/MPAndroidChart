package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.github.mikephil.charting.data.GanttChartData;
import com.github.mikephil.charting.data.GanttTask;

/**
 * A custom Gantt chart view that renders tasks as horizontal bars.
 * Each bar represents a task with its start time and duration.
 */
public class GanttChart extends View {
    private GanttChartData data;
    private Paint taskPaint;
    private Paint gridPaint;
    private Paint textPaint;

    private float chartLeft;
    private float chartTop;
    private float chartRight;
    private float chartBottom;
    private float taskHeight = 50;
    private float padding = 20;

    public GanttChart(Context context) {
        super(context);
        init();
    }

    public GanttChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GanttChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        taskPaint = new Paint();
        taskPaint.setAntiAlias(true);

        gridPaint = new Paint();
        gridPaint.setColor(0xFFE0E0E0);
        gridPaint.setStrokeWidth(1);

        textPaint = new Paint();
        textPaint.setColor(0xFF333333);
        textPaint.setTextSize(36);
        textPaint.setAntiAlias(true);
    }

    public void setData(GanttChartData data) {
        this.data = data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (data == null || data.getTaskCount() == 0) {
            return;
        }

        calculateDimensions();
        drawGrid(canvas);
        drawTasks(canvas);
    }

    private void calculateDimensions() {
        chartLeft = padding + 100; // Leave space for labels
        chartTop = padding;
        chartRight = getWidth() - padding;
        chartBottom = getHeight() - padding;
    }

    private void drawGrid(Canvas canvas) {
        // Draw vertical grid lines
        float minTime = data.getMinTime();
        float maxTime = data.getMaxTime();
        float timeRange = maxTime - minTime;
        if (timeRange == 0) timeRange = 100;

        int gridLines = 10;
        for (int i = 0; i <= gridLines; i++) {
            float x = chartLeft + (i / (float) gridLines) * (chartRight - chartLeft);
            canvas.drawLine(x, chartTop, x, chartBottom, gridPaint);

            // Draw time labels
            float time = minTime + (i / (float) gridLines) * timeRange;
            canvas.drawText(String.format("%.0f", time), x - 15, chartBottom + 30, textPaint);
        }
    }

    private void drawTasks(Canvas canvas) {
        float minTime = data.getMinTime();
        float maxTime = data.getMaxTime();
        float timeRange = maxTime - minTime;
        if (timeRange == 0) timeRange = 100;

        for (int i = 0; i < data.getTaskCount(); i++) {
            GanttTask task = data.getTask(i);

            // Calculate position
            float taskY = chartTop + i * (taskHeight + 10);
            float startX = chartLeft + ((task.getStartTime() - minTime) / timeRange) * (chartRight - chartLeft);
            float endX = chartLeft + ((task.getEndTime() - minTime) / timeRange) * (chartRight - chartLeft);

            // Draw task bar
            RectF rect = new RectF(startX, taskY, endX, taskY + taskHeight);
            taskPaint.setColor(task.getColor());
            canvas.drawRect(rect, taskPaint);

            // Draw task label
            canvas.drawText(task.getName(), padding, taskY + taskHeight / 2 + 12, textPaint);
        }
    }
}
