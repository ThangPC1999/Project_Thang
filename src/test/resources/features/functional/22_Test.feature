Feature: Test

  Scenario: Test login web facebook
  
    Given I open facebook page
    #When I click textbox number phone on the Facebook page
    And I enters phone of textbox login Facebook
    And I enters password of textbox login Facebook
    And I click button Login on the Facebook page
    Then I should see message login success on the Facebook page