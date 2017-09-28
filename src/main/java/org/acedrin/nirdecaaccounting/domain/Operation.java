package org.acedrin.nirdecaaccounting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Operation {
    private Long id;

    private Long userId;

    private Long categoryId;

    private Long tagId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private LocalDate date;

    private Integer amount;

    private String description;

    public Operation() {
    }

    public Operation(Long userId, Long categoryId, Long tagId, LocalDate date, Integer amount, String description) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.tagId = tagId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public void prepareToSave() {
validate();
    }

    private void validate() {
        if(userId == null) {
            throw new InvalidOperationException("Missing userId");
        }
        if(categoryId == null) {
            throw new InvalidOperationException("Missing categoryId");
        }
        if(date == null) {
            throw new InvalidOperationException("Missing date");
        }
        if(amount == null) {
            throw new InvalidOperationException("Missing amount");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
