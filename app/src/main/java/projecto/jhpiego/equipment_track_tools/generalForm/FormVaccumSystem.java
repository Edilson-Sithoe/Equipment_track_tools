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

public class FormVaccumSystem extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private String cbo_suction_system, cbo_olde_system_ss,cbo_suction_system_working, cbo_condiction_system_ss, cbo_active_pm_program_ss;
    private String cbo_activities_carried_by_ss;
    private TextView txt_capacity_system_ss,txt_frequency_pm_month_ss, txt_name_maintenance_ss, txt_average_pm_suction_ss, txt_budget_suction_ss, txt_comment_suction;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_vaccum_system);

     //   getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suction_system = cbo_suction_system;
                String olde_system_ss = cbo_olde_system_ss;
                String capacity_system_ss = txt_capacity_system_ss.getText().toString();
                String suction_system_working = cbo_suction_system_working;
                String condiction_system_ss =  cbo_condiction_system_ss;
                String active_pm_program_ss = cbo_active_pm_program_ss;
                String frequency_pm_month_ss = txt_frequency_pm_month_ss.getText().toString();
                String activities_carried_by_ss = cbo_activities_carried_by_ss;
                String name_maintenance_ss = txt_name_maintenance_ss.getText().toString();
                String average_pm_suction_ss = txt_average_pm_suction_ss.getText().toString();
                String budget_suction_ss = txt_budget_suction_ss.getText().toString();
                String comment_suction = txt_comment_suction.getText().toString();

                if (TextUtils.isEmpty(capacity_system_ss) ||TextUtils.isEmpty(name_maintenance_ss)||TextUtils.isEmpty(frequency_pm_month_ss)
                        ||TextUtils.isEmpty(average_pm_suction_ss)|| TextUtils.isEmpty(budget_suction_ss)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setSuction_system(suction_system);
                    Assessment.assessment_model.setOlde_system_ss(olde_system_ss);
                    Assessment.assessment_model.setCapacity_system_ss(txt_capacity_system_ss.getText().toString());
                    Assessment.assessment_model.setSuction_system_working(suction_system_working);
                    Assessment.assessment_model.setCondiction_system_ss(condiction_system_ss);
                    Assessment.assessment_model.setActive_pm_program_ss(active_pm_program_ss);
                    Assessment.assessment_model.setFrequency_pm_month_ss(txt_frequency_pm_month_ss.getText().toString());
                    Assessment.assessment_model.setActivities_carried_by_ss(activities_carried_by_ss);
                    Assessment.assessment_model.setName_maintenance_ss(txt_name_maintenance_ss.getText().toString());
                    Assessment.assessment_model.setAverage_pm_suction_ss(average_pm_suction_ss);
                    Assessment.assessment_model.setBudget_suction_ss(txt_budget_suction_ss.getText().toString());
                    Assessment.assessment_model.setComment_suction(txt_comment_suction.getText().toString());

                    Intent i = new Intent(FormVaccumSystem.this, FormMedAirSystem.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vsystem = new Intent(FormVaccumSystem.this, FormOxFactoryPSA.class);
                startActivity(vsystem);
            }
        });

    }

    public void onRadioButtonClicked_vs(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSV:
                if (checked)
                    cbo_suction_system = "Yes";
                break;
            case R.id.chkNoSV:
                if (checked)
                    cbo_suction_system = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_vs(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkLessSV:
                if (checked)
                    cbo_olde_system_ss = "Less than 3 years";
                break;
            case R.id.chkMoreThaOnYSV:
                if (checked)
                    cbo_olde_system_ss = "Between 3-10 years";
                break;
            case R.id.chkMoreThnTwoYSV:
                if (checked)
                    cbo_olde_system_ss = "Between 11-20 years";
                break;
            case R.id.chkDontNoSV:
                if (checked)
                    cbo_olde_system_ss = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked2_vs(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSWSV:
                if (checked)
                    cbo_suction_system_working = "Yes";
                break;
            case R.id.chkNoSWSV:
                if (checked)
                    cbo_suction_system_working = "No";
                break;
            case R.id.chkPartlySWSV:
                if (checked)
                    cbo_suction_system_working = "Partly";
                break;
            case R.id.chkDontNSWSV:
                if (checked)
                    cbo_suction_system_working = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked3_vs(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkGIUSV:
                if (checked)
                    cbo_condiction_system_ss = "Good and in use";
                break;
            case R.id.chkGBNUSV:
                if (checked)
                    cbo_condiction_system_ss = "Good, but not in use";
                break;
            case R.id.chkIU_BNRSV:
                if (checked)
                    cbo_condiction_system_ss = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRSV:
                if (checked)
                    cbo_condiction_system_ss = "In use, but needs to be replaced";
            case R.id.chkOOSBRSV:
                if (checked)
                    cbo_condiction_system_ss = "Out of service, but repairable";
            case R.id.chkOOSAndNRSV:
                if (checked)
                    cbo_condiction_system_ss = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaSV:
                if (checked)
                    cbo_condiction_system_ss = "Still in the installation phase";
            case R.id.chkDontNSV:
                if (checked)
                    cbo_condiction_system_ss = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked4_vs(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMSV:
                if (checked)
                    cbo_active_pm_program_ss = "Yes";
                break;
            case R.id.chkNoPMSV:
                if (checked)
                    cbo_active_pm_program_ss = "No";
                break;
        }
    }

    public void onRadioButtonClicked5_vs(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFSV:
                if (checked)
                    cbo_activities_carried_by_ss = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDISV:
                if (checked)
                    cbo_activities_carried_by_ss = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCSV:
                if (checked)
                    cbo_activities_carried_by_ss = "Subcontracted";
                break;
        }
    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backVS);
        btnNExt = findViewById(R.id.btn_next);

        txt_capacity_system_ss = findViewById(R.id.txtLPMSV);

        txt_frequency_pm_month_ss = findViewById(R.id.txtFPMSV);

        txt_name_maintenance_ss = findViewById(R.id.txtMCSV);
        txt_average_pm_suction_ss = findViewById(R.id.txtCPMCONSV);
        txt_budget_suction_ss = findViewById(R.id.txtMPSV);

        txt_comment_suction = findViewById(R.id.txtCommentSV);
    }

    public void LimparCampos(){
        txt_capacity_system_ss.setText("");
        txt_frequency_pm_month_ss.setText("");
        txt_name_maintenance_ss.setText("");
        txt_average_pm_suction_ss.setText("");
        txt_average_pm_suction_ss.setText("");
        txt_budget_suction_ss.setText("");
        txt_comment_suction.setText("");
    }
}