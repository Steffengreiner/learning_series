package components.views;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import components.ViewModel;
import domain.Summary;

/**
 * View showing a Summary of a Player containing the best performing class and total win amount
 */
public class SummaryView extends VerticalLayout {

  private final ViewModel viewModel;
  private final Grid<Summary> summaryGrid;

  public SummaryView(ViewModel viewModel) {
    this.viewModel = viewModel;
    this.summaryGrid = new Grid<>();
    this.addComponent(summaryGrid);
    init();
  }

  private void init() {
    setupGrid();
    bindData();
  }

  private void setupGrid() {
    summaryGrid.addColumn(Summary::getName).setCaption("Player Name").setId("PlayerName");
    summaryGrid.addColumn(Summary::getTotalWins).setCaption("Total Wins").setId("totalWins");
    summaryGrid.addColumn(Summary::getBestClass).setCaption("Best Class").setId("bestClass");
    summaryGrid.setWidth(100, Unit.PERCENTAGE);
  }

  private void bindData() {

    ListDataProvider<Summary> playerDataProvider = DataProvider.ofCollection(viewModel.getSummaries());
    summaryGrid.setDataProvider(playerDataProvider);
  }

}
