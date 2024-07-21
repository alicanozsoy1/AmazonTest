@Smoke @MailSlurp
Feature: Kullanici Amazon hesabi olusturur

  @Positive
  Scenario: Basarili kayit olma
    Given Kullanici "https://www.amazon.com.tr" sayfasini acar
    And Giris yap butonuna tiklar
    And Uye olun butonuna tiklar
    When Ad soyad alanini doldurur "Deneme"
    And E-posta alanini doldurur
    And Sifre bilgisini girer "123456"
    And Sifre kontrol alanini doldurur "123456"
    Then Hesap oluştur butonuna tiklar
