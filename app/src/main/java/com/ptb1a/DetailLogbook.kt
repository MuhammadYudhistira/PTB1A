package com.ptb1a
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.ptb1a.databinding.ActivityDetailLogbookBinding

lateinit var binding: ActivityDetailLogbookBinding

class DetailLogbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.namaDetailLogbook.text = intent.getStringExtra("Nama")
        binding.nimDetailLogbook.text = intent.getStringExtra("Nim")
        binding.tempatDetailLogbook.text = intent.getStringExtra("Tempat")
        binding.tanggalDetailLogbook.text = intent.getStringExtra("Tanggal")
        binding.tvCatatan.text = intent.getStringExtra("Catatan")

        val getRespon = intent.getStringExtra("Respon") //getting the Respon, can be used with just intent
        binding.tvRespon.text = getRespon
    }


    private fun createNotificationChannel() {

        val CHANNEL_ID = "Detail Logbook"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.ChannelLogbook)
            val descriptionText = "Channel Detail Logbook"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, DetailLogbook::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_username)
            .setContentTitle("New Logbook From "+binding.namaDetailLogbook.text)
            .setContentText(binding.tvCatatan.text)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(12312, builder.build())
        }
    }



    fun ResponClicked(view: View) {

        val Nama = binding.namaDetailLogbook.text.toString()
        val Nim = binding.nimDetailLogbook.text.toString()
        val Tempat = binding.tempatDetailLogbook.text.toString()
        val Tanggal = binding.tanggalDetailLogbook.text.toString()
        val Catatan = binding.tvCatatan.text.toString()
        val addRespon = Intent(this, Respon::class.java )
        addRespon.putExtra("Nama",Nama)
        addRespon.putExtra("Nim",Nim)
        addRespon.putExtra("Tempat",Tempat)
        addRespon.putExtra("Tanggal",Tanggal)
        addRespon.putExtra("Catatan",Catatan)
        startActivity(addRespon)

        createNotificationChannel()
    }
}