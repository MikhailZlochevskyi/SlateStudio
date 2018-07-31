package com.slate.pojo.task;

import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("id")
    private Long id;

    @SerializedName("project_id")
    private Long projectId;

    @SerializedName("content")
    private String content;

    @SerializedName("completed")
    private Boolean completed;

    @SerializedName("order")
    private Integer order;

    @SerializedName("indent")
    private Integer indent;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("comment_count")
    private Integer commentCount;

    @SerializedName("due")
    private Due due;

    @SerializedName("url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getIndent() {
        return indent;
    }

    public void setIndent(Integer indent) {
        this.indent = indent;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Due getDue() {
        return due;
    }

    public void setDue(Due due) {
        this.due = due;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}