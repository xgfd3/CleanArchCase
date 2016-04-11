package study.cleanarchcase.internal.di.modules;

import dagger.Module;

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


}
