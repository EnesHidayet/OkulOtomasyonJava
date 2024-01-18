package com.enes.service;


import com.enes.entity.BaseEntity;
import com.enes.entity.Ogrenci;
import com.enes.entity.enums.State;
import com.enes.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OgrenciService {
    /**
     * Bir bağımlılığın enjekte edilmesi için temelde kullandığımız 2 yöntem vardır
     * 1- @Autowired ile işaretlemek
     * 2- constructor injection ile spring application contextin DI ile bağomlılık enjeksiyonu yapmak
     */
    //1.Yöntem
    //@Autowired
    //private OgrenciRepository ogrenciRepository;

    //2.Yöntem
    //final olarak işaretlendiyse başlatılması lazım. Değer atanır ve sabit kalır.
    private final OgrenciRepository ogrenciRepository;

    /**
     * DİKKAT!!!
     * constructor yazmadan yazılmış gibi kullanmak için
     * lombok annotationlarını kullanabiliriz.
     * @requiredArgsConstructor annotationu ile constructor oluşturulabilir
     */

    //@RequiredArgsConstructor yazdığımız için constructor oluşturulur. aşağıdakine gerek kalmaz.

    // public OgrenciService(OgrenciRepository ogrenciRepository) {
    //    this.ogrenciRepository = ogrenciRepository;
    //}

    public void save(Ogrenci ogrenci){
        ogrenci.setBaseEntity(
                BaseEntity.builder()
                        .state(State.Aktif)
                        .createAt(System.currentTimeMillis())
                        .updateAt(System.currentTimeMillis())
                        .build()
        );
        ogrenciRepository.save(ogrenci);
    }

    public List<Ogrenci> findAll(){
        return ogrenciRepository.findAll();
    }

    public List<Ogrenci> getirOgrencilerinTumunuAdinaGore(String ad){
        return ogrenciRepository.findAllByAd(ad);
    }

    public List<Ogrenci> findAllByAdLike(String ad) {
        return ogrenciRepository.findAllByAdLike(ad);
    }
}
