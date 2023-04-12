package ac.mz.savedatearray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private EditText nome_login, password_login;
    private Button login;

    ArrayList<FormData> formData;

    String name, pass;

    List<FormData> formDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome_login = findViewById(R.id.nome_login);
        password_login = findViewById(R.id.password_login);
        login = findViewById(R.id.login);


        Intent intent = getIntent();

        if (intent !=null){
            formDataList = (List<FormData>) intent.getSerializableExtra("dados");
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fazerLogin();
            }
        });

    }

    public void fazerLogin(){
        name = nome_login.getText().toString();
        pass = password_login.getText().toString();
        boolean autenticado = false;

        if (formDataList != null) {
            for (FormData data : formDataList){
                if (name.equals(data.getNome()) && pass.equals(data.getPass())){
                    autenticado = true; //
                    break; //
                }
            }
            if (autenticado) {
                Toast.makeText(Login.this, "Login com sucesso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Login.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Login.this, "Nenhum dado de formulário encontrado", Toast.LENGTH_SHORT).show();
        }
    }






}