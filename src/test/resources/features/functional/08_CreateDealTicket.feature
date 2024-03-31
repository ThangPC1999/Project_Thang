Feature: Create Deal Ticket

  Background: Create Product & Post For Sale
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

  Scenario: Create Deal Ticket
    ##Loigin CMS page
    Given I open internal page
    And I click menu list deal ticket button on the Internal Home page
    Then I should see list deal ticket on the Internal Marketing page
    When I click button create ticket on the Internal Marketing page
    And I enters product name on the Internal Marketing page
    And I click button save create ticket on the Internal Marketing page
    And I click button approve ticket on the Internal Marketing page
    Then should see status ticket approve "Đã duyệt" on the Internal Marketing page
    ### Click add new
    When I clear property order
