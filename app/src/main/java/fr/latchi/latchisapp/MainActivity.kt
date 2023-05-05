package fr.latchi.latchisapp

import fr.latchi.latchisapp.ui.theme.Navigation
import android.os.Bundle
import android.util.Log
//import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import fr.latchi.latchisapp.ui.theme.LaTchisAppTheme
//import sqldelight.com.squareup.sqlite.migrations.Database

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val driver = AndroidSqliteDriver(
            schema = Database.Schema,
            context = applicationContext,
            name = "items.db"
        )

        val database = Database(driver)

        val memberQueries = database.memberQueries

        val members = memberQueries.selectAll().executeAsList()

//        val queries = Database(androidSqlDriver).itemInCartEntityQueries
//
//        val itemsBefore = queries.selectAll().executeAsList()
//        Log.d("ItemDatabase", "Items Before: $itemsBefore")
//
//        for (i in 1..3) {
//            queries.insertOrReplace(
//                label = "Item $i",
//                image = "https://localhost/item$i.png",
//                quantity = i.toLong(),
//                link = null
//            )
//        }
//
//        val itemsAfter = queries.selectAll().executeAsList()
//        Log.d("ItemDatabase", "Items After: $itemsAfter")

        setContent {
            LaTchisAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }





    }
}

@Preview(
    showBackground = false,
    showSystemUi = true
)
@Composable
fun BirthdayCardPreview() {
    LaTchisAppTheme {
        //GreetingWithImage(brand = "LaTchi", firstname = "Cibee")
    }
}
