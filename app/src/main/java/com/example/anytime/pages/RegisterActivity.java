package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anytime.R;
import com.example.anytime.socket.SocketManager;

import org.json.JSONObject;

import io.socket.emitter.Emitter;

public class RegisterActivity extends AppCompatActivity {

    private SocketManager socketManager;

    private Button registerbtn;
    private TextView loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        socketManager = SocketManager.getInstance();

        socketManager.connect();

        registerbtn = findViewById(R.id.registerbtn);
        loginbtn = findViewById(R.id.loginbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLIKREGISTER", "onClick: SUR REGISTER");

                // Émettez un événement socket
                socketManager.emitEvent("newMessage", "{f_name: 'Samuel'}");


                // Écoutez les événements socket
                socketManager.onEvent("onMessage", new Emitter.Listener() {
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
                });

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