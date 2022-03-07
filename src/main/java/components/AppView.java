package components;

import com.vaadin.ui.VerticalLayout;
import components.views.DetailedView;
import components.views.SummaryView;

/**
 * Main View containing both grids
 */
public class AppView extends VerticalLayout {

  private final SummaryView summaryView;
  private final DetailedView detailedView;

  public AppView(SummaryView summaryView, DetailedView detailedView) {
    this.summaryView = summaryView;
    this.detailedView = detailedView;
    setupAppView();
  }

  private void setupAppView() {
    this.addComponent(summaryView, 0);
    this.addComponent(detailedView, 1);
  }

}
