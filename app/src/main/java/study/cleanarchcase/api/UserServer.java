package study.cleanarchcase.api;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;
import study.cleanarchcase.modle.User;

/**
 * Created by xucz on 2016/4/10.
 */
public interface UserServer {
  @GET("users")
  public Observable<List<User>> users();
}
