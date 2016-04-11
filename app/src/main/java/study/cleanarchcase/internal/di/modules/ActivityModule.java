package study.cleanarchcase.internal.di.modules;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import study.cleanarchcase.internal.di.PerActivity;
import study.cleanarchcase.ui.fragment.UserDetailFragment;
import study.cleanarchcase.ui.fragment.UserListFragment;
import study.cleanarchcase.ui.view.UserDetailView;
import study.cleanarchcase.ui.view.UserListView;

/**
 * Created by xucz on 2016/4/8.
 */
@Module
public class ActivityModule {

  private final Activity activity;

  public ActivityModule(Activity activity){
    this.activity = activity;
  }

  @Provides @PerActivity Activity provideActivity(){return activity;}

  @Provides @PerActivity @Named("userlist") UserListView provideUserListView(UserListFragment userListFragment){return userListFragment;}

  @Provides @PerActivity @Named("userdetail") UserDetailView provideUserDetailView(UserDetailFragment userDetailFragment){return userDetailFragment;}
}
