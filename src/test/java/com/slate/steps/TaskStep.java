package com.slate.steps;

import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.slate.pojo.task.Task;

import static com.slate.client.impl.task.TasksClient.getTasksClient;

public class TaskStep {

    public long getLastAddedTaskId() {
        Task[] tasks = getTasksClient().getTasks().getResponse().as(Task[].class, ObjectMapperType.GSON);
        int tasksCnt = tasks.length;
        return tasks[tasksCnt - 1].getId();
    }

//    public boolean checkTaskCompleted(long id) {
//        Task task = getTasksClient().getTaskById(id).readEntity();
//        return true;
//    }


}
