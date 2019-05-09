package com.petrus.asus.sportrnd;

import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.firebase.client.Firebase;
//import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_feedback extends AppCompatActivity {
    EditText namedata,emaildata,messagedata;
    Button send_feedback,feedback_detail;
    private DatabaseReference mDatabase;
   // Firebase firebase;
//mantap
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        namedata = findViewById(R.id.namedata);
        emaildata = findViewById(R.id.emaildata);
        messagedata = findViewById(R.id.messagedata);

        send_feedback = findViewById(R.id.send_feedback);
        feedback_detail = findViewById(R.id.feedback_detail);
        //Firebase.setAndroidContext(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String UniqueID =
                Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
       // firebase= new Firebase("https://sportrnd-83f09.firebaseio.com"+UniqueID);
        send_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback_detail.setEnabled(true);
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();

                Feedback feedback = new Feedback(name, email, message);
                mDatabase.child("feedback").push().setValue(feedback).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(activity_feedback.this, "Sukses menambahkan feedback", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

//            Firebase child_name = firebase.child("Name");
//            child_name.setValue(name);
//
//            if (name.isEmpty()){
//                namedata.setError("This field!");
//                send_feedback.setEnabled(false);
//            }else{
//                namedata.setError(null);
//                send_feedback.setEnabled(true);
//            }
//
//            Firebase child_email = firebase.child("Email");
//            child_email.setValue(email);
//            if (email.isEmpty()){
//                emaildata.setError("This field!");
//                send_feedback.setEnabled(false);
//            }else{
//                emaildata.setError(null);
//                send_feedback.setEnabled(true);
//            }
//            Firebase child_message = firebase.child("Message");
//            child_message.setValue(message);
//            if (message.isEmpty()){
//                messagedata.setError("This field!");
//                send_feedback.setEnabled(false);
//            }else{
//                messagedata.setError(null);
//                send_feedback.setEnabled(true);
//            }
//            Toast.makeText(activity_feedback.this,"data terkirim",Toast.LENGTH_SHORT).show();
                feedback_detail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(activity_feedback.this)
                                .setTitle("send Detail:")
                                .setMessage("Name=" + name + "\n\nEmail "+email+"\n\nMessage="+message)
                                .show();
                    }
                });
            }
        });
    }
}

