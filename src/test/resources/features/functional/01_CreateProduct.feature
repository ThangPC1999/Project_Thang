Feature: Create Product

  Scenario: Create Product
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
    When I clear property order
