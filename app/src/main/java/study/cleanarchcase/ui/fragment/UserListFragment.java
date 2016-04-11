package study.cleanarchcase.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import java.util.List;
import javax.inject.Inject;
import study.cleanarchcase.R;
import study.cleanarchcase.internal.di.PerActivity;
import study.cleanarchcase.internal.di.component.UserComponent;
import study.cleanarchcase.modle.User;
import study.cleanarchcase.presenter.UserListPresenter;
import study.cleanarchcase.ui.adapter.ListAdapter;
import study.cleanarchcase.ui.view.UserListView;

/**
 * Created by xucz on 2016/4/10.
 */
@PerActivity
public class UserListFragment extends BaseFragment implements UserListView{

  @Inject
  public UserListFragment(){}

  @Bind(R.id.rv_userlist)
  RecyclerView rv_userlist;

  @Inject
  UserListPresenter userListPresenter;

  @Override public Fragment getFragment() {
    return this;
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_userlist, null);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getComponent(UserComponent.class).inject(this);
    userListPresenter.initialize();
  }

  @Override public void initUserList(List<User> users) {
    ListAdapter listAdapter = new ListAdapter(getActivity(), users);
    rv_userlist.setAdapter(listAdapter);
  }
}
