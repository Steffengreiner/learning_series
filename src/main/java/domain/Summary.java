package domain;

/**
 * Summary object containing name, totalWins and bestclass
 */
public class Summary {

  private final String name;

  private final int totalWins;

  private final FantasyClass bestClass;

  Summary(String name, int totalWins,  FantasyClass bestClass){
    this.name = name;
    this.totalWins= totalWins;
    this.bestClass = bestClass;
  }

  public String getName() {
    return name;
  }

  public int getTotalWins() {
    return totalWins;
  }

  public FantasyClass getBestClass() {
    return bestClass;
  }


  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", totalWins='" + totalWins + '\'' +
        ", bestClass ='" + bestClass + '\'' +
        '}';
  }
}
