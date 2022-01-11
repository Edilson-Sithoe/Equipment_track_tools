package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;


public class FormIdentiInterView extends AppCompatActivity {

    private Button btnBack, btnNext;
    private TextView txtName, txtEmail, txtTelephone, txtPosition, txtOther, txtOtherTwo;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_identi_inter_view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        IniciarComponentes();



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormIdentiInterView.this, FormInterviewID.class);
                startActivity(i);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = txtName.getText().toString();
                String e_mail = txtEmail.getText().toString();
                String phone = txtTelephone.getText().toString();
                String pos = txtPosition.getText().toString();
                String other = txtOther.getText().toString();
                String other_two = txtOtherTwo.getText().toString();

                 if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(e_mail) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(pos)) {
                     Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                     snackbar.setBackgroundTint(Color.rgb(178,34,34));
                     snackbar.setTextColor(Color.WHITE);
                     snackbar.show();
                 } else {
                     Assessment.assessment_model.setNome(nome);
                     Assessment.assessment_model.setEmail(e_mail);
                     Assessment.assessment_model.setTelephone(phone);
                     Assessment.assessment_model.setPosition(pos);
                     Assessment.assessment_model.setOther(other);
                     Assessment.assessment_model.setOtherTwo(other_two);

                     Intent inext = new Intent(FormIdentiInterView.this, FormIdentiHeaFacil.class);
                   //  Intent inext = new Intent(FormIdentiInterView.this, FormUPSTwoo.class);
                     startActivity(inext);
                 }

            }
        });

    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_next);

        txtName = findViewById(R.id.idName);
        txtEmail = findViewById(R.id.idEmail);
        txtTelephone = findViewById(R.id.idPhone);
        txtPosition = findViewById(R.id.idPos);

        txtOther = findViewById(R.id.idOther);
        txtOtherTwo = findViewById(R.id.idOtherTwo);

    //    txtName.setText(Assessment.assessment_model.getTxtName()!= null?Assessment.assessment_model.getTxtName():"");
    /*    txtEmail.setText(Assessment.assessment_model.getEmail()!= null?Assessment.assessment_model.getTxtName():"");
        txtTelephone.setText(Assessment.assessment_model.getTelephone()!= null?Assessment.assessment_model.getTxtName():"");
        txtPosition.setText(Assessment.assessment_model.getPosition()!= null?Assessment.assessment_model.getTxtName():"");
        txtOther.setText(Assessment.assessment_model.getOther()!= null?Assessment.assessment_model.getTxtName():"");
        txtOtherTwo.setText(Assessment.assessment_model.getOtherTwo()!= null?Assessment.assessment_model.getTxtName():"");*/
    }

    public void LimparCampos() {
        txtName.setText("");
        txtEmail.setText("");
        txtTelephone.setText("");
        txtTelephone.setText("");
        txtOther.setText("");
        txtOtherTwo.setText("");
    }
}