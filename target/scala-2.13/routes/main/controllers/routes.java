// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseReceiptProcessorController ReceiptProcessorController = new controllers.ReverseReceiptProcessorController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseReceiptProcessorController ReceiptProcessorController = new controllers.javascript.ReverseReceiptProcessorController(RoutesPrefix.byNamePrefix());
  }

}
