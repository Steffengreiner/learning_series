package components;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

/**
 * A helper class with static utility functions for Vaadin Grids.
 *
 * @since 1.0.2
 */
public class GridUtils {

  /**
   * Makes sure that the full grid width is used by the columns upon browser resizing
   * <p>
   * Ensures that the grid width is allocated upon all the columns even if max-width attributes for
   * individual columns are set Without this recalculation the unused column width would show as
   * empty space on the right side of the grid
   *
   * @param grid the {@link com.vaadin.ui.Grid}, which should be responsive to browser window
   *             resizing
   * @since 1.0.2
   */

  public static void makeGridResponsive(Grid grid) {
    grid.addAttachListener(attachEvent -> {
      UI.getCurrent().getPage().addBrowserWindowResizeListener(resizeEvent -> {
        grid.recalculateColumnWidths();
      });
    });
  }
}
