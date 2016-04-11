package study.cleanarchcase.internal.di.component;

import dagger.Component;
import study.cleanarchcase.internal.di.PerActivity;
import study.cleanarchcase.internal.di.modules.ActivityModule;
import study.cleanarchcase.internal.di.modules.UserModule;
import study.cleanarchcase.ui.activity.UserDetailActivity;
import study.cleanarchcase.ui.activity.UserListActivity;
import study.cleanarchcase.ui.fragment.UserDetailFragment;
import study.cleanarchcase.ui.fragment.UserListFragment;

/**
 * Created by xucz on 4/10/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class, UserModule.class})
public interface UserComponent {
  void inject(UserListActivity activity);
  void inject(UserDetailActivity activity);
  void inject(UserListFragment fragment);
  void inject(UserDetailFragment fragment);
}