//“Bekerja keraslah, Bermimpilah lebih besar dan jadilah yang terbaik”
//
//        “Kebesaran sebenarnya dapat ditemukan dalam hal hal kecil yang terkadang kita lewatkan”
//
//        “Ketika kita memiliki satu sama lain, kita Memiliki segalanya”
//
//        “Apa yang akan Anda kerjakan, Ketika anda tahu anda tidak mungkin gagal”
//
//        “Sebuah perjalanan ribuan mil dimulai dari langkah kecil”
//        “Jika anda menghabiskan waktu untuk mencoba menjadi baik dalam segala hal, Anda tidak akan pernah menjadi hebat dalam apapun”
//
//        “Beberapa orang ingin sesuatu terjadi, beberapa orang berharap itu akan terjadi, yang lain mewujudkannya jadi kenyataan”
//
//        “Tunjukkan teman Anda, saya akan menunjukkan masa depan Anda”
//
//        “Hanya mereka yang berani mengambil resiko yang jauh pasti dapat menemukan Seberapa jauh seseorang dapat pergi”
//
//        “Sang juara percaya kepada dirinya sendiri bahkan ketika orang lain tidak percaya”
//
//
//
//        “Anda menghalangi impian anda ketika anda mengizinkan ketakutan Anda tumbuh lebih besar dari keyakinan anda”
//
//        “Orang tua saya bekerja terlalu keras untuk saya bukan supaya saya tidak hanya menjadi orang biasa tetapi menjadi orang luar biasa”
//
//        “Orang-orang yang mengikuti keramaian biasanya tersesat di dalamnya”
//
//        “Jangan menukar apa yang sangat anda inginkan untuk apa yang Anda ingin untuk saat ini”
//
//        “Ketika orang mengatakan anda sudah berubah sebenarnya itu hanya karena anda berhenti melakukan apa yang mereka ingin anda lakukan”
//
//
//
//        “Allah masih mencintai anda jika masih banyak cobaan dan tantangan hidup yang datang menghampiri anda. Allah percaya bahwa anda mampu melaluinya, maka jagalah kepercayaan itu”
//
//        “Berani mengambil keputusan maka anda telah melangkah 10 kali lebih cepat untuk sukses”
//
//        “Realitas kehidupan Anda adalah deskripsi dari jiwa dan pikiran anda”
//
//        “Setiap waktu yang anda lewati dengan sia-sia hanya menjauhkan anda dan semakin jauh dari kata sukses”
//
//        “Keputusan yang baik diperoleh dari pengalaman, dan pengalaman didapat dari keputusan yang buruk”
//
//
//
//        “Jangan Menunggu hari yang terbaik untuk melangkah karena setiap hari sangatlah berharga”
//
//        “Keberuntungan adalah saat kesempatan datang, anda telah matang dengan segala persiapan”
//
//        “Anda saat ini adalah hasil dari pengalaman anda”
//
//        Kata kata Motivasi Hidup
//        “Kegagalan ada bukan untuk ditakuti tetapi untuk dipelajari”
//
//        “Jika Allah yang menjadi alasan anda untuk hidup maka takkan pernah ada alasan untuk menyerah”
//
//        “Jangan pernah membuat keputusan yang permanen untuk perasaan yang sementara”
//
//        “Diam adalah respon terbaik untuk orang bodoh”
//
//        “Guru terbaik kamu adalah kesalahan terakhir yang kamu lakukan”
//
//        “Suatu saat aku akan menjadi tempat yang akan selalu kau rindu”
//
//        “Bintang pun tak kan bersinar tanpa kegelapan”
//
//
//
//        “Jika hari ini sudah sempurna maka Apalah arti hari esok”
//
//        “Bekerjalah seolah kamu tak butuh uang, Cintailah seolah Kamu takkan Tersakiti dan menarilah seakan tak ada yang melihatmu”
//
//        “Lakukanlah apa yang paling kamu takutkan dalam hidupmu”
//
//        “Menjadi dewasa dan bijak diawali dengan menjadi muda dan bodoh”
//
//        “Dengan sikap yang akan menentukan siapa yang akan bertahan dalam hidupmu”
//
//
//
//        “Hati yang memutuskan siapa yang kamu inginkan dalam hidup ini”
//
//        “Waktu yang memutuskan Dengan siapa kamu akan berjumpa”
//
//        “Lakukan sesuatu hari ini yang akan membuat dirimu berterima kasih di hari-hari mendatang”
//
//        “Lebih baik sendiri daripada bersama dengan orang yang salah”
//
//        “Betapapun jauhnya air mengalir ia takkan pernah lupa hulunya”
//
//
//
//        “Kesalahan adalah bukti bahwa kamu sedang mencoba”
//
//        “Mengetahui tidaklah cukup kita harus melakukannya, keinginan tak cukup hanya dengan berangan kita harus melakukannya”
//
//        “Kecantikan akan mengundang perhatian sikap santun memikat Kalbu”
//
//        “Sayangilah dia walau tidak sesempurna seperti yang kau inginkan”
//
//        “Kita mungkin terpisah sejak lama ketika tak mampu belajar untuk lebih dewasa”
//
//
//
//        “Satu ons tindakan sama berharganya dengan satu ton teori”
//
//        “Berilah perhatian lebih ke orang yang kamu sayangi, itu yang mereka butuhkan”
//
//        “Dalam hidup ini banyak orang tahu apa yang harus dilakukan, tetapi hanya sedikit yang melakukan apa yang ia ketahui. Mengetahui tidaklah cukup, Anda harus mengambil tindakan”
//
//        “Ketika cinta itu dipertahankan kamu akan tau siapa yang lebih menghargai tentang sebuah hubungan”
//
//        “Menangis dapat melepaskan tambahan hormon stress, itulah mengapa kita sehabis menangis merasa lebih baik”
//
//
//
//        Kata kata Motivasi Diri
//        “Pergilah sejauh mungkin dan ketika anda tiba di sana anda akan melihat lebih jauh lagi”
//
//        “Allah, aku tahu bahwa saat aku kehilangan sesuatu engkau sedang mempersiapkan hal yang lebih baik untukku”
//
//        “Anda tidak dapat mengubah masa lalu anda dan janganlah terlalu khawatir dengan hari esok .Hari ini adalah hari yang dapat mengubah masa depan Anda”
//
//        “Saya berpikir bahwa ada suatu hal yang lebih penting daripada sekedar percaya, tindakan Dunia ini penuh dengan pemimpi ,tidaklah banyak orang yang berani maju ke depan dan Mulai mengambil langkah pasti untuk mewujudkan visi mereka”
//
//        “Hari ini adalah hari pertama dalam hidup anda. Buatlah hari ini menjadi hari yang terbaik sepanjang hidup anda dan semoga hari esok matahari bersinar dengan terang”
//
//        “Takut akan kegagalan seharusnya tidak menjadi alasan untuk tidak mencoba sesuatu”
//
//        “Tragedi dalam kehidupan ini bukanlah yang berakhir terlalu cepat, tetapi kita menunggu terlalu lama untuk memulainya”
//
//        “Kehidupan yang besar dimulai dari mimpi yang besar”
//
//        “Menjadi tua itu pasti menjadi dewasa itu pilihan”
//
//        “Tidak ada kata gagal yang ada hanya sukses atau perlu belajar lagi sampai berhasil”
//
//        “dalam takut yang tampak adalah hambatan, dalam yakin yang tampak adalah kesempatan”
//
//        “Seorang pemberani bukan orang yang tidak mempunyai rasa takut .Tapi orang yang mampu berjalan diatas rasa takutnya”
//
//        “Ketika situasi di sekolah Anda tidak menyenangkan. Di saat itulah sebenarnya karakter anda sedang dibentuk”
//
//        “Tangkap peluang kerja kan selesaikan”
//
//        “1000 perkataan dan pengetahuan tidak berarti tanpa adanya satu tindakan yang nyata”
//“Kebahagiaan dimulai dengan ketulusan”
//
//        “Jangan mengharapkan sesuatu yang luar biasa jika anda hanya mau melakukan hal yang biasa saja”
//
//        “Bersyukur adalah cara ampuh untuk meraih energi yang dahsyat, Sudahkah anda bersyukur hari ini”
//
//        “Kualitas pikiran anda menentukan kualitas kehidupan anda”
//
//        “Orang optimis dapat melihat peluang dalam masalah, orang pesimis akan melihat masalah dalam peluang”
//
//        “Keajaiban itu nyata bagi mereka yang yakin berserah diri dan bekerja keras”
//
//        Kata kata Motivasi Semangat
//        “Allah tidak membenci orang malas, tapi Allah mengizinkan orang rajin mengambil rezeki orang malas”
//
//        “90% dari kegagalan berasal dari orang-orang yang memiliki kebiasaan membuat alasan-alasan”
//
//        “Untuk meraih apa yang benar-benar anda inginkan fokus saja tidak cukup. Anda harus memiliki rasa lapar untuk meraihnya”
//
//        “Lihat ke atas agar terinspirasi lihat ke bawah agar bersyukur”
//
//
//
//        “Lihatlah tantangan sebagai ujian dan lihatlah masalah Sebagai teguran”
//
//        “Menang atau kalah lakukanlah dengan jujur”
//
//        “Hujan tidak hanya datang sendirian Ia datang bersama kesejukan, hal buruk tidak datang sendirian ia datang bersama pembelajaran”
//
//        “Orang yang berhenti belajar akan menjadi pemilik masa lalu, orang yang terus belajar akan menjadi pemilik masa depan”
//
//        “Disiplin memang tidak mudah tapi tanpa kedisiplinan hidup anda akan jauh lebih sulit”
//
//        “Jenius adalah 1 inspirasi dan 99 keringat tidak ada yang dapat menggantikan kerja keras”
//
//        “Memaafkan orang lain bagai Menyiram air Bara dendam di hati baik untuk kesehatan kita”
//
//        “Pemenang sejati selalu memberikan 100% upayanya, bahkan ketika tidak seorang pun melihatnya”
//
//        “Diam belum tentu menyelesaikan masalah tapi setidaknya tidak membesarkan masalah”
//
//        “Kesalahan dan kegagalan adalah guru terbaik jika kita mau jujur mengakui dan belajar darinya”
//
//
//
//        “Kesulitan adalah hujan terbaik untuk menunjukkan kualitas diri yang sebenarnya”
//
//        “Dahulukan Allah dalam setiap langkah hidupmu maka semuanya akan ditambahkan kepadamu”
//
//        “Jangan takut menghadapi masa depan, hadapi dan perjuangkanlah”
//
//        “Langkah pertama yang diperlukan untuk mendapatkan hal yang anda inginkan adalah memutuskan apa yang anda inginkan”
//
//        “Kegagalan terbesar adalah ketika tidak berani mencoba”
//
//        “Sakit dalam perjuangan itu hanya berlangsung sementara, namun jika anda menyerah rasa sakit itu akan terasa selamanya”
//
//        “Kerja keras dan kerja cerdas dapat memastikan keberhasilan dan sedekah dapat memudahkannya”
//
//        “Lebih baik menjadi raja tikus daripada ekor naga”
//
//        “Suka belajar, suka jualan, hidup hemat, beli aset suka, sedekah adalah 5 resep Makmur”
//
//        “Bekerjalah dengan ikhlas karena bekerja tanpa paksaan akan memberi hasil maksimal”
//
//        “Pengaruh perkataan orang kepada anda 100% adalah atas izin anda sendiri”
//
//        Kata kata Motivasi Kehidupan
//        “Mulailah dengan yang kecil, Kerjakanlah dengan cara yang besar adalah dengan cara yang benar”
//
//        “Jangan biarkan impianmu dijajah oleh pendapat orang lain”
//
//        “bila ingin hasil yang besar jangan kerjakan hal yang mudah saja”
//
//        “Hati yang sedang panas menumpulkan logika dinginkan terlebih dahulu sebelum mengambil keputusan”
//
//        “Yang menyedihkan bukanlah bidikan yang meleset tapi bidikan tanpa target”
//
//        “Lari dari masalah akan membuat masalah menjadi lebih besar, menghadapinya akan membuat anda menjadi lebih besar”
//
//        “Jika selamanya anda bermain aman, selamanya juga Anda di tempat yang sama”
//
//        “Menabung itu hanya untuk mempertahankan kekayaan, untuk meningkatkannya berinvestasilah”
//
//        “Ada saatnya dimana kekalahan rasa manis yaitu Saat anda sudah melakukan yang terbaik”
//
//        “Siapa yang bisa menerima kelemahannya sesungguhnya baru saja menambah satu kelebihan pada dirinya”
//
//        “Hidup ini sederhana terkadang pikiran manusia yang membuatnya rumit”
//
//        “Cemas yang berlebihan tidak akan mengubah apapun kecuali merusak diri sendiri”
//
//        “Cinta akan membuat kita menjadi orang terkaya di dunia, oleh karena itu mulailah mencintai”
//
//        “pikiran negatif sangat berkuasa bila diberi kesempatan, jadi jangan memberinya kesempatan”
//
//        “Mengeluh itu sisi lain dari pemborosan, pemborosan waktu dan energy”
//
//        “Bukan banyaknya panah yang menentukan kemenangan tapi tajam panah dan tujuannya yang menentukan”
//
//        “Allah tidak pernah terlambat ia akan menunjukkan kuasanya, pada detik terakhir sekalipun”
//
//        “Saat orang lain melakukan impianmu itu berarti mereka belum mampu melihat sejauh anda melihat”
//
//        “Segala sesuatu masalah yang menimpa Anda tidak akan pernah melatih kekuatan anda untuk menyelesaikannya”
//
//        “Orang yang tidak belajar dari kegagalan adalah orang yang gagal sesungguhnya”
//
//        “Katakan bisa pasti bisa dengan penuh keyakinan otak kita akan segera mencari solusi”
//
//        “Sukses seringkali datang pada mereka yang berani bertindak dan jarang menghampiri pada mereka yang dikalahkan ketakutan”
//
//        “Tidak ada harga untuk waktu, tetapi waktu sangat berharga”
//
//        “Tidak semua usaha kita dibayar oleh manusia, tapi Allah akan membayarnya kelak”
//
//        “Semua yang terlalu sedikit dan terlalu banyak tidak akan membawa kebaikan”
//
//        “Respon kita terhadap masalah menentukan kualitas berita fokus pada solusi”
//
//        Motivasi Kehidupan
//        “orang yang paling Bahagia bukanlah orang yang punya hal-hal terbaik tapi orang yang bisa menjadikan hal-hal yang ia punya menjadi yang terbaik”
//
//        “Apapun yang terjadi Yakinlah bahwa Allah menginginkan kita akan jadi lebih baik karena Kejadian ini”
//
//        “goal hanya sekedar goal kalau kita tidak mempunyai alasan yang kuat Mengapa kita harus mencapainya”
//
//        “rasa syukur membuat kita tidak pernah merasa kekurangan”
//
//        “Sukses dimulai dengan melakukan apa yang harus dilakukan”
//
//        “Rezeki itu ditangan Allah yang kita lakukan hanya berusaha semaksimal mungkin dan menyerahkan hasilnya kepada yang kuasa”
//
//        “lari dari masalah bukanlah penyelesaian masalah, hadapi dan Belajarlah dari masalah itu”
//
//        “Saat semua jalan tertutup. Buatlah jalan dan berserahlah kepada Allah”
//
//        “Jaga terus Api Harapan Anda seperti menjaga hidup anda sendiri”
//
//        “cepat atau lambat mereka yang menang adalah mereka yang berfikir dan yakin bahwa mereka bisa”
//
//        “Keuletan adalah tanda jadi kesuksesan”
//
//        “Orang tua bukan hanya punya kekuatan untuk menatap juga untuk mengalah”
//
//        “Tidak perlu keahlian khusus untuk mencari musuh, tapi perlu kesetiaan untuk mempertahankan teman”
//
//        “Tetap Bertahan dan setia pada tujuan saat menghadapi Hambatan adalah kunci kesuksesan”
//
//        “Mengeluh adalah cara paling buruk dalam menyelesaikan masalah”
//
//        “Jika ada hari buruk maka pasti akan hari ada hari baik tugas kita adalah terus bergerak maju”
//
//        “Asal percaya dengan sungguh-sungguh apapun keyakinan Anda dapat menjadi kenyataan”
//
//        “Kematian tidak dapat mengubur perbuatan baik seseorang”
//
//        “sebuah masalah merupakan kesempatan bagi anda untuk mengeluarkan kemampuan terbaik anda”
//
//        “Malas adalah kemenangan saat ini dan kekalahan di masa nanti”
//
//        “Nilai manusia ditentukan bukan dari apa yang diperoleh melainkan apa yang telah diberikan”
//
//        “masa depan kita tergantung pada apa yang kita lakukan pada saat ini. Maka jangan sia-siakan waktumu sekarang”
//
//        “bertahan saja tidak cukup anda perlu bereaksi terhadap tekanan dan merubah keadaan”
//
//        “Anda tidak akan mengubah kehidupan sampai anda mengubah Apa yang anda lakukan setiap hari”
//
//        Kata Motivasi
//        “Orang hebat membicarakan ide, orang menengah membicarakan pengalaman, orang lemah membicarakan orang lain”
//
//        “Orang pintar itu biasa orang hebat itu luar biasa tapi orang berani lah pemenangnya”
//
//        “hidup seseorang telah ditebak, tapi Nasib orang malas mudah untuk ditebak”
//
//        “Saat kita merasa hebat kita baru saja kehilangan separuh pangkat kita karena lengah untuk terus belajar”
//
//        “lewat kesulitan lah manusia belajar, lewatnya kenyamanan lah manusia Terlena”
//
//        “berusaha dan gagal Ternyata jauh lebih melegakan daripada pasrah melihat ke kanan dengan tangan terlipat”
//
//        “atasan hanya memberikan tugas berat pada karyawan terbaik, Allah hanya memberikan ujian pada pada manusia terbaik”
//
//        “Kadang cara terbaik untuk Memanfaatkan peluang adalah dengan mengatakan tidak pada peluang baru dan fokus mengembangkan apa yang sudah ada di tangan”
//
//        “jangan takut karena masalah yang anda hadapi tidak lebih besar dari jalan keluarnya, Allah siapkan bagi anda”
//
//        “Ada saatnya penundaan memberikan keuntungan terutama saat terlalu emosi untuk mengambil keputusan”
//
//        “seseorang dapat berhasil dalam hampir segala hal Jika ia memiliki antusias yang tidak terbatas”
//
//        “Bicaralah secukupnya, lakukanlah semampunya. Jangan melakukan sebaliknya”
//
//        “seseorang tidak bisa sukses seringkali karena kurangnya keberanian untuk mencoba”
//
//        “terasa sakit selalu hampir tidak ada rasanya setelah apa yang kita perjuangkan tercapai”
//
//        “Tidak ada yang gagal mereka hanya berhenti terlalu cepat”
//
//        “Ada yang lebih berharga dari uang dan emas yaitu waktu”
//
//        “usia bisa berbohong tapi kedewasaan tidak”
//
//        “Impian, target, kemauan dan tujuan semuanya sia-sia tanpa tindakan”
//
//        “Kepercayaan tidak bisa dibeli, tapi kepercayaan bisa dipelihara”
//
//        “Jangan hanya tertarik dengan apa yang dicapai orang sukses, tanpa lelah juga dengan perjuangan yang mereka usahakan untuk mencapainya”
//
//        “uang tidak merusak seseorang keserakahan lah yang merusak manusia”
//
//        “sukses sering datang kepada orang yang berani bertindak sukses jarang datang kepada penakut yang tidak berani menerima konsekuensi”
//
//        “Keraguan bersahabat dekat dengan kegagalan”
//
//        “Sukses meninggalkan jejak, gagal meninggalkan pelajaran, diam meninggalkan penyesalan”
//
//        Kata Bijak Motivasi
//        “semua kemajuan tidak akan ada tanpa kesalahan, kesalahan adalah bagian dari kemajuan selama diakui dan diperbaiki”
//
//        “Sibuk bukanlah jaminan karir karena hasil jauh lebih didengar orang”
//
//        “Sahabat itu seperti bintang, tak selalu Nampak tetapi selalu ada dihati”
//
//        “Janganlah menunggu, tidak ada waktu yang tepat untuk memulai. Mulailah dari titik dimana anda berdiri dan kemampuan yang anda punyai, dan kemampuan yang lebih baik akan muncul di dalam perjalanan anda”
//
//        “Cintailah orang tua dengan sungguh-sungguh, karena cinta orang tua tak pernah menghadirkan air mata kesedihan”
//
//        “Orang mungkin ragu terhadap apayang anda katakan, tetapi mereka akan mempercayai apa yang anda lakukan”
//
//        “Jadilah diri sendiri, karena tidak ada yang bisa melakukan lebih baik dari diri kita sendiri”
//
//        “Selalu ada kegelapan yang tergelap sebelum terbitnya fajar”
//
//        “Belajarlah menikmati apa yang kamu miliki, itu akan membuat hidupmu lebih bernilai”
//
//        “Ketika semua hal tidak sejalan dengan anda, ingatlah bahwa sebuah pesawat terbang melawan angin, bukan dengan mengikuti angin”
//
//        “Kita tidak usah saling menyalahkan, agar dimasa depan tak ada yang menuntut akan kesalahan”
//
//        “Perbedaan antara pemain yang baik dan pemain yang hebat adalah, pemain hebat mencoba sekali lagi. Ketika setiap orang berfikir bahwa timnya kalah, mereka yang hebat masih tetap berusaha untuk menang”
//
//        “Hiduplah seperti kamu akan mati besok, dan berbahagialah seperti kamu akan hidup selamanya”
//
//        “Jika anda dapat menerima masa lalu tanpa penyesalah dan berani menghadapi masa depan tanpa rasa takut, hal ini berarti anda berada pada jalur yang tepat”
//
//        “Lamanya hidup seseorang diukur oleh hal manfaat yang telah dilakukannya, dan waktu adalah berlian bagi orang bijaksana”
//
//        “Bukannya saya pintar, hanyalah karena saya berusaha lebih lama lagi”
//
//        “Kebaikan adalah seorang yang matanya penuh perhatian, serta tangannya yang penuh manfaat”
//
//        “Nilai sebuah tindakan terletak dalam usaha menyelesaikan sampai tuntas”
//
//        “Jangan permainkan perasaan seseorang, jika memang tak ada rasa lebih baik jujur saja, jangan jadi alasa seseorang terluka”
//
//        Kata Motivasi Hidup
//        “Tidak ada jalan pintas yang dapat membawa anda ketempat yang berarti untuk dituju”
//
//        “Bermimpilah setinggi langit Jika kamu terjatuh kamu akan di antara ribuan bintang bintang”
//
//        “Kesempatan sering tidak dikenali oleh banyak orang karena ia berpenampilan seperti pekerjaan”
//
//        Berbagilah kepada orang lain seperti pelangi, bulan dan bintang yang membagi keindahannya kepada kita”
//
//        “Satu hal yang terpenting dalam hidup ini bukanlah terletak pada kemenangan, tetapi pada usaha meraihnya”
//
//        “Kalau kamu sayang sama seseorang dan tidak mau menerima resiko untuk jauh darinya jadikanlah dia sahabat”
//
//        “Kesabaran, sikap pantang menyerah dan kerja keras merupakan kombinasi sukses yang tak terkalahkan”
//
//        “Hanya bersama sahabat kita bisa melewati semua tantangan yang ada untuk mencapai suatu keberhasilan yang tertinggi”
//
//        “Tetesan yang terus-menerus pada akhirnya akan membuat lubang pada batu”
//
//        “Waktu yang terindah, disaat kalian sukses bersama sahabat sahabat kalian”
//
//        “Dengan talenta yang biasa-biasa saja dan daya tahan yang luar biasa semua hal dapat tercapai”
//
//        “Sahabat selalu saling mendukung walaupun harus berpisah sementara Demi meraih kesuksesan”
//
//        “Saya percaya dengan kekuatan dari kerja keras, Apakah itu menggunakan kepala atau tangan. Dunia ini tidak berhutang kepada siapapun, tetapi ia berutang kepada setiap orang yang memberikan kesempatan untuk hidup”
//
//        “Kadang kita diberikan rasa kesepian yang mendalam, agar kita dapat lebih menghargai Indahnya Kebersamaan”
//
//        “Kau tak seharusnya menjadi seperti sesu”atu yang terbuang, Yang Tersakiti. Meski kau yakini dia itu cinta sejati
//
//        “Berusaha untuk menggapai kesuksesan tanpa kerja keras, seperti mencoba mendapatkan hasil panen tanpa menanam”
//
//        “Jangan mencari kesalahan orang lain. tapi Carilah kebaikannya dan Ikutilah agar kamu bisa menjadi lebih baik”
//
//        “Saya tidak dapat membayangkan seseorang dapat mencapai kesuksesan tanpa memberikan segalanya yang ia punya”
//
//        “Tidak ada kata tidak mungkin kalau kita mengajarnya dengan kerja keras dan untaian doa”
//
//        “Sebesar apapun dan Sekuat apapun itu bisa dihancurkan, jika itu kehendak Allah Oleh karena itu jangan sombong”
//
//        Kata kata Bijak Motivasi
//        “Suatu hal yang lucu mengenai hidup ini, jika anda menolak untuk menerima selain yang terbaik seringkali anda akan mendapatkannya”
//
//        “Saya saya hari ini adalah karena pilihan-pilihan yang saya buat kemarin”
//
//        “Dalam kehidupan pasti ada rintangan, Jangan pernah takut untuk menghadapinya Jika kamu mau jadi orang yang lebih baik”
//
//        “Hidup ini dapat diibaratkan sebagai mesin penghancur raksasa. Apakah hidup akan menghancurkan Anda atau membentuk Anda, tergantung pada Terbuat dari apakah anda”
//
//        “Jangan terlalu mengharapkan seseorang, jika ia pergi kau hanya memiliki harapan kosong”
//
//        “Pemenang bukanlah mereka yang tidak pernah gagal, tetapi mereka yang tidak pernah menyerah”
//
//        “Jangan terlalu mempercayai seseorang dan jangan juga mencurigai seseorang berlebihan”
//
//        “Sukses besar esok hari dimulai dari tindakan-tindakan kecil hari ini”
//
//        “Apapun yang kita lakukan pasti memiliki dampak, tergantung dari kitanya ingin dampak yang baik atau yang buruk”
//
//        “Apapun yang dapat diterima dan dipercayai oleh pikiran-pikiran itu dapat mewujudkannya”
//
//        “Cobalah selalu berubah menjadi seseorang yang lebih baik”
//
//        “Dunia luar anda merupakan cermin dunia di dalam diri anda”
//
//        “Jika kalian menginginkan suatu hal janganlah terlalu berpikir. Tetapi hanya cukup memulainya dan melakukannya”
//
//        “Kita akan serupa dengan apa yang kita pikirkan sepanjang hari”
//
//        “Setiap orang pasti banyak mengalami kegagalan, hambatan, tantangan di dalam hidupnya. Sebenarnya dia Hampir mencapai tujuan yang diinginkan”
//
//        “Jika anda percaya bahwa anda mampu melakukan sesuatu atau anda percaya bahwa anda tidak mampu, dalam 2 hal itu anda mungkin benar”
//
//        Motivasi Diri
//        “Orang yang memiliki tekad yang kuat yang akan bisa melewati suatu rintangan dalam mencapai hal yang dia inginkan”
//
//        “Pikiran merupakan sumber dari segala kekayaan, segala kesuksesan, segala perolehan materi, segala penemuan dan segala pencapaian”
//
//        “Tanpa adanya suatu kemauan yang keras kalian tidak akan pernah mendapatkan hasil yang maksimal”
//
//        “Semua hal yang besar di dunia ini dilakukan oleh orang-orang yang tidak mengetahui bahwa hal tersebut mustahil untuk dilakukan”
//
//        “Sahabat adalah keluarga yang baru dan selalu ada buat kita”
//
//        “Apapun yang anda percaya dengan keyakinan akan menjadi kenyataan, keyakinan Anda sangatlah menentukan kenyataan hidup anda”
//
//        “Tidak ada orang yang berhasil tanpa melewati proses dan bantuan dari orang lain”
//
//        “Perdebatkan lah batas kemampuan anda dan sangat pasti itu menjadi batasan anda”
//
//        “Dalam hidup ini anda jarang mendapatkan apa yang anda inginkan, namun hampir selalu akan mendapatkan apa yang menjadi ekspektasi anda”
//
//        “Mungkinkah semua orang tahu apa itu suka sayang dan cinta Menurut kalian apa?”
//
//        “Disaat kita dapat menyelesaikan masalah, di saat itu juga derajat kita semakin meningkat dan harus siap dengan masalah berikutnya”
//
//        “Ketika kita benar-benar yakin bahwa kita mampu mencapai suatu target, Allah akan mengalirkan kekuatannya ke dalam darah kita, sehingga kita akan berpikir, berbicara dan bertindak layaknya kita sudah mencapainya”
//
//        “Semua terobosan terobosan pribadi bermula pada saat seseorang mengubah keyakinannya”
//
//        “Sebelum mencari orang yang sayang ama kamu, Carilah dulu mereka yang bisa sayang sama kedua orang tuamu”
//
//        “Ukuran kesuksesan Anda tergantung pada ukuran keyakinan anda”
//
//        “Satu-satunya hal yang memisahkan antara seseorang dengan apa yang ia inginkan dalam hidupnya seringkali hanyalah keinginan untuk mencoba dan keyakinan yang kuat bahwa hal itu dapat dicapai”
//
//        “Bukti terbaik bahwa suatu hal dapat dilakukan adalah ketika orang lain telah melakukannya”
//
//        “Terdapat hukum dalam ilmu psikologi yang menyatakan, bahwa jika anda membentuk suatu gambaran di pikiran anda mengenai apa yang akan terjadi dan Anda terus mengingat gambaran itu dalam kurun waktu yang panjang, anda akan segera menjadi apa yang anda pikirkan”
//
//        Kata kata Motivasi Untuk Diri Sendiri
//        “Tak seorang pun dapat mencapai kesuksesan tanpa kesediaan untuk berkorban”
//
//        “Jika anda mengubah pikiran anda, anda akan mengubah perasaan Anda. Hal ini akan membuat tindakan Anda berubah, hal ini pasti mengubah kehidupan anda”
//
//        “Kemiskinan dan kekayaan sama-sama hasil dari pemikiran”
//
//        “kegagalan atau kesuksesan Anda dimulai dari pikiran anda”
//
//        “Belajarlah tanggung jawab atas yang sudah dipercayakan untuk diselesaikan”
//
//        “Untuk sukses kenali tiga hal: diri Anda, apa yang harus anda lakukan dan bagaimana melakukannya”
//
//        “Tidak ada sesuatu yang baik ataupun jelek, tetapi pikiran lah yang membuatnya baik ataupun jelek”
//
//        “Untuk sukses sikap sama pentingnya dengan kemampuan”
//
//        “Pikiran itu sama halnya dengan parasut mereka hanya berguna ketika terbuka”
//
//        “Di dunia ini tidak ada masalah yang sulit bagi orang-orang yang punya kemauan”
//
//        “Apa yang Anda pikirkan mengenai diri anda jauh lebih penting daripada apa yang orang lain pikirkan mengenai anda”
//
//        “Imajinasi batasnya hanya ada dalam pikiran itu sendiri”
//
//        “Setiap kesuksesan datang dari keputusan untuk mencoba”
//
//        “Apa yang terjadi pada masa lalu adalah masalah-masalah kecil jika dibandingkan apa yang ada di dalam diri kita”
//
//        “Terus berjuang bergerak belajar dan bekerja, maka kesuksesan dan kemenangan sejati akan kita dapatkan”
//
//        “Beberapa orang memiliki beribu-ribu macam alasan mengapa mereka tidak mampu melakukan apa yang mereka ingin lakukan.Satu hal yang mereka butuhkan adalah satu alasan mengapa mereka mampu”
//
//        “Kehidupan manusia terbatas, maka ketahuilah nilai kehidupan yang pantas kita raih. Segera Tentukan pilihan rencanakan dan wujudkan”
//
//        “Salah satu penemuan paling hebat yang dilakukan manusia termasuk salah satu dari keterkejutan mereka. Yaitu menemukan bahwa ia mampu melakukan sesuatu yang pada awalnya ditakutkan tidak mampu untuk dilakukan”
//
//        “Saat menghadapi perubahan yang tak menentu Jangan Menunggu secara pasif, bahwa perubahan akan membaik kita hal yang harus bersikap optimis aktif dan penuh inisiatif”
//
//        “Belajarlah menggunakan kata tidak mungkin dengan sangat hati-hati”
//
//        “Jangan membatasi diri Anda. Kebanyakan orang membatasi diri mereka terhadap apa yang mereka pikir mampu mereka lakukan. Anda dapat terus maju sejauh batasan pikiran Anda, apa yang Anda yakini percayailah anda mampu mewujudkan nya”
//
//        Kata kata Motivasi Belajar
//        “Anda harus yakin dengan diri anda ketika tidak ada seorang pun yang yakin, itulah yang membuat anda menjadi seorang juara”
//
//        “Langkah yang tepat untuk pemula adalah berhenti berbicara dan mulailah melakukan”
//
//        “Kebahagiaan tidak bergantung pada siapa Anda atau apa yang Anda punyai, kebahagiaan tergantung pada Apa yang anda pikirkan”
//
//        “Lakukan yang terbaik dan buat orang menyukainya, maka anda telah selangkah lebih maju untuk sukses”
//
//        “Kesuksesan tidak mendatangi anda-anda yang harus mengejarnya”
//
//        “Terkadang Anda harus jatuh dulu agar tahu dimana dimana anda berpijak”
//
//        “Kejadian-kejadian dalam hidup kita bukanlah yang membuat hidup kita. Tetapi pikiran kita lah yang memberikan arti bagi setiap kejadian yang terjadi dalam hidup kita”
//
//        “Anda tak akan pernah menyesal jika telah mencoba”
//
//        “Pikiran kita hanya mampu menampung 1 pikiran dalam satu waktu. Buatlah ia positif dan konstruktif”
//
//        “Para pemenang mempunyai kebiasaan untuk menciptakan ekspektasi-ekspektasi positif sebelum hal itu terjadi”
//
//        “Anda mungkin harus memenangkan pertandingan lebih dari sekali untuk bisa disebut sebagai pemenang”
//
//        “Cikal bakal dari setiap kesuksesan berasal dari sebuah pikiran”
//
//        “Motivasi adalah hal yang mendorong anda untuk memulai dan kebiasaan adalah hal yang membuat Anda terus melakukannya”
//
//        “Anda mempengaruhi pikiran bawah sadar anda dengan pengulangan kata-kata”
//
//        “Setiap kemajuan dimulai saat Anda berani untuk meninggalkan zona nyaman”
//
//        “Perhatikanlah kata-kata Anda, perkataan itulah manifestasi sesungguhnya dari pikiran anda”
//
//        “Ketika anda keinginan maka anda kehilangan harapan, tanpa Harapan hidup hanya akan dipenuhi dengan omong kosong”
//
//        “Poin penting dari setiap permulaan adalah keinginan”
//
//        “Bukan dari ukuran besarnya anjing dalam pertandingan yang menentukan, tetapi ukuran Daya juang yang ada di dalam anjing itulah yang menentukan”
//
//        “Mulailah dari mana anda berada, gunakan apapun yang anda miliki. Dan Lakukan semampu anda”
//
//        “Begitu anda percaya, anda akan memicu kekuatan untuk mencari cara untuk menggapainya”
//
//        “Beranilah menjadi yang terbaik yang bisa anda lakukan”
//
//        “Tidak ada sesuatupun di dunia ini yang tidak dapat anda miliki, begitu Anda secara mental menerima fakta bahwa anda dapat memilikinya”
//
//        Kata kata Motivasi Sukses
//        “Ketika datang kegelapan maka Jadilah orang pertama yang menyinari dengan cahaya”
//
//        “siapa Anda hari ini adalah hasil pikiran anda kemarin, siapa Anda besok tergantung pada apa yang Anda pikirkan hari ini”
//
//        orang-orang akan menjadi sangat hebat ketika mereka berpikir bahwa mereka mampu melakukan sesuatu ketika mereka yakin akan dirinya mereka telah memiliki rahasia pertama dari kesuksesan
//
//        “Mereka sukses karena mereka pikir mereka mampu”
//
//        “Masa depan dimiliki oleh mereka yang percaya akan keindahan mimpi mereka”
//
//        “Percayalah dan ambilah tindakan seakan-akan hal tersebut tidak mungkin gagal”
//
//        “Semua impian anda akan menjadi kenyataan Jika Anda berani mengejarnya”
//
//        “Sikap yang positif tidaklah berguna apabila tidak disertai dengan tindakan-tindakan positif”
//
//        “Jika anda tidak menginginkan resiko maka anda hanya akan meraih yang biasa-biasa saja”
//
//        “kehidupan ini adalah 10% apa yang terjadi pada anda. Dan 90% bagaimana anda merespon kejadian itu”
//
//        “Sukses biasanya akan datang pada mereka yang terlalu sibuk mencarinya”
//
//        “Jangan bertanya apa yang terjadi jika sesuatu tidak berhasil, namun bertanyalah Apa yang terjadi jika berhasil”

//        “Orang pesimis mengeluh karena adanya angina, orang optimis berharap agar angin itu bisa hilang, seorang juara menutup mulutnya mengharapkan yang terbaik dan yang terpenting menyesuaikan layarnya”
