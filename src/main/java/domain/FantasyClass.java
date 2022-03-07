package domain;

/**
 * FantasyClasses currently employed in the game
 */
public enum FantasyClass {

  FIGHTER("Fighter"),
  MAGE("Mage"),
  ROGUE("Rogue"),
  PRIEST("Priest");

  /**
   Holds the String value of the enum
   */
  private final String value;

  /**
   * Private constructor to create different FantasyClass enum items
   */
  FantasyClass(String value) {
    this.value = value;
  }

  /**
   * Returns to the enum item value
   */
  String getValue() {
    return value;
  }

  /**
   * Returns a String representation of the enum item
   */
  @Override
  public String toString() {
    return this.getValue();
  }
}
