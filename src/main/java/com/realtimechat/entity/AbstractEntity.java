package com.realtimechat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @Basic
    @CreatedDate
    @Column(updatable = false, name = "created_date")
    @JsonIgnore
    private LocalDateTime createdDate;

    @Basic
    @LastModifiedDate
    @Column(name = "modified_date")
    @JsonIgnore
    private LocalDateTime modifiedDate;

    @Basic
    @CreatedBy
    @Column(updatable = false, name = "created_by")
    @JsonIgnore
    private Long createdBy;

    @Basic
    @LastModifiedBy
    @Column(name = "modified_by")
    @JsonIgnore
    private Long modifiedBy;
}