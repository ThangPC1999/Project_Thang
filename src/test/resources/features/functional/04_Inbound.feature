Feature: Inbound

  Background: Create Product + Sales + Set Location
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

  Scenario: Inbound
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
    ###Delete
    And I call api remove mapping on the Internal WSM page
    When I clear property order
