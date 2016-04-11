package study.cleanarchcase.internal.di.component;

import android.content.Context;
import dagger.Component;
import java.util.concurrent.Executor;
import javax.inject.Singleton;
import study.cleanarchcase.http.Executor.PostExecutionThread;
import study.cleanarchcase.http.ServerFactory;
import study.cleanarchcase.internal.di.modules.ApplicationModule;
import study.cleanarchcase.navigation.Navigator;

/**
 * Created by xucz on 2016/4/7.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  Context context();
  Executor jobExecutor();
  PostExecutionThread uiExecutor();
  ServerFactory serverFactory();
  Navigator navigator();
}
