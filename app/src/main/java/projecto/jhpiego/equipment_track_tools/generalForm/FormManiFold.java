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

public class FormManiFold extends AppCompatActivity {

    private Button btnBack, btnNext;
    private TextView txtareas_does_supply_other, txtareas_does_supply_otherTwoo, txtcapacity_manifold, txtdiameter_system, txthow_many_cylinder_conect_rs, txthow_many_cylinder_conect_ls;
    private TextView txthow_many_cylinder_conect_total, txtaverage_per_month, txtmost_common_model_cylinder_other, txtfrequency_pm_mani;
    private TextView txtname_maintenance_maniFold, txtaverage_cost_per_year_maniFold, txtbugdet_maitenance_program, txtname_cylinder_supply, txtcomments_manifold;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_facility_ox, cbo_manifold_used, cbo_follow_areas, cbo_old_sys, cbo_mani_aut_manu, cno_shortages;
    private String cbo_most_common, cbo_connection_cylinder, cbo_logbook_upd, cboMain_gen_cond, cbo_carrie_by, cbo_pm_cm;
    private String cbo_health_fac_receive, cbo_po_sys_working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_mani_fold);

        //  getSupportActionBar().hide();
        InitComponents();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manifold_in_health = cbo_facility_ox;
                String type_supply_used_manifold = cbo_manifold_used;
                String areas_does_supply = cbo_follow_areas;
                String areas_does_supply_other = txtareas_does_supply_other.getText().toString();
                String areas_does_supply_otherTwoo = txtareas_does_supply_otherTwoo.getText().toString();
                String old_system_manifold = cbo_old_sys;
                String kind_manifold = cbo_mani_aut_manu;
                String capacity_manifold = txtcapacity_manifold.getText().toString();
                String diameter_system = txtdiameter_system.getText().toString();
                String how_many_cylinder_conect_rs = txthow_many_cylinder_conect_rs.getText().toString();
                String how_many_cylinder_conect_ls = txthow_many_cylinder_conect_ls.getText().toString();
                String how_many_cylinder_conect_total = txthow_many_cylinder_conect_total.getText().toString();
                String average_per_month = txtaverage_per_month.getText().toString();
                String most_common_model_cylinder = cbo_most_common;
                String most_common_model_cylinder_other = txtmost_common_model_cylinder_other.getText().toString();
                String type_conection_cylinder_maniFold = cbo_connection_cylinder;
                String manifold_working = cbo_po_sys_working;
                String condition_system = cboMain_gen_cond;
                String active_pm_program_manif = cbo_logbook_upd;
                String frequency_pm_mani = txtfrequency_pm_mani.getText().toString();
                String activities_by = cbo_carrie_by;
                String name_maintenance_maniFold = txtname_maintenance_maniFold.getText().toString();
                String average_cost_per_year_maniFold = txtaverage_cost_per_year_maniFold.getText().toString();
                String bugdet_maitenance_program = txtbugdet_maitenance_program.getText().toString();
                String logbbook_maintenance = cbo_pm_cm;
                String logbbook_update_manifold = cbo_logbook_upd;
                String name_cylinder_supply = txtname_cylinder_supply.getText().toString();
                String how_does_receive_cylinder = cbo_health_fac_receive;
                String shortages_last_twoo_year = cbo_logbook_upd;
                String comments_manifold = txtcomments_manifold.getText().toString();


                if (TextUtils.isEmpty(capacity_manifold) || TextUtils.isEmpty(diameter_system) || TextUtils.isEmpty(how_many_cylinder_conect_rs) ||
                        TextUtils.isEmpty(how_many_cylinder_conect_ls) || TextUtils.isEmpty(how_many_cylinder_conect_total) || TextUtils.isEmpty(average_per_month) ||
                        TextUtils.isEmpty(frequency_pm_mani) || TextUtils.isEmpty(name_maintenance_maniFold) || TextUtils.isEmpty(average_cost_per_year_maniFold) || TextUtils.isEmpty(bugdet_maitenance_program) ||
                        TextUtils.isEmpty(name_cylinder_supply)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setManifold_in_health(manifold_in_health);
                    Assessment.assessment_model.setType_supply_used_manifold(type_supply_used_manifold);
                    Assessment.assessment_model.setAreas_does_supply(areas_does_supply);
                    Assessment.assessment_model.setAreas_does_supply_other(areas_does_supply_other);
                    Assessment.assessment_model.setAreas_does_supply_otherTwoo(areas_does_supply_otherTwoo);
                    Assessment.assessment_model.setOld_system_manifold(old_system_manifold);
                    Assessment.assessment_model.setKind_manifold(kind_manifold);
                    Assessment.assessment_model.setCapacity_manifold(txtcapacity_manifold.getText().toString());
                    Assessment.assessment_model.setDiameter_system(txtdiameter_system.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_rs(txthow_many_cylinder_conect_rs.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_ls(txthow_many_cylinder_conect_ls.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_total(txthow_many_cylinder_conect_total.getText().toString());
                    Assessment.assessment_model.setAverage_per_month(txtaverage_per_month.getText().toString());
                    Assessment.assessment_model.setMost_common_model_cylinder(most_common_model_cylinder);
                    Assessment.assessment_model.setMost_common_model_cylinder_other(txtmost_common_model_cylinder_other.getText().toString());
                    Assessment.assessment_model.setType_conection_cylinder_maniFold(type_conection_cylinder_maniFold);
                    Assessment.assessment_model.setManifold_working(manifold_working);
                    Assessment.assessment_model.setCondition_system(condition_system);
                    Assessment.assessment_model.setActive_pm_program_manif(active_pm_program_manif);
                    Assessment.assessment_model.setFrequency_pm_mani(txtfrequency_pm_mani.getText().toString());
                    Assessment.assessment_model.setActivities_by(activities_by);
                    Assessment.assessment_model.setName_maintenance_maniFold(txtname_maintenance_maniFold.getText().toString());
                    Assessment.assessment_model.setAverage_cost_per_year_maniFold(txtaverage_cost_per_year_maniFold.getText().toString());
                    Assessment.assessment_model.setBugdet_maitenance_program(txtbugdet_maitenance_program.getText().toString());
                    Assessment.assessment_model.setLogbbook_maintenance(logbbook_maintenance);
                    Assessment.assessment_model.setLogbbook_update_manifold(logbbook_update_manifold);
                    Assessment.assessment_model.setName_cylinder_supply(txtname_cylinder_supply.getText().toString());
                    Assessment.assessment_model.setHow_does_receive_cylinder(how_does_receive_cylinder);
                    Assessment.assessment_model.setShortages_last_twoo_year(shortages_last_twoo_year);
                    Assessment.assessment_model.setComments_manifold(comments_manifold);

                    Intent i = new Intent(FormManiFold.this, FormManiFoldTwoo.class);
                    // Intent i = new Intent(FormManiFold.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMF = new Intent(FormManiFold.this, FormConcentrator.class);
                startActivity(backMF);
            }
        });
    }

    public void onRadioButtonClicked_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesMF:
                if (checked)
                    cbo_facility_ox = "Yes";
                break;
            case R.id.idChkNoMF:
                if (checked)
                    cbo_facility_ox = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPrimaMF:
                if (checked)
                    cbo_manifold_used = "Primary";
                break;
            case R.id.chkSecondMF:
                if (checked)
                    cbo_manifold_used = "Secondary";
                break;
            case R.id.chkEmergMF:
                if (checked)
                    cbo_manifold_used = "Emergency";
                break;
        }
    }

    public void onRadioButtonClicked2_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkNAMF:
                if (checked)
                    cbo_follow_areas = "Nursery ward";
                break;
            case R.id.chkCAMF:
                if (checked)
                    cbo_follow_areas = "Casualty ward";
                break;
            case R.id.chkPTMF:
                if (checked)
                    cbo_follow_areas = "Operating Theatre";
                break;
            case R.id.chkMaternMF:
                if (checked)
                    cbo_follow_areas = "Maternity";
                break;
            case R.id.chkICUMF:
                if (checked)
                    cbo_follow_areas = "Intensive Care (ICU)";
                break;
        }
    }

    public void onRadioButtonClicked3_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLess:
                if (checked)
                    cbo_old_sys = "Less than 3 years";
                break;
            case R.id.chkB3_10:
                if (checked)
                    cbo_old_sys = "Between 3-10 years";
                break;
            case R.id.idChkB11_20:
                if (checked)
                    cbo_old_sys = "Between 11-20 years";
                break;
            case R.id.idChkMore20:
                if (checked)
                    cbo_old_sys = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked4_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkMANMF:
                if (checked)
                    cbo_mani_aut_manu = "Manual";
                break;
            case R.id.chkAUTOMF:
                if (checked)
                    cbo_mani_aut_manu = "Automatic";
                break;
        }
    }

    public void onRadioButtonClicked5_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEMF:
                if (checked)
                    cbo_most_common = "E (1m3/680L)";
                break;
            case R.id.chkFMF:
                if (checked)
                    cbo_most_common = "F (1.5/1360L)";
                break;
            case R.id.chkGMF:
                if (checked)
                    cbo_most_common = "G (3.5m3/3400L)";
                break;
            case R.id.chkJMF:
                if (checked)
                    cbo_most_common = "J (7.5m3/7800L)";
                break;
            case R.id.chkDontNoMF:
                if (checked)
                    cbo_most_common = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked6_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPINMF:
                if (checked)
                    cbo_connection_cylinder = "Pin index";
                break;
            case R.id.chkPINSMF:
                if (checked)
                    cbo_connection_cylinder = "Pin-index side spindle valve";
                break;
            case R.id.chkBullnoseMF:
                if (checked)
                    cbo_connection_cylinder = "Bullnose valve";
                break;
            case R.id.chkHandwheelMF:
                if (checked)
                    cbo_connection_cylinder = "Handwheel side outlet";
                break;
        }
    }

    public void onRadioButtonClicked7_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYMF:
                if (checked)
                    cbo_po_sys_working = "Yes";
                break;
            case R.id.chkNMF:
                if (checked)
                    cbo_po_sys_working = "No";
                break;
            case R.id.chkPartlyMF:
                if (checked)
                    cbo_po_sys_working = "Partly";
                break;
            case R.id.chkDontNMF:
                if (checked)
                    cbo_po_sys_working = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked8_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkGIUMF:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.chkGBNUMF:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.chkIU_BNRMF:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRMF:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.chkOOSBRMF:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.chkOOSAndNRMF:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaMF:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.chkDontKnowMF:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked9_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESPMMF:
                if (checked)
                    cbo_logbook_upd = "Yes";
                break;
            case R.id.chkNOPMMF:
                if (checked)
                    cbo_logbook_upd = "No";
                break;
        }
    }

    public void onRadioButtonClicked10_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFMF:
                if (checked)
                    cbo_carrie_by = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIMF:
                if (checked)
                    cbo_carrie_by = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCMF:
                if (checked)
                    cbo_carrie_by = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked11_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMCMMF:
                if (checked)
                    cbo_pm_cm = "Yes";
                break;
            case R.id.chkNOSPMCMMF:
                if (checked)
                    cbo_pm_cm = "No";
                break;
        }
    }

    public void onRadioButtonClicked12_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESKBMF:
                if (checked)
                    cno_shortages = "Yes";
                break;
            case R.id.chkNOLBMF:
                if (checked)
                    cno_shortages = "No";
                break;
        }
    }

    public void onRadioButtonClicked13_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDailyMF:
                if (checked)
                    cbo_health_fac_receive = "Daily";
                break;
            case R.id.chkWeeklyMF:
                if (checked)
                    cbo_health_fac_receive = "Weekly";
                break;
            case R.id.chkFortnightlyMF:
                if (checked)
                    cbo_health_fac_receive = "Fortnightly";
                break;
            case R.id.chkMonthlyMF:
                if (checked)
                    cbo_health_fac_receive = "Monthly";
                break;
            case R.id.chkOnrequestMF:
                if (checked)
                    cbo_health_fac_receive = "On request";
                break;
        }
    }


    public void onRadioButtonClicked14_mf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESSUC:
                if (checked)
                    cbo_logbook_upd = "Yes";
                break;
            case R.id.chkNOSC:
                if (checked)
                    cbo_logbook_upd = "No";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backMF);
        btnNext = findViewById(R.id.btn_next);

        txtareas_does_supply_other = findViewById(R.id.txtOtherOMF);
        txtareas_does_supply_otherTwoo = findViewById(R.id.txtOtherTMF);

        txtcapacity_manifold = findViewById(R.id.txtLPMMF);
        txtdiameter_system = findViewById(R.id.txtMMMF);

        txthow_many_cylinder_conect_rs = findViewById(R.id.txtRMF);
        txthow_many_cylinder_conect_ls = findViewById(R.id.txtLSMF);
        txthow_many_cylinder_conect_total = findViewById(R.id.txtTotalMF);
        txtaverage_per_month = findViewById(R.id.txtAGVMonthMF);

        txtmost_common_model_cylinder_other = findViewById(R.id.txtOtherMF);
        txtfrequency_pm_mani = findViewById(R.id.txtFPMMF);

        txtname_maintenance_maniFold = findViewById(R.id.txtNMCMF);
        txtaverage_cost_per_year_maniFold = findViewById(R.id.txtAVGCostMF);
        txtbugdet_maitenance_program = findViewById(R.id.txtBMPMF);

        txtname_cylinder_supply = findViewById(R.id.txtCSMF);
        txtcomments_manifold = findViewById(R.id.txtCommentsMF);
    }

    public void LimparCampos() {
        txtareas_does_supply_other.setText("");
        txtareas_does_supply_otherTwoo.setText("");
        txtcapacity_manifold.setText("");
        txtdiameter_system.setText("");
        txthow_many_cylinder_conect_rs.setText("");
        txthow_many_cylinder_conect_ls.setText("");
        txthow_many_cylinder_conect_total.setText("");
        txtaverage_per_month.setText("");
        txtmost_common_model_cylinder_other.setText("");
        txtfrequency_pm_mani.setText("");
        txtname_maintenance_maniFold.setText("");
        txtaverage_cost_per_year_maniFold.setText("");
        txtbugdet_maitenance_program.setText("");
        txtname_cylinder_supply.setText("");
        txtcomments_manifold.setText("");
    }
}