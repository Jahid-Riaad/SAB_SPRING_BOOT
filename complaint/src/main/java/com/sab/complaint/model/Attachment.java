package com.sab.complaint.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Attachment {
    @Id
    private String id;

    private String fileName;
    private String fileType;
    private long fileSize;
    private String filePath;  // Path to the file on the file system

    @ManyToOne
    @JoinColumn(name = "complaint_id", referencedColumnName = "id")
    private Complaint complaint;

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
