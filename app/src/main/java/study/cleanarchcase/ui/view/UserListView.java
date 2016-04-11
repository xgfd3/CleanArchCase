package study.cleanarchcase.ui.view;

import java.util.List;
import study.cleanarchcase.modle.User;

/**
 * Created by xucz on 4/10/16.
 */
public interface UserListView extends BaseView{
  void initUserList(List<User> users);
}
