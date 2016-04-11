package study.cleanarchcase.http;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import study.cleanarchcase.api.APIURL;

/**
 * Created by xucz on 2016/4/10.
 */
@Singleton
public class ServerFactory {
  private static final int DEFAULT_TIMEOUT = 5;

  private Retrofit retrofit;
  private Map<String, Object> cache = new HashMap<>();

  @Inject
  public ServerFactory() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    retrofit = new Retrofit.Builder().client(builder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(APIURL.GITHUB_BASE_URL)
        .build();
  }

  public <T> T create(Class<T> clazz) {
    String name = clazz.getSimpleName();
    Object o = cache.get(name);
    if( o!= null && clazz.isInstance(o)){
      return (T)o;
    }else{
      T t = retrofit.create(clazz);
      cache.put(name, t);
      return t;
    }
  }
}
