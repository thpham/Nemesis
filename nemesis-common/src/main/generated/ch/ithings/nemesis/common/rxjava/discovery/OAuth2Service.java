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

package ch.ithings.nemesis.common.rxjava.discovery;

import java.util.Map;
import rx.Observable;
import rx.Single;
import io.vertx.servicediscovery.spi.ServiceType;
import io.vertx.core.json.JsonObject;
import io.vertx.servicediscovery.Record;
import io.vertx.rxjava.servicediscovery.ServiceDiscovery;
import io.vertx.core.AsyncResult;
import io.vertx.rxjava.ext.auth.oauth2.OAuth2Auth;
import io.vertx.core.Handler;

/**
 *  for OAuth2 provider services.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link ch.ithings.nemesis.common.discovery.OAuth2Service original} non RX-ified interface using Vert.x codegen.
 */

@io.vertx.lang.rxjava.RxGen(ch.ithings.nemesis.common.discovery.OAuth2Service.class)
public class OAuth2Service {

  public static final io.vertx.lang.rxjava.TypeArg<OAuth2Service> __TYPE_ARG = new io.vertx.lang.rxjava.TypeArg<>(
    obj -> new OAuth2Service((ch.ithings.nemesis.common.discovery.OAuth2Service) obj),
    OAuth2Service::getDelegate
  );

  private final ch.ithings.nemesis.common.discovery.OAuth2Service delegate;
  
  public OAuth2Service(ch.ithings.nemesis.common.discovery.OAuth2Service delegate) {
    this.delegate = delegate;
  }

  public ch.ithings.nemesis.common.discovery.OAuth2Service getDelegate() {
    return delegate;
  }

  public static Record createRecord(String name, JsonObject config, JsonObject metadata) { 
    Record ret = ch.ithings.nemesis.common.discovery.OAuth2Service.createRecord(name, config, metadata);
    return ret;
  }

  public static void getOAuth2Provider(ServiceDiscovery discovery, JsonObject filter, Handler<AsyncResult<OAuth2Auth>> resultHandler) { 
    ch.ithings.nemesis.common.discovery.OAuth2Service.getOAuth2Provider(discovery.getDelegate(), filter, new Handler<AsyncResult<io.vertx.ext.auth.oauth2.OAuth2Auth>>() {
      public void handle(AsyncResult<io.vertx.ext.auth.oauth2.OAuth2Auth> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(OAuth2Auth.newInstance(ar.result())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    });
  }

  public static Single<OAuth2Auth> rxGetOAuth2Provider(ServiceDiscovery discovery, JsonObject filter) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      getOAuth2Provider(discovery, filter, fut);
    }));
  }

  public static void getOAuth2Provider(ServiceDiscovery discovery, JsonObject filter, JsonObject consumerConfiguration, Handler<AsyncResult<OAuth2Auth>> resultHandler) { 
    ch.ithings.nemesis.common.discovery.OAuth2Service.getOAuth2Provider(discovery.getDelegate(), filter, consumerConfiguration, new Handler<AsyncResult<io.vertx.ext.auth.oauth2.OAuth2Auth>>() {
      public void handle(AsyncResult<io.vertx.ext.auth.oauth2.OAuth2Auth> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture(OAuth2Auth.newInstance(ar.result())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    });
  }

  public static Single<OAuth2Auth> rxGetOAuth2Provider(ServiceDiscovery discovery, JsonObject filter, JsonObject consumerConfiguration) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      getOAuth2Provider(discovery, filter, consumerConfiguration, fut);
    }));
  }


  public static OAuth2Service newInstance(ch.ithings.nemesis.common.discovery.OAuth2Service arg) {
    return arg != null ? new OAuth2Service(arg) : null;
  }
}
