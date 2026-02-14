# Coffee Machine (Java)

Console-based coffee machine simulation developed as part of the HyperSkill Java Developer track. This project simulates the internal logic of a professional coffee maker, managing ingredient resources, varied drink recipes, and maintenance schedules.

## Features

* **Enum-based Recipe System:** Stores specific ingredient ratios (water, milk, beans) and pricing for Espresso, Latte, and Cappuccino using Java Enums.
* **Smart Resource Tracking:** Monitors real-time levels of water, milk, coffee beans, and disposable cups to ensure order feasibility.
* **Maintenance Guard:** Automatically tracks cup production and restricts operation after 10 servings until a cleaning cycle is performed.
* **Robust State Validation:** Uses fail-fast logic to check machine cleanliness and resource availability before prompting for user input.

## Technologies Used

* **Java 21+**
* **Java Enums** for structured data management and recipe definitions.
* **Guard Clauses** to enforce "fail-fast" logic for cleaning and resource checks.
* **JavaDoc** for comprehensive method and class documentation.
* **AI Collaborative Development:** This project was developed with the assistance of Gemini (AI) to optimize architectural patterns and documentation standards.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/StanIvanov90/HyperSkill-Coffee-Machine.git
   
2. Navigate to the source folder and compile:
   ```bash
   javac machine/*.java

3. Run the application:
   ```bash
   java machine.CoffeeMachine

## Example Usage

Write action (buy, fill, take, clean, remaining, exit):
> buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 1
I have enough resources, making you a coffee!

Write action (buy, fill, take, clean, remaining, exit):
> remaining
The coffee machine has:
150 of water
540 of milk
104 of coffee beans
8 disposable cups
554 of money

Write action (buy, fill, take, clean, remaining, exit):
> buy
I need cleaning!

Write action (buy, fill, take, clean, remaining, exit):
> clean
I have been cleaned!
