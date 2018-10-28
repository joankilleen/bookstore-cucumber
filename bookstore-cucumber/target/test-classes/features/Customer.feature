#Author: joan.killeen@bluewin.ch

Feature: Registration of a customer

  Scenario: Registration of a customer
    Given registration: username "JoanK" and password "Fitz01" 
    And address: city "Berne" and country "CH" and street "Zugweg" and postal code "1234"
    And credit card: type "MasterCard" and number "5000111122223333" and expiration month "08" and expiration year "20" 
