package study.cleanarchcase.modle;

/**
 * Created by xucz on 2016/4/10.
 */
public class User {
  private String login;
  private String avatar_url;
  private String url;
  private String type;

  public User(String login, String avatar_url, String url, String type) {
    this.login = login;
    this.avatar_url = avatar_url;
    this.url = url;
    this.type = type;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getAvatar_url() {
    return avatar_url;
  }

  public void setAvatar_url(String avatar_url) {
    this.avatar_url = avatar_url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override public String toString() {
    return "User{" +
        "login='" + login + '\'' +
        ", avatar_url='" + avatar_url + '\'' +
        ", url='" + url + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}
