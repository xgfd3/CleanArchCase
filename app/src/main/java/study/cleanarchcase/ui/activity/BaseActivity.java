package study.cleanarchcase.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import study.cleanarchcase.CleanArchApplication;
import study.cleanarchcase.R;
import study.cleanarchcase.internal.di.component.ApplicationComponent;
import study.cleanarchcase.navigation.Navigator;

/**
 * Created by xucz on 2016/4/7.
 */
public abstract class BaseActivity extends AppCompatActivity {
  protected String TAG = this.getClass().getSimpleName();

  Navigator navigator;



  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    navigator = getApplicationComponent().navigator();
    setContentView(R.layout.activity_base);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    initInjector();
    Fragment fragment = getContainerFragment();
    if( fragment != null) addFragment(R.id.container, fragment);

  }

  public abstract Fragment getContainerFragment();
  public abstract void initInjector();

  public ApplicationComponent getApplicationComponent(){
    return ((CleanArchApplication) getApplication()).getApplicationComponent();
  }

  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }
}
