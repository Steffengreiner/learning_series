package components;

import components.resourceService.PlayerService;
import domain.Player;
import domain.Summary;
import domain.ComputeSummaryFromPlayer;
import java.util.ArrayList;
import java.util.List;

/**
 * Viewmodel accessible by both Views containing the Summary and Player information
 */
public class ViewModel {

  List<Player> players;
  List<Summary> summaries;

  public ViewModel(PlayerService playerService) {
    players = playerService.requestPlayers();
    summaries = computeSummaries();
  }

  public List<Player> getPlayers() {
    return players;
  }

  public List<Summary> getSummaries() {
    return summaries;
  }

  private List<Summary> computeSummaries() {
    List<Summary> summaryList = new ArrayList<>();
    for (Player player : players) {
      summaryList.add(ComputeSummaryFromPlayer.computeSummary(player));
    }
    return summaryList;
  }
}
