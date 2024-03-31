Feature: Create Accumulated Points

  Scenario: Create Accumulated Points
    When I clear property order
    ##Loigin CMS page
    Given I open internal page
    When I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I click menu list promotion button on the Internal Home page
    Then I should see list promotion on the Internal Marketing page
    ### Click add new
    When I click button add new promotion on the Internal Marketing List Promotion page
    And I enters promotion name on the Internal Marketing Promotion page
    And I enters promotion content on the Internal Marketing Promotion page
    And I select promotion type "Chương trình giảm giá" on the Internal Marketing Promotion page
    And I select voucher group "Nhóm Mã MANUAL" on the Internal Marketing Promotion page
    And I upload logo voucher on the Internal Marketing Promotion page
    And I enters start date on the Internal Marketing Promotion page
    And I enters public date on the Internal Marketing Promotion page
    And I select reward type "Giảm giá tuyệt đối" on the Internal Marketing page
    And I enters absolute discount on the Internal Marketing page
    And I click button add new promotion code on the Internal Marketing List Promotion page
    ###Login Add Voucher
    And I click menu list exchange point button on the Internal Home page
    Then I should see list exchange point on the Internal Marketing page
    ### Click add new
    When I click button add new exchange point on the Internal Marketing List Exchange Point page
    And I enters promotion name on the Internal Marketing Create Exchange Point page
    And I enters point on the Internal Marketing Create Exchange Point page
    And I enters point on the Internal Marketing Create Exchange Point page
    And I select status display "Bật" on the Internal Marketing Create Exchange Point page
    And I click button save point on the Internal Marketing Create Exchange Point page
    When I clear property order
