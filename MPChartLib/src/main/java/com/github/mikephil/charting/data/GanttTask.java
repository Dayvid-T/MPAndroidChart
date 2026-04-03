package com.github.mikephil.charting.data;

/**
 * Represents a single task in a Gantt chart.
 * Each task has a name, start time, duration, and display color.
 */
public class GanttTask {
    private String name;
    private float startTime;
    private float duration;
    private int color;

    /**
     * Create a new Gantt task.
     *
     * @param name Task name/label
     * @param startTime When the task starts
     * @param duration How long the task lasts
     * @param color Display color (Android color int)
     */
    public GanttTask(String name, float startTime, float duration, int color) {
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public float getStartTime() {
        return startTime;
    }

    public float getEndTime() {
        return startTime + duration;
    }

    public float getDuration() {
        return duration;
    }

    public int getColor() {
        return color;
    }
}
