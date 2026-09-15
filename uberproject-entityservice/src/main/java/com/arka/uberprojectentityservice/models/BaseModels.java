package com.arka.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass
public class BaseModels {
    @Id // for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto Increment
    protected Long id;

    @Column(nullable = false) // this annotation tells spring about the formates of thr date object to be stored
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate  // thia annotation tells that only handle it for object creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  // this annotation tells that only handle it for object update
    protected Date updateAT;
}
