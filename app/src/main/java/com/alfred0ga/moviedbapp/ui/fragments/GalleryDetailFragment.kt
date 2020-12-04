package com.alfred0ga.moviedbapp.ui.fragments

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.alfred0ga.moviedbapp.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.fragment_gallery_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class GalleryDetailFragment : Fragment(R.layout.fragment_gallery_detail) {
    private val args by navArgs<GalleryDetailFragmentArgs>()
    val imageRef = Firebase.storage.reference

    var curFile: Uri? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bitmap = BitmapFactory.decodeFile(args.path)
        ivImg.setImageBitmap(bitmap)

        btn_upload.setOnClickListener {
            Toast.makeText(context, "Succesfully uploaded image", Toast.LENGTH_SHORT).show()
            uploadImageToStorage("myImage")
        }
    }

    private fun uploadImageToStorage(fileName: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            curFile?.let {
                imageRef.child("images/$fileName").putFile(it).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Succesfully uploaded image", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Image not uploaded", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}