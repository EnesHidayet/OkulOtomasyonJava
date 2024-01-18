package com.enes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_ebeveyn")
@Entity
public class Ebeveyn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "ad", nullable = false,length = 50)
    String ad;
    @Column(name = "soyad", nullable = false,length = 50)
    String soyad;
    @Column(name = "telefon", nullable = false,length = 20)
    String telefon;
    @Column(name = "adres",nullable = false,length = 300)
    String adres;
    @Embedded
    BaseEntity baseEntity;


}
