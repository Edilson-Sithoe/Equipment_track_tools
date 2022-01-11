package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormSupervisory extends AppCompatActivity {
    private Button btnBack, btn_next;
    private String cbo_last_time_rec_super, cbo_last_time_rec_sup_training;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_supervisory);

     //   getSupportActionBar().hide();
        IniciarComponentes();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String last_time_rec_super = cbo_last_time_rec_super;
                String last_time_rec_sup_training = cbo_last_time_rec_sup_training;

                Assessment.assessment_model.setLast_time_rec_super(last_time_rec_super);
                Assessment.assessment_model.setLast_time_rec_sup_training(last_time_rec_sup_training);

                Intent i = new Intent(FormSupervisory.this, FormTeam.class);
                startActivity(i);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormSupervisory.this, FormMaintaMedEquip.class);
                startActivity(i);
            }
        });
    }

    public void onRadioButtonClicked_sup(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chk0_6MonthsMGS:
                if (checked)
                    cbo_last_time_rec_super = "0-6 Months";
                break;
            case R.id.chk7_12MonthsMGS:
                if (checked)
                    cbo_last_time_rec_super = "7-12 Months";
                break;
            case R.id.chkMoreThanOneYMGS:
                if (checked)
                    cbo_last_time_rec_super = "More than 1 year ago";
                break;
            case R.id.chkDontNoMGS:
                if (checked)
                    cbo_last_time_rec_super = "Don't know";
                break;
            case R.id.chkNeverMGS:
                if (checked)
                    cbo_last_time_rec_super = "Never";
                break;
        }
    }

    public void onRadioButtonClicked1_sup(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chk0_6MonthsTMT:
                if (checked)
                    cbo_last_time_rec_sup_training = "0-6 Months";
                break;
            case R.id.chk7_12MonthsTMT:
                if (checked)
                    cbo_last_time_rec_sup_training = "7-12 Months";
                break;
            case R.id.chkMoreThanOneTMT:
                if (checked)
                    cbo_last_time_rec_sup_training = "More than 1 year ago";
                break;
            case R.id.chkDontNoTMT:
                if (checked)
                    cbo_last_time_rec_sup_training = "Don't know";
                break;
            case R.id.chkNeverTMT:
                if (checked)
                    cbo_last_time_rec_sup_training = "Never";
                break;
        }
    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backSup);
        btn_next = findViewById(R.id.btn_next);

    }
}