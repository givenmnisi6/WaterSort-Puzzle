import java.util.Scanner;
import java.util.Random;
public class WaterSort {
	Character top = null;
	// create constants for colors
	static Character red = new Character('r');
	static Character blue = new Character('b');
	static Character green = new Character('g');
	// Bottles declaration
	
	
	public static void showAll( StackAsMyArrayList bottles[])
	{
		for (int i = 0; i<=4; i++)
		 {
			 System.out.println("Bottle "+ i+ ": " + bottles[i]);
		 }
	}

	//a method that checks whether the puzzle is solved
	public static boolean solved(StackAsMyArrayList bottles[]) {
		boolean gameIsSolved = false; 
		int allBottlesFilled = 0;	//checks te number of bottles filled
		for(int i = 0; i <= 4; i++) {
			if(bottles[i].getStackSize() == 4 && bottles[i].checkStackUniform()==true) {	
				allBottlesFilled++;
			}
			//if there are 3 bottles that are filled the game is solved
			if(allBottlesFilled == 3){
				gameIsSolved = true;
			}else{
				gameIsSolved = false;
			}
		}
		return gameIsSolved;
	}
	
    public static void main(String args[])
    {
		 int moves = 0;// number of moves to mix the water
		 int target = 0; // number of bottle to pour TO
		 int max = 4; // total number of items allowed per bottle
		 Random randomNum = new Random();

		 // Bottles declaration
		 StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
		 //You can do this with a for also
		 bottles[0] = new StackAsMyArrayList<Character>();
		 bottles[1] = new StackAsMyArrayList<Character>();
		 bottles[2] = new StackAsMyArrayList<Character>();
		 bottles[3] = new StackAsMyArrayList<Character>();
		 bottles[4] = new StackAsMyArrayList<Character>();
		 
		 //////STRATEGY #1
		 while (moves<4) // 4 moves per 3 colors = 12 moves required
        {
          // get source bottle
          target = randomNum.nextInt(max+1);
          while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(blue);
		  target = randomNum.nextInt(max+1);
		  while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(red);
		  target = randomNum.nextInt(max+1);
		  while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(green );
         
          // increment valid moves
          moves++;
        }
		showAll(bottles);
		
		//if there puzzle is not solved, the puzzle must prompt the user to enter 
		while(!solved(bottles)) {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter source bottle number: ");
			Integer sourceBottle =  Integer.parseInt(input.nextLine());		
			
			//SPECIAL CASE!!
			/*checks whether the user inputted a valid source bottle number, it tells the user that the bottle
			   is invalid and should put a valid one */
			while((sourceBottle) >= 5) {
				System.out.println("Invalid source bottle, enter another bottle number");
				System.out.print("Enter source bottle number: ");
				sourceBottle =  Integer.parseInt(input.nextLine());
			}

			//SPECIAL CASE!!
			//checks whether the user inputted a valid target bottle number
			Scanner output = new Scanner(System.in);
			System.out.print("Enter target bottle number: ");
			Integer targetBottle = Integer.parseInt(output.nextLine());

			while((targetBottle)>=5) {
				System.out.println("Invalid target bottle, enter another bottle number");
				System.out.print("Enter target bottle number: ");
				targetBottle = Integer.parseInt(output.nextLine());
			}

			boolean isTrue = false;
			
			while(!isTrue) {
				//SPECIAL CASE!!
				//if the user wants to take a color from an empty bottle, should promty the user to enter again
				if(bottles[sourceBottle].getStackSize() == 0) {
					System.out.println("Source bottle is empty");
		
					sourceBottle = 100;
					targetBottle = 100;
		
					while((sourceBottle) >= 5) {
						//System.out.println("Invalid source bottle, enter another bottle number");
						System.out.print("Enter source bottle number: ");
						sourceBottle =  Integer.parseInt(input.nextLine());
					}
		
					while((targetBottle)>=5) {
						//System.out.println("Invalid target bottle, enter another bottle number");
						System.out.print("Enter target bottle number: ");
						targetBottle = Integer.parseInt(output.nextLine());
					}
		
				}else if(bottles[targetBottle].getStackSize()==0) { //if the target bottle is empty push into it
					isTrue = true;
				}
				else{
					//SPECIAL CASE!!
					//comparing the colors in the source bottle and the target bottle, if they dont match
					while(bottles[targetBottle].peek() != (bottles[sourceBottle].peek())) {
						System.out.println("Colors not matching");
			
						//any number that is bigger than 5, so that the conditiion can be met
						sourceBottle = 100;
						targetBottle = 100;
			
						while((sourceBottle) >= 5) {
							System.out.print("Enter source bottle number: ");
							sourceBottle =  Integer.parseInt(input.nextLine());
						}
			
						while((targetBottle)>=5) {
							System.out.print("Enter target bottle number: ");
							targetBottle = Integer.parseInt(output.nextLine());
						}
					}
					isTrue = true;	
				}
			}

			/*checks whether the bottle you want to add in is full or not, if it is not full,
		 	 outputs a message that you have to input another bottles, if not it is false*/
		 
			if(bottles[targetBottle].getStackSize() < 4 && isTrue == true) {
				bottles[targetBottle].push(bottles[sourceBottle].pop());
				//SPECIAL CASE!!
				//checks whether the color in the source bottle same as the one on the target bottle, and checks whether the size is less than 4
				while(bottles[sourceBottle].peek() == bottles[targetBottle].peek() && bottles[targetBottle].getStackSize()<4){
					bottles[targetBottle].push(bottles[sourceBottle].pop());
				}
			}else {
				//SPECIAL CASE!!
				//adding on a bottle whereby it is full
				System.out.println("Target bottle is already full");
			}

			System.out.println("----------------------------------");
			showAll(bottles);

			//if the game is solved it should output a message
			if(solved(bottles) == true) {
				System.out.println("Cogratulations you have solved the puzzle!");
				break;
			}
		}		
    }
}
