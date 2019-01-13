/**
 * This material is based upon work supported by 
 * the National Science Foundation under Grant No. 1140753.
 */

package sudoku.backtrack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import sudoku.util.Solver;
import sudoku.util.board.Move;
import sudoku.util.board.SudokuBoard;

/**
 * A sudoku solver which employs plain backtracking to finish a puzzle.
 */
public class BacktrackSolver implements Solver {
	private Queue<Cell> openCells;
	private Stack<Cell> closedCells;

	public BacktrackSolver(SudokuBoard board) {
		openCells = new LinkedList<Cell>();
		closedCells = new Stack();

	}

	public void solve(SudokuBoard board) {

		openCells = new LinkedList<Cell>();

		for (int i = 0; i < board.size() * board.size(); i++) {

			if (board.valueAt(i) == 0) {
				openCells.add(new Cell(i));
			}

		}
		solveHelper(board);
	}

	boolean solveHelper(SudokuBoard board) {

		// base case: solution found
		if (board.isSolved() && openCells.isEmpty())
			return true;

		else {
			Cell emptySpace = openCells.poll();
			closedCells.push(emptySpace);

			for (int i = 1; i <= board.size(); i++) {
				// Assign legal values to cell
				// fix loop
				if (board.isLegal(i, emptySpace.getIndex())) {

					/**
					 * If the value is legal then move it into the position on
					 * the board and recursively call solve helper on the board.
					 */
					board.move(i, emptySpace.getIndex());
					System.out.println("Placing " + i + " at " + emptySpace.getIndex());
					System.out.println(board);
					
					boolean valid = solveHelper(board);
					if (valid)return true;
						

					// Else, if the move is NOT legal undo last move
					board.unmove();
					openCells.add(closedCells.pop());
					System.out.println("Move was incorrect!");

				}

			}
			return false;// no choice found, trigger backtracking
		}
	}

}
