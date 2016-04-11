package study.cleanarchcase.http;

import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import study.cleanarchcase.api.UserServer;
import study.cleanarchcase.modle.User;
import study.cleanarchcase.http.Executor.PostExecutionThread;

/**
 * Created by xucz on 2016/4/10.
 */
@Singleton
public class GitCase implements Git{

  private final ServerFactory serverFactory;
  private final Executor executor;
  private final PostExecutionThread postExecutionThread;

  @Inject
  public GitCase(ServerFactory serverFactory, Executor executor,
      PostExecutionThread postExecutionThread){
    this.serverFactory = serverFactory;
    this.executor = executor;
    this.postExecutionThread = postExecutionThread;
  }

  public void getUserList(Subscriber<List<User>> subscriber){
    System.out.println("GitCase ------- getUserList");
    Observable<List<User>> users = serverFactory.create(UserServer.class).users();
    toSubscriber(users, subscriber);
  }

  private <T> void toSubscriber(Observable<T> users, Subscriber<T> subscriber) {
    users.subscribeOn(Schedulers.from(executor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(subscriber);
  }

}
