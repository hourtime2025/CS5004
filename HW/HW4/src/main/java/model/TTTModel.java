package model;

/**
 * The {@code TTTModel} interface represents the back-end (Model) of a
 * Tic-Tac-Toe game in an MVC design.
 *
 * <p>This interface is intentionally free of any UI or I/O code so that it
 * can be reused with many different controllers and views (GUI, text, etc.).</p>
 *
 * <p>Coordinates are zero-based: (0, 0) is the top-left cell, and
 * (getBoardSize() - 1, getBoardSize() - 1) is the bottom-right cell.</p>
 */
public interface TTTModel {

  /**
   * Returns the side length of the square Tic-Tac-Toe board.
   *
   * @return the size {@code n} such that the board is {@code n x n}.
   */
  int getBoardSize();
  // Dev note: we expose size instead of hard-coding 3 so we can later
  // support bigger boards without changing this interface.

  /**
   * Returns the {@link Player} whose turn it is.
   *
   * <p>If the game is over (win or draw), this method returns {@code null}
   * because there is no "current" player after the game has finished.</p>
   *
   * @return the player who should move next, or {@code null} if the game
   *     is already over.
   */
  Player getCurrentPlayer();
  // Dev note: null is used deliberately here to mean "no player".
  // This is simpler than inventing an extra enum constant such as NONE.

  /**
   * Returns the {@link Player} that occupies the given cell, or {@code null} if the cell is
   * currently empty.
   *
   * @param row the row index of the cell (0-based, 0 is top row).
   * @param col the column index of the cell (0-based, 0 is leftmost column).
   * @return the player in this cell, or {@code null} if the cell is empty.
   * @throws IllegalArgumentException if {@code row} or {@code col} is outside
   *                                  {@code [0, getBoardSize())}.
   */
  Player getCell(int row, int col) throws IllegalArgumentException;
  // Dev note: we use null here to represent an empty square instead of
  // adding an EMPTY enum value to Player. This keeps Player representing
  // only actual players.

  /**
   * Plays a move for the current player at the given cell.
   *
   * <p>If the move is legal, the model:
   * <ul>
   *   <li>marks the cell with the current player's symbol,</li>
   *   <li>updates any win/draw state, and</li>
   *   <li>switches the turn to the other player,
   *       unless the game has just ended.</li>
   * </ul>
   * </p>
   *
   * @param row the row index for the move (0-based).
   * @param col the column index for the move (0-based).
   * @throws IllegalArgumentException if {@code row} or {@code col} is outside
   *     {@code [0, getBoardSize())}.
   * @throws IllegalStateException if the target cell is already occupied
   *     or the game is already over when this method is called.
   */
  void makeMove(int row, int col)
      throws IllegalArgumentException, IllegalStateException;
  // Dev note: IllegalArgumentException → "bad coordinates" (caller error).
  // IllegalStateException → "bad timing" (trying to move on full/finished game).

  /**
   * Returns whether the game is over.
   *
   * <p>The game is over if there is a winner or the board is full and
   * there is no winner (a draw).</p>
   *
   * @return {@code true} if the game has ended, {@code false} otherwise.
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game, if any.
   *
   * @return the winning {@link Player}, or {@code null} if there is
   *     currently no winner (either the game is still in progress
   *     or it ended in a draw).
   */
  Player getWinner();
  // Dev note: controller can combine getWinner() with isGameOver():
  // - !isGameOver()  → game in progress
  // - isGameOver() && getWinner() == null → draw
  // - isGameOver() && getWinner() != null → that player won.

  /**
   * Returns whether the game ended in a draw.
   *
   * <p>A draw means: the board is completely full and no player has won.</p>
   *
   * @return {@code true} if the game is over and there is no winner;
   *     {@code false} otherwise.
   */
  boolean isDraw();

  /**
   * Resets the model to the initial state: empty board, X to move first,
   * and no winner/draw.
   *
   * <p>After calling this method, the model should behave as if a brand new
   * game has just been created.</p>
   */
  void reset();
  // Dev note: this supports a "New Game" button in the UI without forcing
  // the controller to construct a new model object.
}
