package puissance4;

import java.util.Scanner;

public class Main {
	
	//------------- Variables -------------
	static String player1;
	static String player2;
	static String firstPlayer;
	static String actualPlayer = "";
	static int actualPosX;
	static int actualPosY;
	static int posX;
	static int posY;
	static int[][] gameBoard = new int [6][7];
	static int columnChoice;
	static boolean gameOver = false;
	static boolean playAgain;
	static boolean firstlaunch = true;
	static boolean draw = false;
	static char uniPlayer1 = '\u25cf';
	static char uniPlayer2 = '\u25CB';
	
	static Scanner scanner = new Scanner(System.in);

	//------------- Initialisation du jeu -------------
	public static void InitGame() {
		if(firstlaunch) {
			firstlaunch = false;
			System.out.println("----------------------");
			System.out.println("Welcome to Connect 4 !");
			System.out.println("----------------------");
			EnterPlayersNames();
		}
		CreateGameBoard();
		firstPlayer = WhoBeginRandom(player1, player2);
		System.out.println(firstPlayer + " begin !!");
		
	}
	
	public static void EnterPlayersNames() {
		System.out.println("Enter your name !");
		System.out.println("----------------------");
		System.out.println("Player1 ? ");
		player1 = scanner.next();
		System.out.println("----------------------");
		System.out.println("Player2 ? ");
		player2 = scanner.next();
		System.out.println("----------------------");
	}
	
	public static void CreateGameBoard() {
		System.out.println("We create the game board now...");
		for(int indexX = 0; indexX < 7; indexX++) {
			for(int indexY = 0; indexY < 6; indexY++) {
				gameBoard[indexY][indexX] = 0;
			}
		}
	}
	
	public static String WhoBeginRandom(String player1, String player2) {
		String result = "";
		int random = (int) (Math.random() * ((2 - 1) + 1)) + 1;
		if(random == 1) result = player1;
		if(random == 2) result = player2;
		return result;
	}
	
	//------------- Jouer -------------
	public static void Play() {
		DrawInConsole();
		actualPlayer = firstPlayer;
		System.out.println(actualPlayer + " choose your column...");
		while(true) {
			UpdateGameBoardArray();
			DrawInConsole();
			gameOver = IsGameOver();
			if(gameOver) break;
			draw = CheckIfDraw();
			if(draw) break;
			actualPlayer = WhoPlayNow(actualPlayer);
			System.out.println(actualPlayer + " choose your column...");
		}	
		if(gameOver) System.out.println(actualPlayer + " win the game !");
		if(draw) System.out.println("Draw !");
	}
	
