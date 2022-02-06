package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormLiquidOx;
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

public class Update_manifold_emergency extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private TextView txtcapacity_manifold_emerg, txtdiameter_system_emerg;
    private TextView txthow_many_cylinder_conect_total_emerg, txtaverage_per_month_emerg, txtmost_common_model_cylinder_other_emerg, txtfrequency_pm_mani_emerg;
    private TextView txtname_maintenance_maniFold_emerg, txtaverage_cost_per_year_maniFold_emerg, txtbugdet_maitenance_program_emerg, txtname_cylinder_supply_emerg, txtcomments_manifold_emerg;
    private RadioButton idChkYesME, idChkNoME;
    private RadioButton idChkB11_20ME, idChkMore20ME, chkPrimaME, chkSecondME, chkEmergME;
    private RadioButton chkLessME, chkB3_10ME, chkMANME, chkAUTOME, chkEME, chkFME;
    private RadioButton chkGME, chkJME, chkDontNoME, chkPINME, chkBullnoseME, chkHandwheelME, chkYME;
    private RadioButton chkPINSMF, chkNME, chkPartlyME, chkDontNME, chkGIUME, chkGBNUME;
    private RadioButton chkIU_BNRME, chkIUNNTRME, chkOOSBRME, chkOOSAndNRME, chkStilInstPhaME, chkDontKnowME, chkYESPMME;
    private RadioButton chkNOPMME, chkPHFME, chkPDIME, chkSubCME, chkYesPMCMME, chkNOSPMCMME, chkYESKBME;
    private RadioButton chkNOLBME, chkDailyME, chkWeeklyME, chkFortnightlyME, chkMonthlyME, chkOnrequestME;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_facility_ox_emerg, cbo_manifold_used_emerg, cbo_follow_areas_emerg, cbo_old_sys_emerg, cbo_mani_aut_manu_emerg, cbo_record_upd;
    private String cbo_most_common_emerg, cbo_connection_cylinder_emerg, cbo_logbook_upd_emerg, cboMain_gen_cond_emerg, cbo_carrie_by_emerg, cbo_pm_cm_emerg;
    private String cbo_health_fac_receive_emerg, cbo_po_sys_working_emerg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_manifold_emergency);

        InitComponents();
        getAndSetIntentData();

        setRB_manifold_in_health();
        setRB_manifold_areas_supp();
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

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manifold_in_health_emerg = cbo_facility_ox_emerg;
                String type_supply_used_manifold_emerg = cbo_manifold_used_emerg;
                String old_system_manifold_emerg = cbo_old_sys_emerg;
                String kind_manifold_emerg = cbo_mani_aut_manu_emerg;
                String capacity_manifold_emerg = txtcapacity_manifold_emerg.getText().toString();
                String diameter_system_emerg = txtdiameter_system_emerg.getText().toString();
                String how_many_cylinder_conect_total_emerg = txthow_many_cylinder_conect_total_emerg.getText().toString();
                String average_per_month_emerg = txtaverage_per_month_emerg.getText().toString();
                String most_common_model_cylinder_emerg = cbo_most_common_emerg;
                String most_common_model_cylinder_other_emerg = txtmost_common_model_cylinder_other_emerg.getText().toString();
                String type_conection_cylinder_maniFold_emerg = cbo_connection_cylinder_emerg;
                String manifold_working_emerg = cbo_po_sys_working_emerg;
                String condition_system_emerg = cboMain_gen_cond_emerg;
                String active_pm_program_manif_emerg = cbo_logbook_upd_emerg;
                String frequency_pm_mani_emerg = txtfrequency_pm_mani_emerg.getText().toString();
                String activities_by_emerg = cbo_carrie_by_emerg;
                String name_maintenance_maniFold_emerg = txtname_maintenance_maniFold_emerg.getText().toString();
                String average_cost_per_year_maniFold_emerg = txtaverage_cost_per_year_maniFold_emerg.getText().toString();
                String bugdet_maitenance_program_emerg = txtbugdet_maitenance_program_emerg.getText().toString();
                String logbbook_maintenance_emerg = cbo_pm_cm_emerg;
                String logbbook_update_manifold_emerg = cbo_logbook_upd_emerg;
                String name_cylinder_supply_emerg = txtname_cylinder_supply_emerg.getText().toString();
                String how_does_receive_cylinder_emerg = cbo_health_fac_receive_emerg;
                String comments_manifold_emerg = txtcomments_manifold_emerg.getText().toString();

                if (idChkYesME.isChecked())
                    Variaveis.assessment_model.setManifold_in_health_emerg("Yes");
                else if (idChkNoME.isChecked())
                    Variaveis.assessment_model.setManifold_in_health_emerg("No");

                if (chkPrimaME.isChecked())
                    Variaveis.assessment_model.setType_supply_used_manifold_emerg("Primary");
                else if (chkSecondME.isChecked())
                    Variaveis.assessment_model.setType_supply_used_manifold_emerg("Secondary");
                else if (chkEmergME.isChecked())
                    Variaveis.assessment_model.setType_supply_used_manifold_emerg("Emergency");

                if (chkLessME.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_emerg("Less than 3 years");
                else if (chkB3_10ME.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_emerg("Between 3-10 years");
                else if (idChkB11_20ME.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_emerg("Between 11-20 years");
                else if (idChkMore20ME.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold_emerg("More than 20 years");

                if (chkMANME.isChecked())
                    Variaveis.assessment_model.setKind_manifold_emerg("Manual");
                else if (chkAUTOME.isChecked())
                    Variaveis.assessment_model.setKind_manifold_emerg("Automatic");

                if (chkEME.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_emerg("E (1m3/680L)");
                else if (chkFME.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_emerg("F (1.5/1360L)");
                else if (chkGME.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_emerg("G (3.5m3/3400L)");
                else if (chkJME.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_emerg("J (7.5m3/7800L)");
                else if (chkDontNoME.isChecked())
                    Variaveis.assessment_model.setMost_common_model_cylinder_emerg("Don't know");

                if (chkPINME.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_mani_emerg("Pin index");
                else if (chkPINSMF.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_mani_emerg("Pin-index side spindle valve");
                else if (chkBullnoseME.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_mani_emerg("Bullnose valve");
                else if (chkHandwheelME.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder_mani_emerg("Handwheel side outlet");

                if (chkYME.isChecked())
                    Variaveis.assessment_model.setManifold_working_emerg("Yes");
                else if (chkNME.isChecked())
                    Variaveis.assessment_model.setManifold_working_emerg("No");
                else if (chkPartlyME.isChecked())
                    Variaveis.assessment_model.setManifold_working_emerg("Partly");
                else if (chkDontNME.isChecked())
                    Variaveis.assessment_model.setManifold_working_emerg("Don't know");

                if (chkGIUME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("Good and in use");
                else if (chkGBNUME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("Good, but not in use");
                else if (chkIU_BNRME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("In use, but needs repair");
                else if (chkIUNNTRME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("In use, but needs to be replaced");
                else if (chkOOSBRME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("Out of service, but repairable");
                else if (chkOOSAndNRME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("Out of service and needs to be replaced");
                else if (chkStilInstPhaME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("Still in the installation phase");
                else if (chkDontKnowME.isChecked())
                    Variaveis.assessment_model.setCondition_system_emerg("Don't know");

                if (chkYESPMME.isChecked())
                    Variaveis.assessment_model.setActive_pm_program_manif_emerg("Yes");
                else if (chkNOPMME.isChecked())
                    Variaveis.assessment_model.setActive_pm_program_manif_emerg("No");

                if (chkPHFME.isChecked())
                    Variaveis.assessment_model.setActivities_by_emerg("Internal Technical Personnel of the health facility");
                else if (chkPDIME.isChecked())
                    Variaveis.assessment_model.setActivities_by_emerg("Personnel of the Department of Infrastructure");
                else if (chkSubCME.isChecked())
                    Variaveis.assessment_model.setActivities_by_emerg("Subcontracted");

                if (chkYesPMCMME.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintena_emerg("Yes");
                else if (chkNOSPMCMME.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintena_emerg("No");

                if (chkYESKBME.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_manifold_emerg("Yes");
                else if (chkNOLBME.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_manifold_emerg("No");

                if (chkMANME.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_emerg("Daily");
                else if (chkAUTOME.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_emerg("Weekly");
                else if (chkAUTOME.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_emerg("Fortnightly");
                else if (chkAUTOME.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_emerg("Monthly");
                else if (chkAUTOME.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder_emerg("On request");

                if (TextUtils.isEmpty(capacity_manifold_emerg) || TextUtils.isEmpty(diameter_system_emerg) || TextUtils.isEmpty(how_many_cylinder_conect_total_emerg)
                        || TextUtils.isEmpty(average_per_month_emerg) || TextUtils.isEmpty(frequency_pm_mani_emerg) || TextUtils.isEmpty(name_maintenance_maniFold_emerg) ||
                        TextUtils.isEmpty(average_cost_per_year_maniFold_emerg) || TextUtils.isEmpty(bugdet_maitenance_program_emerg) ||
                        TextUtils.isEmpty(name_cylinder_supply_emerg)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {

                    Assessment.assessment_model.setManifold_in_health_emerg(manifold_in_health_emerg);
                    Assessment.assessment_model.setType_supply_used_manifold_emerg(type_supply_used_manifold_emerg);
                    Assessment.assessment_model.setOld_system_manifold_emerg(old_system_manifold_emerg);
                    Assessment.assessment_model.setKind_manifold_emerg(kind_manifold_emerg);
                    Assessment.assessment_model.setCapacity_manifold_emerg(txtcapacity_manifold_emerg.getText().toString());
                    Assessment.assessment_model.setDiameter_system_emerg(txtdiameter_system_emerg.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_total_emerg(txthow_many_cylinder_conect_total_emerg.getText().toString());
                    Assessment.assessment_model.setAverage_per_month_emerg(txtaverage_per_month_emerg.getText().toString());
                    Assessment.assessment_model.setMost_common_model_cylinder_emerg(most_common_model_cylinder_emerg);
                    Assessment.assessment_model.setMost_common_model_cylinder_other_emerg(txtmost_common_model_cylinder_other_emerg.getText().toString());
                    Assessment.assessment_model.setType_conection_cylinder_mani_emerg(type_conection_cylinder_maniFold_emerg);
                    Assessment.assessment_model.setManifold_working_emerg(manifold_working_emerg);
                    Assessment.assessment_model.setCondition_system_emerg(condition_system_emerg);
                    Assessment.assessment_model.setActive_pm_program_manif_emerg(active_pm_program_manif_emerg);
                    Assessment.assessment_model.setFrequency_pm_mani_emerg(txtfrequency_pm_mani_emerg.getText().toString());
                    Assessment.assessment_model.setActivities_by_emerg(activities_by_emerg);
                    Assessment.assessment_model.setName_maintenance_maniFold_emerg(txtname_maintenance_maniFold_emerg.getText().toString());
                    Assessment.assessment_model.setAverage_cost_per_year_emerg(txtaverage_cost_per_year_maniFold_emerg.getText().toString());
                    Assessment.assessment_model.setBugdet_maitenance_program_emerg(txtbugdet_maitenance_program_emerg.getText().toString());
                    Assessment.assessment_model.setLogbbook_maintena_emerg(logbbook_maintenance_emerg);
                    Assessment.assessment_model.setLogbbook_update_manifold_emerg(logbbook_update_manifold_emerg);
                    Assessment.assessment_model.setName_cylinder_supply_emerg(txtname_cylinder_supply_emerg.getText().toString());
                    Assessment.assessment_model.setHow_does_receive_cylinder_emerg(how_does_receive_cylinder_emerg);
                    Assessment.assessment_model.setComments_manifold_emerg(txtcomments_manifold_emerg.getText().toString());

                    Intent i = new Intent(Update_manifold_emergency.this, FormLiquidOx.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMFT = new Intent(Update_manifold_emergency.this, Update_manifold_too.class);
                startActivity(backMFT);
            }
        });
    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtcapacity_manifold")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtcapacity_manifold_emerg.setText(Variaveis.assessment_model.getCapacity_manifold_emerg());
            txtdiameter_system_emerg.setText(Variaveis.assessment_model.getDiameter_system_emerg());
            txthow_many_cylinder_conect_total_emerg.setText(Variaveis.assessment_model.getHow_many_cylinder_conect_total_emerg());
            txtaverage_per_month_emerg.setText(Variaveis.assessment_model.getAverage_per_month_emerg());
            txtmost_common_model_cylinder_other_emerg.setText(Variaveis.assessment_model.getMost_common_model_cylinder_other_emerg());
            txtfrequency_pm_mani_emerg.setText(Variaveis.assessment_model.getFrequency_pm_mani_emerg());
            txtname_maintenance_maniFold_emerg.setText(Variaveis.assessment_model.getName_maintenance_maniFold_emerg());
            txtaverage_cost_per_year_maniFold_emerg.setText(Variaveis.assessment_model.getAverage_cost_per_year_emerg());
            txtbugdet_maitenance_program_emerg.setText(Variaveis.assessment_model.getBugdet_maitenance_program_emerg());
            txtname_cylinder_supply_emerg.setText(Variaveis.assessment_model.getName_cylinder_supply_emerg());
            txtcomments_manifold_emerg.setText(Variaveis.assessment_model.getComments_manifold_emerg());
        }
    }


    public void setRB_manifold_in_health() {
        idChkYesME = findViewById(R.id.idChkYesME);
        idChkNoME = findViewById(R.id.idChkNoME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_in_health_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_in_health_emerg().equalsIgnoreCase("Yes")) {
                idChkYesME.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_in_health_emerg().equalsIgnoreCase("No")) {
                idChkNoME.setChecked(true);
            }
        }
    }


    public void onRadioButtonClicked_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesME:
                if (checked)
                    cbo_facility_ox_emerg = "Yes";
                break;
            case R.id.idChkNoME:
                if (checked)
                    cbo_facility_ox_emerg = "No";
                break;
        }
    }

    public void setRB_manifold_areas_supp() {
        chkPrimaME = findViewById(R.id.chkPrimaME);
        chkSecondME = findViewById(R.id.chkSecondME);
        chkEmergME = findViewById(R.id.chkEmergME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getType_supply_used_manifold_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getType_supply_used_manifold_emerg().equalsIgnoreCase("Primary")) {
                chkPrimaME.setChecked(true);
            } else if (Variaveis.assessment_model.getType_supply_used_manifold_emerg().equalsIgnoreCase("Secondary")) {
                chkSecondME.setChecked(true);
            } else if (Variaveis.assessment_model.getType_supply_used_manifold_emerg().equalsIgnoreCase("Emergency")) {
                chkEmergME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked1_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPrimaME:
                if (checked)
                    cbo_manifold_used_emerg = "Primary";
                break;
            case R.id.chkSecondME:
                if (checked)
                    cbo_manifold_used_emerg = "Secondary";
                break;
            case R.id.chkEmergME:
                if (checked)
                    cbo_manifold_used_emerg = "Emergency";
                break;
        }
    }

    public void setRBMain_old_solar() {
        chkLessME = findViewById(R.id.chkLessME);
        chkB3_10ME = findViewById(R.id.chkB3_10ME);
        idChkB11_20ME = findViewById(R.id.idChkB11_20ME);
        idChkMore20ME = findViewById(R.id.idChkMore20ME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getOld_system_manifold_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getOld_system_manifold_emerg().equalsIgnoreCase("Less than 3 years")) {
                chkLessME.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold_emerg().equalsIgnoreCase("Between 3-10 years")) {
                chkB3_10ME.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold_emerg().equalsIgnoreCase("Between 11-20 years")) {
                idChkB11_20ME.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold_emerg().equalsIgnoreCase("More than 20 years")) {
                idChkMore20ME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked2_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLessME:
                if (checked)
                    cbo_old_sys_emerg = "Less than 3 years";
                break;
            case R.id.chkB3_10ME:
                if (checked)
                    cbo_old_sys_emerg = "Between 3-10 years";
                break;
            case R.id.idChkB11_20ME:
                if (checked)
                    cbo_old_sys_emerg = "Between 11-20 years";
                break;
            case R.id.idChkMore20ME:
                if (checked)
                    cbo_old_sys_emerg = "More than 20 years";
                break;
        }
    }

    public void setRB_manifold_auto_manu() {
        chkMANME = findViewById(R.id.chkMANME);
        chkAUTOME = findViewById(R.id.chkAUTOME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getKind_manifold_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getKind_manifold_emerg().equalsIgnoreCase("Manual")) {
                chkMANME.setChecked(true);
            } else if (Variaveis.assessment_model.getKind_manifold_emerg().equalsIgnoreCase("Automatic")) {
                chkAUTOME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked3_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkMANME:
                if (checked)
                    cbo_mani_aut_manu_emerg = "Manual";
                break;
            case R.id.chkAUTOME:
                if (checked)
                    cbo_mani_aut_manu_emerg = "Automatic";
                break;
        }
    }

    public void setRB_manifold_common() {
        chkEME = findViewById(R.id.chkEME);
        chkFME = findViewById(R.id.chkFME);
        chkGME = findViewById(R.id.chkGME);
        chkJME = findViewById(R.id.chkJME);
        chkDontNoME = findViewById(R.id.chkDontNoME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getMost_common_model_cylinder_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getMost_common_model_cylinder_emerg().equalsIgnoreCase("E (1m3/680L)")) {
                chkEME.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_emerg().equalsIgnoreCase("F (1.5/1360L)")) {
                chkFME.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_emerg().equalsIgnoreCase("G (3.5m3/3400L)")) {
                chkGME.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_emerg().equalsIgnoreCase("J (7.5m3/7800L)")) {
                chkJME.setChecked(true);
            } else if (Variaveis.assessment_model.getMost_common_model_cylinder_emerg().equalsIgnoreCase("Don't know")) {
                chkDontNoME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked4_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEME:
                if (checked)
                    cbo_most_common_emerg = "E (1m3/680L)";
                break;
            case R.id.chkFME:
                if (checked)
                    cbo_most_common_emerg = "F (1.5/1360L)";
                break;
            case R.id.chkGME:
                if (checked)
                    cbo_most_common_emerg = "G (3.5m3/3400L)\"";
                break;
            case R.id.chkJME:
                if (checked)
                    cbo_most_common_emerg = "J (7.5m3/7800L)";
                break;
            case R.id.chkDontNoME:
                if (checked)
                    cbo_most_common_emerg = "Don't know";
                break;
        }
    }

    public void setRB_manifold_type_conn() {
        chkPINME = findViewById(R.id.chkPINME);
        chkPINSMF = findViewById(R.id.chkPINSMF);
        chkBullnoseME = findViewById(R.id.chkBullnoseME);
        chkHandwheelME = findViewById(R.id.chkHandwheelME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getType_conection_cylinder_mani_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getType_conection_cylinder_mani_emerg().equalsIgnoreCase("Pin index")) {
                chkPINME.setChecked(true);
            } else if (Variaveis.assessment_model.getType_conection_cylinder_mani_emerg().equalsIgnoreCase("Pin-index side spindle valve")) {
                chkPINSMF.setChecked(true);
            } else if (Variaveis.assessment_model.getType_conection_cylinder_mani_emerg().equalsIgnoreCase("Bullnose valve")) {
                chkBullnoseME.setChecked(true);
            } else if (Variaveis.assessment_model.getType_conection_cylinder_mani_emerg().equalsIgnoreCase("Handwheel side outlet")) {
                chkHandwheelME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked5_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPINME:
                if (checked)
                    cbo_connection_cylinder_emerg = "Pin index";
                break;
            case R.id.chkPINSMF:
                if (checked)
                    cbo_connection_cylinder_emerg = "Pin-index side spindle valve";
                break;
            case R.id.chkBullnoseME:
                if (checked)
                    cbo_connection_cylinder_emerg = "Bullnose valve";
                break;
            case R.id.chkHandwheelME:
                if (checked)
                    cbo_connection_cylinder_emerg = "Handwheel side outlet";
                break;
        }
    }

    public void setRBMain_mani_work_solar() {
        chkYME = findViewById(R.id.chkYME);
        chkNME = findViewById(R.id.chkNME);
        chkPartlyME = findViewById(R.id.chkPartlyME);
        chkDontNME = findViewById(R.id.chkDontNME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_working_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_working_emerg().equalsIgnoreCase("Yes")) {
                chkYME.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working_emerg().equalsIgnoreCase("No")) {
                chkNME.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working_emerg().equalsIgnoreCase("Partly")) {
                chkPartlyME.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working_emerg().equalsIgnoreCase("Don't know")) {
                chkDontNME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked6_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYME:
                if (checked)
                    cbo_po_sys_working_emerg = "Yes";
                break;
            case R.id.chkNME:
                if (checked)
                    cbo_po_sys_working_emerg = "No";
                break;
            case R.id.chkPartlyME:
                if (checked)
                    cbo_po_sys_working_emerg = "Partly";
                break;
            case R.id.chkDontNME:
                if (checked)
                    cbo_po_sys_working_emerg = "Don't know";
                break;
        }
    }

    public void setRBDuraPOut_solar() {
        chkGIUME = findViewById(R.id.chkGIUME);
        chkGBNUME = findViewById(R.id.chkGBNUME);
        chkIU_BNRME = findViewById(R.id.chkIU_BNRME);
        chkIUNNTRME = findViewById(R.id.chkIUNNTRME);
        chkOOSBRME = findViewById(R.id.chkOOSBRME);
        chkOOSAndNRME = findViewById(R.id.chkOOSAndNRME);
        chkStilInstPhaME = findViewById(R.id.chkStilInstPhaME);
        chkDontKnowME = findViewById(R.id.chkDontKnowME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCondition_system_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("Good and in use")) {
                chkGIUME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("Good, but not in use")) {
                chkGBNUME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("In use, but needs repair")) {
                chkIU_BNRME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("In use, but needs to be replaced")) {
                chkIUNNTRME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("Out of service, but repairable")) {
                chkOOSBRME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("Out of service and needs to be replaced")) {
                chkOOSAndNRME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("Still in the installation phase")) {
                chkStilInstPhaME.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system_emerg().equalsIgnoreCase("Don't know")) {
                chkDontKnowME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked7_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkGIUME:
                if (checked)
                    cboMain_gen_cond_emerg = "Good and in use";
                break;
            case R.id.chkGBNUME:
                if (checked)
                    cboMain_gen_cond_emerg = "Good, but not in use";
                break;
            case R.id.chkIU_BNRME:
                if (checked)
                    cboMain_gen_cond_emerg = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRME:
                if (checked)
                    cboMain_gen_cond_emerg = "In use, but needs to be replaced";
            case R.id.chkOOSBRME:
                if (checked)
                    cboMain_gen_cond_emerg = "Out of service, but repairable";
            case R.id.chkOOSAndNRME:
                if (checked)
                    cboMain_gen_cond_emerg = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaME:
                if (checked)
                    cboMain_gen_cond_emerg = "Still in the installation phase";
            case R.id.chkDontKnowME:
                if (checked)
                    cboMain_gen_cond_emerg = "Don't know";
                break;
        }
    }

    public void setRB_manifold_pm_active_program() {
        chkYESPMME = findViewById(R.id.chkYESPMME);
        chkNOPMME = findViewById(R.id.chkNOPMME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActive_pm_program_manif_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActive_pm_program_manif_emerg().equalsIgnoreCase("Yes")) {
                chkYESPMME.setChecked(true);
            } else if (Variaveis.assessment_model.getActive_pm_program_manif_emerg().equalsIgnoreCase("No")) {
                chkNOPMME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked8_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESPMME:
                if (checked)
                    cbo_logbook_upd_emerg = "Yes";
                break;
            case R.id.chkNOPMME:
                if (checked)
                    cbo_logbook_upd_emerg = "No";
                break;
        }
    }

    public void setRBMain_mani_carries_by() {
        chkPHFME = findViewById(R.id.chkPHFME);
        chkPDIME = findViewById(R.id.chkPDIME);
        chkSubCME = findViewById(R.id.chkSubCME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActivities_by_emerg())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActivities_by_emerg().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                chkPHFME.setChecked(true);
            } else if (Variaveis.assessment_model.getActivities_by_emerg().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                chkPDIME.setChecked(true);
            } else if (Variaveis.assessment_model.getActivities_by_emerg().equalsIgnoreCase("Subcontracted")) {
                chkSubCME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked9_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFME:
                if (checked)
                    cbo_carrie_by_emerg = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIME:
                if (checked)
                    cbo_carrie_by_emerg = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCME:
                if (checked)
                    cbo_carrie_by_emerg = "Subcontracted";
                break;
        }
    }

    public void setRB_manifold_pm_cm() {
        chkYesPMCMME = findViewById(R.id.chkYesPMCMME);
        chkNOSPMCMME = findViewById(R.id.chkNOSPMCMME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_maintena_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_maintena_emerg().equalsIgnoreCase("Yes")) {
                chkYesPMCMME.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_maintena_emerg().equalsIgnoreCase("No")) {
                chkNOSPMCMME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicke10_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMCMME:
                if (checked)
                    cbo_pm_cm_emerg = "Yes";
                break;
            case R.id.chkNOSPMCMME:
                if (checked)
                    cbo_pm_cm_emerg = "No";
                break;
        }
    }

    public void setRB_manifold_logbook_upd() {
        chkYESKBME = findViewById(R.id.chkYESKBME);
        chkNOLBME = findViewById(R.id.chkNOLBME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_update_manifold_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_update_manifold_emerg().equalsIgnoreCase("Yes")) {
                chkYESKBME.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_update_manifold_emerg().equalsIgnoreCase("No")) {
                chkNOLBME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicke11_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESKBME:
                if (checked)
                    cbo_record_upd = "Yes";
                break;
            case R.id.chkNOLBME:
                if (checked)
                    cbo_record_upd = "No";
                break;
        }
    }

    public void setRB_manifold_health_receive() {
        chkDailyME = findViewById(R.id.chkDailyME);
        chkWeeklyME = findViewById(R.id.chkWeeklyME);
        chkFortnightlyME = findViewById(R.id.chkFortnightlyME);
        chkMonthlyME = findViewById(R.id.chkMonthlyME);
        chkOnrequestME = findViewById(R.id.chkOnrequestME);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getHow_does_receive_cylinder_emerg())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getHow_does_receive_cylinder_emerg().equalsIgnoreCase("Daily")) {
                chkDailyME.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_emerg().equalsIgnoreCase("Weekly")) {
                chkWeeklyME.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_emerg().equalsIgnoreCase("Fortnightly")) {
                chkFortnightlyME.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_emerg().equalsIgnoreCase("Monthly")) {
                chkMonthlyME.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder_emerg().equalsIgnoreCase("On request")) {
                chkOnrequestME.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked12_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDailyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Daily";
                break;
            case R.id.chkWeeklyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Weekly";
                break;
            case R.id.chkFortnightlyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Fortnightly";
                break;
            case R.id.chkMonthlyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Monthly";
                break;
            case R.id.chkOnrequestME:
                if (checked)
                    cbo_health_fac_receive_emerg = "On request";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backME);
        btnNExt = findViewById(R.id.btn_next);

        txtcapacity_manifold_emerg = findViewById(R.id.txtLPMME);

        txtdiameter_system_emerg = findViewById(R.id.txtMMME);

        txthow_many_cylinder_conect_total_emerg = findViewById(R.id.txtCCMF);

        txtaverage_per_month_emerg = findViewById(R.id.txtAGVMonthME);

        txtmost_common_model_cylinder_other_emerg = findViewById(R.id.txtOtherME);

        txtfrequency_pm_mani_emerg = findViewById(R.id.txtFPMME);

        txtname_maintenance_maniFold_emerg = findViewById(R.id.txtNMCME);
        txtaverage_cost_per_year_maniFold_emerg = findViewById(R.id.txtAVGCostME);
        txtbugdet_maitenance_program_emerg = findViewById(R.id.txtBMPME);

        txtname_cylinder_supply_emerg = findViewById(R.id.txtCSME);
        txtcomments_manifold_emerg = findViewById(R.id.txtCommentsME);
    }

    public void LimparCampos() {
        txtcapacity_manifold_emerg.setText("");
        txtdiameter_system_emerg.setText("");
        txthow_many_cylinder_conect_total_emerg.setText("");
        txtaverage_per_month_emerg.setText("");
        txtmost_common_model_cylinder_other_emerg.setText("");
        txtfrequency_pm_mani_emerg.setText("");
        txtname_maintenance_maniFold_emerg.setText("");
        txtaverage_cost_per_year_maniFold_emerg.setText("");
        txtbugdet_maitenance_program_emerg.setText("");
        txtname_cylinder_supply_emerg.setText("");
        txtcomments_manifold_emerg.setText("");
    }

}