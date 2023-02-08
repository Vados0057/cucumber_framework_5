Feature: Validate Etsy features

  Scenario: Validate Etsy Header
    Given user navigates to "https://www.etsy.com/"
    Then user should see below headers
      | Gifts for Every Valentine | Jewelry & Accessories | Clothing & Shoes | Home & Living | Wedding & Party | Toys & Entertainment | Art & Collectibles | Craft Supplies | Gifts & Gift Cards |
