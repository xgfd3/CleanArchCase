package study.cleanarchcase.http.Executor;

import rx.Scheduler;

/**
 * Created by xucz on 4/10/16.
 */
public interface PostExecutionThread {
  Scheduler getScheduler();
}
