package com.ozlem.usernamestorage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
// MainActivity ve XML arasındaki senkronizasyonu sağlamak için:
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // SharedPreferences'ı onCreate'te tanımladım ama onCreate dışında bir fonksiyondan ulaşmam lazım
    // Bu aşamada 2 farklı şey yapabilirim:
    // 1):
    // (var sharedPreferences : SharedPreferences? = null) şeklinde nullable tanımlayıp null'a eşitleyebilirim
    // 2): lateinit(geç initialize): Bir obje tanımladık ama değerini sonradan atayacağız demektir.
    lateinit var sharedPreferences : SharedPreferences

    // alınan kullanıcı adı:
    // string nullable şeklinde tanımlayıp null'a eşitleyelim:
    var getUsername : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SharedPreferences oluşturmak:
        // this. dediğimizde karşımıza daha önce görmediğimiz MainActivity'den çalıştırılabilen fonksiyonlar çıkıyor.
        // getSharedPreferences bizden iki parametre ister.
        // 1) SharedPreferences xml'imizin ismi, 2) SharedPreferences xml'imizin modu
        // isim olarak istediğimiz şeyi verebiliriz.
        // ama daha sonra farklı dosyalarla karışmasın diye paket ismimizle açmamız önerilir.
        // Mod olarak genelde MODE_PRIVATE kullanılır
        // MODE_PRIVATE: oluşturacağım bu dosya sadece benim uygulamam tarafından kullanılabilir.
        sharedPreferences = this.getSharedPreferences("com.ozlem.usernamestorage", Context.MODE_PRIVATE)

        // kaydedilen veriyi alalım:
        // getString 1. parametre olarak 68. satırda belirlediğimiz key
        // 2. parametre ise verdiğim key'den bir şey çıkmazsa ya da öyle bir değer yoksa ne yapacağı (boş bıraksın dedik)
        // getString fonksiyonu bize String nullable döndürür
        // Bu durumda !! ekleyebilirim ya da getUsername'i String nullable olarak tanımlayabilirim
        // Bu durumda !! eklemek güvevnli olmaz çünkü null gelirse uygulama çöker.
        // Bu yüzden getUsername'i String nullable yapalım.
        getUsername = sharedPreferences.getString("userKey","")

        if(getUsername != null){
            textViewID.text = "Registered Username: ${getUsername}"
        }
    }

    fun onClickSaveButton(view : View){

        // Girilen değeri alıp string'e çevirelim:
        val username = plainTextUserNameID.text.toString()
        // Şimdi aldığımız değeri SharedPreferences'ımıza kaydedelim:
        // kullanıcı input olarak bir şey girmediyse username boş olabilir ve biz bu durumda boş bir şeyi kaydederiz.
        // Bu yüzden önce boş mu diye kontrol edelim:
        if(username == ""){
            Toast.makeText(this , "Please enter a value" , Toast.LENGTH_LONG).show()
        }else{
            // Değeri kaydedelim:
            // SharedPreferences HashMap'e  çok benzer bir yapıdır.
            // Eğer değer almıyorsam ve SharedPreferences XML'inin içinde değişiiklik yapacaksam edit() ile başlarım:
            // putString 2 parametre ister: 1) key 2) value
            // apply() edit'i sonlandırır
            sharedPreferences.edit().putString("userKey",username).apply()
            // kaydetme işlemini tamamladık.
            textViewID.text = "Registered Username: ${username}"

            // Eğer uygulamayı kapatığ baştan açarsak kaydettiğimiz verinin gittiğini göreceğiz.
            // Fakat veri cihazda bir yere kaydedildi.
            // Bu yüzden veriyi onCreate'te almalıyız.
        }

    }

    fun onClickDeleteButton(view : View){
        // Kaydedilen bir veriyi silmeden önce böyle bir veri var mı diye kontrol etmeliyiz:

        getUsername = sharedPreferences.getString("userKey","")
        // null değilse işlemlerimizi yapalım:
        if(getUsername != null){
            // Sileceğimiz için önce textView'un içini boşaltalım:
            textViewID.text = "Registered Username: "
            // şimdi silelim (sadece textView'dan değil sharedPreferences'tanda sildik):
            // edit'le başlıyoruz çünkü değişiklik yapıyoruz:
            // remove veriyi kaydettiğimiz key'i parametre olarak alır:
            sharedPreferences.edit().remove("userKey").apply()
        }
    }

}