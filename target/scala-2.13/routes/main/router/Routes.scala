// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ReceiptProcessorController_0: controllers.ReceiptProcessorController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ReceiptProcessorController_0: controllers.ReceiptProcessorController
  ) = this(errorHandler, ReceiptProcessorController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ReceiptProcessorController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receipts/process""", """controllers.ReceiptProcessorController.processReceipt(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receipts/""" + "$" + """id<[^/]+>/points""", """controllers.ReceiptProcessorController.getPoints(request:Request, id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ReceiptProcessorController_processReceipt0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receipts/process")))
  )
  private[this] lazy val controllers_ReceiptProcessorController_processReceipt0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ReceiptProcessorController_0.processReceipt(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReceiptProcessorController",
      "processReceipt",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """receipts/process""",
      """FETCH_BACKEND_CHALLENGE APIS""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ReceiptProcessorController_getPoints1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receipts/"), DynamicPart("id", """[^/]+""",true), StaticPart("/points")))
  )
  private[this] lazy val controllers_ReceiptProcessorController_getPoints1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ReceiptProcessorController_0.getPoints(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReceiptProcessorController",
      "getPoints",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """receipts/""" + "$" + """id<[^/]+>/points""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ReceiptProcessorController_processReceipt0_route(params@_) =>
      call { 
        controllers_ReceiptProcessorController_processReceipt0_invoker.call(
          req => ReceiptProcessorController_0.processReceipt(req))
      }
  
    // @LINE:7
    case controllers_ReceiptProcessorController_getPoints1_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ReceiptProcessorController_getPoints1_invoker.call(
          req => ReceiptProcessorController_0.getPoints(req, id))
      }
  }
}
