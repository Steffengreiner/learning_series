package components;

/**
 *
 * Defines methods to add responsiveness to grids
 *
 */
public interface Responsive {


  /**
   * Makes sure that the full grid width is used by the columns upon browser resizing
   *
   * Ensures that the grid width is allocated upon all the columns even if max-width attributes for individual columns are set
   * Without this recalculation the unused column width would show as empty space on the right side of the grid
   *
   */

    void makeGridResponsive();

    void disableResizableColumns();
  }
