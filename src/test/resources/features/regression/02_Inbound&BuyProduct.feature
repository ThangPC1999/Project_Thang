Feature: 02 Inbound and Buy Product

  Background: Inbound
    ##Loigin CMS page
    Given I open internal page
    When I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    And I click menu product & setting button on the Internal Home page
    #Then I should see list product on the CMS page
    ##Create product
    When I click button create product on the CMS Product page
    And I enter name product on the CMS Create Product page
    And I select category product on the CMS Create Product page
    And I enter image product on the CMS Create Product page
    And I select product of use on the CMS Create Product page
    #And I enter brand product on the CMS Create Product page
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
    And I call api login get token
    And I open internal page
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
    ###Create PO
    Given I call api login get token
    When I open internal page
    And I click menu insider seller button on the Internal Home page
    And I click buy product button & ticket PO on the Internal MEDX page
    And I click button add new on the Internal MEDX Ticket PO page
    And I enters vendors on the Internal MEDX Ticket PO page
    And I enters ware house "Kho VSIP2 - Bình Dương" on the Internal MEDX Ticket PO page
    And I enters from ware house "Kho VSIP2 - Bình Dương" on the Internal MEDX Ticket PO page
    And I click button add detail product on the Internal MEDX Ticket PO page
    And I enters product name search on the Internal MEDX Ticket PO page
    And I enters quantity on the Internal MEDX Ticket PO page
    And I click button save on the Internal MEDX Ticket PO page
    And I get number PO on the Internal MEDX Ticket PO page
    And I click button confirm on the Internal MEDX Ticket PO page
    ###Check In
    And I click button link PO on the Internal MEDX Ticket PO page
    And I click menu checkin inbound on the Internal WMS page
    And I click button close popup on the Internal WMS Inbound Checkin page
    And I enters number ticket on the Internal WMS Inbound Checkin page
    And I click button checkin on the Internal WMS Inbound Checkin page
    And I enters checkin number on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    And I click menu receive session inbound on the Internal WMS Inbound Checkin page
    And I enters search on the Internal WMS Inbound Checkin page
    And I click number session on the Internal WMS Inbound Checkin page
    And I click button check conveyor on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    And I click button connect on the Internal WMS Inbound Checkin page
    And I click button create code on the Internal WMS Inbound Checkin page
    And I enters code on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    ##Get Basket code
    And I click menu manage warehouse on the Internal WSM page
    And I get button empty bakset on Manage Warehouse WSM page
    And I enters empty basket code on the Internal WMS Inbound Checkin page
    And I click button view detail on the Internal WMS Inbound Checkin page
    And I enters lot on the Internal WMS Inbound Checkin page
    And I enters date on the Internal WMS Inbound Checkin page
    And I click button update lot date on the Internal WMS Inbound Checkin page
    And I click button edit on the Internal WMS Inbound Checkin page
    And I enter new ammounts on the Internal WMS Inbound Checkin page
    And I click button update on the Internal WMS Inbound Checkin page
    And I click button finish on the Internal WMS Inbound Checkin page
    And I click button confirm on the Internal MEDX Ticket PO page
    ###Get QR Code PO
    And I click button detail PO on the Internal WMS Inbound Checkin page
    And I get qr po on the Internal WMS Inbound Detail PO page
    ##GO to web app - put
    And I open internal wms app page
    And I enters name "dUserNamePut" on the Login Internal WMS App page
    And I enters password "dPasswordPut" on the Login Internal WMS App page
    And I click sign in button on the Login Internal WMS App page
    And I click account button on the Internal WMS App page
    And I click department button on the Internal WMS App Account page
    And I click warehouse button on the Internal WMS App Account page
    And I click order button on the Internal WMS App Account page
    And I enters basket code on the Internal WMS App Account page
    And I click start put button on the Internal WMS App Account page
    And I coppy locations code on the Internal WMS App PUT page
    And I coppy qr po code on the Internal WMS App PUT page
    And I click button confirm on the Internal WMS App PUT page
    ###Verify
    And I redirect to detail product skus on the Internal WMS Warehouse page
    Then I should see ammount availability increase on the Internal WMS Warehouse page
    ###Log out
    And I redirect to manage account on the Internal WMS App page
    And I click button sign out on the Internal WMS App page

  Scenario: Buy Product
    ##Android Login
    #Given I click skip button on App Driver ThuocSi
    #When I enters username on App Driver ThuocSi
    #And I enters password on App Driver ThuocSi
    #And I click signin button on App Driver ThuocSi
    #And I click location button on App Driver ThuocSi
    #And I click continous button on App Driver ThuocSi
    #And I click location using button on App Driver ThuocSi
    #And I click location button on App Driver ThuocSi
    #Given I click menu home button on App Driver ThuocSi
    ##Get Province
    When I call api login get token
    And I open internal page
    And I enters name on the Login Internal page
    And I enters password on the Login Internal page
    And I click sign in button on the Login Internal page
    ##Get Area
    And I click menu product & setting button on the Internal Home page
    And I click menu area button on the CMS page
    Then I should see area division on the CMS page
    ## Register Account
    #Given I open thuocsi page
    #And I click button accept popup on the Home page
    #When I click button register on the Home Page
    #And I enters name of popup register on the Home page
    #And I enters phone of popup register on the Home page
    #And I enters email of popup register on the Home page
    #And I enters password of popup register on the Home page
    #And I select province code of popup register on the Home page
    #And I choose option radio of popup register on the Home page
    #And I click check agree button of popup register on the Home page
    #And I click button register account of popup register on the Home page
    #Then I should see message register success on the Home page
    #Update Address For Account
    #And I select district on Manage Account page
    #And I select ward on Manage Account page
    #And I enters address on Manage Account page
    #And I click update button on Manage Account page
    #Then I should see message update account success on the Home page
    #Call API Change Status Account
    #When I call api login get token
    #And I call api get account code
    #And I call api active account
   ###Order
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
