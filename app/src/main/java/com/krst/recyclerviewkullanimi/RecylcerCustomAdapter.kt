package com.krst.recyclerviewkullanimi

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*
import kotlin.coroutines.coroutineContext

class RecylcerCustomAdapter(val isim_listesi : Array<String>,val cntx:Context) : RecyclerView.Adapter<RecylcerCustomAdapter.holder>() {

    // Buraya layout'ta bulunan tüm elemanları erişmemizi sağlayacak kodları giriyoruz.
    // Viewholder aslında bizim UI tutucumuz.

    class holder(view:View) : RecyclerView.ViewHolder(view){
        //Buraya argüman olarak girilen view objesi aşağıda ilk metodta oluşturacağımız view'dır. Bu view aslında layout'un yani XML'in Kotlinde view objesine dönüştürülmüş halidir.
        //Biz aşağıda aslında view objesi içerisinde bulunan elemanları ayrıştırdık.

        val baslik_alani = view.textView // row_item.xml içerisinde bulunan textView objemizin ID'si.
        val buton = view.button // // row_item.xml içerisinde bulunan buton objemizin ID'si.
    }


    // Bu metodu LayoutManager çağırır.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        // Burası eleman oluşturmamız gerektiğinde kullanılır. Geri dönüş olarak bizim oluşturduğumuz ViewHolder objesi döndürür.

        //Burada yapmamız gerek oluşturduğumuz layout objesini yani ITEM görünümünü yani XML dosyamızı View objesine dönüştürmeliyiz.
        // Bunu yapmak için LayoutInflater sınıfını kullanıyoruz. Bu sınıf XML'i view objesine dönüştürür ve bize view objesini döndürür.
        // Daha fazla bilgi için => https://developer.android.com/reference/android/view/LayoutInflater?hl=en
        val yeni_view_objesi = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false) //Böylece XML'i view objesine dönüştürdük.
        return holder(yeni_view_objesi)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        // Burada ise yukarıda oluşturduğumuz viewholder içerisindeki elemanlara erişip bilgileri gireceğiz.
        // Layoutmanager holder parametresi olarak birinci metodta oluşturduğu ViewHolder objesini verir.
        // Yani parametre olan holder değişkeni aslında önceki metodta oluşturduğumuz yeni holder objesini göstermekte.
        // Burada yapacaklarımız:
        // 1- Bir diziden isimleri çekeceğiz ve onları TextView objesine atacağız. Bunun için adapter classımıza isim_liste adında bir array parametresi tanımladık.
        // 2- Butonların her birine mesaj yazdırtacağız.

        //position: Bu metodu LayoutManager çağırır ve çağırdığında poisiton argümanı olarak üzerinde çalıştığımız ITEM'ın index numarasını verir. Böylece 0. eleman, isim_liste'nin 0. elemanı ile eşleşiyor vs.

        holder.baslik_alani.text = isim_listesi[position].toString()

        holder.buton.setOnClickListener {
            println("Welcome ${holder.baslik_alani.text}")
        }

    }

    override fun getItemCount(): Int {
       // Burada toplam eleman sayısını döndüreceğiz.
        return isim_listesi.size
    }



}