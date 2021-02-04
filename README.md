Reproducción, pausa, continuación y detención de archivo de audio Android Studio

Itegrantes: 
 - Chantal Morales
 - Sebastián Morales
 - Kevin Segovia
 - Israel Vásquez
 - Nicole Zambrano

Para esto, crearemoos un nuevo proyecto en Android Studio y colocaremos los botones de la interfaz con el texto de las funciones que realizará cada uno.

![Alt text](/captures/ejercicio_en_emulador.png?raw=true "Interfaz")

Luego, creamos una carpeta con el nombre "raw" dentro de "res" y dentro de esta colocaremos el archivo mp3 que queremos usar.

![Alt text](/captures/arhivo_mp3.png?raw=true "Archivo MP3")

Ahora haremos los métodos respectivos de los botones, que para esto, declaramos 3 variables una tipo `MediaPlayer`, otra `Button` y un `int` que va a tener la posición de cuando se haga pausa el audio.

Método "destroy"

```
public void destroy() {
        if (mp != null) {
            mp.release();
        }
    }
```

Método "iniciar/play"

```
public void init(View view) {
        destroy();
        mp = MediaPlayer.create(this, R.raw.cancion);
        mp.start();
        String op = b5.getText().toString();
        if (op.equals("no reproducir en forma circular")) {
            mp.setLooping(false);
        } else {
            mp.setLooping(true);
        }
    }
```

Método "pausa"

```
public void pause(View view) {
        if (mp != null && mp.isPlaying()) {
            position = mp.getCurrentPosition();
            mp.pause();
        }
    }
```

Método "continuar"

```
public void cont(View view) {
        if (mp != null && mp.isPlaying() == false) {
            mp.seekTo(position);
            mp.start();
        }
    }
```

Método "parar"

```
public void stop(View view) {
        if (mp != null) {
            mp.stop();
            position = 0;
        }
    }
```

Método "repetir"

```
public void circle(View view) {
        stop(null);
        String op = b5.getText().toString();
        if (op.equals("no reproducir en forma circular")) {
            b5.setText("reproducir en forma circular");
        } else {
            b5.setText("no reproducir en forma circular");
        }
    }
```
