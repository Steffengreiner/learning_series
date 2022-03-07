package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * Compiles the information of a player into a dedicated summary showing total amount of wins and
 * best class
 * Intended to emulates the Result of a Use Case
 */
public class ComputeSummaryFromPlayer {

  public static Summary computeSummary(Player player) {
    Map<FantasyClass, Integer> playerClassWinsMap = convertToMap(player);
    int playerTotalWins = computeTotalWins(playerClassWinsMap);
    FantasyClass playerBestClass = determineBestClass(playerClassWinsMap);
    return new Summary(player.getName(), playerTotalWins, playerBestClass);
  }

  private static Map<FantasyClass, Integer> convertToMap(Player player) {
    Map<FantasyClass, Integer> playerClassWinsMap = new HashMap<>();
    playerClassWinsMap.put(FantasyClass.FIGHTER, player.getFighterWins());
    playerClassWinsMap.put(FantasyClass.MAGE, player.getMageWins());
    playerClassWinsMap.put(FantasyClass.ROGUE, player.getRogueWins());
    playerClassWinsMap.put(FantasyClass.PRIEST, player.getPriestWins());
    return playerClassWinsMap;
  }

  private static int computeTotalWins(Map<FantasyClass, Integer> playerClassWinsMap) {
    return playerClassWinsMap.values().stream().reduce(0, Integer::sum);
  }

  private static FantasyClass determineBestClass(Map<FantasyClass, Integer> playerClassWinsMap) {
    int max = Collections.max(playerClassWinsMap.values());
    List<FantasyClass> bestFantasyClasses = playerClassWinsMap.entrySet().stream()
        .filter(fantasyClassIntegerEntry -> fantasyClassIntegerEntry.getValue() == max)
        .map(Entry::getKey).collect(Collectors.toList());
    //This could be replaced to show all best classes instead of a random one
    Random random = new Random();
    return bestFantasyClasses.get(random.nextInt(bestFantasyClasses.size()));

  }
}
