Feature: Test Case 24: Download Invoice after purchase order

  @wip
  Scenario: e2e test: Download Invoice after purchase order
    When The user navigates to url
    Then Verify that the user is on the "Home" page
    And The user adds following products to cart and clicks "Continue Shopping" button
      | Men Tshirt                   |
      | Fancy Green Top              |
      | Little Girls Mr. Panda Shirt |
      | Pure Cotton V-Neck T-Shirt   |
      | Blue Top                     |
    And The user clicks "Cart" menu
    Then Verify that the user is on the "Cart" page
    And The user clicks "Proceed To Checkout" button
    And The user clicks "Register / Login" button
    And The user creates an account by clicking the "Create Account" button after filling in all the details in the Sign Up form
    Then Verify that "Account Created!" text is displayed
    And The user clicks "Continue" button
    Then Verify that "Logged in as John Doe" text is displayed
    And The user clicks "Cart" menu
    And The user clicks "Proceed To Checkout" button
    Then Verify that address details and review order
      | Men Tshirt                   |
      | Fancy Green Top              |
      | Little Girls Mr. Panda Shirt |
      | Pure Cotton V-Neck T-Shirt   |
      | Blue Top                     |
    And The user enters "5 product will be ordered" description in comment text area
    And The user clicks "Place Order" button
    And The user enters payment details as "name-on-card" "card-number" "cvc" "expiry-month" "expiry-year"
    And The user clicks "Pay and Confirm Order" button
    Then Verify that "Congratulations! Your order has been confirmed!" text is displayed
    And  The user clicks "Download Invoice" button new
    And  Verify that invoice is downloaded successfully.
    And The user clicks "Continue" button
    And The user clicks " Delete Account" button
    Then Verify that "Account Deleted!" text is displayed
    And The user clicks "Continue" button






