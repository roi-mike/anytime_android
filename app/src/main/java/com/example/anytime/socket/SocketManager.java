package com.example.anytime.socket;

import android.app.Application;
import android.util.Log;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.transports.WebSocket;
import io.socket.engineio.client.transports.Polling;

public class SocketManager extends Application {

    private static SocketManager instance;
    private Socket socket;
    private String SOCKET_URL = "http://10.0.2.2:3000";

    private SocketManager() {
        try {
            // Spécifiez les options de configuration pour votre instance Socket.io
            IO.Options options = new IO.Options();

            // Spécifiez les méthodes de transport prises en charge
            options.transports = new String[] { WebSocket.NAME, Polling.NAME };

            // Initialisez votre instance Socket.io avec les options spécifiées
            socket = IO.socket(SOCKET_URL, options);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static SocketManager getInstance() {
        if (instance == null) {
            instance = new SocketManager();
        }
        return instance;
    }

    public void connect() {
        socket.connect();

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d("SOCKET", "Connexion établie");
            }
        });

        socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                if (args != null && args.length > 0) {
                    if (args[0] instanceof Exception) {
                        Exception exception = (Exception) args[0];
                        String errorMessage = exception.getMessage();
                        Log.e("SOCKET", "Erreur de connexion : " + errorMessage);
                    } else {
                        Log.e("SOCKET", "Erreur de connexion : " + args[0]);
                    }
                }
            }
        });

        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.d("SOCKET", "Connexion perdue");
            }
        });
    }

    public boolean isConnected() {
        return socket.connected();
    }

    public void disconnect() {
        socket.disconnect();
    }

    public void setConnectTimeout(int timeout) {
        socket.io().timeout(timeout);
    }

    public void setReconnection(boolean reconnection) {
        socket.io().reconnection(reconnection);
    }

    public void setReconnectionDelay(int delay) {
        socket.io().reconnectionDelay(delay);
    }

    public void emitEvent(String event, Object... args) {
        socket.emit(event, args);
    }

    public void onEvent(String event, Emitter.Listener listener) {
        socket.on(event, listener);
    }



}
