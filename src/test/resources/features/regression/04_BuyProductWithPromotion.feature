Feature: 04 Buy Product With Promotion

  Background: Create Promotion
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
    And I click button add new promotion code on the Internal Marketing List Promotion page
    And I enters code promotion on the Internal Marketing page
    And I select reward type "Giảm giá tuyệt đối" on the Internal Marketing page
    And I enters absolute discount on the Internal Marketing page
    And I click change status on the Internal Marketing page
    And I click button add code promotion on the Internal Marketing page

  Scenario: 04 Buy Product With Promotion
    #Android Login
    #Given I click skip button on App Driver ThuocSi
    #When I enters username on App Driver ThuocSi
    #And I enters password on App Driver ThuocSi
    #And I click signin button on App Driver ThuocSi
    #And I click location button on App Driver ThuocSi
    #And I click continous button on App Driver ThuocSi
    #And I click location using button on App Driver ThuocSi
    #And I click location button on App Driver ThuocSi
    #Given I click menu home button on App Driver ThuocSi
    #Get Province
    When I call api login get token
    ##Get Area
    And I click menu product & setting button on the Internal Home page
    And I click menu area button on the CMS page
    Then I should see area division on the CMS page
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
    Then I should see total money before use discount absolute on Payment page
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
    Then I should see total money using absolute discount on the CRM page
    And I click change status order button on the CRM page
    Then I should see status order changed on the CRM page
    #Click SO Number
    When I click number so button on the CRM page
    ###Active Ticket
    And I click view ticket pick button on the WSM page
    And I click active ticket on the Detail Ticket WSM page
    And I enters reason active ticket on the Detail Ticket WSM page
    And I click active button on Detail Ticket WSM page
    Then I should see status change "Chờ lấy hàng" on the Internal Detail Ticket WMS page
    ##Get VAT
    When I open new tab
    And I open internal page
    And I click menu insider seller button on the Internal Home page
    And I click product button & sales product on the Internal MEDX page
    And I get VAT product on the MEDX page
    And I closed current tab and switch old tab
    #Checkin Zone Pick
    When I call api login account pick get token
    And I call api checkin zone pick
    #Asign Sub Pick
    And I call api login get token
    And I call api assign sub pick
    ## Recieve Oder
    And I call api receive order ticket
    Then I should see status change "Đang lấy hàng" on the Internal Detail Ticket WMS page
    ## Assign basket code
    When I click menu manage warehouse on the Internal WSM page
    And I click button empty bakset on Manage Warehouse WSM page
    And I call api assign basket code for pick ticket
    ## Pick sub pick
    And I call api pick sub pick ticket
    And I call api complete sub pick ticket
    Then I should see status change "Chờ QC" on the Internal Detail Ticket WMS page
    #GO To QC Coppy QR
    When I click menu QC on the WSM page
    And I click button start shift on the QC WSM page
    And I enters location on the QC WSM page
    And I click apply on the QC WSM page
    And I enters number pick on the QC WSM page
    And I coppy qr code on the QC WSM page
    And I click button finished on the QC WSM page
    Then I should see status change "CHỜ ĐÓNG GÓI" on the Internal Detail Ticket WMS page
    #Open WMS APP
    When I open new tab
    And I open internal wms app page
    And I enters name "dUserNamePack" on the Login Internal WMS App page
    And I enters password "dPasswordPack" on the Login Internal WMS App page
    And I click sign in button on the Login Internal WMS App page
    And I click account button on the Internal WMS App page
    And I click department button on the Internal WMS App Account page
    And I click warehouse button on the Internal WMS App Account page
    And I click pack button on the Internal WMS App Account page
    And I enters search location on the Internal WMS App page
    And I enters search so on the Internal WMS App Pack page
    And I click start pack button on the Internal WMS App Pack page
    And I click popup information button on the Internal WMS App Pack page
    And I click notification button on the Internal WMS App Pack page
    And I enters search number packet on the Internal WMS App Pack page
    And I upload image on the Internal WMS App Pack page
    And I click finish button on the Internal WMS App Pack page
    ###Back
    When I open new tab
    When I open internal login page
    When I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I redirect url to detail ticket
    Then I should see status change "ĐÃ HOÀN THÀNH" on the Internal Detail Ticket WMS page
    When I click book logistic button on the Internal Detail Ticket WMS page
    ###Go to Logistic
    And I click menu logistic button on the Internal Detail Ticket WMS page
    And I click HUB button on the Internal Logistic page
    And I enters hub search on the Internal Logistic page
    And I click item hub on the Internal Logistic page
    And I get number so on the Internal Logistic Manage Hub page
    And I click handover button on the Internal Logistic Manage Hub page
    And I click submenu handover button on the Internal Logistic Manage Hub page
    And I select option handover on the Internal Logistic Handover page
    And I select name from hub handover on the Internal Logistic Handover page
    And I select name to hub handover on the Internal Logistic Handover page
    And I select license plate on the Internal Logistic Handover page
    And I click start delivery button Internal Logistic Handover page
    And I get ticket transport on the Internal Logistic Handover page
    And I scan ticket number so on the Internal Logistic Handover page
    And I click complete rotation button on the Internal Logistic Handover page
    ###Go To My Hub
    And I enters my hub search on the Internal Logistic page
    And I click item my hub on the Internal Logistic page
    And I click wating for stock button on the Internal Logistic Managehub page
    And I click receipt button on the Internal Logistic Managehub page
    And I enters scan oders on the Internal Logistic Managehub page
    And I click finish ticket button on the Internal Logistic Managehub page
    And I click confirm finish button on the Internal Logistic Managehub page
    And I click item my hub on the Internal Logistic page
    And I click assign driver button on the Internal Logistic Managehub page
    And I select driver on the Internal Logistic Managehub page
    And I click confirm finish button on the Internal Logistic Managehub page
    ###APP Driver
    ## Recieve Pack
    And I call api login account driver get token
    And I call api change status delivering
    And I call api change status delivered
    ####Check Status On Accountain
    And I open new tab
    And I open internal page
    And I click menu accountain button on the Internal Detail Ticket WMS page
    And I click sub item menu customer invoice on the Internal Accountain page
    And I enters so number on the Internal Accountain Invoice page
    Then I should see status "CHỜ THU TIỀN" on the Internal Accountain Invoice page
    ###Update Status Order
    And I call api get reconcile code
    And I call api get line id
    And I call api change status order checking
    And I call api change status reconcile seesion
    ###Click Control Driver
    And I click item my hub on the Internal Logistic page
    And I click control driver button on the Internal Logistic Managehub page
    And I enter number ticket on the Internal Logistic Managehub Control Driver page
    And I click detail ticket on the Internal Logistic Managehub Control Driver page
    ##Verify
    Then I should see total money on the Internal Logistic Managehub Control Driver page
    ### Click For Control
    When I click for control button on the Internal Logistic Managehub Control Driver page
    And I click confirm finish button on the Internal Logistic Managehub page
    ##For Control Accountain
    And I click item my hub on the Internal Logistic page
    And I click control accountant button on the Internal Logistic Managehub page
    And I enter number ticket on the Internal Logistic Managehub Control Driver page
    And I click detail ticket accountain on the Internal Logistic Managehub Control Accountain page
    And I enters ticket numbers on the Internal Logistic Managehub Control Accountain page
    And I click item ticket on the Internal Logistic Managehub Control Accountain page
    And I click payment button on the Internal Logistic Managehub Control Accountain page
    And I click confirm finish button on the Internal Logistic Managehub page
    ##Go To Accountain
    And I click menu accountain button on the Internal Detail Ticket WMS page
    And I click sub item menu list control hub on the Internal Accountain page
    And I enters ticket id on the Internal Accountain List Control Hub page
    And I click detail control session on the Internal Accountain List Control Hub page
    And I enter money on the Internal Accountain Detail Control Hub page
    And I click start control button on the Internal Accountain Detail Control Hub page
    And I click confirm finish button on the Internal Logistic Managehub page
    ####Check Status On Accountain
    And I open new tab
    And I open internal page
    And I click menu accountain button on the Internal Detail Ticket WMS page
    And I click sub item menu customer invoice on the Internal Accountain page
    And I enters so number on the Internal Accountain Invoice page
    Then I should see status "HOÀN TẤT" on the Internal Accountain Invoice page
    ##Switch to tap thuocsi
    When I switch to old tab
    Then I should see status order changed "Đã hoàn tất" on Manage Account page
    ##Verify status
    #Then I should see status change "Chờ lấy hàng" on the Internal Detail Ticket WMS page
    #When I call api delete ticket
    When I clear property order
