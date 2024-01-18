package com.enes.repository;

import com.enes.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * TODO: REPOSITORY, Temel veritabanı işlemlerini yapmak için kullandığımız sınıfı ifade eder.
 * Spring bu sınıftan bir Bean yaratır. Ancak burada dikkat edilmesi gerekli olan bir husus vardır.
 * Spring Boot 3.x den önceki sürümlerde bu sınıftan bir bean yaratılabilmesi için @Repository
 * anatasyonu eklenmek zorunlu idi, Ancak artık ilgili sınıf JpaRepository den extends alması yeterli olmaktadır.
 *
 */
public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {
    /**
     * TODO: Jpa Keywords, spring kendisine özgü kelimelerin bir araya gelmesi ile oluşan
     * methodların gövdelerini oluşturabilmektedir.
     * Select * from tbl_ogrenci where ad = ? and soyad = ? and yas > ? and yas < ?
     * List<Ogrenci> findAllByAdAndBySoyadAndBetweenYas(String ad, String soyad, Integer yasStart, Integer yasEnd);
     * TODO: Jpa Repository Keywordleri kullanılarak nasıl sorgu methodu oluturulur?
     * 1- [find - count - get - delete] keywordlerden birisi ile başlamanız gereklidir.
     * 2- By ile seçilecek property belirleniyor.
     * 3- [Entity değişkeninin adı]: Dikkat entity değişkeni yazılırken mutlaka baş harfi büyük olmalıdır.
     * örn:
     * User{
     *     ad, -> findByAd
     *     adSoyad-> findByAdSoyad
     *     adsoyad -> findByAdsoyad
     * }
     * 4- Eğer başka sorgular ek parametreler eklenecek ise And, Or [In, Not, True] ile devam edilmelidir.
     * 5- Eğer method yazımında parametre talep edecek şekilde oluşturulmuş ise, parantezler içinde yazılan
     * parametrelerin sırası ile eklenmesi gereklidir.Aşağıdaki örnekte olduğu gibi method adında Ad ve Soyad
     * için iki parametre talep edildiği açıktır.(Değişken tanımlanırken kullanılan isim önemli değil String ad
     * yerine String comolokkoda yazabilirdik.)
     * 6- Her methodun geri dönüş tipi belirtilmelidir. Burada sorgu neticesinde ne talep ediliyor ise ona
     * göre geri dönüş tipi belirleyiniz.
     */

    /**
     * select * from tbl_ogrenci where ad = ? and soyad = ?
     *
     */
    Ogrenci findByAdAndSoyad(String ad, String soyad);
    Optional<Ogrenci> findOptionalByAdAndSoyad(String ad, String soyad);

    /**
     * select * from tbl_ogrenci where ad = ?
     */
    List<Ogrenci> findAllByAd(String ad);

    /**
     * select * from tbl_ogrenci where yas > ?
     */
    List<Ogrenci> findAllByYasGreaterThan(Integer yas);
    /**
     * Like -> _%
     * select * from tbl_ogrenci where ad like ?1 -> %ad%
     */
    List<Ogrenci> findAllByAdLike(String ad);
}
