package study.cleanarchcase.ui.activity;

import android.app.Fragment;
import javax.inject.Inject;
import javax.inject.Named;
import study.cleanarchcase.internal.di.HasComponent;
import study.cleanarchcase.internal.di.component.DaggerUserComponent;
import study.cleanarchcase.internal.di.component.UserComponent;
import study.cleanarchcase.internal.di.modules.ActivityModule;
import study.cleanarchcase.ui.view.UserDetailView;

/**
 * Created by xucz on 4/10/16.
 */
public class UserDetailActivity extends BaseActivity implements HasComponent<UserComponent>{

  UserComponent userComponent;

  @Inject @Named("userdetail")
  UserDetailView userDetailView;

  @Override public Fragment getContainerFragment() {
    return userDetailView.getFragment();
  }

  @Override public void initInjector() {
    this.userComponent = DaggerUserComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .build();
    this.userComponent.inject(this);
  }

  @Override public UserComponent getComponent() {
    return this.userComponent;
  }

}
