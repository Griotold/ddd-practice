package com.example.ddd.domain.entity.product;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * TODO: JPA에서 Value Object를 구성하는 방법
 * */
@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuditingDate {

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
