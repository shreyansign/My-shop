package com.example.kotlinshop

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot

class FirebaseRepo{

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    //Auth
    fun getUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    fun getshoplist(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("shop list")
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
    }
}