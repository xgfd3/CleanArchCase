package study.cleanarchcase.http;

import java.util.List;
import rx.Subscriber;
import study.cleanarchcase.modle.User;

/**
 * Created by xucz on 2016/4/10.
 */
public interface Git {
  void getUserList(Subscriber<List<User>> subscriber);

}
