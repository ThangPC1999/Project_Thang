Feature: Seller Add Product

  Scenario: Seller Create Product
    Given I open Seller page
    When I enters name on the Login Seller page
    And I enters password on the Login Seller page
    And I click sign in button on the Login Seller page
    ##Click Menu
    And I click menu "Quản lý sản phẩm" on the Seller Home page
    And I click menu "Thêm sản phẩm" on the Seller Home page
    And I enters product name on the Seller Home page
    And I enters seller sku on the Seller Home page
    And I select status buy "Đang bán" on the Seller Home page
    And I select category "Cơ, xương, khớp" on the Seller Home page
    And I select seller category "Thuốc" on the Seller Home page
    And I select manufacturer "Châu Long Phát" on the Seller Home page
    And I select efficacy codes "Test - Xương" on the Seller Home page
    And I select locations "Miền Nam" on the Seller Home page
    And I upload image logo on the Seller Home page
    And I enters raw price on the Seller Home page
    And I enters seller inventory on the Seller Home page
    And I enters volume on the Seller Home page
    And I select unit "Hộp" on the Seller Home page
    And I click button save create product on the Seller Home page
    ##Post for sale Seller
    Given I open new tab
    When I open internal page
    And I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I click menu seller button on the Internal Home page
    And I click sub menu request approve button on the Internal Seller page
    And I click status pending approve button on the Internal Seller page
    And I enters product name on the Internal Seller page
    And I click apply button on the Internal Seller page
    And I click checkbox item product on the Internal Seller page
    And I click view detail item product on the Internal Seller page
    And I click accept button on the Internal Seller page
    When I clear property order
    