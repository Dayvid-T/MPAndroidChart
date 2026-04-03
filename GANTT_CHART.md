# Gantt Chart Feature

A native Gantt chart implementation for MPAndroidChart that visualizes tasks as horizontal bars positioned by time intervals.

## Features

- **Time-based positioning** - Tasks positioned by start time and duration
- **Responsive layout** - Automatically scales to fit any number of tasks
- **Customizable colors** - Each task can have its own color
- **Grid lines** - Time scale visualization with grid lines and labels
- **Clean design** - Professional appearance with task labels and borders

## Usage

### 1. Add to your layout XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.github.mikephil.charting.charts.GanttChart
        android:id="@+id/ganttChart"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```

### 2. Create your Activity

```java
package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.GanttChart;
import com.github.mikephil.charting.data.GanttChartData;
import com.github.mikephil.charting.data.GanttTask;

public class GanttChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gantt_chart);

        GanttChart chart = findViewById(R.id.ganttChart);

        // Create Gantt chart data
        GanttChartData ganttData = new GanttChartData();
        
        // Add tasks (name, startTime, duration, color)
        ganttData.addTask(new GanttTask("Design", 0, 30, Color.rgb(255, 107, 107)));
        ganttData.addTask(new GanttTask("Development", 20, 40, Color.rgb(66, 165, 245)));
        ganttData.addTask(new GanttTask("Testing", 50, 20, Color.rgb(76, 175, 80)));
        ganttData.addTask(new GanttTask("Deployment", 65, 15, Color.rgb(255, 193, 7)));

        // Set data and render
        chart.setData(ganttData);
    }
}
```

## API Reference

### GanttTask

Represents a single task in the Gantt chart.

```java
GanttTask task = new GanttTask(
    "Task Name",      // String: display name
    0,                // float: start time
    50,               // float: duration
    Color.BLUE        // int: task color
);
```

**Methods:**
- `getName()` - Get task name
- `getStartTime()` - Get start time
- `getDuration()` - Get task duration
- `getEndTime()` - Get end time (startTime + duration)
- `getColor()` - Get task color

### GanttChartData

Container for managing tasks.

```java
GanttChartData data = new GanttChartData();
data.addTask(task1);
data.addTask(task2);
data.clearTasks();
```

**Methods:**
- `addTask(GanttTask)` - Add a single task
- `addTasks(List<GanttTask>)` - Add multiple tasks
- `getTasks()` - Get all tasks
- `getTaskCount()` - Get number of tasks
- `getMinTime()` - Get earliest start time
- `getMaxTime()` - Get latest end time
- `clearTasks()` - Remove all tasks

### GanttChart

Custom View that renders the Gantt chart.

```java
GanttChart chart = findViewById(R.id.ganttChart);
chart.setData(ganttData);
```

**Methods:**
- `setData(GanttChartData)` - Set chart data and trigger redraw

## Example Use Cases

- **Project Management** - Visualize project timeline and tasks
- **Resource Allocation** - Show resource usage over time
- **Production Scheduling** - Display manufacturing timeline
- **Event Planning** - Timeline visualization for events

## Tips

- Use consistent time units (hours, days, weeks) across all tasks
- Ensure start times and durations use the same scale
- Keep task names reasonably short for better display
- Use contrasting colors for task visibility

## Customization

The chart automatically scales to fit your screen size and number of tasks. All styling parameters are calculated dynamically based on:
- Available screen space
- Number of tasks
- Time range of tasks

For visual customization, modify the `GanttChart` class directly:
- Adjust padding in `calculateDimensions()`
- Change grid line color/style in `drawGrid()`
- Modify task bar appearance in `drawTasks()`
