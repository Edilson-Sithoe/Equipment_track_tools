package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormManiFoldTwoo;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Update_manifold_too extends AppCompatActivity {
    private Button btnBack, btnNext;
    private TextView txtareas_does_supply_other, txtareas_does_supply_otherTwoo, txtcapacity_manifold, txtdiameter_system, txthow_many_cylinder_conect_rs, txthow_many_cylinder_conect_ls;
    private TextView txthow_many_cylinder_conect_total, txtaverage_per_month, txtmost_common_model_cylinder_other, txtfrequency_pm_mani;
    private TextView txtname_maintenance_maniFold, txtaverage_cost_per_year_maniFold, txtbugdet_maitenance_program, txtname_cylinder_supply, txtcomments_manifold;
    private RadioButton idChkYesMF, idChkNoMF;
    private RadioButton chkPrimaMF, chkSecondMF, chkEmergMF, chkNAMF, chkCAMF;
    private RadioButton chkPTMF, chkMaternMF, chkICUMF, chkLess, chkB3_10, chkMANMF;
    private RadioButton chkAUTOMF, chkEMF, chkFMF, chkGMF, chkJMF, chkDontNoMF, chkPINMF;
    private RadioButton chkPINSMF, chkBullnoseMF, chkHandwheelMF, chkYMF, chkNMF, chkPartlyMF;
    private RadioButton chkDontNMF, chkGIUMF, chkGBNUMF, chkIU_BNRMF, chkIUNNTRMF, chkOOSBRMF, chkOOSAndNRMF;
    private RadioButton chkStilInstPhaMF, chkDontKnowMF, chkYESPMMF, chkNOPMMF, chkPHFMF, chkPDIMF, chkSubCMF;
    private RadioButton chkYesPMCMMF, chkNOSPMCMMF, chkYESKBMF, chkNOLBMF, chkDailyMF, chkWeeklyMF, chkFortnightlyMF;
    private RadioButton chkMonthlyMF, chkOnrequestMF, chkYESSUC, chkNOSC, idChkB11_20, idChkMore20;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_facility_ox, cbo_manifold_used, cbo_follow_areas, cbo_old_sys, cbo_mani_aut_manu, cno_shortages;
    private String cbo_most_common, cbo_connection_cylinder, cbo_logbook_upd, cboMain_gen_cond, cbo_carrie_by, cbo_pm_cm;
    private String cbo_health_fac_receive, cbo_po_sys_working;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_manifold_too);

        getAndSetIntentData();
        InitComponents();

        setRB_manifold_in_health();
        setRB_manifold_areas_supp();
        setRB_manifold_old_system();
        setRBMain_old_solar();
        setRB_manifold_auto_manu();
        setRB_manifold_common();
        setRB_manifold_type_conn();
        setRBMain_mani_work_solar();
        setRBDuraPOut_solar();
        setRB_manifold_pm_active_program();
        setRBMain_mani_carries_by();
        setRB_manifold_pm_cm();
        setRB_manifold_logbook_upd();
        setRB_manifold_health_receive();
        setRB_manifold_shortages();

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

                if (idChkYesMF.isChecked())
                    Variaveis.assessment_model.setManifold_in_health_twoo("Yes");
                else if (idChkNoMF.isChecked())
                    Variaveis.assessment_model.setManifold_in_health_twoo("No");

                if (chkPrimaMF.isChecked())
                    Variaveis.assessment_model.setType_supply_used_manifold_twoo("Primary");
                else if (chkSecondMF.isChecked())
                    Variaveis.assessment_model.setType_supply_used_manifold_twoo("Secondary");
                else if (chkEmergMF.isChecked())
                    Variaveis.assessment_model.setType_supply_used_manifold_twoo("Emergency");

                if (chkNAMF.isChecked())
                    Variaveis.assessment_model.setAreas_does_supply_twoo("Nursery ward");
                else if (chkCAMF.isChecked())
                    Variaveis.assessment_model.setAreas_does_supply_twoo("Casualty ward");
                else if (chkPTMF.isChecked())
                    Variaveis.assessment_model.setAreas_does_supply_twoo("Operating Theatre");
                else if (chkMaternMF.isChecked())
                    Variaveis.assessment_model.setAreas_does_supply_twoo("Maternity");
                else if (chkICUMF.isChecked())
                    Variaveis.assessment_model.setAreas_does_supply_twoo("Intensive Care (ICU)");

                if (chkLess.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_twoo("Less than 3 years");
                else if (chkB3_10.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_twoo("Between 3-10 years");
                else if (idChkB11_20.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_twoo("Between 11-20 years");
                else if (idChkMore20.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_twoo("More than 20 years");

                if (chkMANMF.isChecked())
                    Variaveis.assessment_model.setKind_manifold_twoo("Manual");
                else if (chkAUTOMF.isChecked())
                    Variaveis.assessment_model.setKind_manifold_twoo("Automatic");

                if (chkEMF.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_twoo("E (1m3/680L)");
                else if (chkFMF.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_twoo("F (1.5/1360L)");
                else if (chkGMF.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_twoo("G (3.5m3/3400L)");
                else if (chkJMF.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_twoo("J (7.5m3/7800L)");
                else if (chkDontNoMF.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_twoo("Don't know");

                if (chkPINMF.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_twoo("Pin index");
                else if (chkPINSMF.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_twoo("Pin-index side spindle valve");
                else if (chkBullnoseMF.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_twoo("Bullnose valve");
                else if (chkHandwheelMF.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_twoo("Handwheel side outlet");

                if (chkYMF.isChecked())
                    Variaveis.assessment_model.setManifold_working_twoo("Yes");
                else if (chkNMF.isChecked())
                    Variaveis.assessment_model.setManifold_working_twoo("No");
                else if (chkPartlyMF.isChecked())
                    Variaveis.assessment_model.setManifold_working_twoo("Partly");
                else if (chkDontNMF.isChecked())
                    Variaveis.assessment_model.setManifold_working_twoo("Don't know");

                if (chkGIUMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("Good and in use");
                else if (chkGBNUMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("Good, but not in use");
                else if (chkIU_BNRMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("In use, but needs repair");
                else if (chkIUNNTRMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("In use, but needs to be replaced");
                else if (chkOOSBRMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("Out of service, but repairable");
                else if (chkOOSAndNRMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("Out of service and needs to be replaced");
                else if (chkStilInstPhaMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("Still in the installation phase");
                else if (chkDontKnowMF.isChecked())
                    Variaveis.assessment_model.setCondition_system_twoo("Don't know");

                if (chkYESPMMF.isChecked())
                    Variaveis.assessment_model.setActive_pm_program_manif_twoo("Yes");
                else if (chkNOPMMF.isChecked())
                    Variaveis.assessment_model.setActive_pm_program_manif_twoo("No");

                if (chkPHFMF.isChecked())
                    Variaveis.assessment_model.setActivities_by_twoo("Internal Technical Personnel of the health facility");
                else if (chkPDIMF.isChecked())
                    Variaveis.assessment_model.setActivities_by_twoo("Personnel of the Department of Infrastructure");
                else if (chkSubCMF.isChecked())
                    Variaveis.assessment_model.setActivities_by_twoo("Subcontracted");

                if (chkYesPMCMMF.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintenance_twoo("Yes");
                else if (chkNOSPMCMMF.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintenance_twoo("No");

                if (chkYESKBMF.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_manifold_twoo("Yes");
                else if (chkNOLBMF.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_manifold_twoo("No");

                if (chkMANMF.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_twoo("Daily");
                else if (chkAUTOMF.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_twoo("Weekly");
                else if (chkAUTOMF.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_twoo("Fortnightly");
                else if (chkAUTOMF.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_twoo("Monthly");
                else if (chkAUTOMF.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_twoo("On request");

                if (chkYESSUC.isChecked())
                    Variaveis.assessment_model.setShortages_last_twoo_year_twoo("Yes");
                else if (chkNOSC.isChecked())
                    Variaveis.assessment_model.setShortages_last_twoo_year_twoo("No");

                if (TextUtils.isEmpty(capacity_manifold) || TextUtils.isEmpty(diameter_system) || TextUtils.isEmpty(how_many_cylinder_conect_rs) ||
                        TextUtils.isEmpty(how_many_cylinder_conect_ls) || TextUtils.isEmpty(how_many_cylinder_conect_total) || TextUtils.isEmpty(average_per_month) ||
                        TextUtils.isEmpty(frequency_pm_mani) || TextUtils.isEmpty(name_maintenance_maniFold) || TextUtils.isEmpty(average_cost_per_year_maniFold) || TextUtils.isEmpty(bugdet_maitenance_program) ||
                        TextUtils.isEmpty(name_cylinder_supply)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setManifold_in_health_twoo(manifold_in_health);
                    Assessment.assessment_model.setType_supply_used_manifold_twoo(type_supply_used_manifold);
                    Assessment.assessment_model.setAreas_does_supply_twoo(areas_does_supply);
                    Assessment.assessment_model.setAreas_does_supply_other_twoo(areas_does_supply_other);
                    Assessment.assessment_model.setAreas_does_supply_otherTwoo_twoo(areas_does_supply_otherTwoo);
                    Assessment.assessment_model.setOld_system_manifold_twoo(old_system_manifold);
                    Assessment.assessment_model.setKind_manifold_twoo(kind_manifold);
                    Assessment.assessment_model.setCapacity_manifold_twoo(txtcapacity_manifold.getText().toString());
                    Assessment.assessment_model.setDiameter_system_twoo(txtdiameter_system.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_rs_twoo(txthow_many_cylinder_conect_rs.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_ls_twoo(txthow_many_cylinder_conect_ls.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_total_twoo(txthow_many_cylinder_conect_total.getText().toString());
                    Assessment.assessment_model.setAverage_per_month_twoo(txtaverage_per_month.getText().toString());
                    Assessment.assessment_model.setMost_common_model_cylinder_twoo(most_common_model_cylinder);
                    Assessment.assessment_model.setMost_common_model_cylinder_other_twoo(txtmost_common_model_cylinder_other.getText().toString());
                    Assessment.assessment_model.setType_conection_cylinder_twoo(type_conection_cylinder_maniFold);
                    Assessment.assessment_model.setManifold_working_twoo(manifold_working);
                    Assessment.assessment_model.setCondition_system_twoo(condition_system);
                    Assessment.assessment_model.setActive_pm_program_manif_twoo(active_pm_program_manif);
                    Assessment.assessment_model.setFrequency_pm_mani_twoo(txtfrequency_pm_mani.getText().toString());
                    Assessment.assessment_model.setActivities_by_twoo(activities_by);
                    Assessment.assessment_model.setName_maintenance_maniFold_twoo(txtname_maintenance_maniFold.getText().toString());
                    Assessment.assessment_model.setAverage_cost_per_year_twoo(txtaverage_cost_per_year_maniFold.getText().toString());
                    Assessment.assessment_model.setBugdet_maitenance_program_twoo(txtbugdet_maitenance_program.getText().toString());
                    Assessment.assessment_model.setLogbbook_maintenance_twoo(logbbook_maintenance);
                    Assessment.assessment_model.setLogbbook_update_manifold_twoo(logbbook_update_manifold);
                    Assessment.assessment_model.setName_cylinder_supply_twoo(txtname_cylinder_supply.getText().toString());
                    Assessment.assessment_model.setHow_does_receive_cylinder_twoo(how_does_receive_cylinder);
                    Assessment.assessment_model.setShortages_last_twoo_year_twoo(shortages_last_twoo_year);
                    Assessment.assessment_model.setComments_manifold_twoo(comments_manifold);

                    Intent i = new Intent(Update_manifold_too.this, Update_manifold_emergency.class);
                    // Intent i = new Intent(FormManiFold.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMF = new Intent(Update_manifold_too.this, Update_concentrator.class);
                startActivity(backMF);
            }
        });


    }
    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtcapacity_manifold")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
//            txtareas_does_supply_other.setText(Variaveis.assessment_model.getAreas_does_supply_other_twoo());
//            txtareas_does_supply_otherTwoo.setText(Variaveis.assessment_model.getAreas_does_supply_otherTwoo_twoo());
//            txtcapacity_manifold.setText(Variaveis.assessment_model.getCapacity_manifold_twoo());
//            txtdiameter_system.setText(Variaveis.assessment_model.getDiameter_system_twoo());
//            txthow_many_cylinder_conect_rs.setText(Variaveis.assessment_model.getHow_many_cylinder_conect_rs_twoo());
//            txthow_many_cylinder_conect_ls.setText(Variaveis.assessment_model.getHow_many_cylinder_conect_ls_twoo());
//            txthow_many_cylinder_conect_total.setText(Variaveis.assessment_model.getHow_many_cylinder_conect_total_twoo());
//            txtaverage_per_month.setText(Variaveis.assessment_model.getAverage_per_month_twoo());
//            txtmost_common_model_cylinder_other.setText(Variaveis.assessment_model.getMost_common_model_cylinder_other_twoo());
//            txtfrequency_pm_mani.setText(Variaveis.assessment_model.getFrequency_pm_mani_twoo());
//            txtname_maintenance_maniFold.setText(Variaveis.assessment_model.getName_maintenance_maniFold_twoo());
//            txtaverage_cost_per_year_maniFold.setText(Variaveis.assessment_model.getAverage_cost_per_year_twoo());
//            txtbugdet_maitenance_program.setText(Variaveis.assessment_model.getBugdet_maitenance_program_twoo());
//            txtname_cylinder_supply.setText(Variaveis.assessment_model.getName_cylinder_supply_twoo());
//            txtcomments_manifold.setText(Variaveis.assessment_model.getComments_manifold_twoo());
        }
    }


    public void setRB_manifold_in_health() {
        idChkYesMF = findViewById(R.id.idChkYesMF);
        idChkNoMF = findViewById(R.id.idChkNoMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_in_health())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_in_health().equalsIgnoreCase("Yes")) {
                idChkYesMF.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_in_health().equalsIgnoreCase("No")) {
                idChkNoMF.setChecked(true);
            }
        }
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

    public void setRB_manifold_areas_supp() {
        chkPrimaMF = findViewById(R.id.chkPrimaMF);
        chkSecondMF = findViewById(R.id.chkSecondMF);
        chkEmergMF = findViewById(R.id.chkEmergMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getType_supply_used_manifold_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getType_supply_used_manifold_twoo().equalsIgnoreCase("Primary")) {
                chkPrimaMF.setChecked(true);
            } else if (Variaveis.assessment_model.getType_supply_used_manifold_twoo().equalsIgnoreCase("Secondary")) {
                chkSecondMF.setChecked(true);
            } else if (Variaveis.assessment_model.getType_supply_used_manifold_twoo().equalsIgnoreCase("Emergency")) {
                chkEmergMF.setChecked(true);
            }
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

    public void setRB_manifold_old_system() {
        chkNAMF = findViewById(R.id.chkNAMF);
        chkCAMF = findViewById(R.id.chkCAMF);
        chkPTMF = findViewById(R.id.chkPTMF);
        chkMaternMF = findViewById(R.id.chkMaternMF);
        chkICUMF = findViewById(R.id.chkICUMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getAreas_does_supply_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getAreas_does_supply_twoo().equalsIgnoreCase("Nursery ward")) {
                chkNAMF.setChecked(true);
            } else if (Variaveis.assessment_model.getAreas_does_supply_twoo().equalsIgnoreCase("Casualty ward")) {
                chkCAMF.setChecked(true);
            } else if (Variaveis.assessment_model.getAreas_does_supply_twoo().equalsIgnoreCase("Operating Theatre")) {
                chkPTMF.setChecked(true);
            } else if (Variaveis.assessment_model.getAreas_does_supply_twoo().equalsIgnoreCase("Maternity")) {
                chkMaternMF.setChecked(true);
            } else if (Variaveis.assessment_model.getAreas_does_supply_twoo().equalsIgnoreCase("Intensive Care (ICU)")) {
                chkICUMF.setChecked(true);
            }
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

    public void setRBMain_old_solar() {
        chkLess = findViewById(R.id.chkLess);
        chkB3_10 = findViewById(R.id.chkB3_10);
        idChkB11_20 = findViewById(R.id.idChkB11_20);
        idChkMore20 = findViewById(R.id.idChkMore20);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getOld_system_manifold_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getOld_system_manifold_twoo().equalsIgnoreCase("Less than 3 years")) {
                chkLess.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold_twoo().equalsIgnoreCase("Between 3-10 years")) {
                chkB3_10.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold_twoo().equalsIgnoreCase("Between 11-20 years")) {
                idChkB11_20.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold_twoo().equalsIgnoreCase("More than 20 years")) {
                idChkMore20.setChecked(true);
            }
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

    public void setRB_manifold_auto_manu() {
        chkMANMF = findViewById(R.id.chkMANMF);
        chkAUTOMF = findViewById(R.id.chkAUTOMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getKind_manifold_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getKind_manifold_twoo().equalsIgnoreCase("Manual")) {
                chkMANMF.setChecked(true);
            } else if (Variaveis.assessment_model.getKind_manifold_twoo().equalsIgnoreCase("Automatic")) {
                chkAUTOMF.setChecked(true);
            }
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

    public void setRB_manifold_common() {
        chkEMF = findViewById(R.id.chkEMF);
        chkFMF = findViewById(R.id.chkFMF);
        chkGMF = findViewById(R.id.chkGMF);
        chkJMF = findViewById(R.id.chkJMF);
        chkDontNoMF = findViewById(R.id.chkDontNoMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getMost_common_model_cylinder_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getMost_common_model_cylinder_twoo().equalsIgnoreCase("E (1m3/680L)")) {
                chkEMF.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_twoo().equalsIgnoreCase("F (1.5/1360L)")) {
                chkFMF.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_twoo().equalsIgnoreCase("G (3.5m3/3400L)")) {
                chkGMF.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_twoo().equalsIgnoreCase("J (7.5m3/7800L)")) {
                chkJMF.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_twoo().equalsIgnoreCase("Don't know")) {
                chkDontNoMF.setChecked(true);
            }
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

    public void setRB_manifold_type_conn() {
        chkPINMF = findViewById(R.id.chkPINMF);
        chkPINSMF = findViewById(R.id.chkPINSMF);
        chkBullnoseMF = findViewById(R.id.chkBullnoseMF);
        chkHandwheelMF = findViewById(R.id.chkHandwheelMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getType_conection_cylinder_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getType_conection_cylinder_twoo().equalsIgnoreCase("Pin index")) {
                chkPINMF.setChecked(true);
            } else if (Variaveis.assessment_model.getType_conection_cylinder_twoo().equalsIgnoreCase("Pin-index side spindle valve")) {
                chkPINSMF.setChecked(true);
            } else if (Variaveis.assessment_model.getType_conection_cylinder_twoo().equalsIgnoreCase("Bullnose valve")) {
                chkBullnoseMF.setChecked(true);
            } else if (Variaveis.assessment_model.getType_conection_cylinder_twoo().equalsIgnoreCase("Handwheel side outlet")) {
                chkHandwheelMF.setChecked(true);
            }
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

    public void setRBMain_mani_work_solar() {
        chkYMF = findViewById(R.id.chkYMF);
        chkNMF = findViewById(R.id.chkNMF);
        chkPartlyMF = findViewById(R.id.chkPartlyMF);
        chkDontNMF = findViewById(R.id.chkDontNMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_working_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_working_twoo().equalsIgnoreCase("Yes")) {
                chkYMF.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working_twoo().equalsIgnoreCase("No")) {
                chkNMF.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working_twoo().equalsIgnoreCase("Partly")) {
                chkPartlyMF.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working_twoo().equalsIgnoreCase("Don't know")) {
                chkDontNMF.setChecked(true);
            }
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

    public void setRBDuraPOut_solar() {
        chkGIUMF = findViewById(R.id.chkGIUMF);
        chkGBNUMF = findViewById(R.id.chkGBNUMF);
        chkIU_BNRMF = findViewById(R.id.chkIU_BNRMF);
        chkIUNNTRMF = findViewById(R.id.chkIUNNTRMF);
        chkOOSBRMF = findViewById(R.id.chkOOSBRMF);
        chkOOSAndNRMF = findViewById(R.id.chkOOSAndNRMF);
        chkStilInstPhaMF = findViewById(R.id.chkStilInstPhaMF);
        chkDontKnowMF = findViewById(R.id.chkDontKnowMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCondition_system_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("Good and in use")) {
                chkGIUMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("Good, but not in use")) {
                chkGBNUMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("In use, but needs repair")) {
                chkIU_BNRMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("In use, but needs to be replaced")) {
                chkIUNNTRMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("Out of service, but repairable")) {
                chkOOSAndNRMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("Out of service and needs to be replaced")) {
                chkOOSAndNRMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("Still in the installation phase")) {
                chkStilInstPhaMF.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_twoo().equalsIgnoreCase("Don't know")) {
                chkDontKnowMF.setChecked(true);
            }
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

    public void setRB_manifold_pm_active_program() {
        chkYESPMMF = findViewById(R.id.chkYESPMMF);
        chkNOPMMF = findViewById(R.id.chkNOPMMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActive_pm_program_manif_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActive_pm_program_manif_twoo().equalsIgnoreCase("Yes")) {
                chkYESPMMF.setChecked(true);
            } else if (Variaveis.assessment_model.getActive_pm_program_manif_twoo().equalsIgnoreCase("No")) {
                chkNOPMMF.setChecked(true);
            }
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

    public void setRBMain_mani_carries_by() {
        chkPHFMF = findViewById(R.id.chkPHFMF);
        chkPDIMF = findViewById(R.id.chkPDIMF);
        chkSubCMF = findViewById(R.id.chkSubCMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActivities_by_twoo())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActivities_by_twoo().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                chkPHFMF.setChecked(true);
            } else if (Variaveis.assessment_model.getActivities_by_twoo().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                chkPDIMF.setChecked(true);
            } else if (Variaveis.assessment_model.getActivities_by_twoo().equalsIgnoreCase("Subcontracted")) {
                chkSubCMF.setChecked(true);
            }
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

    public void setRB_manifold_pm_cm() {
        chkYesPMCMMF = findViewById(R.id.chkYesPMCMMF);
        chkNOSPMCMMF = findViewById(R.id.chkNOSPMCMMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_maintenance_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_maintenance_twoo().equalsIgnoreCase("Yes")) {
                chkYesPMCMMF.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_maintenance_twoo().equalsIgnoreCase("No")) {
                chkNOSPMCMMF.setChecked(true);
            }
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

    public void setRB_manifold_logbook_upd() {
        chkYESKBMF = findViewById(R.id.chkYESKBMF);
        chkNOLBMF = findViewById(R.id.chkNOLBMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_update_manifold_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_update_manifold_twoo().equalsIgnoreCase("Yes")) {
                chkYESKBMF.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_update_manifold_twoo().equalsIgnoreCase("No")) {
                chkNOLBMF.setChecked(true);
            }
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

    public void setRB_manifold_health_receive() {
        chkDailyMF = findViewById(R.id.chkDailyMF);
        chkWeeklyMF = findViewById(R.id.chkWeeklyMF);
        chkFortnightlyMF = findViewById(R.id.chkFortnightlyMF);
        chkMonthlyMF = findViewById(R.id.chkMonthlyMF);
        chkOnrequestMF = findViewById(R.id.chkOnrequestMF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getHow_does_receive_cylinder_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getHow_does_receive_cylinder_twoo().equalsIgnoreCase("Daily")) {
                chkDailyMF.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_twoo().equalsIgnoreCase("Weekly")) {
                chkWeeklyMF.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_twoo().equalsIgnoreCase("Fortnightly")) {
                chkFortnightlyMF.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_twoo().equalsIgnoreCase("Monthly")) {
                chkMonthlyMF.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_twoo().equalsIgnoreCase("On request")) {
                chkOnrequestMF.setChecked(true);
            }
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

    public void setRB_manifold_shortages() {
        chkYESSUC = findViewById(R.id.chkYESSUC);
        chkNOSC = findViewById(R.id.chkNOSC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getShortages_last_twoo_year_twoo())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getShortages_last_twoo_year_twoo().equalsIgnoreCase("Yes")) {
                chkYESSUC.setChecked(true);
            } else if (Variaveis.assessment_model.getShortages_last_twoo_year_twoo().equalsIgnoreCase("No")) {
                chkNOSC.setChecked(true);
            }
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
        btnNext = findViewById(R.id.btn_next_upd_mf_too);

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