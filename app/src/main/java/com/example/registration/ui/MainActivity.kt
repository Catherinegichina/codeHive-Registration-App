package com.example.registration.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.registration.API.ApiClient
import com.example.registration.API.ApiInterface
import com.example.registration.Models.RegistrationRequest
import com.example.registration.Models.RegistrationResponse
import com.example.registration.R
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.viewmodel.UserViewModel
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
//    lateinit var etName: EditText
//    lateinit var etDob: EditText
//    lateinit var etPassword: EditText
//    lateinit var etEmail: EditText
//    lateinit var etPhoneNumber: EditText
//    lateinit var btnRegister: Button
//    lateinit var spNationality: Spinner
    lateinit var binding:ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        castViews()
//        clickRegister()
    }
    override fun onResume(){
        super.onResume()
        binding.btnRegisterLbl.setOnClickListener{
            var registrationRequest=RegistrationRequest(
                name=binding.tvname.text.toString(),
                phoneNumber = binding.etPhoneNumber.text.toString(),
                email = binding.tvemail.text.toString(),
                dateOfBirth = binding.etdOB.text.toString(),
                password =binding.tvpassword.text.toString(),
                nationality = binding.spNationality.selectedItem.toString(),
//                name=binding.etName.text.toString()
//                nationality=binding.spNationality.selectedItem.toString(),
            )
            userViewModel.registerUser(registrationRequest)
        }
            userViewModel.registrationLiveData.observe(this,{registrationResponse->
                if(!registrationResponse.studentId.isNullOrEmpty()){
                    Toast.makeText(baseContext,"Registration successful",Toast.LENGTH_LONG).show()
                }
            })
        userViewModel.registrationFailedLiveData.observe(this,{ error ->
            Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
        })

    }}
data class ApiError(var errors:List<String>)
//ERROR:LINE 57

//    fun castViews() {
//        etName = findViewById(R.id.etName)
//        etDob = findViewById(R.id.etDob)
//        etPhoneNumber = findViewById(R.id.etPhoneNumber)
//        etEmail = findViewById(R.id.etEmail)
//        etPassword = findViewById(R.id.etPassword)
//        btnRegister = findViewById(R.id.btnRegisterLbl)
//        spNationality = findViewById(R.id.spNationality)
//        val nationalities = arrayOf("KENYAN", "RWANDAN", "SOUTH SUDAN", "UGANDAN")
//        var adapter =
//            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationalities)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = adapter
//    }
//
//    fun clickRegister() {
//        var error = false
//        btnRegister.setOnClickListener {
//            var name = etName.text.toString() //validation
//            if (name.isEmpty()) {
//                error = true
//                etName.setError("Name is required")
//            }
//            var dob = etDob.text.toString()
//            if (dob.isEmpty()) {
//                error = true
//                etDob.setError("Dob is required")
//            }
//            var nationality = spNationality.selectedItem.toString()
//
//            var password = etPassword.text.toString()
//            if (password.isEmpty()) {
//                error = true
//                etPassword.setError("Password required")
//            }
//            var email = etEmail.text.toString()
//            if (email.isEmpty()) {
//                error = true
//                etEmail.setError("Email required")
//            }
//            var phoneNumber = etPhoneNumber.text.toString()
//            if (phoneNumber.isEmpty()) {
//                error = true
//                etPhoneNumber.setError("PhoneNumber required")
//            }
//
//            var registrationRequest = RegistrationRequest(
//                name = name,
//                phoneNumber = phoneNumber,
//                email = email,
//                nationality = nationality,
//                dateOfBirth = dob,
//                password = password
//            )
//
//            var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.registerStudent(registrationRequest)
//            request.enqueue(object : Callback<RegistrationResponse?> {
//                override fun onResponse(
//                    call: retrofit2.Call<RegistrationResponse?>,
//                    response: Response<RegistrationResponse?>
//                ) {
//                    if (response.isSuccessful) {
////                      var posts = response.body()
//                        Toast.makeText(
//                            baseContext,
//                            "Registration Successful",
//                            Toast.LENGTH_LONG
//                        ).show()
//                        var intent = Intent(baseContext, LoginActivity::class.java)
//                        startActivity(intent)
//
//                    } else {
//                        try {
//                            val error = JSONObject(response.errorBody()!!.string())
//                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
//                                .show()
//                        } catch (e: Exception) {
//                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
//                        }
//                    }
//                }
//
//                override fun onFailure(
//                    call: retrofit2.Call<RegistrationResponse?>,
//                    t: Throwable
//                ) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//            })
//        }
//        data class ApiError(var errors: List<String>)
//
//    }
//}