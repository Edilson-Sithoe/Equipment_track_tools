package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Update_interview_id extends AppCompatActivity {
    private Button btnBack, btnNext;
    private EditText txtFullName, txtOrganization, txtData, txtOthers, txtSecInterV, txtSecInterVTwoo;
    private RadioButton rbOnSet, rbByPhone, rbByEmail;

    private ProgressDialog load;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    int id;
    private String fullname, organization, data, others, secInterV, secIntervTwoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_interview_id);
        IniciarComponentes_update();
        setRadioButton();
        getAndSetIntentData();
        //  settingData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(fullname);
        }

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

                txtData.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        txtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Update_interview_id.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingData();
                String name = txtFullName.getText().toString();
                String org = txtOrganization.getText().toString();
                String date = txtData.getText().toString();
                //   String type_interview = txtSecInterV.getText().toString();
                String other = txtOthers.getText().toString();
                String second = txtSecInterV.getText().toString();
                String secondTwoo = txtSecInterVTwoo.getText().toString();

                if (rbOnSet.isChecked())
                    Variaveis.assessment_model.setChk_interview_type("On set");
                else if (rbByPhone.isChecked())
                    Variaveis.assessment_model.setChk_interview_type("By Phone");
                else
                    Variaveis.assessment_model.setChk_interview_type("By Email");

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(org) || TextUtils.isEmpty(date)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {

                    Assessment.assessment_model.setTxtFullName(name);
                    Assessment.assessment_model.setTxtOrganization(org);
                    Assessment.assessment_model.setDataDates(date);
                    //    Assessment.assessment_model.setCboOupatient(type_interview);
                    Assessment.assessment_model.setTxtOther(other);
                    Assessment.assessment_model.setTxtSecInterV(second);
                    Assessment.assessment_model.setTxtSecInterVTwoo(secondTwoo);
                    Intent i = new Intent(Update_interview_id.this, Update_identi_inter_view.class);
                    startActivity(i);
                }
            }
        });

    }

    private void settingData() {
        id = Variaveis.assessment_model.getId();
        fullname = txtFullName.getText().toString().trim();
        organization = txtOrganization.getText().toString().trim();
        data = txtData.getText().toString().trim();
        others = txtOthers.getText().toString().trim();
        secInterV = txtSecInterV.getText().toString().trim();
        secIntervTwoo = txtSecInterVTwoo.getText().toString().trim();
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("fullname") && getIntent().hasExtra("organization")
                && getIntent().hasExtra("data") && getIntent().hasExtra("others") && getIntent().hasExtra("secInterv") && getIntent().hasExtra("secIntrevTwoo")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtFullName.setText(Variaveis.assessment_model.getTxtFullName());
            txtOrganization.setText(Variaveis.assessment_model.getTxtOrganization());
            txtData.setText(Variaveis.assessment_model.getDataDates());
            txtOthers.setText(Variaveis.assessment_model.getOther());
            txtSecInterV.setText(Variaveis.assessment_model.getTxtSecInterV());
            txtSecInterVTwoo.setText(Variaveis.assessment_model.getTxtSecInterVTwoo());
            //  Log.w("tentando criar tabela", String.valueOf(fullName));
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover " + fullname + " ?");
        builder.setMessage("Pretende apagar " + fullname + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Update_interview_id.this);
                database_connection.deleteOneRow(id);
                finish();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }


    public void setRadioButton() {
        rbOnSet = findViewById(R.id.radio_set_edit);
        rbByPhone = findViewById(R.id.radio_phone_edit);
        rbByEmail = findViewById(R.id.radio_email_edit);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getChk_interview_type())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getChk_interview_type().equalsIgnoreCase("On set")) {
                rbOnSet.setChecked(true);
            } else if (Variaveis.assessment_model.getChk_interview_type().equalsIgnoreCase("By Phone")){
                rbByPhone.setChecked(true);
            } else {
                rbByEmail.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_interview_edit(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_set_edit:
                if (checked)
                    //  interview_type = "On set";
                    Assessment.assessment_model.setChk_interview_type("On set");
                //  Toast.makeText(FormInterviewID.this, "Clicado aqui", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_phone_edit:
                if (checked)
                    Assessment.assessment_model.setChk_interview_type("By Phone");
                //  Toast.makeText(FormInterviewID.this, "Clicado aqui", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_email_edit:
                if (checked)
                    Assessment.assessment_model.setChk_interview_type("By Email");
                //   Toast.makeText(FormInterviewID.this, "Clicado aqui", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void IniciarComponentes_update() {
        txtFullName = findViewById(R.id.idFisrtUsar_edit);
        txtOrganization = findViewById(R.id.idOrga_edit);
        txtData = findViewById(R.id.id_date_inter_edit);
        txtOthers = findViewById(R.id.id_other_edit);
        txtSecInterV = findViewById(R.id.idIntervThree_edit);
        txtSecInterVTwoo = findViewById(R.id.idIntervTwo_edit);

        btnBack = findViewById(R.id.btn_back_edit);
        btnNext = findViewById(R.id.btn_next_edit);

     /*   fullName.setText(Assessment.assessment_model.getTxtFullName() != null ? Assessment.assessment_model.getTxtName() : "");
        organization.setText(Assessment.assessment_model.getTxtOrganization() != null ? Assessment.assessment_model.getTxtOrganization() : "");
        data.setText(Assessment.assessment_model.getDataDates() != null ? Assessment.assessment_model.getDataDates() : "");

        others.setText(Assessment.assessment_model.getTxtOther() != null ? Assessment.assessment_model.getTxtOther() : "");
        secInterV.setText(Assessment.assessment_model.getTxtSecInterV() != null ? Assessment.assessment_model.getTxtSecInterV() : "");
        secInterVTwoo.setText(Assessment.assessment_model.getTxtSecInterVTwoo() != null ? Assessment.assessment_model.getTxtSecInterVTwoo() : "");*/
    }

}