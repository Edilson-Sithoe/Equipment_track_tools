//package projecto.jhpiego.equipment_track_tools.adapter;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//import projecto.jhpiego.equipment_track_tools.R;
//import projecto.jhpiego.equipment_track_tools.model.Equipment_inventory;
//import projecto.jhpiego.equipment_track_tools.view.inventory.Update_equipm_inventory;
//
//public class Equipment_inventory_adapter extends RecyclerView.Adapter<Equipment_inventory_adapter.MyViewHolder> {
//
//    private Context context;
//    private Activity activity;
//    private ArrayList id, txtDept, txtTypeEquip, txtInvent_number, txtMake, txtModel, txtSerialNumber;
//    private ArrayList txtEquipCondition, txtYearInstall, txtContract_man, txtData_last_man, txtComment;
//    Equipment_inventory equipment_inventory;
//
//    Animation translate_anim;
//
//
//    public Equipment_inventory_adapter(Activity activity, Context context, ArrayList id, ArrayList txtDept, ArrayList txtTypeEquip, ArrayList txtInvent_number, ArrayList txtMake, ArrayList txtModel, ArrayList txtSerialNumber, ArrayList txtEquipCondition, ArrayList txtYearInstall, ArrayList txtContract_man, ArrayList txtData_last_man, ArrayList txtComment) {
//        this.activity = activity;
//        this.context = context;
//        this.id = id;
//        this.txtDept = txtDept;
//        this.txtTypeEquip = txtTypeEquip;
//        this.txtInvent_number = txtInvent_number;
//        this.txtMake = txtMake;
//        this.txtModel = txtModel;
//        this.txtSerialNumber = txtSerialNumber;
//        this.txtEquipCondition = txtEquipCondition;
//        this.txtYearInstall = txtYearInstall;
//        this.txtContract_man = txtContract_man;
//        this.txtData_last_man = txtData_last_man;
//        this.txtComment = txtComment;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.inventory, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//     //   holder.id.setText(equipment_inventory.get(position).getId);
//
//        holder.id.setText(String.valueOf(id.get(position)));
//        holder.txtDept.setText(String.valueOf(txtDept.get(position)));
//        holder.txtTypeEquip.setText(String.valueOf(txtTypeEquip.get(position)));
//        holder.txtInvent_number.setText(String.valueOf(txtInvent_number.get(position)));
//        holder.txtMake.setText(String.valueOf(txtMake.get(position)));
//        holder.txtModel.setText(String.valueOf(txtModel.get(position)));
//        holder.txtSerialNumber.setText(String.valueOf(txtSerialNumber.get(position)));
//        holder.txtEquipCondition.setText(String.valueOf(txtEquipCondition.get(position)));
//        holder.txtYearInstall.setText(String.valueOf(txtYearInstall.get(position)));
//        holder.txtContract_man.setText(String.valueOf(txtContract_man.get(position)));
//        holder.txtData_last_man.setText(String.valueOf(txtData_last_man.get(position)));
//
//
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              /*  Bundle bundle = new Bundle();
//                bundle.putInt("id",equipment_inventory.getId());
//                bundle.putString("txtDept",equipment_inventory.getDepartment());
//                bundle.putString("txtTypeEquip",equipment_inventory.getTypeEquipment());
//                bundle.putString("txtInvent_number",equipment_inventory.getInventory_number());
//                bundle.putString("txtMake",equipment_inventory.getMake());
//                bundle.putString("txtModel",equipment_inventory.getModel());
//                bundle.putString("txtSerialNumber",equipment_inventory.getSerial_number());
//                bundle.putString("txtEquipCondition",equipment_inventory.getEquipment_condition());
//                bundle.putString("txtYearInstall",equipment_inventory.getYear_install());
//                bundle.putString("txtDataMaint",equipment_inventory.getData_last_main());
//                bundle.putString("txtComment",equipment_inventory.getComments());*/
//                Intent intent = new Intent(context, Update_equipm_inventory.class);
//                //   intent.putExtra("userdata", bundle);
//                intent.putExtra("id", String.valueOf(id.get(position)));
//                intent.putExtra("txtDept", String.valueOf(txtDept.get(position)));
//                intent.putExtra("txtTypeEquip", String.valueOf(txtTypeEquip.get(position)));
//                intent.putExtra("txtInvent_number", String.valueOf(txtInvent_number.get(position)));
//                intent.putExtra("txtMake", String.valueOf(txtMake.get(position)));
//                intent.putExtra("txtModel", String.valueOf(txtModel.get(position)));
//                intent.putExtra("txtSerialNumber", String.valueOf(txtSerialNumber.get(position)));
//                intent.putExtra("txtEquipCondition", String.valueOf(txtEquipCondition.get(position)));
//                intent.putExtra("txtYearInstall", String.valueOf(txtYearInstall.get(position)));
//                intent.putExtra("txtContract_man", String.valueOf(txtContract_man.get(position)));
//                intent.putExtra("txtData_last_man", String.valueOf(txtData_last_man.get(position)));
//                activity.startActivityForResult(intent, 1);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return id.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView id, txtDept, txtTypeEquip, txtInvent_number, txtMake, txtModel, txtSerialNumber;
//        TextView txtEquipCondition, txtYearInstall, txtContract_man, txtData_last_man;
//        LinearLayout mainLayout;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            id = itemView.findViewById(R.id.invent_id);
//            txtDept = itemView.findViewById(R.id.txt_dept);
//            txtTypeEquip = itemView.findViewById(R.id.txt_type);
//            txtInvent_number = itemView.findViewById(R.id.txt_inv_number);
//            txtMake = itemView.findViewById(R.id.txt_make);
//            txtModel = itemView.findViewById(R.id.txt_model);
//            txtSerialNumber = itemView.findViewById(R.id.txt_serial);
//            txtEquipCondition = itemView.findViewById(R.id.txt_eq_cond);
//            txtYearInstall = itemView.findViewById(R.id.txt_install);
//            txtContract_man = itemView.findViewById(R.id.txt_data);
//            txtData_last_man = itemView.findViewById(R.id.txt_data);
//
//            mainLayout = itemView.findViewById(R.id.mainLayout);
//            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
//            mainLayout.setAnimation(translate_anim);
//        }
//    }
//}
