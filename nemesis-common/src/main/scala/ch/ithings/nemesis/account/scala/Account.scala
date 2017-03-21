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

package ch.ithings.nemesis.account.scala

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import ch.ithings.nemesis.account.{Account => JAccount}

/**
  * User account data object
  */
class Account(private val _asJava: JAccount) {

  def asJava = _asJava
  def setBirthDate(value: Long) = {
    asJava.setBirthDate(value)
    this
  }
  def getBirthDate: Long = {
    asJava.getBirthDate().asInstanceOf[Long]
  }
  def setEmail(value: String) = {
    asJava.setEmail(value)
    this
  }
  def getEmail: String = {
    asJava.getEmail().asInstanceOf[String]
  }
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }
  def setPhone(value: String) = {
    asJava.setPhone(value)
    this
  }
  def getPhone: String = {
    asJava.getPhone().asInstanceOf[String]
  }
  def setUsername(value: String) = {
    asJava.setUsername(value)
    this
  }
  def getUsername: String = {
    asJava.getUsername().asInstanceOf[String]
  }
}

object Account {
  
  def apply() = {
    new Account(new JAccount(emptyObj()))
  }
  
  def apply(t: JAccount) = {
    if (t != null) {
      new Account(t)
    } else {
      null
    }
  }
  
  def fromJson(json: JsonObject): Account = {
    if (json != null) {
      new Account(new JAccount(json))
    } else {
      null
    }
  }
}
