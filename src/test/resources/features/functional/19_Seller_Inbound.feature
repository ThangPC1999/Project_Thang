Feature: Seller Inbound

  Background: Seller Create Product
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
    ##Setting Locations
    When I open internal page
    ####Go to warse house
    And I click menu warehouse on the Internal Home page
    And I click warehouse "Kho Bình Dương" on the Internal WMS page
    And I click menu manage warehouse on the Internal WSM page
    And I click sub menu setting location product on the Internal WSM page
    And I enters product search on the Internal WSM page
    And I enters location search on the Internal WSM page

  Scenario: Seller Create Product
    Given I open Seller page
    #When I enters name on the Login Seller page
    #And I enters password on the Login Seller page
    #And I click sign in button on the Login Seller page
    ##Click Menu
    And I click menu "Quản lý kho" on the Seller Home page
    And I click menu "Phiếu gửi hàng" on the Seller Home page
    And I click create draft ticket button on the Seller Home page
    And I select warehouse "Kho Bình Dương" on the Seller Home page
    And I select delivery method "Nhà bán hàng tự vận chuyển" on the Seller Home page
    And I enter expectdate on the Seller Home page
    And I enter expecttime on the Sellter Home page
    And I click add product on the Seller Home page
    And I enters product name search on the Seller Home page
    And I click add product icon on the Seller Home page
    And I click closed popup button on the Seller Home page
    And I enters lot on the Seller Home page
    And I enters date on the Seller Home page
    And I click create ticket button on the Seller Home page
    And I click print button on the Seller Home page
    And I click complete gift button on the Seller Home page
    And I enters package quantity on the Seller Home page
    And I click download button on the Seller Home page
    And I click download button on the Seller Home page
    Then I get ticket number on the Seller Home page
    ##Setting Locations
    When I open internal page
    ###Check in
    And I click menu warehouse on the Internal Home page
    And I click warehouse "Kho Bình Dương" on the Internal WMS page
    And I click menu checkin inbound on the Internal WMS page
    And I click button close popup on the Internal WMS Inbound Checkin page
    And I enters number ticket on the Internal WMS Inbound Checkin page
    And I click button checkin on the Internal WMS Inbound Checkin page
    And I enters checkin number on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    And I click menu receive session inbound on the Internal WMS Inbound Checkin page
    And I enters search on the Internal WMS Inbound Checkin page
    And I click number session on the Internal WMS Inbound Checkin page
    And I click button check conveyor on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    And I click button connect on the Internal WMS Inbound Checkin page
    And I click button create code on the Internal WMS Inbound Checkin page
    And I enters code on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    ##Get Basket code
    And I click menu manage warehouse on the Internal WSM page
    And I get button empty bakset on Manage Warehouse WSM page
    And I enters empty basket code on the Internal WMS Inbound Checkin page
    And I click button view detail on the Internal WMS Inbound Checkin page
    And I enters lot on the Internal WMS Inbound Checkin page
    And I enters date on the Internal WMS Inbound Checkin page
    And I click button update lot date on the Internal WMS Inbound Checkin page
    And I click button edit on the Internal WMS Inbound Checkin page
    And I enter new ammounts on the Internal WMS Inbound Checkin page
    And I click button update on the Internal WMS Inbound Checkin page
    And I click button finish on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    ###Get QR Code PO
    And I click button detail PO on the Internal WMS Inbound Checkin page
    And I get qr po on the Internal WMS Inbound Detail PO page
    ##GO to web app - put
    And I open internal wms app page
    And I enters name "dUserNamePut" on the Login Internal WMS App page
    And I enters password "dPasswordPut" on the Login Internal WMS App page
    And I click sign in button on the Login Internal WMS App page
    And I click account button on the Internal WMS App page
    And I click department button on the Internal WMS App Account page
    And I click warehouse button on the Internal WMS App Account page
    And I click order button on the Internal WMS App Account page
    And I enters basket code on the Internal WMS App Account page
    And I click start put button on the Internal WMS App Account page
    And I coppy locations code on the Internal WMS App PUT page
    And I coppy qr po code on the Internal WMS App PUT page
    And I click button confirm on the Internal WMS App PUT page
    ###Verify
    And I redirect to detail product skus on the Internal WMS Warehouse page
    Then I should see ammount availability increase on the Internal WMS Warehouse page
    ###Delete
    And I call api remove mapping on the Internal WSM page
    When I clear property order
