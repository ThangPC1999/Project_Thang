Feature: Order Product
#
  Scenario: Order Product COD Random
    When I clear property order
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    #Order
    And I click menu quick order on Manage Account page
    And I entes ammount 20 with random product name on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "COD" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    ####Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    When I clear property order
#
  Scenario: Order Product COD By Name
    When I clear property order
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    #####Order Product
    And I click menu quick order on Manage Account page
    And I enters product name "Obagi 300ml Be Anh" on Quick Order page
    And I entes ammount 20 with product name "Obagi 300ml Be Anh" on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #####Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "COD" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    #####Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    When I clear property order

  Scenario: Order Product COD
    When I clear property order
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    #Order
    And I click menu quick order on Manage Account page
    And I entes ammount 20 with random product name on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "COD" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    #Order Product
    When I click edit order on Payment page
    And I click menu quick order on Manage Account page
    And I enters product name "Obagi 300ml Be Anh" on Quick Order page
    And I entes ammount 20 with product name "Obagi 300ml Be Anh" on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "COD" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    ###Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    When I clear property order

  ###############################################################################################################################################################
  Scenario: Order Product Bank Transfer
    When I clear property order
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    #Order
    And I click menu quick order on Manage Account page
    And I entes ammount 20 with random product name on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #Click View Cart
    When I click view cart on Quick Order page
    And I click contiunous payment button on Cart page
    And I seletect payment type "Bank" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    ###Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    When I clear property order

  Scenario: Order Product Transfer By Name
    When I clear property order
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    ####Order Product
    And I click menu quick order on Manage Account page
    And I enters product name "Obagi 300ml Be Anh" on Quick Order page
    And I entes ammount 20 with product name "Obagi 300ml Be Anh" on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    ####Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "Bank" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    ####Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    When I clear property order

  Scenario: Order Product Transfer
    When I clear property order
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button sign in on the Home Page
    And I enters phone "dAccountPhone" of popup sign in on the Home page
    And I enters password "dAccountPassword" of popup sign in on the Home page
    And I click button sign in of popup sign in on the Home Page
    #Order
    And I click menu quick order on Manage Account page
    And I entes ammount 20 with random product name on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "Bank" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
    #Order Product
    When I click edit order on Payment page
    And I click menu quick order on Manage Account page
    And I enters product name "Obagi 300ml Be Anh" on Quick Order page
    And I entes ammount 20 with product name "Obagi 300ml Be Anh" on Quick Order page
    Then I should see information product matches with cart on Quick Order page
    #Click View Cart
    When I click view cart on Quick Order page
    When I click contiunous payment button on Cart page
    And I seletect payment type "COD" on Payment pages
    And I click payment button on Payment page
    Then I should see payment success on Payment page
   #### Go to detail
    When I click detail bill on Payment page
    Then I should see status bill on Manage Account page
    And I should see status order changed "Chờ xác nhận" on Manage Account page
    When I clear property order
