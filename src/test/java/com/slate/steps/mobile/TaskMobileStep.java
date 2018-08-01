package com.slate.steps.mobile;

import static com.slate.pages.TaskPage.verifyTaskDisappear;
import static com.slate.pages.TaskPage.verifyTaskPresent;

public class TaskMobileStep {

    public void verifyTaskPresentOnMobile(String taskName) {
        verifyTaskPresent(taskName);
    }

    public void verifyTaskIsNotPresentOnMobile(String taskName) {
        verifyTaskDisappear(taskName);
    }

}
