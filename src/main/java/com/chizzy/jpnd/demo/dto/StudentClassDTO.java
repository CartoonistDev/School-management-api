package com.chizzy.jpnd.demo.dto;

import javax.validation.constraints.NotBlank;

public class StudentClassDTO {
    private Long classId;

    @NotBlank
    private String className;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
