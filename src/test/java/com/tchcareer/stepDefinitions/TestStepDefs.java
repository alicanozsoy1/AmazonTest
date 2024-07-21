package com.tchcareer.stepDefinitions;

import com.tchcareer.pages.MainPage;
import com.tchcareer.pages.SearchPage;
import com.tchcareer.pages.SignInPage;
import com.tchcareer.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.tchcareer.driver.Driver.getDriver;
import static com.tchcareer.pages.MainPage.mainPageAccount;
import static com.tchcareer.pages.MainPage.mainPageSignIn;
import static com.tchcareer.pages.SignInPage.mailMissingAlert;
import static com.tchcareer.utilities.Constants.*;
import static com.tchcareer.utilities.MailSlurpUtil.inboxDto;
import static com.tchcareer.utilities.PageObjectUtil.actions;
import static com.tchcareer.utilities.WaitUtil.waitFor;
import static com.tchcareer.utilities.WaitUtil.waitForVisibility;

public class TestStepDefs {
    @Given("Kullanici {string} sayfasini acar")
    public void kullaniciSayfasiniAcar(String url) {
        getDriver().get(url);
        waitFor(3);
        SearchPage.cookieReject.click();
    }

    @And("Giris yap butonuna tiklar")
    public void girisYapButonunaTiklar() {
        waitFor(3);
        actions.moveToElement(mainPageAccount).click(mainPageSignIn).perform();
    }

    @When("Mail alanini doldurur")
    public void mailAlaniniDoldurur() {
        SignInPage.emailBox.sendKeys(VALID_EMAIL);
        waitFor(2);
    }

    @When("Sifre bilgisini doldurur")
    public void sifreBilgisiniDoldurur() {
        waitFor(2);
        SignInPage.passwordBox.sendKeys(VALID_PASSWORD);
    }

    @When("Sifre bilgisini girer {string}")
    public void sifreBilgisiniGirer(String password) {
        waitFor(2);
        SignInPage.passwordBox.sendKeys(password);
    }

    @And("Sign in sayfasindaki giris yap butonuna tiklar")
    public void girisSayfasindakiGirisYapButonunaTiklar() {
        SignInPage.signUpPageSignUpButton.click();
    }

    @Then("Kayitin basarili sekilde tamamlandigi dogrulanir")
    public void kayitinBasariliSekildeTamamlandigiDogrulanir() {
        waitFor(2);
        Assert.assertEquals(MainPage.mainPageSignedIn.getText(),"Ali");
    }

    @When("Mail bilgisini doldurur {string}")
    public void mailBilgisiniDoldurur(String email) {
        SignInPage.emailBox.sendKeys(email);
        waitFor(2);
    }

    @And("Devam et butonuna tiklar")
    public void devamEtButonunaTiklar() {
        SignInPage.continueButton.click();
    }

    @Then("Ilgili hata mesaji teyit edilir {string} {string}")
    public void ilgiliHataMesajiTeyitEdilir(String errorType, String errorMsg) {
        switch (errorType){
            case "1":
                waitForVisibility((By) mailMissingAlert,10);
                Assert.assertEquals(mailMissingAlert.getText(),errorMsg);
                break;
            case "2":
                Assert.assertEquals(SignInPage.MailErrorMsg.getText(),errorMsg);
                break;
            case "3":
                Assert.assertEquals(SignInPage.invalidMailErrorBox.getText(),errorMsg);
                break;
            case "4":
                Assert.assertEquals(SignInPage.passwordAlert.getText(),errorMsg);
                break;
            case "5":
                Assert.assertEquals(SignInPage.passwordErrorMsg.getText(),errorMsg);
                break;
        }
    }

    @And("Uye olun butonuna tiklar")
    public void uyeOlunButonunaTiklar() {
        waitFor(5);
        SignUpPage.mainPageSignUp.click();
    }

    @When("Ad soyad alanini doldurur {string}")
    public void adSoyadAlaniniDoldurur(String name) {
        SignUpPage.nameBox.sendKeys(name);
    }

    @And("E-posta alanini doldurur")
    public void ePostaAlaniniDoldurur() {
        String mailSlurpEmail = inboxDto.getEmailAddress();
        SignUpPage.emailBox.sendKeys(mailSlurpEmail);
    }

    @And("Sifre alanini doldurur {string}")
    public void sifreAlaniniDoldurur(String password) {
        SignUpPage.passwordBox.sendKeys(password);
    }

    @And("Sifre kontrol alanini doldurur {string}")
    public void sifreKontrolAlaniniDoldurur(String password) {
        SignUpPage.passwordCheckBox.sendKeys(password);
    }

    @Then("Hesap oluştur butonuna tiklar")
    public void hesapOlusturButonunaTiklar() {
        SignUpPage.createAccount.click();
    }

    @When("Arama cubugundan bir urun aratir")
    public void aramaCubugundanBirUrunAratir() {
        waitFor(4);
        MainPage.searchBar.sendKeys("araba");
        MainPage.searchBar.sendKeys(Keys.ENTER);
    }

    @And("Bir urune tiklar")
    public void birUruneTiklar() {
        waitFor(3);
        SearchPage.product.click();
    }

    @And("Urunu sepete atar")
    public void urunuSepeteAtar() {
        waitFor(3);
        SearchPage.addToCart.click();
    }

    @Then("Urun sepete eklenir")
    public void urunSepeteEklenir() {
        waitFor(4);
        Assert.assertEquals(SearchPage.addedCart.getText(),"Sepete Eklendi");
    }

    @And("Sepete git butonuna tiklar")
    public void sepeteGitButonunaTiklar() {
        SearchPage.goToCart.click();
    }

    @And("Urunu sepette goruntuler")
    public void urunuSepetteGoruntuler() {
        Assert.assertEquals(SearchPage.cart.getText(),"Ara toplam (1 ürün):");
    }
}
