package domain;

/**
 * Player object containing the name of the player and number of scored Wins for each class
 *
 */
public class Player {

  private final String name;

  private final int fighterWins;

  private final int mageWins;

  private final int rogueWins;

  private final int priestWins;

  public Player(String name, int fighterWins, int mageWins, int rogueWins, int priestWins){
    this.name = name;
    this.fighterWins = fighterWins;
    this.mageWins = mageWins;
    this.rogueWins = rogueWins;
    this.priestWins = priestWins;
  }

  public String getName() {
    return name;
  }

  public int getFighterWins() {
    return fighterWins;
  }

  public int getMageWins() {
    return mageWins;
  }

  public int getRogueWins() {
    return rogueWins;
  }

  public int getPriestWins() {
    return priestWins;
  }

  @Override
  public String toString() {

    return "Player{" +
        "name='" + name + '\'' +
        ", fighterWins='" + fighterWins + '\'' +
        ", fighterWins='" + mageWins + '\'' +
        ", fighterWins='" + rogueWins + '\'' +
        ", mageWins=" + priestWins +
        '}';
  }

}
