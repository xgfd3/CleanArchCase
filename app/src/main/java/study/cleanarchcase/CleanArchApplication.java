package study.cleanarchcase;

import android.app.Application;
import study.cleanarchcase.internal.di.component.ApplicationComponent;
import study.cleanarchcase.internal.di.component.DaggerApplicationComponent;
import study.cleanarchcase.internal.di.modules.ApplicationModule;

/**
 * Created by xucz on 2016/4/7.
 */
public class CleanArchApplication extends Application{
  private static final  java.lang.String TAG = CleanArchApplication.class.getSimpleName();

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent(){return  this.applicationComponent;}
}
