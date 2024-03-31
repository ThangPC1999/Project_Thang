Feature: Create Voucher Percent

  Scenario: Create Voucher Percent
    ##Loigin CMS page
    Given I open internal page
    When I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I click menu list code promotion button on the Internal Home page
    Then I should see list code promotion on the Internal Marketing page
    ### Click add new
    When I click button add new code promotion on the Internal Marketing page
    And I enters code promotion on the Internal Marketing page
    And I enters code name promotion on the Internal Marketing page
    And I select voucher type "Chương trình giảm giá" on the Internal Marketing page
    And I select voucher group "Nhóm Mã MANUAL" on the Internal Marketing Promotion page
    And I upload logo voucher on the Internal Marketing page
    And I enters start date on the Internal Marketing page
    And I enters public date on the Internal Marketing page
    And I select reward type "Giảm giá theo %" on the Internal Marketing page
    And I enters percent discount on the Internal Marketing page
    And I enters max discount on the Internal Marketing page
    And I click change status on the Internal Marketing page
    And I click button add code promotion on the Internal Marketing page
    ###Login Add Voucher
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    #Quick Order
    And I click menu quick order on Manage Account page
    And I enter ammount product on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    ###Click View Cart
    When I click view cart on Quick Order page
    And I click button add promotion code on Payment page
    And I enters promotion code on Payment page
    And I click button use now on Payment page
    Then I should see total money before use discount percent on Payment page
    ###
    When I click contiunous payment button on Cart page
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    ##Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    ###Open new Tab
    When I open new tab
    And I open internal page
    ###Click Menu Customer & Order
    And I click menu customer & order button on the Internal Home page
    And I click menu order button on the Internal CRM page
    And I enters order id on the CRM page
    And I click apply button on the CRM page
    Then I should see total money using percent discount on the CRM page
    When I clear property order
