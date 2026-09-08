package com.example.consultaproductosrest_semana4;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.consultaproductosrest_semana4.model.Producto;
import com.example.consultaproductosrest_semana4.retrofit.ApiService;
import com.example.consultaproductosrest_semana4.retrofit.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLista = findViewById(R.id.tvLista);
        tvLista.setText("⏳ Cargando productos...");

        consultarProductosAPI();
    }

    private void consultarProductosAPI() {
        ApiService servicio = RetrofitClient.getCliente().create(ApiService.class);
        Call<List<Producto>> llamada = servicio.obtenerProductos();

        llamada.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> respuesta) {
                if (respuesta.isSuccessful() && respuesta.body() != null) {
                    List<Producto> lista = respuesta.body();
                    StringBuilder texto = new StringBuilder();

                    for (Producto p : lista) {
                        String cat = p.getCategoria();
                        String iconoCat = "📦";
                        String etiquetaPrecio = "💰";

                        // Ícono según categoría
                        if (cat.equalsIgnoreCase("electronics")) {
                            iconoCat = "📱";
                        } else if (cat.equalsIgnoreCase("jewelery")) {
                            iconoCat = "💍";
                        } else if (cat.contains("clothing")) {
                            iconoCat = "👕";
                        }

                        // Color según precio
                        if (p.getPrecio() < 30) {
                            etiquetaPrecio = "🟢";
                        } else if (p.getPrecio() < 80) {
                            etiquetaPrecio = "🟡";
                        } else {
                            etiquetaPrecio = "🔴";
                        }

                        // ✅ TODO ALINEADO Y ORDENADO
                        texto.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                        texto.append(" 🆔 ID:      ").append(p.getId()).append("\n");
                        texto.append(" 📦 Nombre:  ").append(p.getNombre()).append("\n");
                        texto.append(" ").append(etiquetaPrecio).append(" Precio:   $").append(String.format("%.2f", p.getPrecio())).append("\n");
                        texto.append(" ").append(iconoCat).append(" Categoría: ").append(cat).append("\n");
                        texto.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n");
                    }

                    // Total al final
                    texto.append("\n");
                    texto.append("═══════════════════════════════════\n");
                    texto.append(" 📊 Total de productos: ").append(lista.size()).append("\n");
                    texto.append("═══════════════════════════════════");

                    tvLista.setText(texto.toString());

                } else {
                    Toast.makeText(MainActivity.this, "No se recibieron datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable error) {
                Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}