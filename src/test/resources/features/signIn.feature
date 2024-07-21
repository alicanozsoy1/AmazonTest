@Smoke
Feature: Kullanicinin Amazon hesabina giris yapma islemi

  @Positive
  Scenario: Basarili giris
    Given Kullanici "https://www.amazon.com.tr" sayfasini acar
    And Giris yap butonuna tiklar
    When Mail alanini doldurur
    And Devam et butonuna tiklar
    When Sifre bilgisini doldurur
    And Sign in sayfasindaki giris yap butonuna tiklar
    Then Kayitin basarili sekilde tamamlandigi dogrulanir

  @Negative
  Scenario Outline: Basarisiz mail girisi
    Given Kullanici "https://www.amazon.com.tr" sayfasini acar
    And Giris yap butonuna tiklar
    When Mail bilgisini doldurur "<Email>"
    And Devam et butonuna tiklar
    Then Ilgili hata mesaji teyit edilir "<MailErrorMessage>" "<ErrorType>"
    Examples:
      | ErrorType | Email                 | MailErrorMessage                                                                                   |
      | 1         |                       | E-posta adresinizi veya cep telefonu numaranızı girin                                              |
      | 2         | tdeneme497            | Yanlış veya geçersiz e-posta adresi veya cep telefonu numarası. Lütfen düzeltin ve tekrar deneyin. |
      | 3         | tdeneme497@yanlis.com | Bu e-posta adresiyle bir hesap bulamıyoruz                                                         |

  @Negative
  Scenario Outline: Basarisiz sifre girisi
    Given Kullanici "https://www.amazon.com.tr" sayfasini acar
    And Giris yap butonuna tiklar
    When Mail bilgisini doldurur "<Email>"
    And Devam et butonuna tiklar
    When Sifre alanini doldurur "<Password>"
    And Sign in sayfasindaki giris yap butonuna tiklar
    Then Ilgili hata mesaji teyit edilir "<PasswordErrorMessage>" "<ErrorType>"
    Examples:
      | ErrorType | Email                | Password                    | PasswordErrorMessage |
      | 4         | tdeneme497@gmail.com | asdasda                     | Şifreniz yanlış      |
      | 4         | tdeneme497@gmail.com | 111111111111111111111111111 | Şifreniz yanlış      |
      | 4         | tdeneme497@gmail.com | a123456                     | Şifreniz yanlış      |
      | 5         | tdeneme497@gmail.com |                             | Şifrenizi girin      |