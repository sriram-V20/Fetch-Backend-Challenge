// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseReceiptProcessorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def processReceipt(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receipts/process")
    }
  
    // @LINE:7
    def getPoints(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receipts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/points")
    }
  
  }


}
