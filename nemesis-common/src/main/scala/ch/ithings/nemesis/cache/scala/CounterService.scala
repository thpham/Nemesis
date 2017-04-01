/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package ch.ithings.nemesis.cache.scala

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.AsyncResult
import ch.ithings.nemesis.cache.{CounterService => JCounterService}
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A service interface for global cache and counter management using a cache backend (e.g. Redis).
  * 
  * This service is an event bus service (aka. service proxy)
  * </p>
  */
class CounterService(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * First add the counter, then retrieve.
    * @param key counter key
    * @param resultHandler async result handler
    */
  def addThenRetrieve(key: String, resultHandler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JCounterService].addThenRetrieve(key.asInstanceOf[java.lang.String], {x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  /**
    * First add the counter by a `increment`, then retrieve.
    * @param key counter key
    * @param increment increment step
    * @param resultHandler async result handler
    */
  def addThenRetrieveBy(key: String, increment: Long, resultHandler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JCounterService].addThenRetrieveBy(key.asInstanceOf[java.lang.String], increment.asInstanceOf[java.lang.Long], {x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  /**
    * First retrieve the counter, then add.
    * @param key counter key
    * @param resultHandler async result handler
    */
  def retrieveThenAdd(key: String, resultHandler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JCounterService].retrieveThenAdd(key.asInstanceOf[java.lang.String], {x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  /**
    * Reset the value of the counter with a certain `key`
    * @param key counter key
    * @param resultHandler async result handler
    */
  def reset(key: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JCounterService].reset(key.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  def close(): Unit = {
    asJava.asInstanceOf[JCounterService].close()
  }

 /**
   * Like [[addThenRetrieve]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def addThenRetrieveFuture(key: String): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounterService].addThenRetrieve(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[addThenRetrieveBy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def addThenRetrieveByFuture(key: String, increment: Long): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounterService].addThenRetrieveBy(key.asInstanceOf[java.lang.String], increment.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[retrieveThenAdd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def retrieveThenAddFuture(key: String): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JCounterService].retrieveThenAdd(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[reset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resetFuture(key: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JCounterService].reset(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object CounterService {
  def apply(asJava: JCounterService) = new CounterService(asJava)  
  def createProxy(vertx: Vertx, address: String): CounterService = {
    CounterService(JCounterService.createProxy(vertx.asJava.asInstanceOf[JVertx], address.asInstanceOf[java.lang.String]))
  }

}
