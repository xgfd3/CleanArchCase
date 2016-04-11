package study.cleanarchcase.http.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by xucz on 4/10/16.
 */
@Singleton
public class UIExecutor implements PostExecutionThread{
  @Inject
  public UIExecutor(){}

  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
