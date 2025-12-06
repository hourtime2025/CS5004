package model;

/**
 * The {@code Player} enum represents the two players in a standard
 * Tic-Tac-Toe game.
 *
 * <p>We intentionally include only real players (X and O). Empty cells on
 * the board are represented by {@code null} in methods such as
 * {@link TTTModel#getCell(int, int)}.</p>
 *
 * <p>This avoids overloading the enum with non-player states such as
 * EMPTY or DRAW. A cell with no player simply has the value {@code null},
 * and a drawn game is represented by {@code isDraw() == true} and
 * {@code getWinner() == null} in the model.</p>
 */
public enum Player {
  /**
   * The player using the 'X' mark.
   */
  X,

  /**
   * The player using the 'O' mark.
   */
  O;
  // Dev note: we deliberately do NOT define EMPTY or DRAW here:
  // - EMPTY is a cell state, not a player.
  // - DRAW is a game outcome, not a player.
  // This keeps Player focused on actual human/AI participants.
}
