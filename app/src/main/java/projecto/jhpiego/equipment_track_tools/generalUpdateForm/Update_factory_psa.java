package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormLiquidOxTwoo;
import projecto.jhpiego.equipment_track_tools.generalForm.FormOxFactoryPSA;
import projecto.jhpiego.equipment_track_tools.generalForm.FormVaccumSystem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Update_factory_psa extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private String cbo_oxygen_ox2_plant, cbo_old_system_ox2, cbo_system_working_ox2, cbo_condition_ox2, cbo_specific_transformer_ox2;
    private String cbo_specific_generator_ox2, cbo_specific_ups_ox2, cbo_specific_stablilizer_ox2, cbo_manifolf_fill_cylinder;
    private String cbo_most_common_ox2, cbo_system_working_ox2_ox, cbo_supply_cylinder_ox2, cbo_active_pm_program_ox2;
    private String cbo_activities_carried_by_ox2, cbo_specilized_tecn_internal_ox2, cbo_any_shortage_two_last_ox2;

    private TextView txt_capacity_factory_ox2, txt_diemeter_ox2, txt_tota_production, txt_cap_fill_system_ox_cylinder, txt_cap_ox_tank_fill_system;
    private TextView txt_which_supply_cylinder_ox2, txt_name_supply_ox_tank, txt_frequency_pm_ox2, txt_name_maintenance_ox2, txt_average_cost_year_ox2, txt_budget_ox2;
    private TextView txt_how_many_tecn_available_ox2, txt_comments_ox2;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_factory_psa);

        InitComponents();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oxygen_ox2_plant = cbo_oxygen_ox2_plant;
                String old_system_ox2 = cbo_old_system_ox2;
                String capacity_factory_ox2 = txt_capacity_factory_ox2.getText().toString();
                String diemeter_ox2 = txt_diemeter_ox2.getText().toString();
                String tota_production = txt_tota_production.getText().toString();
                String system_working_ox2 = cbo_system_working_ox2;
                String condition_ox2 = cbo_condition_ox2;
                String specific_transformer_ox2 = cbo_specific_transformer_ox2;
                String specific_generator_ox2 = cbo_specific_generator_ox2;
                String specific_ups_ox2 = cbo_specific_ups_ox2;
                String specific_stablilizer_ox2 = cbo_specific_stablilizer_ox2;
                String manifolf_fill_cylinder = cbo_manifolf_fill_cylinder;
                String cap_fill_system_ox_cylinder = txt_cap_fill_system_ox_cylinder.getText().toString();
                String cap_ox_tank_fill_system = txt_cap_ox_tank_fill_system.getText().toString();
                String most_common_ox2 = cbo_most_common_ox2;
                String system_working_ox2_ox = cbo_system_working_ox2_ox;
                String supply_cylinder_ox2 = cbo_supply_cylinder_ox2;
                String which_supply_cylinder_ox2 = txt_which_supply_cylinder_ox2.getText().toString();
                String health_supply_cyclinder = txt_name_supply_ox_tank.getText().toString();
                String active_pm_program_ox2 = cbo_active_pm_program_ox2;
                String frequency_pm_ox2 = txt_frequency_pm_ox2.getText().toString();
                String activities_carried_by_ox2 = cbo_activities_carried_by_ox2;
                String name_maintenance_ox2 = txt_name_maintenance_ox2.getText().toString();
                String average_cost_year_ox2 = txt_average_cost_year_ox2.getText().toString();
                String budget_ox2 = txt_budget_ox2.getText().toString();
                String specilized_tecn_internal_ox2 = cbo_specilized_tecn_internal_ox2;
                String how_many_tecn_available_ox2 = txt_how_many_tecn_available_ox2.getText().toString();
                String any_shortage_two_last_ox2 = cbo_any_shortage_two_last_ox2;
                String comments_ox2 = txt_comments_ox2.getText().toString();

                if (TextUtils.isEmpty(capacity_factory_ox2) || TextUtils.isEmpty(diemeter_ox2) || TextUtils.isEmpty(tota_production)
                        || TextUtils.isEmpty(cap_fill_system_ox_cylinder) || TextUtils.isEmpty(cap_ox_tank_fill_system) || TextUtils.isEmpty(which_supply_cylinder_ox2) ||
                        TextUtils.isEmpty(frequency_pm_ox2) || TextUtils.isEmpty(name_maintenance_ox2) ||
                        TextUtils.isEmpty(average_cost_year_ox2) || TextUtils.isEmpty(budget_ox2) || TextUtils.isEmpty(how_many_tecn_available_ox2)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setOxygen_ox2_plant(oxygen_ox2_plant);
                    Assessment.assessment_model.setOld_system_ox2(old_system_ox2);
                    Assessment.assessment_model.setCapacity_factory_ox2(capacity_factory_ox2);
                    Assessment.assessment_model.setDiemeter_ox2(diemeter_ox2);
                    Assessment.assessment_model.setTota_production(tota_production);
                    Assessment.assessment_model.setSystem_working_ox2(system_working_ox2);
                    Assessment.assessment_model.setCondition_ox2(condition_ox2);
                    Assessment.assessment_model.setSpecific_transformer_ox2(specific_transformer_ox2);
                    Assessment.assessment_model.setSpecific_generator_ox2(specific_generator_ox2);
                    Assessment.assessment_model.setSpecific_ups_ox2(specific_ups_ox2);
                    Assessment.assessment_model.setSpecific_stablilizer_ox2(specific_stablilizer_ox2);
                    Assessment.assessment_model.setManifolf_fill_cylinder(manifolf_fill_cylinder);
                    Assessment.assessment_model.setCap_fill_system_ox_cylinder(cap_fill_system_ox_cylinder);
                    Assessment.assessment_model.setCap_ox_tank_fill_system(cap_ox_tank_fill_system);
                    Assessment.assessment_model.setMost_common_ox2(most_common_ox2);
                    Assessment.assessment_model.setSystem_working_ox2_ox(system_working_ox2_ox);
                    Assessment.assessment_model.setSupply_cylinder_ox2(supply_cylinder_ox2);
                    Assessment.assessment_model.setWhich_supply_cylinder_ox2(which_supply_cylinder_ox2);
                    Assessment.assessment_model.setHealth_supply_cyclinder(health_supply_cyclinder);
                    Assessment.assessment_model.setActive_pm_program_ox2(active_pm_program_ox2);
                    Assessment.assessment_model.setFrequency_pm_ox2(frequency_pm_ox2);
                    Assessment.assessment_model.setActivities_carried_by_ox2(activities_carried_by_ox2);
                    Assessment.assessment_model.setName_maintenance_ox2(name_maintenance_ox2);
                    Assessment.assessment_model.setAverage_cost_year_ox2(average_cost_year_ox2);
                    Assessment.assessment_model.setBudget_ox2(budget_ox2);
                    Assessment.assessment_model.setSpecilized_tecn_internal_ox2(specilized_tecn_internal_ox2);
                    Assessment.assessment_model.setHow_many_tecn_available_ox2(how_many_tecn_available_ox2);
                    Assessment.assessment_model.setAny_shortage_two_last_ox2(any_shortage_two_last_ox2);
                    Assessment.assessment_model.setComments_ox2(comments_ox2);

                    Intent i = new Intent(Update_factory_psa.this, FormVaccumSystem.class);
                    //   Intent i = new Intent(FormOxFactoryPSA.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Update_factory_psa.this, FormLiquidOxTwoo.class);
                startActivity(i);
            }
        });
    }

    public void onRadioButtonClicked_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesOX:
                if (checked)
                    cbo_oxygen_ox2_plant = "Yes";
                break;
            case R.id.chkNoOX:
                if (checked)
                    cbo_oxygen_ox2_plant = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkLessOX:
                if (checked)
                    cbo_old_system_ox2 = "Less than 3 years";
                break;
            case R.id.chkB3_10OX:
                if (checked)
                    cbo_old_system_ox2 = "Between 3-10 years";
                break;
            case R.id.chkB11_20OX:
                if (checked)
                    cbo_old_system_ox2 = "Between 11-20 years";
                break;
            case R.id.chkMore20OX:
                if (checked)
                    cbo_old_system_ox2 = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked2_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYOX:
                if (checked)
                    cbo_system_working_ox2 = "Yes";
                break;
            case R.id.chkNOX:
                if (checked)
                    cbo_system_working_ox2 = "No";
                break;
            case R.id.chkPartlyOX:
                if (checked)
                    cbo_system_working_ox2 = "Partly";
                break;
            case R.id.chkDontNOX:
                if (checked)
                    cbo_system_working_ox2 = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked3_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkGIUOX:
                if (checked)
                    cbo_condition_ox2 = "Good and in use";
                break;
            case R.id.chkGBNUOX:
                if (checked)
                    cbo_condition_ox2 = "Good, but not in use";
                break;
            case R.id.chkIU_BNROX:
                if (checked)
                    cbo_condition_ox2 = "In use, but needs repair";
                break;
            case R.id.chkIUNNTROX:
                if (checked)
                    cbo_condition_ox2 = "In use, but needs to be replaced";
            case R.id.chkOOSBROX:
                if (checked)
                    cbo_condition_ox2 = "Out of service, but repairable";
            case R.id.chkOOSAndNROX:
                if (checked)
                    cbo_condition_ox2 = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaOX:
                if (checked)
                    cbo_condition_ox2 = "Still in the installation phase";
            case R.id.chkDontKnowOX:
                if (checked)
                    cbo_condition_ox2 = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked4_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESTranOX:
                if (checked)
                    cbo_specific_transformer_ox2 = "Yes";
                break;
            case R.id.chkNOTranOX:
                if (checked)
                    cbo_specific_transformer_ox2 = "No";
                break;
            case R.id.chkYesBIDWTranOX:
                if (checked)
                    cbo_specific_transformer_ox2 = "Yes, but it does not work";
                break;
        }
    }

    public void onRadioButtonClicked5_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESGENOX:
                if (checked)
                    cbo_specific_generator_ox2 = "Yes";
                break;
            case R.id.chkNOGENOX:
                if (checked)
                    cbo_specific_generator_ox2 = "No";
                break;
            case R.id.chkYesBIDWGENOX:
                if (checked)
                    cbo_specific_generator_ox2 = "Yes, but it does not work";
                break;
        }
    }

    public void onRadioButtonClicked6_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESUPSOX:
                if (checked)
                    cbo_specific_ups_ox2 = "Yes";
                break;
            case R.id.chkNOUPSOX:
                if (checked)
                    cbo_specific_ups_ox2 = "No";
                break;
            case R.id.chkYesBIDWUPSOX:
                if (checked)
                    cbo_specific_ups_ox2 = "Yes, but it does not work";
                break;
        }
    }

    public void onRadioButtonClicked7_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESSTABOX:
                if (checked)
                    cbo_specific_stablilizer_ox2 = "Yes";
                break;
            case R.id.chkNOSTABOX:
                if (checked)
                    cbo_specific_stablilizer_ox2 = "No";
                break;
            case R.id.chkYesBIDWSTABOX:
                if (checked)
                    cbo_specific_stablilizer_ox2 = "Yes, but it does not work";
                break;
        }
    }

    public void onRadioButtonClicked8_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESMCOX:
                if (checked)
                    cbo_manifolf_fill_cylinder = "Yes";
                break;
            case R.id.chkNOMCOX:
                if (checked)
                    cbo_manifolf_fill_cylinder = "No";
                break;
            case R.id.chkYesBIDWMCOX:
                if (checked)
                    cbo_manifolf_fill_cylinder = "Yes, but it does not work";
                break;
        }
    }

    public void onRadioButtonClicked9_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEOX:
                if (checked)
                    cbo_most_common_ox2 = "E (1m3/680L)";
                break;
            case R.id.chkFOX:
                if (checked)
                    cbo_most_common_ox2 = "F (1.5/1360L)";
                break;
            case R.id.chkGOX:
                if (checked)
                    cbo_most_common_ox2 = "G (3.5m3/3400L)\"";
                break;
            case R.id.chkJOX:
                if (checked)
                    cbo_most_common_ox2 = "J (7.5m3/7800L)";
                break;
            case R.id.chkDontNoOX:
                if (checked)
                    cbo_most_common_ox2 = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked10_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkSWYOX:
                if (checked)
                    cbo_system_working_ox2_ox = "Yes";
                break;
            case R.id.chkSWNOX:
                if (checked)
                    cbo_system_working_ox2_ox = "No";
                break;
            case R.id.chkSWPartlyOX:
                if (checked)
                    cbo_system_working_ox2_ox = "Partly";
                break;
            case R.id.chkSWDontNOX:
                if (checked)
                    cbo_system_working_ox2_ox = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked11_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesCHOX:
                if (checked)
                    cbo_supply_cylinder_ox2 = "Yes";
                break;
            case R.id.chkNoCHOX:
                if (checked)
                    cbo_supply_cylinder_ox2 = "No";
                break;
        }
    }

    public void onRadioButtonClicked12_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMOX:
                if (checked)
                    cbo_active_pm_program_ox2 = "Yes";
                break;
            case R.id.chkNoPMOX:
                if (checked)
                    cbo_active_pm_program_ox2 = "No";
                break;
        }
    }

    public void onRadioButtonClicked13_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFOX:
                if (checked)
                    cbo_activities_carried_by_ox2 = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIOX:
                if (checked)
                    cbo_activities_carried_by_ox2 = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubOX:
                if (checked)
                    cbo_activities_carried_by_ox2 = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked14_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesHFSpecOX:
                if (checked)
                    cbo_specilized_tecn_internal_ox2 = "Yes";
                break;
            case R.id.chkNoHFSpecOX:
                if (checked)
                    cbo_specilized_tecn_internal_ox2 = "No";
                break;
        }
    }

    public void onRadioButtonClicked15_ox_fac_psa(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYEShorOX:
                if (checked)
                    cbo_any_shortage_two_last_ox2 = "Yes";
                break;
            case R.id.chkNoShorOX:
                if (checked)
                    cbo_any_shortage_two_last_ox2 = "No";
                break;
        }
    }

    public void InitComponents() {
        btnNExt = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.btn_backFSPA);

        txt_capacity_factory_ox2 = findViewById(R.id.txtCapaFactOX);
        txt_diemeter_ox2 = findViewById(R.id.txtDiametreOX);
        txt_tota_production = findViewById(R.id.txtTotalProdOX);
        txt_name_supply_ox_tank = findViewById(R.id.txtTotalProdOX);
        txt_cap_fill_system_ox_cylinder = findViewById(R.id.txtCapFSOX);
        txt_cap_ox_tank_fill_system = findViewById(R.id.txtCAPOXTankOX);
        txt_which_supply_cylinder_ox2 = findViewById(R.id.txtOne);
        txt_frequency_pm_ox2 = findViewById(R.id.txtFreqPMOX);
        txt_name_maintenance_ox2 = findViewById(R.id.txtCaseSNMaintOX);
        txt_average_cost_year_ox2 = findViewById(R.id.txtAVGOX);
        txt_budget_ox2 = findViewById(R.id.txtTecnAvailOX);
        txt_how_many_tecn_available_ox2 = findViewById(R.id.txtBudgetOX);
        txt_comments_ox2 = findViewById(R.id.txtCommentOX);
    }

    public void LimparCampos() {
        txt_capacity_factory_ox2.setText("");
        txt_diemeter_ox2.setText("");
        txt_tota_production.setText("");
        txt_cap_fill_system_ox_cylinder.setText("");
        txt_cap_ox_tank_fill_system.setText("");
        txt_which_supply_cylinder_ox2.setText("");
        txt_frequency_pm_ox2.setText("");
        txt_name_maintenance_ox2.setText("");
        txt_average_cost_year_ox2.setText("");
        txt_budget_ox2.setText("");
        txt_how_many_tecn_available_ox2.setText("");
        txt_comments_ox2.setText("");
    }
}