	public static boolean IsGameOver() {
		int countToWinPlayer1 = 0;
		int countToWinPlayer2 = 0;
		
		//Vérification verticale
		for(int indexX = 0; indexX < gameBoard[0].length; indexX++) {
			for(int indexY = 0; indexY < gameBoard.length; indexY++) {
				if(gameBoard[indexY][indexX] == 1) countToWinPlayer1++;
				else countToWinPlayer1 = 0;
				if(countToWinPlayer1 == 4) return true;
				
				if(gameBoard[indexY][indexX] == 2) countToWinPlayer2++;
				else countToWinPlayer2 = 0;
				if(countToWinPlayer2 == 4) return true;
			}
		}
		
		//Vérification horizontale
		countToWinPlayer1 = 0;
		countToWinPlayer2 = 0;
		for(int indexY = 0; indexY < gameBoard.length; indexY++) {
			countToWinPlayer1 = 0;
			for(int indexX = 0; indexX < gameBoard[indexY].length; indexX++) {
				if(gameBoard[indexY][indexX] == 1) countToWinPlayer1++;
				else countToWinPlayer1 = 0;
				if(countToWinPlayer1 == 4) return true;
				if(gameBoard[indexY][indexX] == 2) countToWinPlayer2++;
				else countToWinPlayer2 = 0;
				if(countToWinPlayer2 == 4) return true;
			}
		}
		
		//Vérification diagonale haut droit
		posX = actualPosX;
		posY = actualPosY;
		countToWinPlayer1 = 0;
		countToWinPlayer2 = 0;
		while(posX >= 0 && posX < gameBoard.length && posY >= 0
				&& posY < gameBoard[0].length) {
			if(gameBoard[posX][posY] == 1) countToWinPlayer1++;
			if(gameBoard[posX][posY] == 2) countToWinPlayer2++;
			if(countToWinPlayer1 == 4 || countToWinPlayer2 == 4) return true;
			posX--;
			posY++;
		}
		
		//Vérification diagonale haut gauche
		posX = actualPosX;
		posY = actualPosY;
		countToWinPlayer1 = 0;
		countToWinPlayer2 = 0;
		while(posX >= 0 && posX < gameBoard.length && posY >= 0
				&& posY < gameBoard[0].length) {
			if(gameBoard[posX][posY] == 1) countToWinPlayer1++;
			if(gameBoard[posX][posY] == 2) countToWinPlayer2++;
			if(countToWinPlayer1 == 4 || countToWinPlayer2 == 4) return true;
			posX--;
			posY--;
		}
		
		//Vérification diagonale bas gauche
		posX = actualPosX;
		posY = actualPosY;
		countToWinPlayer1 = 0;
		countToWinPlayer2 = 0;
		while(posX >= 0 && posX < gameBoard.length && posY >= 0
				&& posY < gameBoard[0].length) {
			if(gameBoard[posX][posY] == 1) countToWinPlayer1++;
			if(gameBoard[posX][posY] == 2) countToWinPlayer2++;
			if(countToWinPlayer1 == 4 || countToWinPlayer2 == 4) return true;
			posX++;
			posY--;
		}
			
		//Vérification diagonale bas droit
		posX = actualPosX;
		posY = actualPosY;
		countToWinPlayer1 = 0;
		countToWinPlayer2 = 0;
		while(posX >= 0 && posX < gameBoard.length && posY >= 0
				&& posY < gameBoard[0].length) {
			if(gameBoard[posX][posY] == 1) countToWinPlayer1++;
			if(gameBoard[posX][posY] == 2) countToWinPlayer2++;
			if(countToWinPlayer1 == 4 || countToWinPlayer2 == 4) return true;
			posX++;
			posY++;
		}
		return false;
	}
	
	public static String WhoPlayNow(String lastPlayer) {
		if(lastPlayer == player1) return player2;
		else return player1;
	}
	
	public static boolean CheckIfDraw() {
		for(int indexX = 0; indexX < gameBoard.length; indexX++) {
			for(int indexY = 0; indexY < gameBoard[0].length; indexY++) {
				if(gameBoard[indexX][indexY] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void UpdateGameBoardArray() {
		int x = 5;
		do {
			columnChoice = scanner.nextInt() - 1;
			if(columnChoice < 0 || columnChoice > 6) {
				System.out.println("Invalid number please type a number between 1 - 7");
			}
		}while(columnChoice < 0 || columnChoice > 6);
		while(gameBoard[x][columnChoice] == 1 || gameBoard[x][columnChoice] == 2) {
			x--;
			if(x < 0) {
				x = 5;
				System.out.println("This column is full, choose another one...");
				columnChoice = scanner.nextInt() - 1;
			}
		}
		if(actualPlayer == player1) gameBoard[x][columnChoice] = 1;
		if(actualPlayer == player2) gameBoard[x][columnChoice] = 2;
		
		actualPosX = x;
		actualPosY = columnChoice;
	}
	
	public static void DrawInConsole() {
		for(int indexX = 0; indexX < gameBoard.length; indexX++) {
			for(int indexY = 0; indexY < gameBoard[0].length; indexY++) {
				if(gameBoard[indexX][indexY] == 1) {
					System.out.print("|"+uniPlayer1);
				} else if (gameBoard[indexX][indexY] == 2){
					System.out.print("|"+uniPlayer2);
				} else {
					System.out.print("| ");
				}
			}
			System.out.println("|");
		}
	}
	
	//------------- Relancer le jeu ? -------------
	public static boolean ReloadGame() {
		System.out.println("Do you want to play another game ?");
		System.out.println("1 - Yes");
		System.out.println("2 - No");
		int answer = scanner.nextInt();
		if(answer == 1) return true;
		if(answer == 2) return false;
		return false;
	}
	//------------- Programme principal -------------
	public static void main(String[] args) {
		do {
			InitGame();
			Play();
			playAgain = ReloadGame();
		}while(playAgain);
		System.out.println("Thanks for playing ! Good bye !");
		

	}

}
