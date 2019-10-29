@smokeTest
Feature: Ability to create a new record by registering to shaadi.com
  Sign off - (Pending)
  @TC_001
  Scenario: Registration flow for community Marathi
    Given Navigate to Community Registration Page "https://www.marathishaadi.com/"
    And Click SignUp option
    And Enter Below Details
    |Email ID        |Password    |
    |XXX234@gmail.com|Password@234|
    And Create Profile for "Self"
    And Select Gender
    And Verify MotherTongue for "Marathi"
    
 @TC_002
  Scenario: Registration flow for community Gujarati
    Given Navigate to Community Registration Page "https://www.gujaratishaadi.com/"
    And Click SignUp option
    And Enter Below Details
    |Email ID        |Password    |
    |XXX234@gmail.com|Password@234|
    And Create Profile for "Self"
    And Select Gender
    And Verify MotherTongue for "Gujarati"