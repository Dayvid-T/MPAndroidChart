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
 * entries.add(GanttUtils.createTimeIntervalEntry(0, 0, 100));
 * 
 * // Task 2 (row 1): starts at time 50, duration 150
 * entries.add(GanttUtils.createTimeIntervalEntry(1, 50, 150));
 * 
 * // Task 3 (row 2): starts at time 200, has two segments
 * float[] timeIntervals = {200, 100, 250, 75}; // start1, duration1, start2, duration2
 * entries.add(GanttUtils.createMultiSegmentEntry(2, timeIntervals));
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
     * 
     * @param taskIndex Y-axis position (task row)
     * @param startTime Start time value
     * @param duration Duration value
     * @return BarEntry configured for time interval rendering
     * 
     * @example
     * // Create task at row 0, starting at time 100, lasting 50 time units
     * BarEntry entry = GanttUtils.createTimeIntervalEntry(0, 100, 50);
     */
    public static BarEntry createTimeIntervalEntry(float taskIndex, float startTime, float duration) {
        return new BarEntry(taskIndex, new float[]{startTime, duration});
    }

    /**
     * Create a time interval entry with multiple segments.
     * Useful for showing multiple time ranges for a single task.
     * 
     * @param taskIndex Y-axis position (task row)
     * @param timeIntervals Array of [start1, duration1, start2, duration2, ...]
     * @return BarEntry configured for time interval rendering
     * 
     * @example
     * // Create task with two time segments
     * float[] segments = {100, 50, 200, 75}; // segment1: 100-150, segment2: 200-275
     * BarEntry entry = GanttUtils.createMultiSegmentEntry(1, segments);
     */
    public static BarEntry createMultiSegmentEntry(float taskIndex, float[] timeIntervals) {
        if (timeIntervals == null || timeIntervals.length < 2) {
            throw new IllegalArgumentException("timeIntervals must have at least 2 elements [startTime, duration]");
        }
        return new BarEntry(taskIndex, timeIntervals);
    }

    /**
     * Create a time interval entry with custom data.
     * 
     * @param taskIndex Y-axis position (task row)
     * @param startTime Start time value
     * @param duration Duration value
     * @param data Custom data object to attach to this entry
     * @return BarEntry configured for time interval rendering with data
     * 
     * @example
     * // Create task with custom data (e.g., task ID or status)
     * BarEntry entry = GanttUtils.createTimeIntervalEntry(0, 100, 50, "Task-123");
     */
    public static BarEntry createTimeIntervalEntry(float taskIndex, float startTime, 
                                                    float duration, Object data) {
        return new BarEntry(taskIndex, new float[]{startTime, duration}, data);
    }
}
