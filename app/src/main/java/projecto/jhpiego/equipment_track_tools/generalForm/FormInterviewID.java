package projecto.jhpiego.equipment_track_tools.generalForm;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.TelaPrincipal;

public class FormInterviewID extends AppCompatActivity {

    private Button btnBack, btnNext;
    private EditText fullName, organization,data, others,secInterV, secInterVTwoo;

    private ProgressDialog load;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String interview_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_interview_id);

//        getSupportActionBar().hide();
        IniciarComponentes();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullName.getText().toString();
                String org = organization.getText().toString();
                String date = data.getText().toString();
             //   String type_interview = interview_type;
                String other = others.getText().toString();
                String second = secInterV.getText().toString();
                String secondTwoo = secInterVTwoo.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(org) ||TextUtils.isEmpty(date)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178,34,34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {

                    Assessment.assessment_model.setTxtFullName(name);
                    Assessment.assessment_model.setTxtOrganization(org);
                    Assessment.assessment_model.setDataDates(date);
                  //  Assessment.assessment_model.setCboOupatient(type_interview);
                    Assessment.assessment_model.setTxtOther(other);
                    Assessment.assessment_model.setTxtSecInterV(second);
                    Assessment.assessment_model.setTxtSecInterVTwoo(secondTwoo);

                    Intent i = new Intent(FormInterviewID.this,FormIdentiInterView.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormInterviewID.this, TelaPrincipal.class);
                startActivity(i);
            }
        });

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();
            }

            private void updateCalendar() {
                String format = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);

                data.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(FormInterviewID.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void onRadioButtonClicked_interview(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_set:
                if (checked)
                  //  interview_type = "On set";
                    Assessment.assessment_model.setChk_interview_type("On set");
              //  Toast.makeText(FormInterviewID.this, "Clicado aqui", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_phone:
                if (checked)
                    Assessment.assessment_model.setChk_interview_type("By Phone");
              //  Toast.makeText(FormInterviewID.this, "Clicado aqui", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_email:
                if (checked)
                    Assessment.assessment_model.setChk_interview_type("By Email");
             //   Toast.makeText(FormInterviewID.this, "Clicado aqui", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void IniciarComponentes(){
        fullName = findViewById(R.id.idFisrtUsar);
        organization = findViewById(R.id.idOrga);
        data = findViewById(R.id.id_date_inter);

        others = findViewById(R.id.id_other);
        secInterV = findViewById(R.id.idIntervThree);
        secInterVTwoo = findViewById(R.id.idIntervTwo);

        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_next);

        fullName.setText(Assessment.assessment_model.getTxtFullName()!= null?Assessment.assessment_model.getTxtName():"");
        organization.setText(Assessment.assessment_model.getTxtOrganization()!= null?Assessment.assessment_model.getTxtOrganization():"");
        data.setText(Assessment.assessment_model.getDataDates()!= null?Assessment.assessment_model.getDataDates():"");

        others.setText(Assessment.assessment_model.getTxtOther()!= null?Assessment.assessment_model.getTxtOther():"");
        secInterV.setText(Assessment.assessment_model.getTxtSecInterV()!= null?Assessment.assessment_model.getTxtSecInterV():"");
        secInterVTwoo.setText(Assessment.assessment_model.getTxtSecInterVTwoo()!= null?Assessment.assessment_model.getTxtSecInterVTwoo():"");
    }

    public void LimparCampos() {
        fullName.setText("");
        organization.setText("");
        data.setText("");

        others.setText("");
        secInterV.setText("");
        secInterVTwoo.setText("");
    }
}