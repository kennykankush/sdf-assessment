package vttp.batch5.sdf.task02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vttp.batch5.sdf.task02.Utility.fileManagement;
import vttp.batch5.sdf.task02.Utility.tttEngine;

public class Main {

	public static void main(String[] args) throws IOException {

		if (args.length > 2){
			System.out.println("Input expecting: <folder/filename.txt>");
			return;
		}

		String fileName = args[0];
		
		String[][] board = fileManagement.txtReaderToBoard(fileName);
		System.out.println(tttEngine.printBoard(board));
		System.out.println(tttEngine.nextMoveCalculator(board));
	}

}
