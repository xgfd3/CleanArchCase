package study.cleanarchcase.internal.di.component;

import android.app.Activity;
import dagger.Component;
import study.cleanarchcase.internal.di.PerActivity;
import study.cleanarchcase.internal.di.modules.ActivityModule;

/**
 * Created by xucz on 2016/4/8.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  Activity activity();

}
