# BTK-UsernameStorage

## Kotlin İle Android Mobil Uygulama Geliştirme Eğitimi Temel Seviye (BTK AKADEMİ) Notlarım

## SharedPreferences Nedir?

> Küçük boyuttaki verilerimizi saklamak için SharedPreferences adında bir yapı var. 

> XML sadece arayüz oluşturmak için değil veri saklamak içinde kullanılıyor.

> SharedPreferences aslında bir XML yapısı. Biz bu yapıyı oluşturduğumuzda uygulamayı kullandığımız telefonun içindeki data dosyasında bir xml dosyası oluşturuluyor. Gerektiği zaman veri bu dosyadan okunuyor.

> SharedPreferences sadece key ve value eşleşmesini tutabiliyor.

> Eğer kaydetmemiz gereken  1000 tane verimiz varsa SharedPreferences uygun bir yapı değil. 

> SharedPreferences'ın tanımlama şekli diğer yapılara göre farklıdır çünkü SharedPreferences bir sınıf değil bir arayüzdür (interface).

> SharedPreferences'ı içinde bulunduğumuz context'ten oluştururuz.

> this. dediğimizde karşımıza daha önce görmediğimiz MainActivity'den çalıştırılabilen fonksiyonlar çıkıyor:

> getSharedPreferences() : SharedPreferences'ı al

> deleteSharedPreferences() : SharedPreferences'ı sil

> NOT: Hint ya da text farketmez girdiğimiz değer oraya bir şey yollandığında silinir.

> SharedPreferences'a veriyi .put ile koyup .get ile alıyoruz.

## lateinit (Geç Initialize) Nedir?

> Bir obje tanımladık ama değerini sonradan atayacağız demektir.

> Örneğin:

`lateinit var sharedPreferences : SharedPreferences` 

## Projenin Ekran Görüntüleri

![image](https://user-images.githubusercontent.com/109730490/182403500-fa573e07-176d-4d2d-a8be-541ce7fc9fe5.png)

- Hiçbir input girmeden "SAVE" butonuna basıldığında:

![image](https://user-images.githubusercontent.com/109730490/182403677-4b10038e-68df-4f73-9d3f-f92bdedd72da.png)

- Input girilip "SAVE" butonuna basıldığında:

![image](https://user-images.githubusercontent.com/109730490/182404066-3c13ea44-4cb9-416d-bee6-af2b655b5c37.png)

- "DELETE" butonuna basıldığında:

![image](https://user-images.githubusercontent.com/109730490/182404213-298f98cf-f1a2-44ca-8974-6209d01f8ebf.png)

## Kaynaklar

- [BTK Akademi](https://www.btkakademi.gov.tr/portal/course/kotlin-ile-android-mobil-uygulama-gelistirme-egitimi-temel-seviye-10274)
