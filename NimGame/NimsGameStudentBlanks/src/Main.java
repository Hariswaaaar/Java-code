import java.util.Scanner;
 
public class Main {
   
    public static void main(String[] args) throws Exception {
      
        Scanner sc = new Scanner(System.in);

        //Asks the user to input thier name for the player
        System.out.println("What is player1's name?: ");
        //TO DO: Create Player 1
        Player Player1 = new Player(sc.nextLine());

        sc = new Scanner(System.in);
        //Asks the user to input their name for the player.
        System.out.println("What is player2's name?: ");
        //TO DO: Create Player 2
        Player Player2 = new Player(sc.nextLine());

        String again = "Literally any string";
        Player currentPlayer = Player1;
        
        //Runs the game
        while (!again.equals("q")){
            //Generates the game
            //TO DO: Create "game"
            Game game = new Game(Player1, Player2 );
            

            //TO DO: Set the a random player as the current player
            int rand = (int) Math.random() * 2 + 1;
            if (rand == 1) {
                currentPlayer = Player1;
            }
            else if(rand == 2){
                currentPlayer = Player2;
            }
            
            game.setFirstPlayer(currentPlayer);
            //This is the loop in which the game will be played
            while(!game.isComplete()){
               //TO DO
                currentPlayer = game.getNextPlayer();
                game.takePiece();
            }
            System.out.println(currentPlayer.getName() + " Won!!");
            System.out.println(Player1.getName() + " had removed " + Player1.getScore() + " pieces!");
            System.out.println(Player2.getName() +" had removed "+ Player2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
