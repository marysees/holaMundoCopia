package com.example.tarde.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SaludadorIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_SALUDAR = "com.example.tarde.intentservice.action.SALUDAR";
    private static final String ACTION_DESPEDIR = "com.example.tarde.intentservice.action.DESPEDIR";
    public static final String BROADCAST_ACTION_SALUDAR = "com.example.tarde.intentservice.broadcast.action.SALUDAR";
    public static final String BROADCAST_ACTION_DESPEDIR = "com.example.tarde.intentservice.broadcast.action.DESPEDIR";


    // TODO: Rename parameters
    public static final String EXTRA_PARAM_NOMBRE = "nombre";


    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see android.app.IntentService
     */
    // TODO: Customize helper method
    public static void startActionSaludar(Context context, String nombre) {
        Intent intent = new Intent(context, SaludadorIntentService.class);
        intent.setAction(ACTION_SALUDAR);
        intent.putExtra(EXTRA_PARAM_NOMBRE, nombre);

    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see android.app.IntentService
     */
    // TODO: Customize helper method
    public static void startActionDespedir(Context context, String nombre) {
        Intent intent = new Intent(context, SaludadorIntentService.class);
        intent.setAction(ACTION_DESPEDIR);
        intent.putExtra(EXTRA_PARAM_NOMBRE, nombre);

        context.startService(intent);
    }

    public SaludadorIntentService() {
        super("SaludadorIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //este metodo es el encargado de ejecutar el servicio
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SALUDAR.equals(action)) {
                final String nombre = intent.getStringExtra(EXTRA_PARAM_NOMBRE);
                 saludar(nombre);
            } else if (ACTION_DESPEDIR.equals(action)) {
                final String nombre = intent.getStringExtra(EXTRA_PARAM_NOMBRE);
                 despedir(nombre);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void saludar(String nombre) {
        //como corre en un hilo secundario no se pueden poner Toast asi que uso broadcast
        Intent intent = new Intent(BROADCAST_ACTION_SALUDAR);
        intent.putExtra(EXTRA_PARAM_NOMBRE,nombre);
        sendBroadcast(intent);
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void despedir(String nombre) {

        Intent intent = new Intent(BROADCAST_ACTION_DESPEDIR);
        intent.putExtra(EXTRA_PARAM_NOMBRE,nombre);
        sendBroadcast(intent);
    }
}
