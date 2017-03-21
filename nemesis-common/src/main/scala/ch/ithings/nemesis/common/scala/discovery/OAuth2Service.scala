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

package ch.ithings.nemesis.common.scala.discovery

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.scala.ext.auth.oauth2.OAuth2Auth
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import ch.ithings.nemesis.common.discovery.{OAuth2Service => JOAuth2Service}
import io.vertx.core.Handler
import io.vertx.scala.servicediscovery.Record
import io.vertx.ext.auth.oauth2.{OAuth2Auth => JOAuth2Auth}

/**
  *  for OAuth2 provider services.
  */
class OAuth2Service(private val _asJava: Object) {

  def asJava = _asJava

}

object OAuth2Service {
  def apply(asJava: JOAuth2Service) = new OAuth2Service(asJava)  
  def createRecord(name: String, config: io.vertx.core.json.JsonObject, metadata: io.vertx.core.json.JsonObject): Record = {
    Record(JOAuth2Service.createRecord(name.asInstanceOf[java.lang.String], config, metadata))
  }

  def getOAuth2Provider(discovery: ServiceDiscovery, filter: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[OAuth2Auth]]): Unit = {
    JOAuth2Service.getOAuth2Provider(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, {x: AsyncResult[JOAuth2Auth] => resultHandler.handle(AsyncResultWrapper[JOAuth2Auth, OAuth2Auth](x, a => OAuth2Auth(a)))})
  }

  def getOAuth2Provider(discovery: ServiceDiscovery, filter: io.vertx.core.json.JsonObject, consumerConfiguration: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[OAuth2Auth]]): Unit = {
    JOAuth2Service.getOAuth2Provider(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, consumerConfiguration, {x: AsyncResult[JOAuth2Auth] => resultHandler.handle(AsyncResultWrapper[JOAuth2Auth, OAuth2Auth](x, a => OAuth2Auth(a)))})
  }

}
