package study.cleanarchcase.internal.di.modules;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import study.cleanarchcase.http.GetUserListCase;
import study.cleanarchcase.http.UserCase;
import study.cleanarchcase.internal.di.PerActivity;

/**
 * Created by xucz on 4/10/16.
 */
@Module
public class UserModule {

  private int userId = -1;

  public UserModule() {}

  public UserModule(int userId) {
    this.userId = userId;
  }

  @Provides @PerActivity @Named("userlist") UserCase provideGetUserListCase(GetUserListCase getUserListCase){return getUserListCase;}
}
