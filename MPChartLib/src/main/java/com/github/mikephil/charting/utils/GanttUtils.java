package com.github.mikephil.charting.utils;

import android.graphics.Color;

import com.github.mikephil.charting.data.GanttTask;
import com.github.mikephil.charting.data.GanttChartData;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for creating Gantt chart data and tasks.
 * 
 * <h3>Usage Example:</h3>
 * <pre>
 * // Create Gantt chart data
 * GanttChartData ganttData = new GanttChartData();
 * 
 * // Add tasks
 * ganttData.addTask(new GanttTask("Design", 0, 50, Color.rgb(255, 107, 107)));
 * ganttData.addTask(new GanttTask("Development", 40, 100, Color.rgb(66, 165, 245)));
 * ganttData.addTask(new GanttTask("Testing", 120, 40, Color.rgb(76, 175, 80)));
 * ganttData.addTask(new GanttTask("Launch", 150, 20, Color.rgb(255, 193, 7)));
 * 
 * // Or use the helper
 * GanttChartData data = GanttUtils.createSampleGanttData();
 * </pre>
 */
public class GanttUtils {

    private GanttUtils() {
        // utility class - no instances
    }

    /**
     * Create a sample Gantt chart with demo tasks.
     * Useful for testing and examples.
     *
     * @return GanttChartData with 4 sample tasks
     */
    public static GanttChartData createSampleGanttData() {
        GanttChartData data = new GanttChartData();
        
        data.addTask(new GanttTask("Design", 0, 50, Color.rgb(255, 107, 107)));
        data.addTask(new GanttTask("Development", 40, 100, Color.rgb(66, 165, 245)));
        data.addTask(new GanttTask("Testing", 120, 40, Color.rgb(76, 175, 80)));
        data.addTask(new GanttTask("Launch", 150, 20, Color.rgb(255, 193, 7)));
        
        return data;
    }

    /**
     * Create an empty Gantt chart data container.
     *
     * @return Empty GanttChartData
     */
    public static GanttChartData createGanttData() {
        return new GanttChartData();
    }

    /**
     * Create a new Gantt task.
     *
     * @param name Task name
     * @param startTime Task start time
     * @param duration Task duration
     * @param color Task display color
     * @return A new GanttTask
     */
    public static GanttTask createTask(String name, float startTime, float duration, int color) {
        return new GanttTask(name, startTime, duration, color);
    }
}
