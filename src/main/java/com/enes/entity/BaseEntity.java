package com.enes.entity;

import com.enes.entity.enums.State;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //diğerlerine ekleyebiliriz bu sayede
public class BaseEntity {
    @Enumerated
    State state;
    Long createAt;
    Long updateAt;
}
