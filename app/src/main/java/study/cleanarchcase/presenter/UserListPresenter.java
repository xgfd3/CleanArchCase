package study.cleanarchcase.presenter;

import android.app.Activity;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import study.cleanarchcase.http.UserCase;
import study.cleanarchcase.http.subscribers.ProgressSubscriber;
import study.cleanarchcase.http.subscribers.SubscriberOnNextListener;
import study.cleanarchcase.internal.di.PerActivity;
import study.cleanarchcase.modle.User;
import study.cleanarchcase.ui.view.UserListView;

/**
 * Created by xucz on 4/10/16.
 */
@PerActivity
public class UserListPresenter {

  private static final String TAG = UserListPresenter.class.getSimpleName();
  private final Activity activity;
  private final UserCase userCase;
  private UserListView userListView;

  @Inject
  public UserListPresenter(Activity activity, @Named("userlist") UserCase userCase){
    this.activity = activity;
    this.userCase = userCase;
  }

  public void setUserListView(UserListView userListView){
    this.userListView = userListView;
  }

  public void initialize(){
    System.out.println("UserListPresenter ---- initialize");
    userCase.execute(new ProgressSubscriber<List<User>>(new SubscriberOnNextListener<List<User>>() {
      @Override public void onNext(List<User> users) {
        userListView.initUserList(users);
      }
    }, activity));
  }

}
