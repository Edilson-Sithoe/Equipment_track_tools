package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormManiFoldTwoo extends AppCompatActivity {

    private Button btnBack, btnNext;
    private TextView txtareas_does_supply_other_twoo, txtareas_does_supply_otherTwoo_twoo, txtcapacity_manifold_twoo, txtdiameter_system_twoo, txthow_many_cylinder_conect_rs_twoo, txthow_many_cylinder_conect_ls_twoo;
    private TextView txthow_many_cylinder_conect_total_twoo, txtaverage_per_month_twoo, txtmost_common_model_cylinder_other_twoo, txtfrequency_pm_mani_twoo;
    private TextView txtname_maintenance_maniFold_twoo, txtaverage_cost_per_year_maniFold_twoo, txtbugdet_maitenance_program_twoo, txtname_cylinder_supply_twoo, txtcomments_manifold_twoo;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_facility_ox_twoo, cbo_manifold_used_twoo, cbo_follow_areas_twoo, cbo_old_sys_twoo, cbo_mani_aut_manu_twoo, cbo_shortages_twoo;
    private String cbo_most_common_twoo, cbo_connection_cylinder_twoo, cbo_logbook_upd_twoo, cbo_condiction_system_twoo,cboMain_gen_cond_twoo, cbo_carrie_by_twoo, cbo_pm_cm_twoo;
    private String cbo_health_fac_receive_twoo, cbo_po_sys_working_twoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_mani_fold_twoo);

     //   getSupportActionBar().hide();
        InitComponents();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manifold_in_health_twoo = cbo_facility_ox_twoo;
                String type_supply_used_manifold_twoo = cbo_manifold_used_twoo;
                String areas_does_supply_twoo = cbo_follow_areas_twoo;
                String areas_does_supply_other_twoo = txtareas_does_supply_other_twoo.getText().toString();
                String areas_does_supply_otherTwoo_twoo = txtareas_does_supply_otherTwoo_twoo.getText().toString();
                String old_system_manifold_twoo = cbo_old_sys_twoo;
                String kind_manifold_twoo = cbo_mani_aut_manu_twoo;
                String capacity_manifold_twoo = txtcapacity_manifold_twoo.getText().toString();
                String diameter_system_twoo = txtdiameter_system_twoo.getText().toString();
                String how_many_cylinder_conect_rs_twoo = txthow_many_cylinder_conect_rs_twoo.getText().toString();
                String how_many_cylinder_conect_ls_twoo = txthow_many_cylinder_conect_ls_twoo.getText().toString();
                String how_many_cylinder_conect_total_twoo = txthow_many_cylinder_conect_total_twoo.getText().toString();
                String average_per_month_twoo = txtaverage_per_month_twoo.getText().toString();
                String most_common_model_cylinder_twoo = cbo_most_common_twoo;
                String most_common_model_cylinder_other_twoo = txtmost_common_model_cylinder_other_twoo.getText().toString();
                String type_conection_cylinder_maniFold_twoo = cbo_connection_cylinder_twoo;
                String manifold_working_twoo = cbo_po_sys_working_twoo;
                String condition_system_twoo = cboMain_gen_cond_twoo;
                String active_pm_program_manif_twoo = cbo_condiction_system_twoo;
                String frequency_pm_mani_twoo = txtfrequency_pm_mani_twoo.getText().toString();
                String activities_by_twoo = cbo_carrie_by_twoo;
                String name_maintenance_maniFold_twoo = txtname_maintenance_maniFold_twoo.getText().toString();
                String average_cost_per_year_maniFold_twoo = txtaverage_cost_per_year_maniFold_twoo.getText().toString();
                String bugdet_maitenance_program_twoo = txtbugdet_maitenance_program_twoo.getText().toString();
                String logbbook_maintenance_twoo = cbo_pm_cm_twoo;
                String logbbook_update_manifold_twoo = cbo_logbook_upd_twoo;
                String name_cylinder_supply_twoo = txtname_cylinder_supply_twoo.getText().toString();
                String how_does_receive_cylinder_twoo = cbo_health_fac_receive_twoo;
                String shortages_last_twoo_year_twoo = cbo_shortages_twoo;
                String comments_manifold_twoo = txtcomments_manifold_twoo.getText().toString();


                if (TextUtils.isEmpty(capacity_manifold_twoo) || TextUtils.isEmpty(diameter_system_twoo) || TextUtils.isEmpty(how_many_cylinder_conect_rs_twoo) ||
                        TextUtils.isEmpty(how_many_cylinder_conect_ls_twoo) || TextUtils.isEmpty(how_many_cylinder_conect_total_twoo) || TextUtils.isEmpty(average_per_month_twoo) ||
                        TextUtils.isEmpty(frequency_pm_mani_twoo) || TextUtils.isEmpty(name_maintenance_maniFold_twoo) || TextUtils.isEmpty(average_cost_per_year_maniFold_twoo) || TextUtils.isEmpty(bugdet_maitenance_program_twoo) ||
                        TextUtils.isEmpty(name_cylinder_supply_twoo)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178,34,34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setManifold_in_health_twoo(manifold_in_health_twoo);
                    Assessment.assessment_model.setType_supply_used_manifold_twoo(type_supply_used_manifold_twoo);
                    Assessment.assessment_model.setAreas_does_supply_twoo(areas_does_supply_twoo);
                    Assessment.assessment_model.setAreas_does_supply_other_twoo(txtareas_does_supply_other_twoo.getText().toString());
                    Assessment.assessment_model.setAreas_does_supply_otherTwoo_twoo(txtareas_does_supply_otherTwoo_twoo.getText().toString());
                    Assessment.assessment_model.setOld_system_manifold_twoo(old_system_manifold_twoo);
                    Assessment.assessment_model.setKind_manifold_twoo(kind_manifold_twoo);
                    Assessment.assessment_model.setCapacity_manifold_twoo(txtcapacity_manifold_twoo.getText().toString());
                    Assessment.assessment_model.setDiameter_system_twoo(txtdiameter_system_twoo.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_rs_twoo(txthow_many_cylinder_conect_rs_twoo.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_ls_twoo(txthow_many_cylinder_conect_ls_twoo.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_total_twoo(txthow_many_cylinder_conect_total_twoo.getText().toString());
                    Assessment.assessment_model.setAverage_per_month_twoo(txtaverage_per_month_twoo.getText().toString());
                    Assessment.assessment_model.setMost_common_model_cylinder_twoo(most_common_model_cylinder_twoo);
                    Assessment.assessment_model.setMost_common_model_cylinder_other_twoo(txtmost_common_model_cylinder_other_twoo.getText().toString());
                    Assessment.assessment_model.setType_conection_cylinder_twoo(type_conection_cylinder_maniFold_twoo);
                    Assessment.assessment_model.setManifold_working_twoo(manifold_working_twoo);
                    Assessment.assessment_model.setCondition_system_twoo(condition_system_twoo);
                    Assessment.assessment_model.setActive_pm_program_manif_twoo(active_pm_program_manif_twoo);
                    Assessment.assessment_model.setFrequency_pm_mani_twoo(txtfrequency_pm_mani_twoo.getText().toString());
                    Assessment.assessment_model.setActivities_by_twoo(activities_by_twoo);
                    Assessment.assessment_model.setName_maintenance_maniFold_twoo(txtname_maintenance_maniFold_twoo.getText().toString());
                    Assessment.assessment_model.setAverage_cost_per_year_twoo(txtaverage_cost_per_year_maniFold_twoo.getText().toString());
                    Assessment.assessment_model.setBugdet_maitenance_program_twoo(txtbugdet_maitenance_program_twoo.getText().toString());
                    Assessment.assessment_model.setLogbbook_maintenance_twoo(logbbook_maintenance_twoo);
                    Assessment.assessment_model.setLogbbook_update_manifold_twoo(logbbook_update_manifold_twoo);
                    Assessment.assessment_model.setName_cylinder_supply_twoo(txtname_cylinder_supply_twoo.getText().toString());
                    Assessment.assessment_model.setHow_does_receive_cylinder_twoo(how_does_receive_cylinder_twoo);
                    Assessment.assessment_model.setShortages_last_twoo_year_twoo(shortages_last_twoo_year_twoo);
                    Assessment.assessment_model.setComments_manifold_twoo(txtcomments_manifold_twoo.getText().toString());

                    Intent i = new Intent(FormManiFoldTwoo.this, FormMFEmerg.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMFT = new Intent(FormManiFoldTwoo.this, FormManiFold.class);
                startActivity(backMFT);
            }
        });

    }

    public void onRadioButtonClicked_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesMF:
                if (checked)
                    cbo_facility_ox_twoo = "Yes";
                break;
            case R.id.idChkNoMF:
                if (checked)
                    cbo_facility_ox_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPrimaMF:
                if (checked)
                    cbo_manifold_used_twoo = "Primary";
                break;
            case R.id.chkSecondMF:
                if (checked)
                    cbo_manifold_used_twoo = "Secondary";
                break;
            case R.id.chkEmergMF:
                if (checked)
                    cbo_manifold_used_twoo = "Emergency";
                break;
        }
    }

    public void onRadioButtonClicked2_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkNAMF:
                if (checked)
                    cbo_follow_areas_twoo = "Nursery ward";
                break;
            case R.id.chkCAMF:
                if (checked)
                    cbo_follow_areas_twoo = "Casualty ward";
                break;
            case R.id.chkPTMF:
                if (checked)
                    cbo_follow_areas_twoo = "Operating Theatre";
                break;
            case R.id.chkMaternMF:
                if (checked)
                    cbo_follow_areas_twoo = "Maternity";
                break;
            case R.id.chkICUMF:
                if (checked)
                    cbo_follow_areas_twoo = "Intensive Care (ICU)";
                break;
        }
    }

    public void onRadioButtonClicked3_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLess:
                if (checked)
                    cbo_old_sys_twoo = "Less than 3 years";
                break;
            case R.id.chkB3_10:
                if (checked)
                    cbo_old_sys_twoo = "Between 3-10 years";
                break;
            case R.id.idChkB11_20:
                if (checked)
                    cbo_old_sys_twoo = "Between 11-20 years";
                break;
            case R.id.idChkMore20:
                if (checked)
                    cbo_old_sys_twoo = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked4_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkMANMF:
                if (checked)
                    cbo_mani_aut_manu_twoo = "Manual";
                break;
            case R.id.chkAUTOMF:
                if (checked)
                    cbo_mani_aut_manu_twoo = "Automatic";
                break;
        }
    }

    public void onRadioButtonClicked5_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEMF:
                if (checked)
                    cbo_most_common_twoo = "E (1m3/680L)";
                break;
            case R.id.chkFMF:
                if (checked)
                    cbo_most_common_twoo = "F (1.5/1360L)";
                break;
            case R.id.chkGMF:
                if (checked)
                    cbo_most_common_twoo = "G (3.5m3/3400L)\"";
                break;
            case R.id.chkJMF:
                if (checked)
                    cbo_most_common_twoo = "J (7.5m3/7800L)";
                break;
            case R.id.chkDontNoMF:
                if (checked)
                    cbo_most_common_twoo = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked6_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPINMF:
                if (checked)
                    cbo_connection_cylinder_twoo = "Pin index";
                break;
            case R.id.chkPINSMF:
                if (checked)
                    cbo_connection_cylinder_twoo = "Pin-index side spindle valve";
                break;
            case R.id.chkBullnoseMF:
                if (checked)
                    cbo_connection_cylinder_twoo = "Bullnose valve";
                break;
            case R.id.chkHandwheelMF:
                if (checked)
                    cbo_connection_cylinder_twoo = "Handwheel side outlet";
                break;
        }
    }

    public void onRadioButtonClicked7_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYMF:
                if (checked)
                    cbo_po_sys_working_twoo = "Yes";
                break;
            case R.id.chkNMF:
                if (checked)
                    cbo_po_sys_working_twoo = "No";
                break;
            case R.id.chkPartlyMF:
                if (checked)
                    cbo_po_sys_working_twoo = "Partly";
                break;
            case R.id.chkDontNMF:
                if (checked)
                    cbo_po_sys_working_twoo = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked8_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkGIUMF:
                if (checked)
                    cboMain_gen_cond_twoo = "Good and in use";
                break;
            case R.id.chkGBNUMF:
                if (checked)
                    cboMain_gen_cond_twoo = "Good, but not in use";
                break;
            case R.id.chkIU_BNRMF:
                if (checked)
                    cboMain_gen_cond_twoo = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRMF:
                if (checked)
                    cboMain_gen_cond_twoo = "In use, but needs to be replaced";
            case R.id.chkOOSBRMF:
                if (checked)
                    cboMain_gen_cond_twoo = "Out of service, but repairable";
            case R.id.chkOOSAndNRMF:
                if (checked)
                    cboMain_gen_cond_twoo = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaMF:
                if (checked)
                    cboMain_gen_cond_twoo = "Still in the installation phase";
            case R.id.chkDontKnowMF:
                if (checked)
                    cboMain_gen_cond_twoo = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked9_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESPMMF:
                if (checked)
                    cbo_condiction_system_twoo = "Yes";
                break;
            case R.id.chkNOPMMF:
                if (checked)
                    cbo_condiction_system_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked10_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFMF:
                if (checked)
                    cbo_carrie_by_twoo = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIMF:
                if (checked)
                    cbo_carrie_by_twoo = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCMF:
                if (checked)
                    cbo_carrie_by_twoo = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked11_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMCMMF:
                if (checked)
                    cbo_pm_cm_twoo = "Yes";
                break;
            case R.id.chkNOSPMCMMF:
                if (checked)
                    cbo_pm_cm_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked12_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLogB:
                if (checked)
                    cbo_logbook_upd_twoo = "Yes";
                break;
            case R.id.chkNoLogB:
                if (checked)
                    cbo_logbook_upd_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked13_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDailyMF:
                if (checked)
                    cbo_health_fac_receive_twoo = "Daily";
                break;
            case R.id.chkWeeklyMF:
                if (checked)
                    cbo_health_fac_receive_twoo = "Weekly";
                break;
            case R.id.chkFortnightlyMF:
                if (checked)
                    cbo_health_fac_receive_twoo = "Fortnightly";
                break;
            case R.id.chkMonthlyMF:
                if (checked)
                    cbo_health_fac_receive_twoo = "Monthly";
                break;
            case R.id.chkOnrequestMF:
                if (checked)
                    cbo_health_fac_receive_twoo = "On request";
                break;
        }
    }

    public void onRadioButtonClicked14_mf_twho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESSUC:
                if (checked)
                    cbo_shortages_twoo = "Yes";
                break;
            case R.id.chkNOSC:
                if (checked)
                    cbo_shortages_twoo = "No";
                break;
        }
    }


    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backMF);
        btnNext = findViewById(R.id.btn_next);

        txtareas_does_supply_other_twoo = findViewById(R.id.txtOtherOMF);
        txtareas_does_supply_otherTwoo_twoo = findViewById(R.id.txtOtherTMF);

        txtcapacity_manifold_twoo = findViewById(R.id.txtLPMMF);
        txtdiameter_system_twoo = findViewById(R.id.txtMMMF);
        txthow_many_cylinder_conect_rs_twoo = findViewById(R.id.txtRMF);
        txthow_many_cylinder_conect_ls_twoo = findViewById(R.id.txtLSMF);
        txthow_many_cylinder_conect_total_twoo = findViewById(R.id.txtTotalMF);
        txtaverage_per_month_twoo = findViewById(R.id.txtAGVMonthMF);

        txtmost_common_model_cylinder_other_twoo = findViewById(R.id.txtOtherMF);
        txtfrequency_pm_mani_twoo = findViewById(R.id.txtFPMMF);
        txtname_maintenance_maniFold_twoo = findViewById(R.id.txtNMCMF);
        txtaverage_cost_per_year_maniFold_twoo = findViewById(R.id.txtAVGCostMF);
        txtbugdet_maitenance_program_twoo = findViewById(R.id.txtBMPMF);
        txtname_cylinder_supply_twoo = findViewById(R.id.txtCSMF);
        txtcomments_manifold_twoo = findViewById(R.id.txtCommentsMF);
    }

    public void LimparCampos() {
        txtareas_does_supply_other_twoo.setText("");
        txtareas_does_supply_otherTwoo_twoo.setText("");
        txtcapacity_manifold_twoo.setText("");
        txtdiameter_system_twoo.setText("");
        txthow_many_cylinder_conect_rs_twoo.setText("");
        txthow_many_cylinder_conect_ls_twoo.setText("");
        txthow_many_cylinder_conect_total_twoo.setText("");
        txtaverage_per_month_twoo.setText("");
        txtmost_common_model_cylinder_other_twoo.setText("");
        txtfrequency_pm_mani_twoo.setText("");
        txtname_maintenance_maniFold_twoo.setText("");
        txtaverage_cost_per_year_maniFold_twoo.setText("");
        txtbugdet_maitenance_program_twoo.setText("");
        txtname_cylinder_supply_twoo.setText("");
        txtcomments_manifold_twoo.setText("");
    }
}