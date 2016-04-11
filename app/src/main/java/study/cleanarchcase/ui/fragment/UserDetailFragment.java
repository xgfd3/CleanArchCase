package study.cleanarchcase.ui.fragment;

import android.app.Fragment;
import javax.inject.Inject;
import study.cleanarchcase.internal.di.PerActivity;
import study.cleanarchcase.ui.view.UserDetailView;

/**
 * Created by xucz on 2016/4/10.
 */
@PerActivity
public class UserDetailFragment extends Fragment implements UserDetailView {

  @Inject
  public UserDetailFragment(){}

  @Override public Fragment getFragment() {
    return this;
  }
}
