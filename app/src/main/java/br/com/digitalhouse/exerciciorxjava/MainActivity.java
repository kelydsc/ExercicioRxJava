package br.com.digitalhouse.exerciciorxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class MainActivity extends AppCompatActivity {

    TextView textViewMensagem;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMensagem = findViewById(R.id.textViewMensagem);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.iniciandoComRXJava();
            }
        });
        iniciandoComRXJava();
    }

    private void iniciandoComRXJava() {

        // cria um Observable, com uma expressão lambda do tipo ObservableOnSubscribe
        //emitter é um argumento do tipo ObservableEmitter
        //essa função é executada quando um Subscriber se vincula ao Observable

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

                //emite valores para os Subscribers vinculados a esse Observable
                emitter.onNext("azul");
                emitter.onNext("rosa");
                emitter.onNext("vermelho");
                emitter.onNext("branco");
                emitter.onNext("preto");
                emitter.onNext("verde");
                emitter.onNext("amarelo");

                //finaliza o Observable
                emitter.onComplete();
            }
        })

        //vincula um Subscriber ao Observable; a funcão enviada como parâmetro é a ação
        // executada no evento onNext
        .subscribe(System.out::println);
    }
}
