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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import ch.ithings.nemesis.account.{AccountService => JAccountService}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import ch.ithings.nemesis.account.{Account => JAccount}
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A service interface managing user accounts.
  * 
  * This service is an event bus service (aka. service proxy).
  * </p>
  */
class AccountService(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Initialize the persistence.
    * @param resultHandler the result handler will be called as soon as the initialization has been accomplished. The async result indicates whether the operation was successful or not.
    */
  def initializePersistence(resultHandler: Handler[AsyncResult[Unit]]): AccountService = {
    asJava.asInstanceOf[JAccountService].initializePersistence({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Add a account to the persistence.
    * @param account a account entity that we want to addsee <a href="../../../../../../../cheatsheet/Account.html">Account</a>
    * @param resultHandler the result handler will be called as soon as the account has been added. The async result indicates whether the operation was successful or not.
    */
  def addAccount(account: Account, resultHandler: Handler[AsyncResult[Unit]]): AccountService = {
    asJava.asInstanceOf[JAccountService].addAccount(account.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Retrieve the user account with certain `id`.
    * @param id user account id
    * @param resultHandler the result handler will be called as soon as the user has been retrieved. The async result indicates whether the operation was successful or not.
    */
  def retrieveAccount(id: String, resultHandler: Handler[AsyncResult[Account]]): AccountService = {
    asJava.asInstanceOf[JAccountService].retrieveAccount(id.asInstanceOf[java.lang.String], {x: AsyncResult[JAccount] => resultHandler.handle(AsyncResultWrapper[JAccount, Account](x, a => Account(a)))})
    this
  }

  /**
    * Retrieve the user account with certain `username`.
    * @param username username
    * @param resultHandler the result handler will be called as soon as the user has been retrieved. The async result indicates whether the operation was successful or not.
    */
  def retrieveByUsername(username: String, resultHandler: Handler[AsyncResult[Account]]): AccountService = {
    asJava.asInstanceOf[JAccountService].retrieveByUsername(username.asInstanceOf[java.lang.String], {x: AsyncResult[JAccount] => resultHandler.handle(AsyncResultWrapper[JAccount, Account](x, a => Account(a)))})
    this
  }

  /**
    * Retrieve all user accounts.
    * @param resultHandler the result handler will be called as soon as the users have been retrieved. The async result indicates whether the operation was successful or not.
    */
  def retrieveAllAccounts(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Account]]]): AccountService = {
    asJava.asInstanceOf[JAccountService].retrieveAllAccounts({x: AsyncResult[java.util.List[JAccount]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JAccount], scala.collection.mutable.Buffer[Account]](x, a => a.asScala.map(x => Account(x))))})
    this
  }

  /**
    * Update user account info.
    * @param account a account entity that we want to updatesee <a href="../../../../../../../cheatsheet/Account.html">Account</a>
    * @param resultHandler the result handler will be called as soon as the account has been added. The async result indicates whether the operation was successful or not.
    */
  def updateAccount(account: Account, resultHandler: Handler[AsyncResult[Account]]): AccountService = {
    asJava.asInstanceOf[JAccountService].updateAccount(account.asJava, {x: AsyncResult[JAccount] => resultHandler.handle(AsyncResultWrapper[JAccount, Account](x, a => Account(a)))})
    this
  }

  /**
    * Delete a user account from the persistence
    * @param id user account id
    * @param resultHandler the result handler will be called as soon as the user has been removed. The async result indicates whether the operation was successful or not.
    */
  def deleteAccount(id: String, resultHandler: Handler[AsyncResult[Unit]]): AccountService = {
    asJava.asInstanceOf[JAccountService].deleteAccount(id.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Delete all user accounts from the persistence
    * @param resultHandler the result handler will be called as soon as the users have been removed. The async result indicates whether the operation was successful or not.
    */
  def deleteAllAccounts(resultHandler: Handler[AsyncResult[Unit]]): AccountService = {
    asJava.asInstanceOf[JAccountService].deleteAllAccounts({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  def close(): Unit = {
    asJava.asInstanceOf[JAccountService].close()
  }

 /**
   * Like [[initializePersistence]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def initializePersistenceFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccountService].initializePersistence(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[addAccount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def addAccountFuture(account: Account): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccountService].addAccount(account.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[retrieveAccount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def retrieveAccountFuture(id: String): scala.concurrent.Future[Account] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccount, Account](x => Account(x))
    asJava.asInstanceOf[JAccountService].retrieveAccount(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[retrieveByUsername]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def retrieveByUsernameFuture(username: String): scala.concurrent.Future[Account] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccount, Account](x => Account(x))
    asJava.asInstanceOf[JAccountService].retrieveByUsername(username.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[retrieveAllAccounts]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def retrieveAllAccountsFuture(): scala.concurrent.Future[scala.collection.mutable.Buffer[Account]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JAccount], scala.collection.mutable.Buffer[Account]](x => x.asScala.map(x => Account(x)))
    asJava.asInstanceOf[JAccountService].retrieveAllAccounts(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[updateAccount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateAccountFuture(account: Account): scala.concurrent.Future[Account] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAccount, Account](x => Account(x))
    asJava.asInstanceOf[JAccountService].updateAccount(account.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[deleteAccount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def deleteAccountFuture(id: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccountService].deleteAccount(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[deleteAllAccounts]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def deleteAllAccountsFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAccountService].deleteAllAccounts(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AccountService {
  def apply(asJava: JAccountService) = new AccountService(asJava)  
  def createProxy(vertx: Vertx, address: String): AccountService = {
    AccountService(JAccountService.createProxy(vertx.asJava.asInstanceOf[JVertx], address.asInstanceOf[java.lang.String]))
  }

}
