package projecto.jhpiego.equipment_track_tools.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import projecto.jhpiego.equipment_track_tools.R;

import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment_aux;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.user.FormCadastro;
import projecto.jhpiego.equipment_track_tools.TelaPrincipal;

public class FormLogin extends AppCompatActivity {
    private TextInputEditText userName, password;
    private Button btn_login;
    private ProgressBar progressBar;
    private TextView registerTV;
    Database_connection DB;
    Assessment_aux DB2;
    String[] mensagens = {"Prrencha todos os campos","Usuário ou senha inválidos","Usuário já existe", "Usuário registado com sucesso","Autenticado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        userName = findViewById(R.id.idEditUserName);
        password = findViewById(R.id.idEditPassword);
        btn_login = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressbar);
        registerTV = findViewById(R.id.idTVLogin);
        DB = new Database_connection(this);

        DB2 = new Assessment_aux(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178,34,34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Boolean chkCheckUserPass = DB.checkUsernamePass(user,pass);
                    if (chkCheckUserPass == true) {
                        Snackbar snackbar = Snackbar.make(v,mensagens[4],Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(176,224,230));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                        Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);
                        startActivity(intent);
                    } else {
                        Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(210,105,30));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                    }
                }
            }
        });

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormLogin.this, FormCadastro.class);
                startActivity(i);
            }
        });

    }

}