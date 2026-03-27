package com.xxmassdeveloper.chartdemo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.GanttUtils;
import com.xxmassdeveloper.mpchartexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of using HorizontalBarChart for Gantt-style time interval visualization.
 * Shows how to display tasks as horizontal bars with start time and duration.
 */
public class TimeIntervalChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_interval_chart);

        HorizontalBarChart chart = findViewById(R.id.chart);

        // Create sample tasks with time intervals
        List<BarEntry> entries = new ArrayList<>();

        // Task 1: starts at 0, duration 100
        entries.add(GanttUtils.createTimeIntervalEntry(0, 0, 100));

        // Task 2: starts at 50, duration 150
        entries.add(GanttUtils.createTimeIntervalEntry(1, 50, 150));

        // Task 3: starts at 150, duration 100
        entries.add(GanttUtils.createTimeIntervalEntry(2, 150, 100));

        // Create dataset with time interval data
        BarDataSet dataSet = new BarDataSet(entries, "Tasks");
        dataSet.setColors(Color.rgb(61, 165, 255), Color.rgb(230, 126, 34), Color.rgb(46, 204, 113));
        dataSet.setBarBorderWidth(1f);
        dataSet.setBarBorderColor(Color.BLACK);

        // Create and set data
        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.8f);
        chart.setData(barData);

        // Configure chart
        chart.setFitBars(true);
        chart.setDrawValueAboveBar(true);
        chart.getXAxis().setDrawLabels(true);
        
        YAxis yl = chart.getAxisLeft();
        yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        // Refresh
        chart.invalidate();
    }
}
