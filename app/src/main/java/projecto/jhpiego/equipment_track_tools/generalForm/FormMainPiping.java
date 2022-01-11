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

public class FormMainPiping extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private String cbo_piping_network, cbo_old_sysem_pp,cbo_system_working_pp, cbo_valvues_for_each_area, cbo_staff_know_where_shut_off;
    private String cbo_staff_know_wher_close, cbo_higt_low_pressure_alarm, cbo_centralized_alarm, cbo_condiction_system_pp, cbo_type_plug_outlet;
    private String cbo_active_pm_program_pp, cbo_pm_actives_carried_pp;
    private TextView txt_system_capacity_mas,txt_frequency_system_pp, txt_type_plug_outlet,  txt_name_maintanance_pp, txt_average_cost_piping, txt_budget_program_pp, txt_comments_pp;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_main_piping);

      //  getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String piping_network = cbo_piping_network;
                String old_sysem_pp = cbo_old_sysem_pp;
                String system_working_pp = cbo_system_working_pp;
                String valvues_for_each_area = cbo_valvues_for_each_area;
                String staff_know_where_shut_off =  cbo_staff_know_where_shut_off;
                String staff_know_wher_close = cbo_staff_know_wher_close;
                String higt_low_pressure_alarm = cbo_higt_low_pressure_alarm;
                String centralized_alarm = cbo_centralized_alarm;
                String condiction_system_pp = cbo_condiction_system_pp;
                String type_plug_outlet = cbo_type_plug_outlet;
                String other_type_plug_outlet = txt_type_plug_outlet.getText().toString();
                String active_pm_program_pp = cbo_active_pm_program_pp;
                String frequency_system_pp = txt_frequency_system_pp.getText().toString();
                String pm_actives_carried_pp = cbo_pm_actives_carried_pp;
                String name_maintanance_pp = txt_name_maintanance_pp.getText().toString();
                String average_cost_piping = txt_average_cost_piping.getText().toString();
                String budget_program_pp = txt_budget_program_pp.getText().toString();
                String comments_pp = txt_comments_pp.getText().toString();

                if (TextUtils.isEmpty(frequency_system_pp) ||TextUtils.isEmpty(name_maintanance_pp)||TextUtils.isEmpty(average_cost_piping)
                        ||TextUtils.isEmpty(budget_program_pp)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setPiping_network(piping_network);
                    Assessment.assessment_model.setOld_sysem_pp(old_sysem_pp);
                    Assessment.assessment_model.setSystem_working_pp(system_working_pp);
                    Assessment.assessment_model.setValves_for_each_area(valvues_for_each_area);
                    Assessment.assessment_model.setStaff_know_where_shut_off(staff_know_where_shut_off);
                    Assessment.assessment_model.setStaff_know_wher_close(staff_know_wher_close);
                    Assessment.assessment_model.setHigh_low_pressure_alarm(higt_low_pressure_alarm);
                    Assessment.assessment_model.setCentralized_alarm(centralized_alarm);
                    Assessment.assessment_model.setCondition_system_pp(condiction_system_pp);
                    Assessment.assessment_model.setType_plug_outlet(type_plug_outlet);
                    Assessment.assessment_model.setOther_type_plug_outlet(other_type_plug_outlet);
                    Assessment.assessment_model.setActive_pm_program_pp(active_pm_program_pp);
                    Assessment.assessment_model.setFrequency_system_pp(txt_frequency_system_pp.getText().toString());
                    Assessment.assessment_model.setPm_actives_carried_pp(pm_actives_carried_pp);
                    Assessment.assessment_model.setName_maintanance_pp(txt_name_maintanance_pp.getText().toString());
                    Assessment.assessment_model.setAverage_cost_piping(txt_average_cost_piping.getText().toString());
                    Assessment.assessment_model.setBudget_program_pp(txt_budget_program_pp.getText().toString());
                    Assessment.assessment_model.setComments_pp(txt_comments_pp.getText().toString());

                    Intent i = new Intent(FormMainPiping.this, FormLogistic.class);
                 //   Intent i = new Intent(FormMainPiping.this, FormMedGasOutlets.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormMainPiping.this, FormMedAirSystem.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMPP:
                if (checked)
                    cbo_piping_network = "Yes";
                break;
            case R.id.chkNoMPP:
                if (checked)
                    cbo_piping_network = "No";
                break;
        }
    }
    public void onRadioButtonClicked1_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkLessMPP:
                if (checked)
                    cbo_old_sysem_pp = "Less than 3 years";
                break;
            case R.id.chkB3_10MPP:
                if (checked)
                    cbo_old_sysem_pp = "Between 3-10 years";
                break;
            case R.id.chkB11_20MPP:
                if (checked)
                    cbo_old_sysem_pp = "Between 11-20 years";
                break;
            case R.id.chkMore20MPP:
                if (checked)
                    cbo_old_sysem_pp = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked2_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSWMPP:
                if (checked)
                    cbo_system_working_pp = "Yes";
                break;
            case R.id.chkNoSWMPP:
                if (checked)
                    cbo_system_working_pp = "No";
                break;
            case R.id.chkPartlySWMPP:
                if (checked)
                    cbo_system_working_pp = "Partly";
                break;
            case R.id.chkDontNSWMPP:
                if (checked)
                    cbo_system_working_pp = "Don't know";
                break;
        }
    }
    public void onRadioButtonClicked3_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesVMPP:
                if (checked)
                    cbo_valvues_for_each_area = "Yes";
                break;
            case R.id.chkNoVMPP:
                if (checked)
                    cbo_valvues_for_each_area = "No";
                break;
            case R.id.chkPartlyVMPP:
                if (checked)
                    cbo_valvues_for_each_area = "Partly";
                break;
            case R.id.chkDontNVMPP:
                if (checked)
                    cbo_valvues_for_each_area = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked4_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSOVMPP:
                if (checked)
                    cbo_staff_know_where_shut_off = "Yes";
                break;
            case R.id.chkNoSOVMPP:
                if (checked)
                    cbo_staff_know_where_shut_off = "No";
                break;
        }
    }

    public void onRadioButtonClicked5_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesCFEVMPP:
                if (checked)
                    cbo_staff_know_wher_close = "Yes";
                break;
            case R.id.chkNoCFEMPP:
                if (checked)
                    cbo_staff_know_wher_close = "No";
                break;
        }
    }

    public void onRadioButtonClicked6_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLPMPP:
                if (checked)
                    cbo_higt_low_pressure_alarm = "Yes";
                break;
            case R.id.chkNoLPMPP:
                if (checked)
                    cbo_higt_low_pressure_alarm = "No";
                break;
            case R.id.chkPartlyLPMPP:
                if (checked)
                    cbo_higt_low_pressure_alarm = "Partly";
                break;
            case R.id.chkDontNLPMPP:
                if (checked)
                    cbo_higt_low_pressure_alarm = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked7_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesCAVMPP:
                if (checked)
                    cbo_centralized_alarm = "Yes";
                break;
            case R.id.chkNoCAMPP:
                if (checked)
                    cbo_centralized_alarm = "No";
                break;
        }
    }

    public void onRadioButtonClicked8_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkGIUMPP:
                if (checked)
                    cbo_condiction_system_pp = "Good and in use";
                break;
            case R.id.chkGBNUMPP:
                if (checked)
                    cbo_condiction_system_pp = "Good, but not in use";
                break;
            case R.id.chkIU_BNRMPP:
                if (checked)
                    cbo_condiction_system_pp = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRMPP:
                if (checked)
                    cbo_condiction_system_pp = "In use, but needs to be replaced";
            case R.id.chkOOSBRMPP:
                if (checked)
                    cbo_condiction_system_pp = "Out of service, but repairable";
            case R.id.chkOOSAndNRMPP:
                if (checked)
                    cbo_condiction_system_pp = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaMPP:
                if (checked)
                    cbo_condiction_system_pp = "Still in the installation phase";
            case R.id.chkDontNMPP:
                if (checked)
                    cbo_condiction_system_pp = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked9_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkOQCMPP:
                if (checked)
                    cbo_type_plug_outlet = "Ohio Quick-connect Quick-connect (OQC) Quick Link System";
                break;
            case R.id.chkAFROXMPP:
                if (checked)
                    cbo_type_plug_outlet = "Rapid connection system (schourader) UK/AFROX";
                break;
            case R.id.chkDISSMPP:
                if (checked)
                    cbo_type_plug_outlet = "Diameter Index Safety System (DISS";
                break;
            case R.id.chkOUSAMPP:
                if (checked)
                    cbo_type_plug_outlet = "Ohmeda (USA) ";
            case R.id.chkCUSAMPP:
                if (checked)
                    cbo_type_plug_outlet = "Chemetron (USA) ";
            case R.id.chkPUSAMPP:
                if (checked)
                    cbo_type_plug_outlet = "Puritan (USA";
            case R.id.chkOMUSAMPP:
                if (checked)
                    cbo_type_plug_outlet = "Oxequip/Medstar (USA) ";
        }
    }

    public void onRadioButtonClicked10_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMMPP:
                if (checked)
                    cbo_active_pm_program_pp = "Yes";
                break;
            case R.id.chkNoPMMPP:
                if (checked)
                    cbo_active_pm_program_pp = "No";
                break;
        }
    }

    public void onRadioButtonClicked11_mpp(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFMPP:
                if (checked)
                    cbo_pm_actives_carried_pp = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIMPP:
                if (checked)
                    cbo_pm_actives_carried_pp = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCMPP:
                if (checked)
                    cbo_pm_actives_carried_pp = "Subcontracted";
                break;
        }
    }


    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backMPP);
        btnNExt = findViewById(R.id.btn_nextPP);

        txt_system_capacity_mas = findViewById(R.id.btn_backMPP);
        txt_type_plug_outlet = findViewById(R.id.txtOtherMPP);
        txt_frequency_system_pp = findViewById(R.id.txtFPMMPP);

        txt_name_maintanance_pp = findViewById(R.id.txtSubMPP);
        txt_average_cost_piping = findViewById(R.id.txtAVGPMMPP);
        txt_budget_program_pp = findViewById(R.id.txtBudgtMPP);

        txt_comments_pp = findViewById(R.id.txtCommentMPP);
    }

    public void LimparCampos(){
        txt_system_capacity_mas.setText("");
        txt_frequency_system_pp.setText("");
        txt_name_maintanance_pp.setText("");
        txt_average_cost_piping.setText("");
        txt_budget_program_pp.setText("");
        txt_comments_pp.setText("");
    }

}