package ch.ithings.nemesis.supervisor

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.ext.web.Router

import scala.concurrent.Future


class SupervisorVerticle extends ScalaVerticle {


  override def startFuture(): Future[Unit] = {
    //Create a router to answer GET-requests to "/hello" with "world"
    val router = Router.router(vertx)
    val route = router
      .get("/supervisor")
      .handler(_.response().end("Hello World"))

    vertx.createHttpServer()
         .requestHandler(router.accept)
         .listenFuture(8666, "0.0.0.0")
         .map(_ => ())
  }
}