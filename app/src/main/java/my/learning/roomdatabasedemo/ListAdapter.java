package my.learning.roomdatabasedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<User> userlist;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name,tv_email;

        public MyViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_email = (TextView) view.findViewById(R.id.tv_email);

        }
    }


    public ListAdapter(List<User> userlist/*,Context context*/) {
        this.userlist = userlist;
       // this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_single, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User movie = userlist.get(position);
        holder.tv_email.setText(movie.getEmail());
        holder.tv_name.setText(movie.getName());

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }
}