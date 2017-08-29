package app.nirmlkar.dalejan.firstappllication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalejan on 30/8/17.
 */

public class AdapterLogin extends RecyclerView.Adapter<AdapterLogin.Listdata> {

    List<UserEdu> userEdus;
    public class Listdata extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView pm;
        public TextView sec;
        public TextView gr;
        public TextView pgr;
        public TextView dip;
        public TextView phd;
        public Listdata(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.loginname);
            pm=itemView.findViewById(R.id.loginpm);
            sec=itemView.findViewById(R.id.loginsec);
            gr=itemView.findViewById(R.id.logingr);
            pgr=itemView.findViewById(R.id.loginpostgr);
            dip=itemView.findViewById(R.id.logindip);
            phd=itemView.findViewById(R.id.loginphd);

             }
    }
    public AdapterLogin(List<UserEdu> user){
        this.userEdus=user;

    }

    @Override
    public AdapterLogin.Listdata onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.loginuser, parent ,false);
        return new AdapterLogin.Listdata(view);
    }

    @Override
    public void onBindViewHolder(AdapterLogin.Listdata holder, int position) {
        holder.name.setText(userEdus.get(position).getName());
        holder.pm.setText(userEdus.get(position).getPm());
        holder.sec.setText(userEdus.get(position).getSec());
        holder.gr.setText(userEdus.get(position).getGr());
        holder.pgr.setText(userEdus.get(position).getPgr());
        holder.dip.setText(userEdus.get(position).getDip());
        holder.phd.setText(userEdus.get(position).getPhd());

    }

    @Override
    public int getItemCount() {
        return userEdus.toArray().length;
    }
}
