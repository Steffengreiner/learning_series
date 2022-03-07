package components.views;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import components.Responsive;
import components.ViewModel;
import domain.Player;

/**
 * View showing the detailed wins for each FantasyClass for a Player
 */
public class DetailedView extends VerticalLayout implements Responsive {

  private final ViewModel viewModel;
  private final Grid<Player> detailedGrid;

  public DetailedView(ViewModel viewModel) {
    this.viewModel = viewModel;
    this.detailedGrid = new Grid<>();
    this.addComponent(detailedGrid);
    init();
  }

  private void init() {
    setupGrid();
    bindData();
    disableResizableColumns();
    makeGridResponsive();
  }

  private void setupGrid() {
    detailedGrid.addColumn(Player::getName).setCaption("Player Name").setId("PlayerName");
    detailedGrid.addColumn(Player::getFighterWins).setCaption("Fighter Wins").setId("fighterWins");
    detailedGrid.addColumn(Player::getMageWins).setCaption("Mage Wins").setId("mageWins");
    detailedGrid.addColumn(Player::getRogueWins).setCaption("Rogue Wins").setId("rogueWins");
    detailedGrid.addColumn(Player::getPriestWins).setCaption("Priest Wins").setId("priestWins");
    detailedGrid.setWidth(100, Unit.PERCENTAGE);

  }

  private void bindData() {
    ListDataProvider<Player> playerDataProvider = DataProvider.ofCollection(viewModel.getPlayers());
    detailedGrid.setDataProvider(playerDataProvider);
  }

  @Override
  public void makeGridResponsive() {
    detailedGrid.addAttachListener(attachEvent -> {
      UI.getCurrent().getPage().addBrowserWindowResizeListener(resizeEvent -> {
        detailedGrid.recalculateColumnWidths();
      });
    });
  }

  @Override
  public void disableResizableColumns() {
    detailedGrid.getColumns().forEach(column ->
    {
      column.setResizable(false);
    });
    }
}
