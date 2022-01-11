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


public class FormDocTrainLiqOxTank extends AppCompatActivity {
    private Button btn_next, btnBack;
    private String cbo_tecni_train_lox,cbo_frequency_trainnOT;
    private TextView txt_how_many_tech_trained_lox, txt_comments_train_lox;
    String [] mensagens = {"Preencha todos os campos","Falha ao registar","Registado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doc_train_liq_ox_tank);

    //    getSupportActionBar().hide();
        InitComponents();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tecni_train_lox = cbo_tecni_train_lox;
                String frequency_trainnOT = cbo_frequency_trainnOT;
                String how_many_tech_trained_lox = txt_how_many_tech_trained_lox.getText().toString();
                String comments_train_lox = txt_comments_train_lox.getText().toString();

                if (TextUtils.isEmpty(how_many_tech_trained_lox)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setTecni_train_lox(tecni_train_lox);
                    Assessment.assessment_model.setFrequency_trainnOT(frequency_trainnOT);
                    Assessment.assessment_model.setHow_many_tech_trained_lox(how_many_tech_trained_lox);
                    Assessment.assessment_model.setComments_train_lox(comments_train_lox);

                    Intent i = new Intent(FormDocTrainLiqOxTank.this, FormOxFactory.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormDocTrainLiqOxTank.this, FormTrainDocManif.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_doc_liq_ox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMS:
                if (checked)
                    cbo_tecni_train_lox = "Yes";
                break;
            case R.id.chkNoMS:
                if (checked)
                    cbo_tecni_train_lox = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_doc_liq_ox(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6:
                if (checked)
                    cbo_frequency_trainnOT = "Every 6 months";
                break;
            case R.id.chkEveryYear:
                if (checked)
                    cbo_frequency_trainnOT = "Every yea";
                break;
            case R.id.chkEvery2Year:
                if (checked)
                    cbo_frequency_trainnOT = "Every 2 years";
                break;
            case R.id.chkEvery5Year:
                if (checked)
                    cbo_frequency_trainnOT = "Every 5 years";
                break;
            case R.id.chkOnRequest:
                if (checked)
                    cbo_frequency_trainnOT = "On request";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backTLT);
        btn_next = findViewById(R.id.btn_next);

        txt_how_many_tech_trained_lox = findViewById(R.id.txtMTTH);
        txt_comments_train_lox = findViewById(R.id.txtCommentsTraiC);
    }

    public void Limpar() {
        txt_how_many_tech_trained_lox.setText("");
        txt_comments_train_lox.setText("");
    }
}