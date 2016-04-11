package study.cleanarchcase.http;

import java.util.concurrent.Executor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;
import study.cleanarchcase.http.Executor.PostExecutionThread;

/**
 * Created by xucz on 2016/4/11.
 */
public abstract class UserCase {

  private final Executor executor;
  private final PostExecutionThread postExecutionThread;

  private Subscription subscription = Subscriptions.empty();

  protected UserCase(Executor executor,
      PostExecutionThread postExecutionThread) {
    this.executor = executor;
    this.postExecutionThread = postExecutionThread;
  }

  /**
   * Builds an {@link rx.Observable} which will be used when executing the current {@link UserCase}.
   */
  protected abstract Observable buildUseCaseObservable();

  /**
   * Executes the current use case.
   *
   * @param UseCaseSubscriber The guy who will be listen to the observable build
   * with {@link #buildUseCaseObservable()}.
   */
  @SuppressWarnings("unchecked")
  public void execute(Subscriber UseCaseSubscriber) {
    this.subscription = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(executor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(UseCaseSubscriber);
  }

  /**
   * Unsubscribes from current {@link rx.Subscription}.
   */
  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
