package vttp.batch5.sdf.task02.Utility;

import java.util.ArrayList;
import java.util.List;

public class tttEngine{

    
	public static String printBoard(String[][] board){
		StringBuilder sb = new StringBuilder();
		sb.append("Board:\n");
		sb.append(board[0][0]).append(board[0][1]).append(board[0][2]).append("\n");
		sb.append(board[1][0]).append(board[1][1]).append(board[1][2]).append("\n");
		sb.append(board[2][0]).append(board[2][1]).append(board[2][2]).append("\n");
		for (int i = 0; i < 30; i++){
			sb.append("-");
		}

		String boardFormat = sb.toString();
		return boardFormat;
	}

	public static List<Integer> isValid(String[][] board){
		List<Integer> isValidList = new ArrayList<>();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (board[i][j].equals(".")){
					int convert = i * 3 + j + 1;
					isValidList.add(convert);
				}
			}
		}
		return isValidList;

	}

	public static int evaluatePos(String[][] board){

		int foundOs = 0;
		int foundVacant = 0;

		for (int i = 0; i < 3; i++) {
			if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && (board[i][0].equals("X"))) {
				return +1;
			}
			if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && (board[0][i].equals("X"))) {
				return +1;
			}
		}

		if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && (board[0][0].equals("X"))) {
			return +1;
		}
		if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && (board[0][2].equals("X"))) {
			return +1;
		}

		for (int i = 0; i < 3; i++){
			if (foundOs == 2 && foundVacant == 1){
				return -1;
			} else {
				foundOs = 0;
				foundVacant = 0;
			}
			for (int j = 0; j < 3; j++){
				if (board[i][j].contains("O")){
					foundOs++;
				} else if (board[i][j].contains(".")){
					foundVacant++;
				}
			
			}
		}

		for (int i = 0; i < 3; i++){
			if (foundOs == 2 && foundVacant == 1){
				return -1;
			} else {
				foundOs = 0;
				foundVacant = 0;
			}
			for (int j = 0; j < 3; j++){
				if (board[j][i].contains("O")){
					foundOs++;
				} else if (board[j][i].contains(".")){
					foundVacant++;
				}
			
			}
		}

		if (board[0][0].contains("O")){
			foundOs++;
		} else if (board[0][0].contains(".")){
			foundVacant++;
		}

		if (board[1][1].contains("O")){
			foundOs++;
		} else if (board[1][1].contains(".")){
			foundVacant++;
		}

		if (board[2][2].contains("O")){
			foundOs++;
		} else if (board[2][2].contains(".")){
			foundVacant++;
		}

		if (foundOs == 2 && foundVacant == 1){
			return -1;
		} else {
			foundOs = 0;
			foundVacant = 0;
		}


		if (board[0][2].contains("O")){
			foundOs++;
		} else if (board[0][2].contains(".")){
			foundVacant++;
		}

		if (board[1][1].contains("O")){
			foundOs++;
		} else if (board[1][1].contains(".")){
			foundVacant++;
		}

		if (board[2][0].contains("O")){
			foundOs++;
		} else if (board[2][0].contains(".")){
			foundVacant++;
		}

		if (foundOs == 2 && foundVacant == 1){
			return -1;
		} else {
			foundOs = 0;
			foundVacant = 0;
		}
		return 0;
	}

	public static String nextMoveCalculator(String[][] board){
		StringBuilder sb = new StringBuilder();

		List<Integer> validMoves = isValid(board);

		for (int i = 0; i < validMoves.size(); i++){
			String[][] tempBoard = new String[3][3];
			
			for (int j = 0; j < 3; j++){
				for (int k = 0; k < 3; k++){
					tempBoard[j][k] = board[j][k];
				}
			}

			// System.out.println(Arrays.deepToString(tempBoard));
			
			int row = (validMoves.get(i) - 1) / 3;
			int col = (validMoves.get(i) - 1) % 3;
			tempBoard[row][col] = "X";

			// System.out.println(Arrays.deepToString(tempBoard));

			int utilityValue = evaluatePos(tempBoard);
			sb.append("y=" + row + ", x=" + col + ", utility=" + utilityValue).append("\n");

		}
	return sb.toString();
	}

}