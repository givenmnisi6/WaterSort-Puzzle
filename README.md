# Water Sort Puzzle


## MAIN IDEA
- In order to check if a game is completed one needs to check if all the colours in a bottle are the same. A generic version of this method should be added to the MyArrayList class called:
- public boolean checkUniform() - The method should return true if all the filled entries are identical.

- Make sure you have a accessor for the instance variable called:
- public int getSize()

## Modifications
Make the following Additions to the StackAsMyArrayList class

- Push and Pop but there is another common one called Peek. Peek returns the value of the top element without removing it. 
- You need to create a Peek method:
- public E peek()
- We are going to add 2 non-typical stack methods [just to make this cool game work!]
- public int getStackSize()  which calls the getSize() method of the MyArrayList class
- public boolean checkStackUniform() which calls the checkUniform() method of the MyArrayList class

### Mix-up 
Start with three sorted bottles. In the strategy the idea is to load three bottles with uniform colour and then move ink around for a number of moves until the bottles are mixed up.
- Advantage: Result is always solvable since the bottles are created in a reversed-game	strategy.
- Disadvantage: It is hard to develop an algorithm which will reach the bottoms of the bottles. We tried this by moving on item from every bottle in rounds. But it still took more than 100 moves to obtain a good mix in the bottles.

## Playing the game
- Implemented finer rules such as that one that if there is enough space  in the target bottle and the source bottle has 2 adjacent similar colour spots, both will be poured.
- You try to sort the colored water in the glasses until all colors in the same glass. A challenging yet relaxing game to exercise your brain!

![image](https://user-images.githubusercontent.com/81802355/203614813-4b3c21ac-8ba9-4cd8-90e4-f21da775c8a6.png)
