// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseReceiptProcessorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def processReceipt: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ReceiptProcessorController.processReceipt",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receipts/process"})
        }
      """
    )
  
    // @LINE:7
    def getPoints: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ReceiptProcessorController.getPoints",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receipts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/points"})
        }
      """
    )
  
  }


}
