package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anytime.R;
import com.example.anytime.interfaces.RegisterInterface;
import com.example.anytime.socket.SocketManager;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Array;

import io.socket.emitter.Emitter;

public class RegisterActivity extends AppCompatActivity {

    //ID Formulaire

    EditText f_nametxt;
    EditText l_nametxt;
    EditText emailtxt;
    EditText passwordtxt;
    EditText confpasswordtxt;

    RegisterInterface registerInterface;

    private SocketManager socketManager;

    private Button registerbtn;
    private TextView loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //init form
        f_nametxt = (EditText) findViewById(R.id.f_nametxt);
        l_nametxt = (EditText) findViewById(R.id.l_nametxt);
        emailtxt = (EditText) findViewById(R.id.emailtxt);
        passwordtxt = (EditText) findViewById(R.id.passwordtxt);
        confpasswordtxt = (EditText) findViewById(R.id.confpasswordtxt);


        socketManager = SocketManager.getInstance();


        socketManager.connect();

        registerbtn = findViewById(R.id.registerbtn);
        loginbtn = findViewById(R.id.loginbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLIKREGISTER", "onClick: SUR REGISTER");

                //Validation formulaire
                registerInterface = new RegisterInterface(f_nametxt.getText().toString(),l_nametxt.getText().toString(),emailtxt.getText().toString(),passwordtxt.getText().toString(),confpasswordtxt.getText().toString());

                //parse avec le dependance Gson
                Gson gson = new Gson();
                String json = gson.toJson(registerInterface);


                if (registerInterface.validateRegister(registerInterface)){
                    Toast.makeText(RegisterActivity.this, "La validation est bon", Toast.LENGTH_SHORT).show();
                    socketManager.emitEvent("registerNewCustomer", new Object[]{json});
                }else {
                    Toast.makeText(RegisterActivity.this, "Faux pas bon !", Toast.LENGTH_SHORT).show();
                }



                // Émettez un événement socket
                //socketManager.emitEvent("newMessage", "{socket: 'Depuis un Android...'}");


                // Écoutez les événements sockets
                /*socketManager.onEvent("onMessage", new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        // Gérer la réception de l'événement socket
                        if (args != null && args.length > 0) {
                            Object arg = args[0]; // Récupérer le premier argument de l'objet args

                            if (arg instanceof String) {
                                String message = (String) arg; // Convertir l'argument en String si nécessaire
                                Log.d("CALL", "Message reçu : " + message);
                            } else if (arg instanceof JSONObject) {
                                JSONObject jsonObject = (JSONObject) arg; // Convertir l'argument en JSONObject si nécessaire
                                // Manipuler le JSONObject selon vos besoins
                                // ...
                                Log.d("CALL", "JSONObject reçu : " + jsonObject.toString());
                            } else {
                                // Gérer d'autres types d'arguments si nécessaire
                            }
                        }
                    }
                });*/

            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Déconnectez-vous du serveur socket lorsque l'activité est détruite
        socketManager.disconnect();
    }
}