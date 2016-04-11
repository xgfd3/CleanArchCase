package study.cleanarchcase.internal.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import javax.inject.Singleton;
import study.cleanarchcase.http.Executor.JobExecutor;
import study.cleanarchcase.http.Executor.PostExecutionThread;
import study.cleanarchcase.http.Executor.UIExecutor;
import study.cleanarchcase.http.Git;
import study.cleanarchcase.http.GitCase;
import study.cleanarchcase.http.ServerFactory;
import study.cleanarchcase.navigation.Navigator;

/**
 * Created by xucz on 2016/4/7.
 */
@Module
public class ApplicationModule {

  private final Context mContext;

  public ApplicationModule(Context context){
    mContext = context;
  }
  @Provides @Singleton Context provideContext(){return mContext;}

  @Provides @Singleton Executor provideJobExecutor(JobExecutor jobExecutor){ return jobExecutor;}
  @Provides @Singleton PostExecutionThread provideUIExecutor(UIExecutor uiExecutor){return uiExecutor;}
  @Provides @Singleton ServerFactory provideServerFactory(){return new ServerFactory();}
  @Provides @Singleton Git provideGitCase(GitCase gitCase){return gitCase;}


  @Provides @Singleton Navigator provideNavigator(){return new Navigator();}

}
