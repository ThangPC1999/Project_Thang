Feature: Create Campaign Promotion Absolute

  Background: Create Product
    When I clear property order
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
    ##		And I enter brand product on the CMS Create Product page
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

  Scenario: Create Campaign Promotion Absolute
    ##Loigin CMS page
    ##Loigin CMS page
    Given I open internal page
    And I click menu list campaign button on the Internal Home page
    Then I should see list campaign on the Internal Marketing page
    ### Click add new
    When I click button create new campaign on the Internal Marketing List Campaign page
    And I select campaign type "Chương trình khuyến mãi" on the Internal Marketing List Campaign page
    And I enters campaign name on the Internal Marketing List Campaign page
    And I upload banner on the Internal Marketing List Campaign page
    And I enters registration start date on the Internal Marketing List Campaign page
    And I click button save campaign on the Internal Marketing List Campaign page
    And I click button active campaign on the Internal Marketing List Campaign page
    ##Go to Campaign Ticket
    And I click menu list campaign ticket button on the Internal Home page
    Then I should see list campaign ticket on the Internal Marketing page
    When I click button create new campaign ticket on the Internal Marketing List Campaign Ticket page
    And I select sale campaign on the Internal Marketing List Campaign Ticket page
    And I select pricing product name on the Internal Marketing List Campaign Ticket page
    And I select sale type "Giảm giá tuyệt đối" on the Internal Marketing List Campaign Ticket page
    And I enters campaign price on the Internal Marketing List Campaign Ticket page
    And I enters quantity on the Internal Marketing List Campaign Ticket page
    And I click button save on the Internal Marketing List Campaign Ticket page
    And I click button active on the Internal Marketing List Campaign Ticket page
    When I clear property order
    