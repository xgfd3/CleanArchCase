package study.cleanarchcase.http;

import java.util.concurrent.Executor;
import javax.inject.Inject;
import rx.Observable;
import study.cleanarchcase.api.UserServer;
import study.cleanarchcase.http.Executor.PostExecutionThread;

/**
 * Created by xucz on 2016/4/11.
 */
public class GetUserListCase extends UserCase {

  private final ServerFactory serverFactory;

  @Inject
  protected GetUserListCase(ServerFactory serverFactory, Executor executor, PostExecutionThread postExecutionThread) {
    super(executor, postExecutionThread);
    this.serverFactory = serverFactory;
  }

  @Override protected Observable buildUseCaseObservable() {
    return serverFactory.create(UserServer.class).users();
  }
}
