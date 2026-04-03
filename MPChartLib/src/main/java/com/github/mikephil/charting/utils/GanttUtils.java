package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.BarEntry;

/**
 * Utility class for creating time interval entries for Gantt-style charts.
 * Provides helper methods to create BarEntry objects with time interval data.
 * 
 * <h3>Usage Example:</h3>
 * <pre>
 * // Create a list of tasks with time intervals
 * List<BarEntry> entries = new ArrayList<>();
 * 
 * // Task 1 (row 0): starts at time 0, duration 100
 * // This creates a bar from 0 to 100 on the X-axis
 * entries.add(GanttUtils.createTimeIntervalEntry(0, 0, 100));
 * 
 * // Task 2 (row 1): starts at time 50, duration 150
 * // This creates a bar from 50 to 200 on the X-axis
 * entries.add(GanttUtils.createTimeIntervalEntry(1, 50, 150));
 * 
 * // Task 3 (row 2): starts at time 200, duration 75
 * // This creates a bar from 200 to 275 on the X-axis
 * entries.add(GanttUtils.createTimeIntervalEntry(2, 200, 75));
 * 
 * // Create dataset and configure chart
 * BarDataSet dataSet = new BarDataSet(entries, "Tasks");
 * BarData barData = new BarData(dataSet);
 * chart.setData(barData);
 * </pre>
 */
public class GanttUtils {

    private GanttUtils() {
        // utility class - no instances
    }

    /**
     * Create a time interval entry for a single task.
     * The bar will be positioned at startTime and sized to span the duration.
     * 
     * @param taskIndex Y-axis position (task row)
     * @param startTime Start time value (X-axis position)
     * @param duration Duration value (bar length on X-axis)
     * @return BarEntry representing a time interval
     * 
     * @example
     * // Create task at row 0, starting at time 100, lasting 50 time units
     * // This renders as a bar from 100 to 150 on the timeline
     * BarEntry entry = GanttUtils.createTimeIntervalEntry(0, 100, 50);
     */
    public static BarEntry createTimeIntervalEntry(float taskIndex, float startTime, float duration) {
        // Position bar at middle of interval, Y value is the duration
        // The bar will extend from (startTime) to (startTime + duration)
        float barPosition = startTime + (duration / 2f);
        return new BarEntry(barPosition, duration);
    }

    /**
     * Create a time interval entry with custom data.
     * 
     * @param taskIndex Y-axis position (task row) - Note: use this to differentiate visually if needed
     * @param startTime Start time value (X-axis position)
     * @param duration Duration value (bar length on X-axis)
     * @param data Custom data object to attach to this entry
     * @return BarEntry representing a time interval with data
     * 
     * @example
     * // Create task with custom data (e.g., task ID or status)
     * BarEntry entry = GanttUtils.createTimeIntervalEntry(0, 100, 50, "Task-123");
     */
    public static BarEntry createTimeIntervalEntry(float taskIndex, float startTime, 
                                                    float duration, Object data) {
        float barPosition = startTime + (duration / 2f);
        return new BarEntry(barPosition, duration, data);
    }
}
