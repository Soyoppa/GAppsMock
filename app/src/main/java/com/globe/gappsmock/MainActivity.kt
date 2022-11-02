package com.globe.gappsmock


import androidx.fragment.app.commit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.replace


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnActivities : Button = findViewById(R.id.btnActivities)
        val btnBuilding : Button = findViewById(R.id.btnBuilding)
        val btnHealthCheck : Button = findViewById(R.id.btnHealthCheck)
        val btnApproval : Button = findViewById(R.id.btnApproval)

        btnActivities.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                supportFragmentManager.commit {
                    replace<ActivitiesFragment>(R.id.fragmentContainerView4)
                    setReorderingAllowed(true)
                    addToBackStack("name") // name can be null
                }
            }
        })

        btnBuilding.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                supportFragmentManager.commit {
                    replace<BuildingFragment>(R.id.fragmentContainerView4)
                    setReorderingAllowed(true)
                    addToBackStack("name") // name can be null
                }
            }
        })

        btnHealthCheck.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                supportFragmentManager.commit {
                    replace<HealthCheckFragment>(R.id.fragmentContainerView4)
                    setReorderingAllowed(true)
                    addToBackStack("name") // name can be null
                }
            }
        })

        btnApproval.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                supportFragmentManager.commit {
                    replace<ApprovalFragment>(R.id.fragmentContainerView4)
                    setReorderingAllowed(true)
                    addToBackStack("name") // name can be null
                }
            }
        })
    }
}