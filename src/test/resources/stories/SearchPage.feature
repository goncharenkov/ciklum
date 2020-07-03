@Automated
Feature: As an applicant I want to find all developer positions in Frankfurt am Main, so that I can apply for a position.
  Search page is used for the search
  Correct amounts of open positions are found
  Click on a position result leads to a subpage, which displays the correct job title
  On the subpage the button `"Jetzt Bewerben"` can be clicked
  Reveals the application e-mail `"dbz-bewerbung@deutschebahn.com"`

  Scenario Outline:
    Given The user has opened a website as "<ScreenSize>"
    And The user has navigated to a search page
    When The user has entered the desired position "<Position>"
    And The user has selected the desired location "<Location>"
    Then The system should display at least "<Amount>" of opened positions

    When The user has clicked on the first found result with the text "<Position>" and "<Location>"
    Then The system should open the new page "zeitarbeit-de/bewerber/jobs-deutsche-bahn"
    And The title should contain the "<Position>" and "<Location>"

    When The user has clicked the apply button
    Then The system should reveals the application e-mail "dbz-bewerbung@deutschebahn.com"

    Examples:
      | ScreenSize | Position               | Location         | Amount |
      | desktop    | Java Developer         | Frankfurt (Main) | 1      |
      | tablet     | React Native Developer | Frankfurt (Main) | 1      |