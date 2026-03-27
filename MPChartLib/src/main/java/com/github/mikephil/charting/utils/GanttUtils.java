package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.BarEntry;

/**
 * Utility class for creating time interval entries for Gantt-style charts.
 * Provides helper methods to create BarEntry objects with time interval data.
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
     */
    public static BarEntry createMultiSegmentEntry(float taskIndex, float[] timeIntervals) {
        if (timeIntervals == null || timeIntervals.length < 2) {
            throw new IllegalArgumentException("timeIntervals must have at least 2 elements");
        }
        return new BarEntry(taskIndex, timeIntervals);
    }

    /**
     * Create a time interval entry with custom data.
     * 
     * @param taskIndex Y-axis position (task row)
     * @param startTime Start time value
     * @param duration Duration value
     * @param data Custom data object
     * @return BarEntry configured for time interval rendering with data
     */
    public static BarEntry createTimeIntervalEntry(float taskIndex, float startTime, 
                                                    float duration, Object data) {
        return new BarEntry(taskIndex, new float[]{startTime, duration}, data);
    }
}
