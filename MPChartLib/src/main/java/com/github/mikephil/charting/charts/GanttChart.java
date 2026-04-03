package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.github.mikephil.charting.data.GanttChartData;
import com.github.mikephil.charting.data.GanttTask;

public class GanttChart extends View {
    private GanttChartData data;
    private Paint taskPaint;
    private Paint gridPaint;
    private Paint textPaint;

    private float chartLeft;
    private float chartTop;
    private float chartRight;
    private float chartBottom;
    private float padding = 16;

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
        gridPaint.setColor(0xFFCCCCCC);
        gridPaint.setStrokeWidth(1);

        textPaint = new Paint();
        textPaint.setColor(0xFF666666);
        textPaint.setTextSize(28);
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
        chartLeft = padding + 70;
        chartTop = padding + 30;
        chartRight = getWidth() - padding;
        chartBottom = getHeight() - padding - 30;
    }

    // Dynamically calculate task height based on available space
    private float getTaskHeight() {
        if (data == null || data.getTaskCount() == 0) return 40;
        float availableHeight = chartBottom - chartTop;
        int taskCount = data.getTaskCount();
        // 80% of slot for bar, 20% for gap
        return (availableHeight / taskCount) * 0.8f;
    }

    private float getTaskSpacing() {
        if (data == null || data.getTaskCount() == 0) return 12;
        float availableHeight = chartBottom - chartTop;
        int taskCount = data.getTaskCount();
        return (availableHeight / taskCount) * 0.2f;
    }

    private void drawGrid(Canvas canvas) {
        float minTime = data.getMinTime();
        float maxTime = data.getMaxTime();
        float timeRange = maxTime - minTime;
        if (timeRange == 0) timeRange = 100;

        int gridLines = 10;
        Paint timeLabelPaint = new Paint();
        timeLabelPaint.setColor(0xFF666666);
        timeLabelPaint.setTextSize(22);
        timeLabelPaint.setAntiAlias(true);
        timeLabelPaint.setTextAlign(Paint.Align.CENTER);

        for (int i = 0; i <= gridLines; i++) {
            float x = chartLeft + (i / (float) gridLines) * (chartRight - chartLeft);
            canvas.drawLine(x, chartTop, x, chartBottom, gridPaint);

            float time = minTime + (i / (float) gridLines) * timeRange;
            canvas.drawText(String.format("%.0f", time), x, chartBottom + 30, timeLabelPaint);
        }
    }

    private void drawTasks(Canvas canvas) {
        float minTime = data.getMinTime();
        float maxTime = data.getMaxTime();
        float timeRange = maxTime - minTime;
        if (timeRange == 0) timeRange = 100;

        float taskHeight = getTaskHeight();
        float taskSpacing = getTaskSpacing();
        float slotHeight = taskHeight + taskSpacing;

        Paint labelPaint = new Paint();
        labelPaint.setColor(0xFF333333);
        labelPaint.setTextSize(24);
        labelPaint.setAntiAlias(true);
        labelPaint.setTextAlign(Paint.Align.RIGHT);

        Paint borderPaint = new Paint();
        borderPaint.setColor(0xFF999999);
        borderPaint.setStrokeWidth(2);
        borderPaint.setStyle(Paint.Style.STROKE);

        for (int i = 0; i < data.getTaskCount(); i++) {
            GanttTask task = data.getTask(i);

            float taskY = chartTop + i * slotHeight;
            float startX = chartLeft + ((task.getStartTime() - minTime) / timeRange) * (chartRight - chartLeft);
            float endX = chartLeft + ((task.getEndTime() - minTime) / timeRange) * (chartRight - chartLeft);

            if (endX - startX < 10) {
                endX = startX + 10;
            }

            // Center label vertically in the slot
            float labelY = taskY + (taskHeight / 2) + 8;
            canvas.drawText(task.getName(), chartLeft - 20, labelY, labelPaint);

            RectF rect = new RectF(startX, taskY, endX, taskY + taskHeight);
            taskPaint.setColor(task.getColor());
            canvas.drawRect(rect, taskPaint);
            canvas.drawRect(rect, borderPaint);
        }
    }
}