package com.example.kotlinshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_storelist.*

private const val TAG: String = "HOMEPAGE_LOG"

class Storelist: AppCompatActivity() {

    private val firebaseRepo: FirebaseRepo = FirebaseRepo()

    private var shoplist: List<PostModel> = ArrayList()
    private val shoplistAdapter: ShoplistAdapter = ShoplistAdapter(shoplist)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storelist)

        //check user
        if (firebaseRepo.getUser() == null){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()

        }else{
            //user logged in
            loadstorelist()
        }

        //init recycler view
        storelist.layoutManager = LinearLayoutManager(this)
        storelist.adapter = shoplistAdapter


    }

    private fun loadstorelist(){
        firebaseRepo.getshoplist().addOnCompleteListener {
            if(it.isSuccessful){
                shoplist  = it.result!!.toObjects(PostModel::class.java)
                Log.d(TAG, "Error: ${shoplist.size}")
                shoplistAdapter.shoplistitem = shoplist
                shoplistAdapter.notifyDataSetChanged()
            }else{
                Log.d(TAG, "Error: ${it.exception!!.message}")
            }
        }


    }

}