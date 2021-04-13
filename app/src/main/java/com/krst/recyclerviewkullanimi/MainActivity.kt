package com.krst.recyclerviewkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LinearLayoutManager oluşturma ve RecyclerView view'ına bağlama işlemi.
        val layout_manager = LinearLayoutManager(this)
        recyclerView.layoutManager = layout_manager


        val isimler = arrayOf<String>("Kursat","Emir","Ali","Atakan","Baran","Mert")
        //Adapter oluşturduk ve onuda RecyclerView'ımıza bağladık.
        val adapter: RecylcerCustomAdapter = RecylcerCustomAdapter(isimler,this@MainActivity)
        recyclerView.adapter = adapter
    }
}



