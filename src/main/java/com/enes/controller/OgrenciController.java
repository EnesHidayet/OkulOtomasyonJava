package com.enes.controller;

import com.enes.entity.Ogrenci;
import com.enes.entity.enums.Cinsiyet;
import com.enes.service.OgrenciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ogrenci")
@RequiredArgsConstructor
public class OgrenciController {
    private final OgrenciService ogrenciService;
    /**
     * TODO:DİKKAT!!! IDEMPOTENT DESIGN PATTERN
     * "Idempotent" terimi, bir işlemin aynıyla tekrar tekrar uygulansa dahi, sonuçlarının ve sunucu tarafındaki
     * işlemlerinin değişmemesi durumudur. Idempotent bir işlemi tekrar tekrar uygulama sonucu değiştirmemelidir.
     *
     * HTTP isteklerinde Idempotent olanlar;
     * GET, PUT, DELETE
     *
     * Idempotent sistemimizde oluşabilecek hatarla başaçıkmada yardımcı olabilecek bir tasarım prensibidir.
     */

    /**
     * Post isteği, end-point tüm istek türlerinde aynıdır değişmez sadece client in geliş şekli değişir.
     * http://localhost:8080/ogrenci/save
     * DİKKAT!!!!
     * POST isteğinde parametreler BODY içinde sunucuya iletilir.Böylece GET isteğinnde açık bir şekilde
     * iletilen datalar güvenli bir şekilde sunucuya iletilmiş olur.
     */
    @PostMapping("/save")

    public void save(String ad, Integer yas, String soyad, Cinsiyet cinsiyet) {
        Ogrenci ogrenci = Ogrenci.builder()
                .ad(ad)
                .yas(yas)
                .soyad(soyad)
                .cinsiyet(cinsiyet)
                .build();
        ogrenciService.save(ogrenci);
    }

    @GetMapping("/get-all")
    public List<Ogrenci> getAll(){
        return ogrenciService.findAll();
    }

    @GetMapping("/get-all-by-ad")
    public List<Ogrenci> getAllByAd(String ad){
        return ogrenciService.getirOgrencilerinTumunuAdinaGore(ad);
    }
    @GetMapping("/get-all-by-ad-like")
    public List<Ogrenci> getAllByAdLike(String ad){
        return ogrenciService.findAllByAdLike("%"+ad+"%");
    }

}
