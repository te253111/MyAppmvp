package com.example.zlink.myappmvp.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.model.DataUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zlink on 10/3/2560.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private Listener listener;
    private Context context;

    public interface Listener {
        void onItemClicked(DataUser clickedItem);
        void Showdialog();
    }

    private List<DataUser> userList;

    public DetailAdapter(List<DataUser> userList, Listener listener , Context Context) {
        this.userList = userList;
        this.listener = listener;
        this.context = Context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_person, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataUser item = this.userList.get(position);
        holder.txtListName.setText(item.getName());
        holder.txtListDate.setText(item.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item);
            }
        });


        holder.btnGetpopupmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.Showdialog();
            }
        });
    }


    @Override
    public int getItemCount() {
        if(userList!=null) {
            return userList.size();
        }else{
            return 0;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_list_name)
        TextView txtListName;
        @BindView(R.id.txt_list_date)
        TextView txtListDate;
        @BindView(R.id.btn_getpopupmenu)
        ImageButton btnGetpopupmenu;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
