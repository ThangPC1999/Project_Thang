#Feature: Search Product
#
  #Background: Login Account
    #Given I open thuocsi page
    #And I click button accept popup on the Home page
    #When I click button sign in on the Home Page
    #And I enters phone "dAccountPhone" of popup sign in on the Home page
    #And I enters password "dAccountPassword" of popup sign in on the Home page
    #And I click button sign in of popup sign in on the Home Page
#
  #Scenario Outline: Search Product
    #Then I should see product search with "<productName>" on the Home page
#
    #Examples: 
      #| productName    |
      #| vrohto,v-rohto |
      #| vrohto         |
      #| v-rohto        |
#
  #Scenario Outline: Search Quick Order
    #And I click menu quick order on Manage Account page
    #Then I should see product quick order search with "<productName>" on the Home page
#
    #Examples: 
      #| productName  |
      #| upsac,upsa-c |
      #| upsac        |
      #| upsa-c       |
