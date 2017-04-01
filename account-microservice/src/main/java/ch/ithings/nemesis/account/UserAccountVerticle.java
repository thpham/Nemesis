package ch.ithings.nemesis.account;

import ch.ithings.nemesis.account.api.RestUserAccountAPIVerticle;
import ch.ithings.nemesis.account.impl.JdbcAccountServiceImpl;
import ch.ithings.nemesis.common.BaseMicroserviceVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ProxyHelper;

import static ch.ithings.nemesis.account.AccountService.SERVICE_ADDRESS;
import static ch.ithings.nemesis.account.AccountService.SERVICE_NAME;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;


/**
 * A verticle publishing the user service.
 *
 * @author
 */
public class UserAccountVerticle extends BaseMicroserviceVerticle {

  private AccountService accountService;
  private MessageConsumer<JsonObject> consumer;

  @Override
  public void start(Future<Void> future) throws Exception {
    super.start();

    // create the service instance
    accountService = new JdbcAccountServiceImpl(vertx, config());
    // register the service proxy on event bus
    consumer = ProxyHelper.registerService(AccountService.class, vertx, accountService, SERVICE_ADDRESS);
    // publish the service and REST endpoint in the discovery infrastructure
    publishEventBusService(SERVICE_NAME, SERVICE_ADDRESS, AccountService.class)
      .compose(servicePublished -> deployRestVerticle())
      .setHandler(future.completer());
  }

  private Future<Void> deployRestVerticle() {
    Future<String> future = Future.future();
    vertx.deployVerticle(new RestUserAccountAPIVerticle(accountService),
      new DeploymentOptions().setConfig(config()),
      future.completer());
    return future.map(r -> null);
  }
  
  @Override
  public void stop(Future<Void> future) throws Exception {
      super.stop();
      ProxyHelper.unregisterService(consumer);
  }
}
