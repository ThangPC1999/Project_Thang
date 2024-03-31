Feature: Register Account

  Scenario: Register Account
    ## Register Account
    Given I open thuocsi page
    And I click button accept popup on the Home page
    When I click button register on the Home Page
    And I enters name of popup register on the Home page
    And I enters phone of popup register on the Home page
    And I enters email of popup register on the Home page
    And I enters password of popup register on the Home page
    And I select province code of popup register on the Home page
    And I choose option radio of popup register on the Home page
    And I click check agree button of popup register on the Home page
    And I click button register account of popup register on the Home page
    Then I should see message register success on the Home page
    ###Update Address For Account
    And I select district on Manage Account page
    And I select ward on Manage Account page
    And I enters address on Manage Account page
    And I click update button on Manage Account page
    Then I should see message update account success on the Home page
    ## #Call API Change Status Account
    When I call api login get token
    And I call api get account code
    And I call api active account
