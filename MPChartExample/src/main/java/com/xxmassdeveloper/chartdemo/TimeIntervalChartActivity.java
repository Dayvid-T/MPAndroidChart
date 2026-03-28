package com.xxmassdeveloper.chartdemo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.GanttUtils;
import com.xxmassdeveloper.mpchartexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo activity showing Gantt-style time interval visualization using HorizontalBarChart.
 * Each bar represents a task with start time and duration.
 * 
 * This demonstrates how to create project timeline or resource allocation charts
 * where each horizontal bar represents a task spanning from a start time to an end time.
 */
public class TimeIntervalChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_interval_chart);

        HorizontalBarChart chart = findViewById(R.id.chart);

        // Create sample project tasks with start times and durations
        // Format: task row, start time, duration
        List<BarEntry> entries = new ArrayList<>();
        entries.add(GanttUtils.createTimeIntervalEntry(0, 0, 100));      // Task A: 0-100
        entries.add(GanttUtils.createTimeIntervalEntry(1, 50, 150));     // Task B: 50-200
        entries.add(GanttUtils.createTimeIntervalEntry(2, 150, 100));    // Task C: 150-250

        // Create dataset with task data
        BarDataSet dataSet = new BarDataSet(entries, "Project Tasks");
        dataSet.setColors(
            Color.rgb(61, 165, 255),    // Blue
            Color.rgb(230, 126, 34),    // Orange
            Color.rgb(46, 204, 113)     // Green
        );
        dataSet.setBarBorderWidth(1f);
        dataSet.setBarBorderColor(Color.BLACK);

        // Configure chart data
        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.6f);
        chart.setData(barData);

        // Disable default interactions
        chart.setDrawValueAboveBar(true);
        chart.setFitBars(true);
        chart.setPinchZoom(false);
        chart.setDragEnabled(true);

        // Configure X-axis (timeline)
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawLabels(true);
        xAxis.setDrawGridLines(true);

        // Configure Y-axis (tasks)
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setDrawGridLines(false);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

        // Configure legend
        Legend legend = chart.getLegend();
        legend.setEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        chart.invalidate();
    }
}
