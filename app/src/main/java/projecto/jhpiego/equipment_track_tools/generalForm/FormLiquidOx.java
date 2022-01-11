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

public class FormLiquidOx extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private TextView txt_average_consuming_oxygen, txt_last_month_consuminh, txt_tank_owner_other;
    private TextView txt_capacity_lox_tank_m3, txt_capacity_lox_tank_ton, txt_frequency_ox_tank, txt_name_maintenance_company_ox_tank;
    private TextView txt_average_cost_ox_tank, txt_budget_lox_tank, txt_name_supply_ox_tank, txt_how_many_tecn_available, txt_comment_ox_tank;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_liquid_oxygen, cbo_tank_owner, cbo_old_system_oxygen, cbo_system_working_ox_tank, cbo_condition_system_ox_tank;
    private String cbo_active_pm_program, cbo_activie_carrie_by_ox_tank, cbo_logbook_mainte_tank, cbo_logbook_update_ox_tank, cbo_health_receive_lox;
    private String cbo_shortages_lox, cbo_specialized_internal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_liquid_ox);

        //   getSupportActionBar().hide();
        InitComponents();

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

                    Intent i = new Intent(FormLiquidOx.this, FormLiquidOxTwoo.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLOX = new Intent(FormLiquidOx.this, FormMFEmerg.class);
                startActivity(backLOX);
            }
        });

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