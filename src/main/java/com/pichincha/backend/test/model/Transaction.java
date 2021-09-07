package com.pichincha.backend.test.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.EntityListeners;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@Table(name = "tstr_transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "transaction_generator",
            sequenceName = "tstr_seq",
            initialValue = 1000
    )
    private Long id;

    @Column(length = 255)
    private String comment;

    @Column(length = 70)
    private String type;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate;

    private Long accountId;

}
