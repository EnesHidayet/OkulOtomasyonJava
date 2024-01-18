package com.enes.controller;

import com.enes.entity.Ebeveyn;
import com.enes.service.EbeveynService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebeveyn")
@RequiredArgsConstructor
public class EbeveynController {

    private final EbeveynService ebeveynService;
    /**
     * Controller sayfasından dışarıya hizmet etme işlemleri end-point ile yapılır.
     * bir end-point şu şekikde görünür;
     * [http or https]://[IP-ADDRESS]:[PORT]/[optional: DEV, API, TEST]/[optional: VERSION]/[CLASS: name]/[ACTION: name]
     * http://localhost:8080/dev/v1/ebevyn/save
     * port dahil olan kısım ilgili sunucuda yayın yapan uygulamaya ulaşmak için kullanılır.
     * Diğer kısımlar geliştiriciye göre değişim gösterir. Asıl olan classa erişim ve içindeki methodları
     * tetiklemek için kullanılan parametrelerdir.
     *
     * *********   DİKKKAT !!!!!! *******
     * GET isteği bir url adresinden bilgi almak için kullanılır.
     * tüm browser lar GET isteği ile çalışır. Amaçları iletilen URL adresindeki
     * bilgiyi çekmektir.Eğer gelen data bir HTML içeriği ise onu web sayfası olarak yorumlar ve açar
     * --GET isteği, herkese açık olan sayfalarınızı ve bilgileriniz iletmek için kullanılır.
     * --gizli, oturum açma bilgilerini içeren istekleri ya da önemli bilgileri taşımak için
     * kullanılmaz, veriler HEADER içinde taşındığı için güvenli değildir. Ağı(network)
     * dinleyen herhangi biri bilgileri kolaylıkla okuyabilir.
     */


    /**
     * GetMapping -> endPointe gelen isteğin GET türünden olması gerektiğini niteler
     * ve belirtilen adrese gelen isteği yakalar, böylelikle ilgili methodun tetiklenmesini
     * sağlar.
     * http://localhost:8080/ebevyn/save
     *
     */


    @GetMapping("/save")
    public void save(){
        ebeveynService.save(Ebeveyn.builder()
                        .ad("Ahmet")
                        .adres("Ankara")
                        .soyad("TAŞ")
                        .telefon("555 555 55 55")
                .build());

        ebeveynService.save(Ebeveyn.builder()
                .ad("Tuna")
                .adres("Ankara")
                .soyad("TEK")
                .telefon("555 555 55 55")
                .build());

        ebeveynService.save(Ebeveyn.builder()
                .ad("Canan")
                .adres("İzmir")
                .soyad("KAYI")
                .telefon("555 555 55 55")
                .build());

        ebeveynService.save(Ebeveyn.builder()
                .ad("Bülent")
                .adres("Bursa")
                .soyad("BAKİ")
                .telefon("555 555 55 55")
                .build());
    }

    /**
     * http://localhost:8080/ebevyn/get-all
     */

    @GetMapping("/get-all")
    public List<Ebeveyn> findAll(){
        return ebeveynService.findAll();
    }

    /**
     * http://localhost:8080/ebevyn/get-all-by-adres
     * GET isteklerinde bilgi transferi isteğin header kısmında taşınır.
     * yani URL adresine bilgiyi ekleyerek göndermemiz gereklidir.İşlem
     * end point in snuna ? ekleyerek yapılır ? den sonra gönderilmek istenilen
     * parametrenin adı = değer şeklinde yazılır.
     * http://localhost:8080/ebeveyn/get-all-by-adres?adres=Ankara
     */

    @GetMapping("/get-all-by-adres")
    public List<Ebeveyn> findAllByAdres(String adres){
        return ebeveynService.findAll().stream().filter(x-> x.getAdres().contains(adres)).toList();
    }

    /**
     * GET isteklerinde bilgi eklemesi yapılırken, header içinde birden fazla bilgi taşıyabilirsiniz.
     * Bu bilgileri eklemek için ifadeler arasına & işareti eklenir.
     * http://localhost:8080/ebevyn/get-all-by-adres-and-ad?adres=a&ad=a
     */
    @GetMapping("/get-all-by-adres-and-ad")
    public List<Ebeveyn> findAllByAdresAndAd(String adres,String ad){
        return ebeveynService.findAll()
                .stream().filter(x-> x.getAdres().contains(adres) && x.getAd().contains(ad)).toList();
    }



}
