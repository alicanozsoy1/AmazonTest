@Smoke @AddToCart
Feature: Sepete urun atma

  Scenario: Sepete urun atma ve goruntuleme
    Given Kullanici "https://www.amazon.com.tr" sayfasini acar
    When Arama cubugundan bir urun aratir
    And Bir urune tiklar
    And Urunu sepete atar
    Then Urun sepete eklenir
    And Sepete git butonuna tiklar
    And Urunu sepette goruntuler