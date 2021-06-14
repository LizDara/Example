package com.example.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.selected)
    TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("APARATO");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(20);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);

        List<Map<String, Object>> listar = new LinkedList<>();
        Map<String, Object> dato1 = new HashMap<>();
        dato1.put("ci", 123);
        dato1.put("nombre", "Juan");
        Map<String, Object> dato2 = new HashMap<>();
        dato2.put("ci", 456);
        dato2.put("nombre", "Carlos");
        Map<String, Object> dato3 = new HashMap<>();
        dato3.put("ci", 987);
        dato3.put("nombre", "Alicia");
        listar.add(dato1);
        listar.add(dato2);
        listar.add(dato3);

        AparatoAdapter aparatoAdapter = new AparatoAdapter(getBaseContext(), listar);
        recycler.setAdapter(aparatoAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class AparatoAdapter extends RecyclerView.Adapter<AparatoAdapter.MyViewHolder> {

        Context context;
        List<Map<String, Object>> list;

        public AparatoAdapter(Context context, List<Map<String, Object>> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.listar, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nombre.setText(list.get(position).get("nombre").toString());
            holder.ci.setText(list.get(position).get("ci").toString());

            holder.param = list.get(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView nombre;
            TextView ci;
            Button editar;
            Button eliminar;
            Map<String, Object> param;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                nombre = itemView.findViewById(R.id.nombre_textView);
                ci = itemView.findViewById(R.id.ci_textView);
                editar = itemView.findViewById(R.id.editar_button);
                eliminar = itemView.findViewById(R.id.eliminar_button);

                editar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selected.setText(param.get("ci").toString() + " " + param.get("nombre").toString());
                    }
                });
                eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selected.setText(param.get("ci").toString() + " " + param.get("nombre").toString());
                    }
                });
            }
        }
    }
}
