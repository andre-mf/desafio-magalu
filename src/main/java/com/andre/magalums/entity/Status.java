package com.andre.magalums.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long statusId;

    private String description;

    public Status() {
    }

    public Status(Long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        PENDING(1l, "pending"),
        SUCCESS(2l, "success"),
        ERROR(3L, "error"),
        CANCELLED(4L, "cancelled");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        @JsonCreator
        public static Status.Values forValues(String value) {
            return Status.Values.valueOf(value.toUpperCase());
        }

        public Status toStatus() {
            return new Status(id, description);
        }
    }
}
