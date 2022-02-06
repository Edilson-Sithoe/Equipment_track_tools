package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormLiquidOx;
import projecto.jhpiego.equipment_track_tools.generalForm.FormLiquidOxTwoo;
import projecto.jhpiego.equipment_track_tools.generalForm.FormMFEmerg;
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

public class Update_liquid_ox extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private TextView txt_average_consuming_oxygen, txt_last_month_consuminh, txt_tank_owner_other;
    private TextView txt_capacity_lox_tank_m3, txt_capacity_lox_tank_ton, txt_frequency_ox_tank, txt_name_maintenance_company_ox_tank;
    private TextView txt_average_cost_ox_tank, txt_budget_lox_tank, txt_name_supply_ox_tank, txt_how_many_tecn_available, txt_comment_ox_tank;
    private RadioButton idChkMore20, chkYesLOX,chkNoMFLOX,chkMISAULOX,chkSupLOX,chkLessLOX,chkB3_10LOX,chkB11_20LOX;
    private RadioButton chkYLOX,chkNLOX,chkDontNLOX,chkPartlyLOX,chkGIULOX,chkGBNULOX,chkIU_BNRLOX,chkIUNNTRLOX,chkOOSBRLOX;
    private RadioButton chkOOSAndNRLOX,chkStilInstPhaLOX,chkDontKnowLOX,chkYESPMLOX,chkNOPMLOX,chkPHFLOX,chkPDILOX,chkSubLOX;
    private RadioButton chkYesPMCMLOX,chkNoPMCMLOX,chkYesLBLOX,chkNoLBLOX,chkDailyLOX,chkWeeklyLOX,chkFortnightlyLOX,chkMonthlyLOX;
    private RadioButton chkOnrequestLOX,chkYEShorLOX,chkNoShorLOX,chkYesSITLOX,chkNoSITLOX;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_liquid_oxygen, cbo_tank_owner, cbo_old_system_oxygen, cbo_system_working_ox_tank, cbo_condition_system_ox_tank;
    private String cbo_active_pm_program, cbo_activie_carrie_by_ox_tank, cbo_logbook_mainte_tank, cbo_logbook_update_ox_tank, cbo_health_receive_lox;
    private String cbo_shortages_lox, cbo_specialized_internal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_liquid_ox);

        InitComponents();
        getAndSetIntentData_liquid();
        setRB_liquid_condition();
        setRB_liquid_facility();
        setRB_liquid_logbook();
        setRB_liquid_logbook_update();
        setRB_liquid_owner();
        setRB_liquid_ox_tank();
        setRB_liquid_receive();
        setRB_liquid_shortages();
        setRB_manifold_liquid_pm_program();
        setRBMain_liquid_carries_by();
        setRBMain_liquid_old_sys();
        setRBMain_liquid_sys_working();


        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String liquid_oxygen = cbo_liquid_oxygen;
                String average_consuming_oxygen = txt_average_consuming_oxygen.getText().toString();
                String last_month_consuminh = txt_last_month_consuminh.getText().toString();
                String tank_owner = cbo_tank_owner;
                String tank_owner_other = txt_tank_owner_other.getText().toString();
                String old_system_oxygen = cbo_old_system_oxygen;
                String capacity_lox_tank_m3 = txt_capacity_lox_tank_m3.getText().toString();
                String capacity_lox_tank_ton = txt_capacity_lox_tank_ton.getText().toString();
                String system_working_ox_tank = cbo_system_working_ox_tank;
                String condition_system_ox_tank = cbo_condition_system_ox_tank;
                String active_pm_program = cbo_active_pm_program;
                String activie_carrie_by_ox_tank = cbo_activie_carrie_by_ox_tank;
                String frequency_ox_tank = txt_frequency_ox_tank.getText().toString();
                String name_maintenance_company_ox_tank = txt_name_maintenance_company_ox_tank.getText().toString();
                String average_cost_ox_tank = txt_average_cost_ox_tank.getText().toString();
                String budget_lox_tank = txt_budget_lox_tank.getText().toString();
                String logbook_mainte_tank = cbo_logbook_mainte_tank;
                String logbook_update_ox_tank = cbo_logbook_update_ox_tank;
                String name_supply_ox_tank = txt_name_supply_ox_tank.getText().toString();
                String health_receive_lox = cbo_health_receive_lox;
                String shortages_lox = cbo_shortages_lox;
                String specialized_internal = cbo_specialized_internal;
                String how_many_tecn_available = txt_how_many_tecn_available.getText().toString();
                String comment_ox_tank = txt_comment_ox_tank.getText().toString();

                if (chkYesLOX.isChecked())
                    Variaveis.assessment_model.setManifold_in_health("Yes");
                else if (chkNoMFLOX.isChecked())
                    Variaveis.assessment_model.setManifold_in_health("No");

                if (chkMISAULOX.isChecked())
                    Variaveis.assessment_model.setManifold_in_health("MISAU-Hospital");
                else if (chkSupLOX.isChecked())
                    Variaveis.assessment_model.setManifold_in_health("Supplier");

                if (chkLessLOX.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold("Less than 3 years");
                else if (chkB3_10LOX.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold("Between 3-10 years");
                else if (chkB11_20LOX.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold("Between 11-20 years");
                else if (idChkMore20.isChecked())
                    Variaveis.assessment_model.setOld_system_manifold("More than 20 years");

                if (chkYLOX.isChecked())
                    Variaveis.assessment_model.setManifold_working("Yes");
                else if (chkNLOX.isChecked())
                    Variaveis.assessment_model.setManifold_working("No");
                else if (chkPartlyLOX.isChecked())
                    Variaveis.assessment_model.setManifold_working("Partly");
                else if (chkDontNLOX.isChecked())
                    Variaveis.assessment_model.setManifold_working("Don't know");

                if (chkGIULOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("Good and in use");
                else if (chkGBNULOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("Good, but not in use");
                else if (chkIU_BNRLOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("In use, but needs repair");
                else if (chkIUNNTRLOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("In use, but needs to be replaced");
                else if (chkOOSBRLOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("Out of service, but repairable");
                else if (chkOOSAndNRLOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("Out of service and needs to be replaced");
                else if (chkStilInstPhaLOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("Still in the installation phase");
                else if (chkDontKnowLOX.isChecked())
                    Variaveis.assessment_model.setCondition_system("Don't know");

                if (chkYESPMLOX.isChecked())
                    Variaveis.assessment_model.setManifold_in_health("Yes");
                else if (chkNOPMLOX.isChecked())
                    Variaveis.assessment_model.setManifold_in_health("No");

                if (chkPHFLOX.isChecked())
                    Variaveis.assessment_model.setActivities_by("Internal Technical Personnel of the health facility");
                else if (chkPDILOX.isChecked())
                    Variaveis.assessment_model.setActivities_by("Personnel of the Department of Infrastructure");
                else if (chkSubLOX.isChecked())
                    Variaveis.assessment_model.setActivities_by("Subcontracted");

                if (chkYesPMCMLOX.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintenance("Yes");
                else if (chkNoPMCMLOX.isChecked())
                    Variaveis.assessment_model.setLogbbook_maintenance("No");

                if (chkYesLBLOX.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_manifold("Yes");
                else if (chkNoLBLOX.isChecked())
                    Variaveis.assessment_model.setLogbbook_update_manifold("No");

                if (chkDailyLOX.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder("Daily");
                else if (chkWeeklyLOX.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder("Weekly");
                else if (chkFortnightlyLOX.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder("Fortnightly");
                else if (chkMonthlyLOX.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder("Monthly");
                else if (chkOnrequestLOX.isChecked())
                    Variaveis.assessment_model.setHow_does_receive_cylinder("On request");

                if (chkYEShorLOX.isChecked())
                    Variaveis.assessment_model.setShortages_last_twoo_year("Yes");
                else if (chkNoShorLOX.isChecked())
                    Variaveis.assessment_model.setShortages_last_twoo_year("No");

                if (chkYesSITLOX.isChecked())
                    Variaveis.assessment_model.setShortages_last_twoo_year("Yes");
                else if (chkNoSITLOX.isChecked())
                    Variaveis.assessment_model.setShortages_last_twoo_year("No");

                if (TextUtils.isEmpty(average_consuming_oxygen) || TextUtils.isEmpty(last_month_consuminh) || TextUtils.isEmpty(capacity_lox_tank_m3)
                        || TextUtils.isEmpty(capacity_lox_tank_ton) || TextUtils.isEmpty(frequency_ox_tank) || TextUtils.isEmpty(name_maintenance_company_ox_tank) ||
                        TextUtils.isEmpty(average_cost_ox_tank) || TextUtils.isEmpty(budget_lox_tank) ||
                        TextUtils.isEmpty(name_supply_ox_tank) || TextUtils.isEmpty(how_many_tecn_available)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setLiquid_oxygen(liquid_oxygen);
                    Assessment.assessment_model.setAverage_consuming_oxygen(average_consuming_oxygen);
                    Assessment.assessment_model.setLast_month_consuminh(last_month_consuminh);
                    Assessment.assessment_model.setTank_owner(tank_owner);
                    Assessment.assessment_model.setTank_owner_other(tank_owner_other);
                    Assessment.assessment_model.setOld_system_oxygen(old_system_oxygen);
                    Assessment.assessment_model.setCapacity_lox_tank_m3(capacity_lox_tank_m3);
                    Assessment.assessment_model.setCapacity_lox_tank_ton(capacity_lox_tank_ton);
                    Assessment.assessment_model.setSystem_working_ox_tank(system_working_ox_tank);
                    Assessment.assessment_model.setCondition_system_ox_tank(condition_system_ox_tank);
                    Assessment.assessment_model.setActive_pm_program(active_pm_program);
                    Assessment.assessment_model.setActivie_carrie_by_ox_tank(activie_carrie_by_ox_tank);
                    Assessment.assessment_model.setFrequency_ox_tank(frequency_ox_tank);
                    Assessment.assessment_model.setName_maintenance_company_ox_tank(name_maintenance_company_ox_tank);
                    Assessment.assessment_model.setAverage_cost_ox_tank(average_cost_ox_tank);
                    Assessment.assessment_model.setBudget_lox_tank(budget_lox_tank);
                    Assessment.assessment_model.setLogbook_mainte_tank(logbook_mainte_tank);
                    Assessment.assessment_model.setLogbook_update_ox_tank(logbook_update_ox_tank);
                    Assessment.assessment_model.setName_supply_ox_tank(name_supply_ox_tank);
                    Assessment.assessment_model.setHealth_receive_lox(health_receive_lox);
                    Assessment.assessment_model.setShortages_lox(shortages_lox);
                    Assessment.assessment_model.setSpecialized_internal(specialized_internal);
                    Assessment.assessment_model.setHow_many_tecn_available(how_many_tecn_available);
                    Assessment.assessment_model.setComment_ox_tank(comment_ox_tank);

                    Intent i = new Intent(Update_liquid_ox.this, FormLiquidOxTwoo.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLOX = new Intent(Update_liquid_ox.this, Update_manifold_emergency.class);
                startActivity(backLOX);
            }
        });


    }

    private void getAndSetIntentData_liquid() {
        if (getIntent().hasExtra("txtcapacity_manifold")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txt_average_consuming_oxygen.setText(Variaveis.assessment_model.getAverage_consuming_oxygen());
            txt_last_month_consuminh.setText(Variaveis.assessment_model.getLast_month_consuminh());
            txt_tank_owner_other.setText(Variaveis.assessment_model.getTank_owner());
            txt_capacity_lox_tank_m3.setText(Variaveis.assessment_model.getCapacity_lox_tank_m3());
            txt_capacity_lox_tank_ton.setText(Variaveis.assessment_model.getCapacity_lox_tank_ton());
            txt_frequency_ox_tank.setText(Variaveis.assessment_model.getFrequency_ox_tank());
            txt_name_maintenance_company_ox_tank.setText(Variaveis.assessment_model.getName_maintenance_company_ox_tank());
            txt_average_cost_ox_tank.setText(Variaveis.assessment_model.getAverage_cost_ox_tank());
            txt_budget_lox_tank.setText(Variaveis.assessment_model.getBudget_lox_tank());
            txt_name_supply_ox_tank.setText(Variaveis.assessment_model.getName_supply_ox_tank());
            txt_how_many_tecn_available.setText(Variaveis.assessment_model.getHow_many_tecn_available());
            txt_comment_ox_tank.setText(Variaveis.assessment_model.getComment_ox_tank());
        }
    }


    public void setRB_liquid_ox_tank() {
        chkYesLOX = findViewById(R.id.chkYesLOX);
        chkNoMFLOX = findViewById(R.id.chkNoMFLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_in_health())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_in_health().equalsIgnoreCase("Yes")) {
                chkYesLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_in_health().equalsIgnoreCase("No")) {
                chkNoMFLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLOX:
                if (checked)
                    cbo_liquid_oxygen = "Yes";
                break;
            case R.id.chkNoMFLOX:
                if (checked)
                    cbo_liquid_oxygen = "No";
                break;
        }
    }

    public void setRB_liquid_owner() {
        chkMISAULOX = findViewById(R.id.chkMISAULOX);
        chkSupLOX = findViewById(R.id.chkSupLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_in_health())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_in_health().equalsIgnoreCase("MISAU-Hospital")) {
                chkMISAULOX.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_in_health().equalsIgnoreCase("Supplier")) {
                chkSupLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked1_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkMISAULOX:
                if (checked)
                    cbo_tank_owner = "MISAU-Hospital";
                break;
            case R.id.chkSupLOX:
                if (checked)
                    cbo_tank_owner = "Supplier";
                break;
        }
    }

    public void setRBMain_liquid_old_sys() {
        chkLessLOX = findViewById(R.id.chkLessLOX);
        chkB3_10LOX = findViewById(R.id.chkB3_10LOX);
        chkB11_20LOX = findViewById(R.id.chkB11_20LOX);
        idChkMore20 = findViewById(R.id.idChkMore20);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getOld_system_manifold())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getOld_system_manifold().equalsIgnoreCase("Less than 3 years")) {
                chkLessLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold().equalsIgnoreCase("Between 3-10 years")) {
                chkB3_10LOX.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold().equalsIgnoreCase("Between 11-20 years")) {
                chkB11_20LOX.setChecked(true);
            } else if (Variaveis.assessment_model.getOld_system_manifold().equalsIgnoreCase("More than 20 years")) {
                idChkMore20.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked2_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLessLOX:
                if (checked)
                    cbo_old_system_oxygen = "Less than 3 years";
                break;
            case R.id.chkB3_10LOX:
                if (checked)
                    cbo_old_system_oxygen = "Between 3-10 years";
                break;
            case R.id.chkB11_20LOX:
                if (checked)
                    cbo_old_system_oxygen = "Between 11-20 years";
                break;
            case R.id.idChkMore20:
                if (checked)
                    cbo_old_system_oxygen = "More than 20 years";
                break;
        }
    }

    public void setRBMain_liquid_sys_working() {
        chkYLOX = findViewById(R.id.chkYLOX);
        chkNLOX = findViewById(R.id.chkNLOX);
        chkPartlyLOX = findViewById(R.id.chkPartlyLOX);
        chkDontNLOX = findViewById(R.id.chkDontNLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getManifold_working())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getManifold_working().equalsIgnoreCase("Yes")) {
                chkYLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working().equalsIgnoreCase("No")) {
                chkNLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working().equalsIgnoreCase("Partly")) {
                chkPartlyLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getManifold_working().equalsIgnoreCase("Don't know")) {
                chkDontNLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked3_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYLOX:
                if (checked)
                    cbo_system_working_ox_tank = "Yes";
                break;
            case R.id.chkNLOX:
                if (checked)
                    cbo_system_working_ox_tank = "No";
                break;
            case R.id.chkPartlyLOX:
                if (checked)
                    cbo_system_working_ox_tank = "Partly";
                break;
            case R.id.chkDontNLOX:
                if (checked)
                    cbo_system_working_ox_tank = "Don't know";
                break;
        }
    }

    public void setRB_liquid_condition() {
        chkGIULOX = findViewById(R.id.chkGIULOX);
        chkGBNULOX = findViewById(R.id.chkGBNULOX);
        chkIU_BNRLOX = findViewById(R.id.chkIU_BNRLOX);
        chkIUNNTRLOX = findViewById(R.id.chkIUNNTRLOX);
        chkOOSBRLOX = findViewById(R.id.chkOOSBRLOX);
        chkOOSAndNRLOX = findViewById(R.id.chkOOSAndNRLOX);
        chkStilInstPhaLOX = findViewById(R.id.chkStilInstPhaLOX);
        chkDontKnowLOX = findViewById(R.id.chkDontKnowLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getCondition_system())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("Good and in use")) {
                chkGIULOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("Good, but not in use")) {
                chkGBNULOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("In use, but needs repair")) {
                chkIU_BNRLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("In use, but needs to be replaced")) {
                chkIUNNTRLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("Out of service, but repairable")) {
                chkOOSBRLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("Out of service and needs to be replaced")) {
                chkOOSAndNRLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("Still in the installation phase")) {
                chkStilInstPhaLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getCondition_system().equalsIgnoreCase("Don't know")) {
                chkDontKnowLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked4_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkGIULOX:
                if (checked)
                    cbo_condition_system_ox_tank = "Good and in use";
                break;
            case R.id.chkGBNULOX:
                if (checked)
                    cbo_condition_system_ox_tank = "Good, but not in use";
                break;
            case R.id.chkIU_BNRLOX:
                if (checked)
                    cbo_condition_system_ox_tank = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRLOX:
                if (checked)
                    cbo_condition_system_ox_tank = "In use, but needs to be replaced";
            case R.id.chkOOSBRLOX:
                if (checked)
                    cbo_condition_system_ox_tank = "Out of service, but repairable";
            case R.id.chkOOSAndNRLOX:
                if (checked)
                    cbo_condition_system_ox_tank = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaLOX:
                if (checked)
                    cbo_condition_system_ox_tank = "Still in the installation phase";
            case R.id.chkDontKnowLOX:
                if (checked)
                    cbo_condition_system_ox_tank = "Don't know";
                break;
        }
    }

    public void setRB_manifold_liquid_pm_program() {
        chkYESPMLOX = findViewById(R.id.chkYESPMLOX);
        chkNOPMLOX = findViewById(R.id.chkNOPMLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActive_pm_program_manif())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActive_pm_program_manif().equalsIgnoreCase("Yes")) {
                chkYESPMLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getActive_pm_program_manif().equalsIgnoreCase("No")) {
                chkNOPMLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked5_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESPMLOX:
                if (checked)
                    cbo_active_pm_program = "Yes";
                break;
            case R.id.chkNOPMLOX:
                if (checked)
                    cbo_active_pm_program = "No";
                break;
        }
    }

    public void setRBMain_liquid_carries_by() {
        chkPHFLOX = findViewById(R.id.chkPHFLOX);
        chkPDILOX = findViewById(R.id.chkPDILOX);
        chkSubLOX = findViewById(R.id.chkSubLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getActivities_by())) {
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getActivities_by().equalsIgnoreCase("Internal Technical Personnel of the Health Facility")) {
                chkPHFLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getActivities_by().equalsIgnoreCase("Personnel from the Department of Infrastructure")) {
                chkPDILOX.setChecked(true);
            } else if (Variaveis.assessment_model.getActivities_by().equalsIgnoreCase("Subcontracted")) {
                chkSubLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked6_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFLOX:
                if (checked)
                    cbo_activie_carrie_by_ox_tank = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDILOX:
                if (checked)
                    cbo_activie_carrie_by_ox_tank = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubLOX:
                if (checked)
                    cbo_activie_carrie_by_ox_tank = "Subcontracted";
                break;
        }
    }

    public void setRB_liquid_logbook() {
        chkYesPMCMLOX = findViewById(R.id.chkYesPMCMLOX);
        chkNoPMCMLOX = findViewById(R.id.chkNoPMCMLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_maintenance())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_maintenance().equalsIgnoreCase("Yes")) {
                chkYesPMCMLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_maintenance().equalsIgnoreCase("No")) {
                chkNoPMCMLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked7_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMCMLOX:
                if (checked)
                    cbo_logbook_mainte_tank = "Yes";
                break;
            case R.id.chkNoPMCMLOX:
                if (checked)
                    cbo_logbook_mainte_tank = "No";
                break;
        }
    }

    public void setRB_liquid_logbook_update() {
        chkYesLBLOX = findViewById(R.id.chkYesLBLOX);
        chkNoLBLOX = findViewById(R.id.chkNoLBLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLogbbook_maintenance())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLogbbook_maintenance().equalsIgnoreCase("Yes")) {
                chkYesLBLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getLogbbook_maintenance().equalsIgnoreCase("No")) {
                chkNoLBLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked8_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLBLOX:
                if (checked)
                    cbo_logbook_update_ox_tank = "Yes";
                break;
            case R.id.chkNoLBLOX:
                if (checked)
                    cbo_logbook_update_ox_tank = "No";
                break;
        }
    }

    public void setRB_liquid_receive() {
        chkDailyLOX = findViewById(R.id.chkDailyLOX);
        chkWeeklyLOX = findViewById(R.id.chkWeeklyLOX);
        chkFortnightlyLOX = findViewById(R.id.chkFortnightlyLOX);
        chkMonthlyLOX = findViewById(R.id.chkMonthlyLOX);
        chkOnrequestLOX = findViewById(R.id.chkOnrequestLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getHow_does_receive_cylinder())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getHow_does_receive_cylinder().equalsIgnoreCase("Daily")) {
                chkDailyLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder().equalsIgnoreCase("Weekly")) {
                chkWeeklyLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder().equalsIgnoreCase("Fortnightly")) {
                chkFortnightlyLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder().equalsIgnoreCase("Monthly")) {
                chkMonthlyLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getHow_does_receive_cylinder().equalsIgnoreCase("On request")) {
                chkOnrequestLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked9_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDailyLOX:
                if (checked)
                    cbo_health_receive_lox = "Daily";
                break;
            case R.id.chkWeeklyLOX:
                if (checked)
                    cbo_health_receive_lox = "Weekly";
                break;
            case R.id.chkFortnightlyLOX:
                if (checked)
                    cbo_health_receive_lox = "Fortnightly";
                break;
            case R.id.chkMonthlyLOX:
                if (checked)
                    cbo_health_receive_lox = "Monthly";
                break;
            case R.id.chkOnrequestLOX:
                if (checked)
                    cbo_health_receive_lox = "On request";
                break;
        }
    }

    public void setRB_liquid_shortages() {
        chkYEShorLOX = findViewById(R.id.chkYEShorLOX);
        chkNoShorLOX = findViewById(R.id.chkNoShorLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getShortages_last_twoo_year())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getShortages_last_twoo_year().equalsIgnoreCase("Yes")) {
                chkYEShorLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getShortages_last_twoo_year().equalsIgnoreCase("No")) {
                chkNoShorLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked10_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYEShorLOX:
                if (checked)
                    cbo_shortages_lox = "Yes";
                break;
            case R.id.chkNoShorLOX:
                if (checked)
                    cbo_shortages_lox = "No";
                break;
        }
    }

    public void setRB_liquid_facility() {
        chkYesSITLOX = findViewById(R.id.chkYesSITLOX);
        chkNoSITLOX = findViewById(R.id.chkNoSITLOX);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getShortages_last_twoo_year())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getShortages_last_twoo_year().equalsIgnoreCase("Yes")) {
                chkYesSITLOX.setChecked(true);
            } else if (Variaveis.assessment_model.getShortages_last_twoo_year().equalsIgnoreCase("No")) {
                chkNoSITLOX.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked11_lox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSITLOX:
                if (checked)
                    cbo_specialized_internal = "Yes";
                break;
            case R.id.chkNoSITLOX:
                if (checked)
                    cbo_specialized_internal = "No";
                break;
        }
    }

    public void InitComponents() {
        btnNExt = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.btn_backLOX);

        txt_average_consuming_oxygen = findViewById(R.id.txtAVGLOX);
        txt_last_month_consuminh = findViewById(R.id.txtMCLOX);
        txt_tank_owner_other = findViewById(R.id.txtOtherLOX);
        txt_capacity_lox_tank_m3 = findViewById(R.id.txtCapaTLOX);
        txt_capacity_lox_tank_ton = findViewById(R.id.txtCapTonsLOX);
        txt_frequency_ox_tank = findViewById(R.id.txtFPMMLOX);
        txt_name_maintenance_company_ox_tank = findViewById(R.id.txtNMCLOX);
        txt_average_cost_ox_tank = findViewById(R.id.txtAVGCPMLOX);
        txt_budget_lox_tank = findViewById(R.id.txtBudgetLOX);
        txt_name_supply_ox_tank = findViewById(R.id.txtNSLOX);
        txt_how_many_tecn_available = findViewById(R.id.txtTechAvLOX);
        txt_comment_ox_tank = findViewById(R.id.txtCommentLOX);
    }

    public void LimparCampos() {
        txt_average_consuming_oxygen.setText("");
        txt_last_month_consuminh.setText("");
        txt_tank_owner_other.setText("");
        txt_capacity_lox_tank_m3.setText("");
        txt_capacity_lox_tank_ton.setText("");
        txt_frequency_ox_tank.setText("");
        txt_name_maintenance_company_ox_tank.setText("");
        txt_average_cost_ox_tank.setText("");
        txt_budget_lox_tank.setText("");
        txt_name_supply_ox_tank.setText("");
        txt_how_many_tecn_available.setText("");
        txt_comment_ox_tank.setText("");
    }
}