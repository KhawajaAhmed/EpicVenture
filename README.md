#  EpicVenture: A World Unveiled in Text

Explore a captivating text-based world where you can move between rooms, uncover hidden objects and secrets, and solve puzzles to progress. With your trusty backpack, you can carry and use items to aid you on your journey. Seamlessly pick up and drop items between rooms to solve puzzles and overcome obstacles. Get fully immersed in the experience as you examine every object and room, using your sharp eye to uncover clues and solve puzzles. Are you ready to embark on an adventure like no other?

The game is implemented in Java, utilizing fundamental object oriented programming concepts like inheritance, encapsulation, abstraction, and polymorphism. The game has been tested for bugs and the code has been optimized for efficiency.

*This game is an inspiration from the game series "Zork".

# Technical Details

*The game has these four Java files.*

**ContainerItem.java:**
* Code for the backpack that stores objects for retrieval.
* Allows for the storage and transfer of objects between rooms.
  
**Driver.java:**
* The main component of the game, responsible for driving the game logic.
* Creates and populates rooms, places objects, and processes user commands.
* Supports commands like 'examine,' 'look,' and 'move.'

**Item.java:**
* Defines the attributes and behaviors of in-game objects.
* Each object in the game is an instance of this class.

**Location.java:**
* Defines the different rooms or locations in the game.
* Each room is an instance of this class, with a 'name,' 'description,' and items.

