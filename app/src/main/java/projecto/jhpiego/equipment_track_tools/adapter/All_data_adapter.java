package projecto.jhpiego.equipment_track_tools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.model.Assessment_model;

public class All_data_adapter extends ArrayAdapter<Assessment_model> {

    private ArrayList<Assessment_model> all_data_set_assessment;
    Context assessm_context;

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
        facility_name.setText(all_data_set_assessment.get(position).getTxtFullName());

        return row;
    }
}
