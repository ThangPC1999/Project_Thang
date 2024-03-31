Feature: Seller Add Product Base On Medx

  Background: Create Product
    #Loigin CMS page
    Given I open internal page
    When I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I click menu product & setting button on the Internal Home page
    Then I should see list product on the CMS page
    #Create product
    When I click button create product on the CMS Product page
    And I select owner "ThinhQC" on the CMS Create Product page
    And I enter name product on the CMS Create Product page
    And I select category product on the CMS Create Product page
    And I enter image product on the CMS Create Product page
    And I select product of use on the CMS Create Product page
    And I enter brand product on the CMS Create Product page
    And I sellect unit product on the CMS Create Product page
    And I enter option packing product on the CMS Create Product page
    And I select origin product on the CMS Create Product page
    And I select manufacturer product on the CMS Create Product page
    And I select industry product on the CMS Create Product page
    And I click button save on the CMS Create Product page
    And I open internal page
    And I click menu product & setting button on the Internal Home page
    And I click menu area button on the CMS page
    Then I should see area division on the CMS page
    ##
    And I click menu insider seller button on the Internal Home page
    And I click product button & sales product on the Internal MEDX page
    #Sale Product
    And I click button sales product on the MEDX page
    And I enters product code on the MEDX Sales Product page
    And I enters location code on the MEDX Sales Product page
    And I enters price on the MEDX Sales Product page
    And I click button save on the MEDX Sales Product page

  Scenario: Seller Create Product With Have Product In Medx
    Given I open Seller page
    When I enters name on the Login Seller page
    And I enters password on the Login Seller page
    And I click sign in button on the Login Seller page
    ##Click Menu
    And I click menu "Quản lý sản phẩm" on the Seller Home page
    And I click menu "Thêm sản phẩm" on the Seller Home page
    And I enters product name search on the Seller Home page
    And I click button select buy on the Seller Home page
    And I enters seller sku on the Seller Home page
    And I select status buy "Đang bán" on the Seller Home page
    And I select category "Cơ, xương, khớp" on the Seller Home page
    And I select seller category "Thuốc" on the Seller Home page
    And I select manufacturer "Châu Long Phát" on the Seller Home page
    And I select efficacy codes "Test - Xương" on the Seller Home page
    And I select locations "regionName" on the Seller Home page
    And I enters raw price on the Seller Home page
    And I enters seller inventory on the Seller Home page
    And I click button save create product on the Seller Home page
    ##Post for sale Seller
    Given I open new tab
    When I open internal page
    And I click menu seller button on the Internal Home page
    And I click sub menu request approve button on the Internal Seller page
    And I click status pending approve button on the Internal Seller page
    And I enters product name on the Internal Seller page
    And I click apply button on the Internal Seller page
    And I click checkbox item product on the Internal Seller page
    And I click view detail item product on the Internal Seller page
    And I click accept button on the Internal Seller page