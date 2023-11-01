package com.muhammed.eterationbank.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {
    @Column(name = "created_date",updatable = false)
    private Instant date = Instant.now();
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate = Instant.now();

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
