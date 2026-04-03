package com.xxmassdeveloper.chartdemo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.GanttChart;
import com.github.mikephil.charting.data.GanttChartData;
import com.github.mikephil.charting.data.GanttTask;
import com.xxmassdeveloper.mpchartexample.R;

/**
 * Demo activity showing Gantt-style timeline visualization.
 * Each horizontal bar represents a task with start time and duration.
 */
public class TimeIntervalChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_interval_chart);

        GanttChart chart = findViewById(R.id.chart);

        // Create Gantt chart data
        GanttChartData ganttData = new GanttChartData();

        // Add sample project tasks
        ganttData.addTask(new GanttTask("Design", 0, 50, Color.rgb(255, 107, 107)));      // Red: 0-50
        ganttData.addTask(new GanttTask("Development", 40, 100, Color.rgb(66, 165, 245))); // Blue: 40-140
        ganttData.addTask(new GanttTask("Testing", 120, 40, Color.rgb(76, 175, 80)));      // Green: 120-160
        ganttData.addTask(new GanttTask("Launch", 150, 20, Color.rgb(255, 193, 7)));       // Yellow: 150-170

        // Set data and render
        chart.setData(ganttData);
    }
}

