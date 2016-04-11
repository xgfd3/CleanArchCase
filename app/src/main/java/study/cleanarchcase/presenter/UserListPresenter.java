package study.cleanarchcase.presenter;

import android.app.Activity;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import study.cleanarchcase.http.Git;
import study.cleanarchcase.http.subscribers.ProgressSubscriber;
import study.cleanarchcase.http.subscribers.SubscriberOnNextListener;
import study.cleanarchcase.modle.User;
import study.cleanarchcase.ui.view.UserListView;

/**
 * Created by xucz on 4/10/16.
 */
public class UserListPresenter {

  private static final String TAG = UserListPresenter.class.getSimpleName();
  private final Activity activity;
  private final Git git;
  private final UserListView userListView;

  @Inject
  public UserListPresenter(Activity activity, Git git, @Named("userlist") UserListView userListView){
    this.activity = activity;
    this.git = git;
    this.userListView = userListView;
  }

  public void initialize(){
    System.out.println("UserListPresenter ---- initialize");
    git.getUserList(new ProgressSubscriber<List<User>>(new SubscriberOnNextListener<List<User>>() {
      @Override public void onNext(List<User> users) {
        for(User u: users){
          System.out.println(u.toString());
        }
      }
    }, activity));
  }

}
