Feature: Set Location Ware House

  Background: Create Product
    ##Loigin CMS page
    Given I open internal page
    When I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I click menu product & setting button on the Internal Home page
    Then I should see list product on the CMS page
    ##Create product
    When I click button create product on the CMS Product page
    And I enter name product on the CMS Create Product page
    And I select category product on the CMS Create Product page
    And I enter image product on the CMS Create Product page
    And I select product of use on the CMS Create Product page
    #		And I enter brand product on the CMS Create Product page
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
    ###
    And I click menu insider seller button on the Internal Home page
    And I click product button & sales product on the Internal MEDX page
    ##Sale Product
    And I click button sales product on the MEDX page
    And I enters product code on the MEDX Sales Product page
    And I enters location code on the MEDX Sales Product page
    And I enters price on the MEDX Sales Product page
    And I click button save on the MEDX Sales Product page

  Scenario: Set Location Ware House
    Given I call api login get token
    When I open internal page
    ##Click Menu Product & Setting
    And I click menu product & setting button on the Internal Home page
    And I get product id on the CMS page
    ##Go to warse house
    And I click menu warehouse on the Internal Home page
    And I click warehouse "Kho Bình Dương" on the Internal WMS page
    And I click menu manage warehouse on the Internal WSM page
    And I click sub menu setting location product on the Internal WSM page
    And I enters product search on the Internal WSM page
    And I enters location search on the Internal WSM page
    ###Delete
    And I call api remove mapping on the Internal WSM page
    When I clear property order
