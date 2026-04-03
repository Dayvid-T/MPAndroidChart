package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Data container for Gantt chart.
 * Manages a list of tasks and provides convenient access methods.
 */
public class GanttChartData {
    private List<GanttTask> tasks = new ArrayList<>();

    /**
     * Add a task to the Gantt chart.
     *
     * @param task The task to add
     */
    public void addTask(GanttTask task) {
        tasks.add(task);
    }

    /**
     * Add multiple tasks to the Gantt chart.
     *
     * @param taskList List of tasks to add
     */
    public void addTasks(List<GanttTask> taskList) {
        tasks.addAll(taskList);
    }

    /**
     * Get all tasks.
     *
     * @return List of all tasks
     */
    public List<GanttTask> getTasks() {
        return tasks;
    }

    /**
     * Get a specific task by index.
     *
     * @param index Task index
     * @return The task at the given index
     */
    public GanttTask getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Get the number of tasks.
     *
     * @return Number of tasks in the chart
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Get the earliest start time across all tasks.
     *
     * @return Minimum start time
     */
    public float getMinTime() {
        if (tasks.isEmpty()) return 0;
        float min = Float.MAX_VALUE;
        for (GanttTask task : tasks) {
            min = Math.min(min, task.getStartTime());
        }
        return min;
    }

    /**
     * Get the latest end time across all tasks.
     *
     * @return Maximum end time
     */
    public float getMaxTime() {
        if (tasks.isEmpty()) return 100;
        float max = 0;
        for (GanttTask task : tasks) {
            max = Math.max(max, task.getEndTime());
        }
        return max;
    }

    /**
     * Clear all tasks.
     */
    public void clearTasks() {
        tasks.clear();
    }
}
