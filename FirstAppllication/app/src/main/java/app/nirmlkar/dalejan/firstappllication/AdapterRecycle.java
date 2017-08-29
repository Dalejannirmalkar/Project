package app.nirmlkar.dalejan.firstappllication;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dalejan on 30/8/17.
 */

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.Listdata> {

    ArrayList<User> Auser=new ArrayList<User>();
    public class Listdata extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView email;
        public Listdata(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.showdashname);
            email=itemView.findViewById(R.id.showdashemail);
        }
    }
    public AdapterRecycle(List<User> user){

        for (User u1:user){
            Auser.add(u1);
        }

    }

    @Override
    public AdapterRecycle.Listdata onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_edu_list, parent ,false);
        return new Listdata(view);
    }

    @Override
    public void onBindViewHolder(AdapterRecycle.Listdata holder, int position) {
        Log.d("jjjjj1",Auser.get(position).getName().toString()+"jhgfhf"+position+Auser.toArray().length);
        holder.name.setText(Auser.get(position).getName());
    holder.email.setText(Auser.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return Auser.toArray().length;
    }


}
