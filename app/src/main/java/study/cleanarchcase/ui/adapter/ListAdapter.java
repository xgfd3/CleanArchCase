package study.cleanarchcase.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.List;
import study.cleanarchcase.R;
import study.cleanarchcase.modle.User;

/**
 * Created by xucz on 2016/4/7.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

  private Context context;
  private List<User> data;

  public ListAdapter(Context context, List<User> data){
    this.context = context;
    this.data = data;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = View.inflate(context, R.layout.holder_user, null);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.tv_login.setText(data.get(position).getLogin());
    holder.tv_url.setText(data.get(position).getUrl());

  }

  @Override public int getItemCount() {
    return data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.iv_avatar)
    ImageView iv_avatar;

    @Bind(R.id.tv_login)
    TextView tv_login;

    @Bind(R.id.tv_url)
    TextView tv_url;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this,view);
    }

    @OnClick(R.id.card_view)
    void onTVClicked(){
      Toast.makeText(context, tv_login.getText(), Toast.LENGTH_SHORT).show();
    }
  }

}
