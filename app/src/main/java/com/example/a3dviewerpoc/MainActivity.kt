package com.example.a3dviewerpoc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
        val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
            .appendQueryParameter(
                "file",
                "https://raw.githubusercontent.com/SartiMau/POC3DObjects/main/house_obj.gltf"
//                "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Avocado/glTF/Avocado.gltf"
            )
            .appendQueryParameter("mode", "3d_only")
            .build()
        sceneViewerIntent.data = intentUri
        sceneViewerIntent.setPackage("com.google.ar.core") // AR-Core app
//        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox") // Google app
        startActivity(sceneViewerIntent)
    }
}
