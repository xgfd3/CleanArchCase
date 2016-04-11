package study.cleanarchcase.ui.activity;

import android.app.Fragment;
import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import javax.inject.Inject;
import javax.inject.Named;
import study.cleanarchcase.R;
import study.cleanarchcase.internal.di.HasComponent;
import study.cleanarchcase.internal.di.component.DaggerUserComponent;
import study.cleanarchcase.internal.di.component.UserComponent;
import study.cleanarchcase.internal.di.modules.ActivityModule;
import study.cleanarchcase.ui.view.UserListView;

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>{
  UserComponent userComponent;

  @Inject @Named("userlist")
  UserListView userListView;

  @Override public Fragment getContainerFragment() {
    return userListView.getFragment();
  }

  @Override public void initInjector(){
    this.userComponent = DaggerUserComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .build();
    this.userComponent.inject(this);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);

    final SearchView
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

    SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    return super.onOptionsItemSelected(item);
  }

  @Override public UserComponent getComponent() {
    return this.userComponent;
  }
}
