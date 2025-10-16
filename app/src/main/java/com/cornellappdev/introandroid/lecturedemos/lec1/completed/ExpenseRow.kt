package com.cornellappdev.introandroid.lecturedemos.lec1.completed

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale
import kotlin.math.absoluteValue

/**
 * An expense row for a list of expenses.
 *
 * Takes in an expense title, date, and amount.
 *
 * Displays the title, date underneath, and amount to the far right;
 * if the amount is negative, it is in red, and if it is positive, it is in green.
 */
@Composable
fun ExpenseRow(
    title: String,
    date: String,
    amount: Double? = null
) {
    // 2.0 -> $2.00
    val formattedAmount = String.format(Locale.US, "%.2f", amount?.absoluteValue)
    val amountText =
        if (amount != null && amount < 0) {
            "-$$formattedAmount"
        } else {
            "+$$formattedAmount"
        }

    // TODO: Use modifiers and arguments to make this look nice!
    //  * Make the background White!
    //  * Make the title text bold and larger!
    //  * Make everything vertically centered!
    //  * Make the row take up the full width!
    //  * Add padding to make it look nice!
    //  * Make the row rounded
    //  * Give it a border
    //  * Show amount only if it is not null or zero
    //  * (Anything else...?)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = date
            )
        }

        amount?.let {
            if (amount != 0.0) {
                Text(
                    text = amountText,
                    color = if (amount < 0) {
                        Color.Red
                    } else {
                        Color.Green
                    }
                )
            }
        }
    }
}

// TODO: Try playing around with different parameters here to see how it looks!
@Preview(showBackground = true)
@Composable
private fun ExpenseRowPreview() {
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 24.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ExpenseRow(
            title = "Paycheck",
            date = "2022-01-01",
            amount = 100.0
        )
        ExpenseRow(
            title = "Dining",
            date = "2022-01-02",
            amount = -45.67
        )
        ExpenseRow(
            title = "Misc",
            date = "2022-01-03",
            amount = 0.0
        )
        ExpenseRow(
            title = "Entertainment",
            date = "2022-01-04"
        )
    }

}
