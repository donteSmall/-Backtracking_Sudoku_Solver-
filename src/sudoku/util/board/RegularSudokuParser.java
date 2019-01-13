/**
 * This material is based upon work supported by 
 * the National Science Foundation under Grant No. 1140753.
 */

package sudoku.util.board;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;

/**
 * A simple parser.
 */
public class RegularSudokuParser
{
	/**
	 * Parses a sudoku file. See the sudoku puzzle directory for specifications
	 * 
	 * @param puzzleFile - the puzzle to be parsed
	 * @return - the sudoku puzzle the file represented
	 * @throws Exception - the file was not found
	 */
	public RegularSudokuBoard parse(File puzzleFile) throws Exception
	{   
		Scanner screenReader = new Scanner(puzzleFile);
		int w = screenReader.nextInt();
		int h = screenReader.nextInt();
		RegularSudokuBoard board= new RegularSudokuBoard ( w,  h);
		int counter=0;
		while(screenReader.hasNextInt()){
			board.setCell(screenReader.nextInt(),counter );
			counter++;
			
		}
		
System.out.println(board);
screenReader.close();
		return board;
	}
	
	
	
}
