package components.resourceService;

import domain.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Emulates a service returning the results of a database query
 */
public class PlayerService {

  private final List<Player> players = new ArrayList<>();

  public PlayerService() {
    generatePlayers();
  }

  private void generatePlayers() {
    players.add(new Player("Han Solo", 2, 0, 8, 0));
    players.add(new Player("Luke Skywalker", 2, 4, 6, 8));
    players.add(new Player("Anakin Skywalker", 8, 6, 4, 2));
    players.add(new Player("Yoda", 4, 4, 6, 8));
    players.add(new Player("Stabby McStab", 4, 1, 9, 0));
    players.add(new Player("Conan Angryman", 12, 0, 0, 1));
    players.add(new Player("Jake The Dog", 2, 10, 0, 0));
    players.add(new Player("Gandalf", 2, 13, 0, 2));
    players.add(new Player("Emperor Palpatine", 1, 12, 4, 12));
    players.add(new Player("Bilbo Beutlin", 5, 0, 5, 0));
    players.add(new Player("Padmé Amidala", 2, 2, 0, 12));
    players.add(new Player("Frodo Beutlin", 6, 0, 6, 0));
  }

  public List<Player> requestPlayers() {
    return players;
  }
}
