package projecto.jhpiego.equipment_track_tools.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.model.Assessment_model;

public class All_data_adapter extends ArrayAdapter<Assessment_model> {

    private ArrayList<Assessment_model> all_data_set_assessment;
    Context assessm_context;
    Animation translate_anim;

    public All_data_adapter(ArrayList<Assessment_model> data, Context context) {
        super(context, R.layout.all_data, data);
        this.all_data_set_assessment = data;
        this.assessm_context = context;

    }

    private int last_positions = -1;

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.all_data, parent, false);

        TextView facility_name = row.findViewById(R.id.facil_name);
        facility_name.setText(all_data_set_assessment.get(position).getTxtName());

        return row;
    }

    /*  @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.all_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.facil_id.setText(String.valueOf(facil_id.get(position)));
        holder.facil_name.setText(String.valueOf(facil_name.get(position)));
        holder.province.setText(String.valueOf(province.get(position)));

      /*  holder.mainLayout_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, )
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

  /*  public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView facil_id, facil_name, province;
        LinearLayout mainLayout_data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            facil_id = itemView.findViewById(R.id.facil_id);
            facil_name = itemView.findViewById(R.id.facil_name);
            province = itemView.findViewById(R.id.province);

            mainLayout_data = itemView.findViewById(R.id.mainLayout_data);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout_data.setAnimation(translate_anim);

        }
    }*/
}
