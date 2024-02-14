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
import com.example.anytime.services.AuthenticationServices;
import com.example.anytime.socket.SocketManager;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Array;

import io.socket.emitter.Emitter;

public class RegisterActivity extends AppCompatActivity {

    //ID Formulaire

    EditText first_name;
    EditText last_name;
    EditText email;
    EditText password;

    RegisterInterface registerInterface;

    private SocketManager socketManager;

    private Button registerbtn;
    private TextView loginbtn;
    private TextView homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //init form
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        socketManager = SocketManager.getInstance();


        socketManager.connect();

        registerbtn = findViewById(R.id.registerbtn);
        loginbtn = findViewById(R.id.loginbtn);
        homebtn = findViewById(R.id.homebtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLIKREGISTER", "onClick: SUR REGISTER");

                AuthenticationServices authenticationServices = new AuthenticationServices();

                //Validation formulaire
                registerInterface = new RegisterInterface(first_name.getText().toString(),last_name.getText().toString(),email.getText().toString(),password.getText().toString());

                //parse avec le dependance Gson
                Gson gson = new Gson();
                String json = gson.toJson(registerInterface);


                if (registerInterface.validateRegister(registerInterface)){
                    Toast.makeText(RegisterActivity.this, "La validation est bon", Toast.LENGTH_SHORT).show();
                    authenticationServices.savaregisternewcustomer(RegisterActivity.this,json);
                    //socketManager.emitEvent("registerNewCustomer", new Object[]{json});
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

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, TopicsLearnActivity.class);
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