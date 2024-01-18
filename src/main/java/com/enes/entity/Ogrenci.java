package com.enes.entity;

import com.enes.entity.enums.Cinsiyet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_ogrenci")
@Entity
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "ad", nullable = false,length = 50)
    String ad;
    @Column(name = "soyad", nullable = false,length = 50)
    String soyad;
    @Enumerated
    Cinsiyet cinsiyet;
    Integer yas;
    @Embedded
    BaseEntity baseEntity;



}
