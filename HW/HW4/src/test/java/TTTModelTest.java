import model.Player;
import model.TTTModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Black-box tests for the TTTModel interface.
 *
 * NOTE: For HW4 the model field will not yet refer to a concrete implementation.
 * These tests are design-time specifications and may not be runnable until
 * a class that implements TTTModel is created and assigned in a setup method.
 */
public class TTTModelTest {

  // For a later HW, you will do something like:
  // @BeforeEach
  // public void setUp() {
  //   model = new TTTModelImpl();
  // }
  private TTTModel model;

  // ---------- getBoardSize() ----------

  @Test
  public void testGetBoardSize_standardBoardIsThree() {
    // A standard TTT board should be 3x3.
    assertEquals(3, model.getBoardSize());
  }

  @Test
  public void testGetBoardSize_doesNotChangeAfterMoves() {
    // Board size should remain constant even as the game progresses.
    int sizeBefore = model.getBoardSize();
    // later we will insert some makeMove calls here
    int sizeAfter = model.getBoardSize();
    assertEquals(sizeBefore, sizeAfter);
  }

  // ---------- getCurrentPlayer() ----------

  @Test
  public void testGetCurrentPlayer_startsWithX() {
    // By convention, X moves first.
    assertEquals(Player.X, model.getCurrentPlayer());
  }

  @Test
  public void testGetCurrentPlayer_isNullAfterGameOver() {
    // Once the game ends, there should be no "current" player.
    // (Later we will drive the model into a terminal state.)
    assertTrue(model.isGameOver());
    assertNull(model.getCurrentPlayer());
  }

  // ---------- getCell(int, int) ----------

  @Test
  public void testGetCell_initialBoardIsEmpty() {
    // Every cell on a brand-new board should be empty (null).
    for (int r = 0; r < model.getBoardSize(); r++) {
      for (int c = 0; c < model.getBoardSize(); c++) {
        assertNull(model.getCell(r, c));
      }
    }
  }

  @Test
  public void testGetCell_outOfBoundsThrows() {
    // Accessing coordinates outside the board should throw.
    assertThrows(IllegalArgumentException.class,
        () -> model.getCell(-1, 0));
  }

  // ---------- makeMove(int, int) ----------

  @Test
  public void testMakeMove_placesMarkAndSwitchesPlayer() {
    // After X moves at (0,0), cell (0,0) contains X, and it's O's turn.
    model.makeMove(0, 0);
    assertEquals(Player.X, model.getCell(0, 0));
    assertEquals(Player.O, model.getCurrentPlayer());
  }

  @Test
  public void testMakeMove_onOccupiedCellThrows() {
    // Playing on an already occupied cell should throw.
    model.makeMove(0, 0); // first move OK
    assertThrows(IllegalStateException.class,
        () -> model.makeMove(0, 0)); // second move same cell → error
  }

  // ---------- isGameOver() ----------

  @Test
  public void testIsGameOver_falseAtStart() {
    // A new game is not over.
    assertFalse(model.isGameOver());
  }

  @Test
  public void testIsGameOver_trueImmediatelyAfterWinningMove() {
    // Example winning sequence for X on top row.
    model.makeMove(0, 0); // X
    model.makeMove(1, 0); // O
    model.makeMove(0, 1); // X
    model.makeMove(1, 1); // O
    model.makeMove(0, 2); // X wins
    assertTrue(model.isGameOver());
  }

  // ---------- getWinner() ----------

  @Test
  public void testGetWinner_nullWhenNoWinnerYet() {
    // At the start there is no winner.
    assertNull(model.getWinner());
  }

  @Test
  public void testGetWinner_returnsCorrectWinnerAfterWin() {
    // After a winning line, getWinner() should return that player.
    model.makeMove(0, 0); // X
    model.makeMove(1, 0); // O
    model.makeMove(0, 1); // X
    model.makeMove(1, 1); // O
    model.makeMove(0, 2); // X wins
    assertEquals(Player.X, model.getWinner());
  }

  // ---------- isDraw() ----------

  @Test
  public void testIsDraw_falseAtStart() {
    // New game is not a draw.
    assertFalse(model.isDraw());
  }

  @Test
  public void testIsDraw_trueOnFullBoardWithNoWinner() {
    // Fill board with a known drawn configuration:
    // X O X
    // X O O
    // O X X
    model.makeMove(0, 0); // X
    model.makeMove(0, 1); // O
    model.makeMove(0, 2); // X
    model.makeMove(1, 1); // O
    model.makeMove(1, 0); // X
    model.makeMove(1, 2); // O
    model.makeMove(2, 1); // X
    model.makeMove(2, 0); // O
    model.makeMove(2, 2); // X

    assertTrue(model.isGameOver());
    assertTrue(model.isDraw());
    assertNull(model.getWinner());
  }

  // ---------- reset() ----------

  @Test
  public void testReset_returnsToInitialState() {
    // After some moves, reset() should restore the initial state.
    model.makeMove(0, 0);
    model.makeMove(1, 1);
    model.reset();

    assertFalse(model.isGameOver());
    assertEquals(Player.X, model.getCurrentPlayer());

    for (int r = 0; r < model.getBoardSize(); r++) {
      for (int c = 0; c < model.getBoardSize(); c++) {
        assertNull(model.getCell(r, c));
      }
    }
  }

  @Test
  public void testReset_canStartNewGameAfterWin() {
    // Play a winning game for X, then reset and verify fresh state.
    model.makeMove(0, 0); // X
    model.makeMove(1, 0); // O
    model.makeMove(0, 1); // X
    model.makeMove(1, 1); // O
    model.makeMove(0, 2); // X wins

    assertTrue(model.isGameOver());
    assertEquals(Player.X, model.getWinner());

    model.reset();

    assertFalse(model.isGameOver());
    assertNull(model.getWinner());
    assertEquals(Player.X, model.getCurrentPlayer());
  }
}
