package org.example;

import components.AppView;
import components.ViewModel;
import components.resourceService.PlayerService;
import components.views.DetailedView;
import components.views.SummaryView;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or
 * some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class AppUI extends UI {

  @Override
  protected void init(VaadinRequest vaadinRequest) {
    VerticalLayout appView = setupAppView();
    setContent(appView);
  }

  @WebServlet(urlPatterns = "/*", name = "AppUIServlet", asyncSupported = true)
  @VaadinServletConfiguration(ui = AppUI.class, productionMode = true)
  public static class AppUIServlet extends VaadinServlet {
  }

  private VerticalLayout setupAppView() {
    PlayerService playerService = new PlayerService();
    ViewModel viewModel = new ViewModel(playerService);
    SummaryView summaryView = new SummaryView(viewModel);
    DetailedView detailedView = new DetailedView(viewModel);
    return new AppView(summaryView, detailedView);
  }
}
