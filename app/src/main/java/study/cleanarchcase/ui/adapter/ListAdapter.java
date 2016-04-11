package study.cleanarchcase.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
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
    return new ViewHolder(new TextView(context));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textView.setText(data.get(position).getLogin());
  }

  @Override public int getItemCount() {
    return data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
    private final TextView textView;

    public ViewHolder(TextView textView) {
      super(textView);
      this.textView = textView;
    }
  }

}
